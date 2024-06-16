
package com.example.skola.dto;

import com.example.skola.model.EventEntity;
import com.example.skola.model.StudentEntity;

import java.util.ArrayList;
import java.util.List;

public class StudentDto {
    private Long id;
    private String name;
    private Long classId;
    private List<Long> eventIds;

    public StudentDto(Long id, String name, Long classId, List<Long> eventIds) {
        this.id = id;
        this.name = name;
        this.classId = classId;
        this.eventIds = eventIds;
    }

    public static StudentDto fromStudentEntity(StudentEntity entity) {
        List<Long> events;
        if (entity.getEvents() == null) {
            events = new ArrayList<>();
        } else {
            events = entity.getEvents().stream().map(EventEntity::getId).toList();
        }
        return new StudentDto(
                entity.getId(),
                entity.getName(),
                entity.getClazz().getId(),
                events);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public List<Long> getEventIds() {
        return eventIds;
    }

    public void setEventIds(List<Long> eventIds) {
        this.eventIds = eventIds;
    }
}
