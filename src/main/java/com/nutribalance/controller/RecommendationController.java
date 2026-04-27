package com.nutribalance.controller;

import com.nutribalance.model.Recommendation;
import com.nutribalance.repository.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {

    @Autowired
    private RecommendationRepository recommendationRepository;

    @PostMapping
    public ResponseEntity<Recommendation> addRecommendation(@RequestBody Recommendation recommendation) {
        recommendation.setTimestamp(LocalDateTime.now());
        return ResponseEntity.ok(recommendationRepository.save(recommendation));
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<Recommendation>> getByPatient(@PathVariable Long patientId) {
        return ResponseEntity.ok(recommendationRepository.findByPatientId(patientId));
    }
}
