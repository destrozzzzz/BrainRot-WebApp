package com.BrainrotWebApp.BrainRotBackend.Entities;

// FocusSession.java

import java.time.*;
import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "focus_sessions",
        indexes = @Index(columnList = "user_id"))
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class FocusSession extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User user;

    @Builder.Default
    private String sessionType = "natural"; // natural | planned | forced

    @Column(nullable = false)
    private Instant startTime;

    private Instant endTime;

    private Integer durationMinutes;
    private Integer targetDurationMinutes;
    private Integer interruptionCount;

    private String completionStatus; // completed | interrupted | abandoned
    private Integer qualityRating;   // 1–5

    @ElementCollection
    private java.util.List<String> appsBlocked;
}
