package com.nutribalance.controller;

import com.nutribalance.model.EducationContent;
import com.nutribalance.service.EducationContentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/education")
public class EducationContentController {

    private final EducationContentService service;

    public EducationContentController(EducationContentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<EducationContent> addContent(@RequestBody EducationContent content) {
        return ResponseEntity.ok(service.addContent(content));
    }

    @GetMapping
    public ResponseEntity<List<EducationContent>> getAllContent() {
        return ResponseEntity.ok(service.getAllContent());
    }
}
