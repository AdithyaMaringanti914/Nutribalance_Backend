package com.nutribalance.controller;

import com.nutribalance.model.User;
import com.nutribalance.model.DietEntry;
import com.nutribalance.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*") // Adjust if needed
public class AdminController {

    @Autowired
    private AdminService adminService;

    // --- USER MANAGEMENT ---

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(adminService.getAllUsers());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return adminService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        try {
            return ResponseEntity.ok(adminService.updateUser(id, userDetails));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        adminService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

    // --- DIET MANAGEMENT ---

    @GetMapping("/diet-entries")
    public ResponseEntity<List<DietEntry>> getAllDietEntries() {
        return ResponseEntity.ok(adminService.getAllDietEntries());
    }

    @DeleteMapping("/diet-entries/{id}")
    public ResponseEntity<Void> deleteDietEntry(@PathVariable Long id) {
        adminService.deleteDietEntry(id);
        return ResponseEntity.ok().build();
    }
}
