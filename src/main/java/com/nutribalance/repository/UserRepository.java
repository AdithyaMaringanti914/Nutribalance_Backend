package com.nutribalance.repository;

import com.nutribalance.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // Use findFirstByEmail to safely handle any accidental duplicate emails in DB
    Optional<User> findFirstByEmail(String email);
    boolean existsByEmail(String email);
}