package com.nutribalance.controller;

import com.nutribalance.model.User;
import com.nutribalance.model.Role;
import com.nutribalance.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import com.nutribalance.dto.UserDTO;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/patients")
    public ResponseEntity<List<UserDTO>> getPatients() {
        // Find all users who are PARENTS or CHILDREN and map to safe DTOs
        List<UserDTO> patients = userRepository.findAll().stream()
                .filter(u -> u.getRole() == Role.PARENT || u.getRole() == Role.CHILD)
                .map(u -> new UserDTO(
                    u.getId(),
                    u.getFullName(),
                    u.getEmail(),
                    u.getOrganizationName(),
                    u.getRole().name()
                ))
                .collect(Collectors.toList());
        return ResponseEntity.ok(patients);
    }
}
