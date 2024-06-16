package com.example.skola.service;

import com.example.skola.exception.NotFoundException;
import com.example.skola.model.StudentEntity;
import com.example.skola.request.CreateStudentRequest;
import com.example.skola.request.UpdateStudentRequest;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentService {
    List<StudentEntity> getStudentsByName(String name);
    StudentEntity getStudentById(Long id) throws NotFoundException;
    List<StudentEntity> getAllStudents();
    void deleteStudent(Long id);

    StudentEntity createStudent(CreateStudentRequest request) throws NotFoundException;
    StudentEntity updateStudent(UpdateStudentRequest request) throws NotFoundException;
}
