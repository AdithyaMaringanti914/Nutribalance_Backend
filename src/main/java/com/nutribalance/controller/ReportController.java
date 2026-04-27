package com.nutribalance.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @GetMapping
    public ResponseEntity<List<Map<String, String>>> getReports() {
        return ResponseEntity.ok(List.of(
            Map.of("id", "1", "patient", "John Doe", "date", "2024-10-14", "type", "Monthly Summary", "status", "Ready"),
            Map.of("id", "2", "patient", "Jane Smith", "date", "2024-10-12", "type", "Deficiency Alert Report", "status", "Ready"),
            Map.of("id", "3", "patient", "Emily Clark", "date", "2024-10-10", "type", "BMI Assessment", "status", "Pending")
        ));
    }
}
