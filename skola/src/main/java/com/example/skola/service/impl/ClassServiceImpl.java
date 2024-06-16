package com.example.skola.service.impl;

import com.example.skola.model.ClassEntity;
import com.example.skola.model.StudentEntity;
import com.example.skola.repository.ClassRepository;
import com.example.skola.repository.StudentRepository;
import com.example.skola.request.CreateClassRequest;
import com.example.skola.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {
    private ClassRepository classRepository;

    public ClassServiceImpl(@Autowired ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    @Override
    public ClassEntity createClass(CreateClassRequest request) {
        ClassEntity entity = new ClassEntity();

        entity.setName(request.getName());

        return classRepository.save(entity);
    }
    @Override
    public List<ClassEntity> getAllClasses() {
        return classRepository.findAll();
    }
    @Override
    public List<StudentEntity> getStudentsFromClass(Long classId) {
        return classRepository.findById(classId).get().getStudents();
    }
}
