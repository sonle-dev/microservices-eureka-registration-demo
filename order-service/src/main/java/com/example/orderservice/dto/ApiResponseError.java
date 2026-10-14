package com.example.orderservice.dto;

import java.time.Instant;

public class ApiResponseError {
    private String timestamp;
    private int status;
    private String error;
    private String path;

    public ApiResponseError(int status, String error, String path) {
        this.timestamp = Instant.now().toString();
        this.status = status;
        this.error = error;
        this.path = path;
    }

    public String getTimestamp() { return timestamp; }
    public int getStatus() { return status; }
    public String getError() { return error; }
    public String getPath() { return path; }
}