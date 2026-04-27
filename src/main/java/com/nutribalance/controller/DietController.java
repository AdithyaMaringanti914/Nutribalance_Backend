package com.nutribalance.controller;

import com.nutribalance.dto.DietEntryDTO;
import com.nutribalance.model.DietEntry;
import com.nutribalance.service.DietService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import jakarta.validation.Valid;

import com.nutribalance.dto.DietCreateRequest;

@RestController
@RequestMapping("/api/diet")
public class DietController {

    private final DietService dietService;

    public DietController(DietService dietService) {
        this.dietService = dietService;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<?> addDiet(@Valid @RequestBody DietCreateRequest request,
                                     @PathVariable Long userId) {
        try {
            DietEntryDTO saved = dietService.addDiet(request, userId);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", "Could not save diet entry: " + e.getMessage()));
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<DietEntryDTO>> getDiet(@PathVariable Long userId) {
        try {
            return ResponseEntity.ok(dietService.getDiet(userId));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{userId}/{id}")
    public ResponseEntity<?> deleteDiet(@PathVariable Long userId,
                                        @PathVariable Long id) {
        try {
            dietService.deleteDiet(id, userId);
            return ResponseEntity.ok(Map.of("message", "Diet entry deleted successfully"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", "Could not delete diet entry: " + e.getMessage()));
        }
    }
}