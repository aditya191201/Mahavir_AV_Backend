package com.mavs.backend.helper;

import org.springframework.stereotype.Component;

@Component
public class LoginResponse {
    private String message;

    public LoginResponse() {
    }

    public LoginResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "LoginResponse [message=" + message + "]";
    }
    
}
