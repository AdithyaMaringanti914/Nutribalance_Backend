package com.nutribalance.service;

import com.nutribalance.model.EducationContent;
import com.nutribalance.repository.EducationContentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationContentService {

    private final EducationContentRepository repository;

    public EducationContentService(EducationContentRepository repository) {
        this.repository = repository;
    }

    public EducationContent addContent(EducationContent content) {
        return repository.save(content);
    }

    public List<EducationContent> getAllContent() {
        return repository.findAll();
    }
}
