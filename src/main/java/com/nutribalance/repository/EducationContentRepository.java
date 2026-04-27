package com.nutribalance.repository;

import com.nutribalance.model.EducationContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationContentRepository extends JpaRepository<EducationContent, Long> {
}
