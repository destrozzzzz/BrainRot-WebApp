package com.BrainrotWebApp.BrainRotBackend.Entities;
import java.time.*;
import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "app_usage",
        indexes = { @Index(columnList = "session_id"), @Index(columnList = "user_id") })
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class AppUsage extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private DeviceSession session;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User user;

    @Column(length = 100, nullable = false)
    private String appName;

    @ManyToOne(fetch = FetchType.LAZY)
    private AppCategory appCategory;

    private String websiteUrl;

    @Column(nullable = false)
    private Instant startTime;

    private Instant endTime;

    @Column(nullable = false)
    private Integer duration; // seconds

    @Builder.Default
    private String activityType = "active"; // active | idle | background
}
