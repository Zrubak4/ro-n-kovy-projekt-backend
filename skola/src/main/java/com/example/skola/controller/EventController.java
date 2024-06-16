package com.example.skola.controller;


import com.example.skola.exception.NotFoundException;
import com.example.skola.request.*;
import com.example.skola.service.EventService;
import org.springframework.web.bind.annotation.*;
import com.example.skola.dto.EventDto;
import com.example.skola.request.AddStudentsEventRequest;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.skola.service.StudentService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/event")
public class EventController {
    private EventService eventService;

    public EventController(@Autowired EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("/create")
    public EventDto createEvent(@RequestBody CreateEventRequest request) {
        return EventDto.fromEventEntity(eventService.createEvent(request));
    }

    @GetMapping("/all")
    public List<EventDto> getAllEvents() {
        return eventService.getAllEvents()
                .stream()
                .map(EventDto::fromEventEntity)
                .collect(Collectors.toList());
    }

    @GetMapping("/{eventId}/students")
    public List<Long> getStudentsFromEvent(@PathVariable Long eventId) throws NotFoundException {
        return eventService.getStudentIdsFromEvent(eventId);
    }

    @GetMapping("/{eventId}/studentsNames")
    public List<String> getStudentsNamesFromEvent(@PathVariable Long eventId) throws NotFoundException{
        return eventService.getStudentsFromEvent(eventId)
                .stream()
                .map(student -> student.getName())
                .collect(Collectors.toList());
    }

    @PutMapping("/{eventId}/addStudents")
    public EventDto addStudentsToEvent(@RequestBody AddStudentsEventRequest request) throws NotFoundException {
        return EventDto.fromEventEntity(
                eventService.addStudentsToEvent(request)
        );
    }

    @PutMapping("/update")
    public EventDto updateEvent(@RequestBody UpdateEventRequest request) throws NotFoundException {
        return EventDto.fromEventEntity(
                eventService.updateEvent(request)
        );
    }

    @DeleteMapping("/delete")
    public void deleteEvent(@RequestBody DeleteEventRequest request) throws NotFoundException {
        eventService.deleteEvent(request.getEventId());
    }


}
