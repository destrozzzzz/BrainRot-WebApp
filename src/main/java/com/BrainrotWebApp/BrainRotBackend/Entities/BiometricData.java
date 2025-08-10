package com.BrainrotWebApp.BrainRotBackend.Entities;

// BiometricData.java
import java.time.*;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "biometric_data",
        indexes = @Index(columnList = "user_id"))
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class BiometricData extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User user;

    @Column(length = 50, nullable = false)
    private String dataSource; // fitbit, garmin, etc.

    @Column(length = 50, nullable = false)
    private String metricType; // heart_rate, sleep_hours, steps

    @Column(nullable = false)
    private Double metricValue; // For floating-point values

    @Column(nullable = false)
    private Instant measurementTime;

    private String unit; // bpm, hours, steps

    @Column(columnDefinition = "json") // For MySQL
    private String rawData; // Store JSON as String
}
