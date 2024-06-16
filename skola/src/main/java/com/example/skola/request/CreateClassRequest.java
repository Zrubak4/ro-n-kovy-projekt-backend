package com.example.skola.request;

public class CreateClassRequest {
    private String name;

    public CreateClassRequest(String name) {
        this.name = name;
    }

    public CreateClassRequest() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
