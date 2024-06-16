package com.example.skola.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 500)
    private String name;

    @ManyToOne
    private ClassEntity clazz;

    @ManyToMany
    private List<EventEntity> events;


    public StudentEntity(Long id, String name, ClassEntity clazz) {
        this.id = id;
        this.name = name;
        this.clazz = clazz;
        this.events = List.of();
    }

    public StudentEntity() {}

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

    public ClassEntity getClazz() {
        return clazz;
    }

    public void setClazz(ClassEntity clazz) {
        this.clazz = clazz;
    }

    public List<EventEntity> getEvents() {
        return events;
    }
    public void setEvents(List<EventEntity> events) {
        this.events = events;
    }
    public void addEvent(EventEntity event) {
        this.events.add(event);
    }
    public void removeEvent(EventEntity event) {
        this.events.remove(event);
    }

}
