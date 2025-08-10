package com.BrainrotWebApp.BrainRotBackend.Entities;

// Notification.java
import java.time.*;
import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "notifications",
        indexes = { @Index(columnList = "user_id"), @Index(columnList = "scheduledTime") })
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class Notification extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User user;

    @Column(length = 50, nullable = false)
    private String notificationType; // break_reminder | achievement …

    @Column(length = 200, nullable = false)
    private String title;

    @Lob
    private String message;

    private Instant scheduledTime;
    private Instant sentTime;

    private String deliveryStatus; // pending | sent | delivered | failed

    @Builder.Default
    private Boolean isRead = false;

    private String actionUrl;
    private String priority; // low | normal | high | urgent
}
