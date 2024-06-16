package com.example.skola.request;
import java.util.List;
public class AddStudentsEventRequest {
    private Long eventId;
    private List<Long> studentIds;
    public AddStudentsEventRequest(Long eventId, List<Long> studentIds) {
        this.eventId = eventId;
        this.studentIds = studentIds;
    }
    public AddStudentsEventRequest() {}

    public void setEventId(Long eventIds) {
        this.eventId = eventIds;
    }

    public void setStudentIds(List<Long> studentIds) {
        this.studentIds = studentIds;
    }
    public Long getEventId() {
        return eventId;
    }

    public List<Long> getStudentIds() {
        return studentIds;
    }

}
