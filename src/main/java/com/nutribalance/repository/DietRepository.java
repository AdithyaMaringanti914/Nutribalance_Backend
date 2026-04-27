package com.nutribalance.repository;

import com.nutribalance.model.DietEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface DietRepository extends JpaRepository<DietEntry, Long> {
    List<DietEntry> findByUserId(Long userId);

    @Transactional
    void deleteByIdAndUserId(Long id, Long userId);
}