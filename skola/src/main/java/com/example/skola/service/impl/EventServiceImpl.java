package com.example.skola.service.impl;


import com.example.skola.dto.EventDto;
import com.example.skola.exception.NotFoundException;
import com.example.skola.model.StudentEntity;
import com.example.skola.repository.EventRepository;
import com.example.skola.request.AddStudentsEventRequest;
import com.example.skola.request.CreateEventRequest;
import com.example.skola.request.UpdateEventRequest;
import com.example.skola.service.EventService;
import com.example.skola.model.EventEntity;
import com.example.skola.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EventServiceImpl implements EventService{
    private EventRepository eventRepository;
    private StudentRepository studentRepository;


    public EventServiceImpl(
            @Autowired
            EventRepository eventRepository,
            @Autowired
            StudentRepository studentRepository
            ) {
        this.eventRepository = eventRepository;
        this.studentRepository = studentRepository;

    }



    @Override
    public EventEntity createEvent(CreateEventRequest request) {
        EventEntity entity = new EventEntity();

        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setLocation(request.getLocation());
        entity.setDate(request.getDate());

        return eventRepository.save(entity);
    }
    @Override
    public List<EventEntity> getAllEvents() {
        return eventRepository.findAll();
    }
    @Override
    public List<Long> getStudentIdsFromEvent(Long eventId) throws NotFoundException {
        return eventRepository.findById(eventId)
                .orElseThrow(() -> new NotFoundException("Event not found!")).
                getStudents()
                .stream()
                .map(StudentEntity::getId)
                .toList();
    }
    @Override
    public List<StudentEntity> getStudentsFromEvent(Long eventId) throws NotFoundException{
        return eventRepository.findById(eventId)
                .orElseThrow(() -> new NotFoundException("Event not found!"))
                .getStudents();
    }

    @Override
    public EventEntity addStudentsToEvent(AddStudentsEventRequest request) throws NotFoundException {

        EventEntity event = eventRepository.findById(request.getEventId())
                .orElseThrow(() -> new NotFoundException("Event not found!"));

        List<StudentEntity> students = studentRepository.findAllById(request.getStudentIds());

        for (StudentEntity student : students) {
            if (student.getEvents().contains(event)) {
                continue;
            }
            student.getEvents().add(event);
        }

        event.getStudents().addAll(students);
        return eventRepository.save(event);

    }
    @Override
    @Transactional
    public void deleteEvent(Long eventId) throws NotFoundException {
        EventEntity event = eventRepository.findById(eventId)
                .orElseThrow(() -> new NotFoundException("Event not found!"));
        for (StudentEntity student : event.getStudents()) {
            student.getEvents().remove(event);
        }


        eventRepository.delete(event);
    }

    @Override
    public EventEntity updateEvent(UpdateEventRequest request) throws NotFoundException {
        EventEntity event = eventRepository.findById(request.getEventId())
                .orElseThrow(() -> new NotFoundException("Event not found!"));

        EventEntity updatedEvent = event;
        updatedEvent.setName(request.getName());
        updatedEvent.setDescription(request.getDescription());
        updatedEvent.setLocation(request.getLocation());
        updatedEvent.setDate(request.getDate());

        return eventRepository.save(updatedEvent);
    }
}
