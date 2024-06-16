package com.example.skola.dto;

import com.example.skola.model.ClassEntity;
import com.example.skola.model.StudentEntity;

import java.util.ArrayList;
import java.util.List;

public class ClassDto {
    private String name;
    private long id;
    private List<Long> studentIds;

    public ClassDto(String name, long id, List<Long> studentIds) {
        this.name = name;
        this.id = id;
        this.studentIds = studentIds;
    }

    public static ClassDto fromClassEntity(ClassEntity entity) {
        List<Long> students;
        if (entity.getStudents() == null) {
            students = new ArrayList<>();
        } else {
            students = entity.getStudents().stream().map(StudentEntity::getId).toList();
        }

        return new ClassDto(
                entity.getName(),
                entity.getId(),
                students
        );
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Long> getStudentIds() {
        return studentIds;
    }

    public void setStudentIds(List<Long> studentIds) {
        this.studentIds = studentIds;
    }
}
