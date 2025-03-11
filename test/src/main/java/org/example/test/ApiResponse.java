package org.example.test;


import java.util.Map;

public class ApiResponse {
    private boolean success;
    private String message;
    private Map<String, Object> data;

    public ApiResponse(boolean success, String message, Map<String, Object> data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public Map<String, Object> getData() {
        return data;
    }
}
