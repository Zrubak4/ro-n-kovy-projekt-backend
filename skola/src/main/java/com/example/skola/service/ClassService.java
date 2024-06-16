package com.example.skola.service;

import com.example.skola.model.ClassEntity;
import com.example.skola.model.StudentEntity;
import com.example.skola.request.CreateClassRequest;

import java.util.List;

public interface ClassService {
    ClassEntity createClass(CreateClassRequest request);
    List<ClassEntity> getAllClasses();
    List<StudentEntity> getStudentsFromClass(Long classId);
}
