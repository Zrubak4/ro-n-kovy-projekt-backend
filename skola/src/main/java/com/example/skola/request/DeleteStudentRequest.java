package com.example.skola.request;

public class DeleteStudentRequest {
    private long studentId;
    public DeleteStudentRequest() {
    }

    public DeleteStudentRequest(long studentId) {
        this.studentId = studentId;
    }
    public long getStudentId(){
        return studentId;
    }
}
