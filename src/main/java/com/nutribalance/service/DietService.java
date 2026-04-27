package com.nutribalance.service;

import com.nutribalance.dto.DietEntryDTO;
import com.nutribalance.model.DietEntry;
import com.nutribalance.model.User;
import com.nutribalance.repository.DietRepository;
import com.nutribalance.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.nutribalance.dto.DietCreateRequest;

@Service
public class DietService {

    private final DietRepository dietRepository;
    private final UserRepository userRepository;

    public DietService(DietRepository dietRepository,
                       UserRepository userRepository) {
        this.dietRepository = dietRepository;
        this.userRepository = userRepository;
    }

    public DietEntryDTO addDiet(DietCreateRequest request, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + userId));
        
        DietEntry entry = new DietEntry();
        entry.setFoodName(request.getFoodName());
        entry.setCalories(request.getCalories());
        entry.setProtein(request.getProtein());
        entry.setCarbs(request.getCarbs());
        entry.setFats(request.getFats());
        entry.setDate(request.getDate());
        entry.setUser(user);

        DietEntry savedEntry = dietRepository.save(entry);
        return convertToDTO(savedEntry);
    }

    public List<DietEntryDTO> getDiet(Long userId) {
        return dietRepository.findByUserId(userId)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public void deleteDiet(Long id, Long userId) {
        Optional<DietEntry> entry = dietRepository.findById(id);
        if (entry.isPresent() && entry.get().getUser().getId().equals(userId)) {
            dietRepository.deleteByIdAndUserId(id, userId);
        } else {
            throw new IllegalArgumentException("Diet entry not found or unauthorized.");
        }
    }

    private DietEntryDTO convertToDTO(DietEntry entry) {
        return new DietEntryDTO(
            entry.getId(),
            entry.getFoodName(),
            entry.getCalories(),
            entry.getProtein(),
            entry.getCarbs(),
            entry.getFats(),
            entry.getDate(),
            entry.getUser().getId()
        );
    }
}