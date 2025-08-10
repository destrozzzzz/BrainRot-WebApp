package com.BrainrotWebApp.BrainRotBackend.Entities;

// UserDetoxActivity.java
import java.time.*;
import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "user_detox_activities",
        indexes = @Index(columnList = "user_id"))
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class UserDetoxActivity extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private DetoxSuggestion suggestion;

    @Column(length = 50, nullable = false)
    private String activityType;

    @Column(nullable = false)
    private Instant startTime;

    private Instant endTime;

    private Integer durationMinutes;

    private String completionStatus;   // started | completed | skipped
    private Integer effectivenessRating; // 1–5

    @Lob
    private String userNotes;
}
