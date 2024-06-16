package com.example.skola.controller;

import  com.example.skola.dto.StudentDto;
import com.example.skola.exception.NotFoundException;
import com.example.skola.model.StudentEntity;
import com.example.skola.request.CreateStudentRequest;
import com.example.skola.request.DeleteStudentRequest;
import com.example.skola.request.UpdateStudentRequest;
import com.example.skola.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private StudentService studentService;
    
    public StudentController(@Autowired StudentService studentService) {
        this.studentService = studentService;
    }



    @GetMapping("name")
    public List<StudentDto> getStudentByName(
            @RequestParam("name") String name
    ) throws NotFoundException {
        return studentService.getStudentsByName(name)
                .stream()
                .map(StudentDto::fromStudentEntity)
                .toList();
    }
    @GetMapping("/{id}")
    public StudentDto getStudentById(@PathVariable Long id) throws NotFoundException {
        return StudentDto.fromStudentEntity(
                studentService.getStudentById(id)
        );
    }
    @GetMapping("/all")
    public List<StudentDto> getAllStudents() {
        return studentService.getAllStudents()
                .stream()
                .map(StudentDto::fromStudentEntity)
                .toList();
    }




    @PostMapping("/create")
    public StudentDto createStudent(@RequestBody CreateStudentRequest request) throws NotFoundException {
        return StudentDto.fromStudentEntity(
                studentService.createStudent(request)
        );
    }

    @PutMapping("/update")
    public StudentDto updateStudent(@RequestBody UpdateStudentRequest request) throws NotFoundException {
        return StudentDto.fromStudentEntity(
                studentService.updateStudent(request)
        );
    }

    @DeleteMapping("/delete")
    public void deleteStudent(@RequestBody DeleteStudentRequest request){
        studentService.deleteStudent(request.getStudentId());
    }



}
