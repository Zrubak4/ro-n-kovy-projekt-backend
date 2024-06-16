package com.example.skola.request;

import java.time.LocalDateTime;
import java.util.List;

public class CreateEventRequest {
    private String name;
    private String description;
    private String location;
    private LocalDateTime date;

    public CreateEventRequest(String name, String description, String location, LocalDateTime date) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.date = date;
    }
    public CreateEventRequest() {}
    public void setName(String name) {
        this.name = name;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public LocalDateTime getDate() {
        return date;
    }

}
