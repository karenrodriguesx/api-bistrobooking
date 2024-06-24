package com.bistrobooking.exception;

import java.time.LocalDateTime;

public class ExceptionDetails {
    private String title;
    private int status;
    private String details;
    private LocalDateTime timestamp;

    public ExceptionDetails(String title, int status, String details, LocalDateTime timestamp) {
        this.title = title;
        this.status = status;
        this.details = details;
        this.timestamp = timestamp;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
