package com.example.skola.request;

import java.util.List;

public class UpdateStudentRequest {
    private long studentId;
    private String name;
    private long classId;
    private List<Long> eventIds;
    public UpdateStudentRequest() {
    }

    public UpdateStudentRequest(long studentId, String name, long classId, List<Long> eventIds) {
        this.studentId = studentId;
        this.name = name;
        this.classId = classId;
        this.eventIds = eventIds;

    }
    public long getStudentId(){
        return studentId;
    }
    public void setStudentId(long studentId){
        this.studentId = studentId;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public long getClassId(){
        return classId;
    }
    public void setClassId(long classId){
        this.classId = classId;
    }

    public List<Long> getEventIds() {
        return eventIds;
    }
    public void setEventIds(List<Long> eventIds) {
        this.eventIds = eventIds;
    }


}
