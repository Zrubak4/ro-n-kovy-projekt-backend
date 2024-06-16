package com.example.skola.controller;

import com.example.skola.dto.ClassDto;
import com.example.skola.request.CreateClassRequest;
import com.example.skola.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/class")
public class ClassController {
    private ClassService classService;

    public ClassController(@Autowired ClassService classService) {
        this.classService = classService;
    }

    @PostMapping("/create")
    public ClassDto createClass(@RequestBody CreateClassRequest request) {
        return ClassDto.fromClassEntity(classService.createClass(request));
    }


    @GetMapping("/all")
    public List<ClassDto> getAllClasses() {
        return classService.getAllClasses()
                .stream()
                .map(ClassDto::fromClassEntity)
                .collect(Collectors.toList());
    }
    @GetMapping("/{classId}/students")
    public List<Long> getStudentsFromClass(@PathVariable Long classId) {
        return classService.getStudentsFromClass(classId)
                .stream()
                .map(student -> student.getId())
                .collect(Collectors.toList());
    }
    @GetMapping("/{classId}/studentsNames")
    public List<String> getStudentsNamesFromClass(@PathVariable Long classId) {
        return classService.getStudentsFromClass(classId)
                .stream()
                .map(student -> student.getName())
                .collect(Collectors.toList());
    }

}
