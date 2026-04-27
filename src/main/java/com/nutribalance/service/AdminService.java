package com.nutribalance.service;

import com.nutribalance.model.User;
import com.nutribalance.model.DietEntry;
import com.nutribalance.repository.UserRepository;
import com.nutribalance.repository.DietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DietRepository dietRepository;

    // --- USER CRUD ---
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        
        user.setFullName(userDetails.getFullName());
        user.setOrganizationName(userDetails.getOrganizationName());
        user.setEmail(userDetails.getEmail());
        user.setRole(userDetails.getRole());
        
        // Update password only if provided (not recommended in plain text, but keeping it simple as per existing project)
        if (userDetails.getPassword() != null && !userDetails.getPassword().isEmpty()) {
            user.setPassword(userDetails.getPassword());
        }

        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // --- DIET ENTRIES CRUD ---
    public List<DietEntry> getAllDietEntries() {
        return dietRepository.findAll();
    }

    public void deleteDietEntry(Long id) {
        dietRepository.deleteById(id);
    }
}
