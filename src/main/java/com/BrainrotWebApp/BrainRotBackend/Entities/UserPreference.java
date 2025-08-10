package com.BrainrotWebApp.BrainRotBackend.Entities;

// UserPreference.java
import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "user_preferences",
        uniqueConstraints = @UniqueConstraint(columnNames = { "user_id", "preferenceKey" }))
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class UserPreference extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User user;

    @Column(length = 100, nullable = false)
    private String preferenceKey;

    @Lob
    private String preferenceValue;

    private String dataType; // string | integer | boolean | json
}
