package com.example.goUpskill.instructor.payload;

public class ApiResponse {
    private String name;
    private boolean success;

    public ApiResponse(){

    }

    public ApiResponse(String name, boolean success) {
        this.name = name;
        this.success = success;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
