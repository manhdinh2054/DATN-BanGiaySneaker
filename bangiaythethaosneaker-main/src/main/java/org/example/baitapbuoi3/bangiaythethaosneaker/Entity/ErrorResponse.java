package org.example.baitapbuoi3.bangiaythethaosneaker.Entity;

public class ErrorResponse {
    private String message;

    // Constructor, getter, setter
    public ErrorResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
