package org.example.backend.dto;

import org.springframework.stereotype.Component;

@Component
public class AuthDTO {

    private String email;
    private String token;

    // Default constructor
    public AuthDTO() {}

    // Parameterized constructor
    public AuthDTO(String email, String token) {
        this.email = email;
        this.token = token;
    }

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    // Override toString() for better representation
    @Override
    public String toString() {
        return "AuthDTO{" +
                "email='" + email + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
