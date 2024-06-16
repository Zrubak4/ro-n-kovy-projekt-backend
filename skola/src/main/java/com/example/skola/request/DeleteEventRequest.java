package com.example.skola.request;

public class DeleteEventRequest {
    private long eventId;
    public DeleteEventRequest() {
    }

    public DeleteEventRequest(long eventId) {
        this.eventId = eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public long getEventId(){
        return eventId;
    }
}
