package com.example.skola.service.impl;

import com.example.skola.exception.NotFoundException;
import com.example.skola.model.ClassEntity;
import com.example.skola.model.EventEntity;
import com.example.skola.model.StudentEntity;
import com.example.skola.repository.ClassRepository;
import com.example.skola.repository.EventRepository;
import com.example.skola.repository.StudentRepository;
import com.example.skola.request.CreateStudentRequest;
import com.example.skola.request.UpdateStudentRequest;
import com.example.skola.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;
    private ClassRepository classRepository;
    private EventRepository eventRepository;


    public StudentServiceImpl(
            @Autowired
            StudentRepository studentRepository,

            @Autowired
            ClassRepository classRepository,

            @Autowired
            EventRepository eventRepository
    ) {
        this.studentRepository = studentRepository;
        this.classRepository = classRepository;
        this.eventRepository = eventRepository;
    }

    @Override
    public List<StudentEntity> getStudentsByName(String name) {
        return studentRepository.findAllByNameContains(name);
    }

    public StudentEntity getStudentById(Long id) throws NotFoundException {
        return studentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Student not found!"));
    }
    public List<StudentEntity> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public StudentEntity createStudent(CreateStudentRequest request) throws NotFoundException {
        ClassEntity studentClass = classRepository.findById(request.getClassId())
                .orElseThrow(() -> new NotFoundException("Class not found!"));

        StudentEntity newStudent = new StudentEntity();
        newStudent.setName(request.getName());
        newStudent.setClazz(studentClass);

        return studentRepository.save(newStudent);
    }

    @Override
    public StudentEntity updateStudent(UpdateStudentRequest request) throws NotFoundException {
        Optional<StudentEntity> student = studentRepository.findById(request.getStudentId());
        if (student.isEmpty()) {
            throw new NotFoundException("Student not found!");
        }

        ClassEntity studentClass = classRepository.findById(request.getClassId())
                .orElseThrow(() -> new NotFoundException("Class not found!"));

        List<EventEntity> events = eventRepository.findAllById(request.getEventIds());

        StudentEntity updatedStudent = student.get();
        updatedStudent.setName(request.getName());
        updatedStudent.setClazz(studentClass);
        updatedStudent.setEvents(events);

        return studentRepository.save(updatedStudent);
    }
}
