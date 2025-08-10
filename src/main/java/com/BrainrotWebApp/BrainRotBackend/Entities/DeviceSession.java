package com.BrainrotWebApp.BrainRotBackend.Entities;

// DeviceSession.java
import java.time.*;
import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "device_sessions",
        indexes = { @Index(columnList = "user_id"), @Index(columnList = "sessionStart") })
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class DeviceSession extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User user;

    @Builder.Default
    private String deviceType = "desktop"; // desktop | mobile | tablet

    private String deviceName;

    @Column(nullable = false)
    private Instant sessionStart;

    private Instant sessionEnd;

    private Integer totalDuration; // seconds
}
