package com.BrainrotWebApp.BrainRotBackend.Entities;

// DetoxSuggestion.java

import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "detox_suggestions")
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class DetoxSuggestion extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String category; // break | meditation | exercise …

    @Column(length = 200, nullable = false)
    private String title;

    @Lob
    private String description;

    private Integer durationMinutes;
    private String difficultyLevel; // easy | medium | hard
    private Integer minToxicityScore;
    private Integer maxToxicityScore;

    @ElementCollection
    private java.util.List<String> triggers;

    @Lob
    private String instructions;

    @Builder.Default
    private Boolean isActive = true;
}
