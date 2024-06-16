package com.example.skola.service;


import com.example.skola.dto.EventDto;
import com.example.skola.exception.NotFoundException;
import com.example.skola.model.EventEntity;
import com.example.skola.model.StudentEntity;
import com.example.skola.request.CreateEventRequest;
import com.example.skola.request.AddStudentsEventRequest;
import com.example.skola.request.UpdateEventRequest;

import java.util.List;

public interface EventService {
    EventEntity createEvent(CreateEventRequest request);
    List<EventEntity> getAllEvents();
    List<Long> getStudentIdsFromEvent(Long eventId) throws NotFoundException;
    List<StudentEntity> getStudentsFromEvent(Long eventId) throws NotFoundException;
    EventEntity addStudentsToEvent(AddStudentsEventRequest request) throws NotFoundException;
    void deleteEvent(Long eventId) throws NotFoundException;
    EventEntity updateEvent(UpdateEventRequest request) throws NotFoundException;
}
