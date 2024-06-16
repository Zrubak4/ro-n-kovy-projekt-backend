package com.example.skola.request;

import java.util.List;

public class CreateStudentRequest {
    private String name;
    private long classId;

    public CreateStudentRequest(String name, long classId) {
        this.name = name;
        this.classId = classId;
    }

    public CreateStudentRequest() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getClassId() {
        return classId;
    }

    public void setClassId(long classId) {
        this.classId = classId;
    }
}
