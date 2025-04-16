package org.example.backend.dto;

import org.example.backend.enums.Role;
import org.springframework.stereotype.Component;


@Component
public class AuthDTO {

    private String email;
    private String token;
    private Role role;

    public AuthDTO() {
    }

    public AuthDTO(String email, String token, Role role) {
        this.email = email;
        this.token = token;
        this.role = role;
    }

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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "AuthDTO{" +
                "email='" + email + '\'' +
                ", token='" + token + '\'' +
                ", role=" + role +
                '}';
    }
}