package com.example.skola.dto;
import com.example.skola.model.StudentEntity;
import com.example.skola.model.EventEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EventDto {
    private String name;
    private Long id;
    private List<Long> studentIds;
    private String description;
    private String location;
    private LocalDateTime date;

    public EventDto(String name, Long id, List<Long> studentIds, String description, String location, LocalDateTime date) {
        this.name = name;
        this.id = id;
        this.studentIds = studentIds;
        this.description = description;
        this.location = location;
        this.date = date;
    }
    public static EventDto fromEventEntity(EventEntity entity) {
        List<Long> students;
        if (entity.getStudents() == null) {
            students = new ArrayList<>();
        } else {
            students = entity.getStudents().stream().map(StudentEntity::getId).toList();
        }

        return new EventDto(
                entity.getName(),
                entity.getId(),
                students,
                entity.getDescription(),
                entity.getLocation(),
                entity.getDate()
        );
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public List<Long> getStudentIds() {
        return studentIds;
    }
    public void setStudentIds(List<Long> studentIds) {
        this.studentIds = studentIds;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }


}
