package com.BrainrotWebApp.BrainRotBackend.Entities;

// User.java
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity @Table(name = "users",
        indexes = { @Index(columnList = "username"), @Index(columnList = "email") })
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class User extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false, unique = true)
    private String username;

    @Column(length = 100, nullable = false, unique = true)
    private String email;

    @Column(length = 255, nullable = false)
    private String passwordHash;

    private String firstName;
    private String lastName;

    private java.time.LocalDate dateOfBirth;

    @Builder.Default
    private String timezone = "UTC";

    @Builder.Default
    private Boolean isActive = true;

    private Instant lastLogin;
}
