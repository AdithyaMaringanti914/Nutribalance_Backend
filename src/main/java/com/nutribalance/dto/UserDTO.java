package com.nutribalance.dto;

import com.nutribalance.model.Role;

public class UserDTO {
    private Long id;
    private String fullName;
    private String email;
    private String organizationName;
    private String role;

    public UserDTO() {}

    public UserDTO(Long id, String fullName, String email, String organizationName, String role) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.organizationName = organizationName;
        this.role = role;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getOrganizationName() { return organizationName; }
    public void setOrganizationName(String organizationName) { this.organizationName = organizationName; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
