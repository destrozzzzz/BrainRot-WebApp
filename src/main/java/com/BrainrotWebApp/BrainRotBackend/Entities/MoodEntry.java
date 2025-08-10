package com.BrainrotWebApp.BrainRotBackend.Entities;

// MoodEntry.java
import java.time.*;
import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "mood_entries",
        indexes = @Index(columnList = "user_id"))
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class MoodEntry extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User user;

    @Column(nullable = false)
    private Instant entryTime;

    private Integer moodScore;      // 1-10
    private Integer stressLevel;    // 1-10
    private Integer energyLevel;    // 1-10
    private Integer focusLevel;     // 1-10

    @ElementCollection
    private java.util.List<String> triggers;

    @Lob
    private String notes;

    private Boolean screenTimeCorrelation;
}
