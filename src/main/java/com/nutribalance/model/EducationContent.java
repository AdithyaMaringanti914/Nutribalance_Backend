package com.nutribalance.model;

import jakarta.persistence.*;

@Entity
public class EducationContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String youtubeUrl;
    private int rewardPoints;

    public EducationContent() {}

    public EducationContent(Long id, String title, String description, String youtubeUrl, int rewardPoints) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.youtubeUrl = youtubeUrl;
        this.rewardPoints = rewardPoints;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getYoutubeUrl() { return youtubeUrl; }
    public void setYoutubeUrl(String youtubeUrl) { this.youtubeUrl = youtubeUrl; }

    public int getRewardPoints() { return rewardPoints; }
    public void setRewardPoints(int rewardPoints) { this.rewardPoints = rewardPoints; }
}
