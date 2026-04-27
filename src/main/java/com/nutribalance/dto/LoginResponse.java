package com.nutribalance.dto;

public class LoginResponse {

    private Long id;
    private String email;
    private String fullName;
    private String role;
    private String token;

    public LoginResponse() {}

    public LoginResponse(Long id, String email, String fullName, String role, String token) {
        this.id = id;
        this.email = email;
        this.fullName = fullName;
        this.role = role;
        this.token = token;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    // ✅ FIX ADDED
    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }
}