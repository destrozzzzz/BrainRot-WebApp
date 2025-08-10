package com.BrainrotWebApp.BrainRotBackend.Entities;
// DailyScore.java
import java.time.*;
import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "daily_scores",
        uniqueConstraints = @UniqueConstraint(columnNames = { "user_id", "scoreDate" }))
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class DailyScore extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User user;

    @Column(nullable = false)
    private LocalDate scoreDate;

    @Column(nullable = false)
    private Integer totalScreenTime; // seconds

    private Double focusScore;
    private Double toxicityScore;
    private Double productivityScore;

    private Integer appSwitchCount;
    private Integer eveningUsageMinutes;
}
