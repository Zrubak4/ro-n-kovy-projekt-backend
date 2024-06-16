package com.example.skola.request;

import java.time.LocalDateTime;

public class UpdateEventRequest {
    private long eventId;
    private String name;
    private String description;
    private String location;
    private LocalDateTime date;

    public UpdateEventRequest() {
    }
    public UpdateEventRequest(long eventId, String name, String description, String location, LocalDateTime date) {
        this.eventId = eventId;
        this.name = name;
        this.description = description;
        this.location = location;
        this.date = date;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public long getEventId() {
        return eventId;
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
