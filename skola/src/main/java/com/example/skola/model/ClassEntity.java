package com.example.skola.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class ClassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 500)
    private String name;

    @OneToMany(mappedBy = "clazz")
    private List<StudentEntity> students;

    public ClassEntity(Long id, String name, List<StudentEntity> students) {
        this.id = id;
        this.name = name;
        this.students = students;
    }

    public ClassEntity() {}

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

    public List<StudentEntity> getStudents() {
        return students;
    }

    public void setStudents(List<StudentEntity> students) {
        this.students = students;
    }
}
