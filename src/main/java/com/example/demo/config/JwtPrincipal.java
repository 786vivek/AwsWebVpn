package com.example.demo.config;

import java.util.List;

public class JwtPrincipal {

    private Long userId;
    private String email;
    private List<String> roles;

    public JwtPrincipal(Long userId, String email, List<String> roles) {
        this.userId = userId;
        this.email = email;
        this.roles = roles;
    }

    public Long getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public List<String> getRoles() {
        return roles;
    }
}