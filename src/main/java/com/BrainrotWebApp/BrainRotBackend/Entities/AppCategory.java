package com.BrainrotWebApp.BrainRotBackend.Entities;
import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "app_categories")
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class AppCategory {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, unique = true, nullable = false)
    private String categoryName;

    @Builder.Default
    private Double toxicityWeight = 1.0;

    @Builder.Default
    private Double productivityWeight = 1.0;

    private String colorCode;   // Hexadecimal format is recorded for color

    private String iconName;

    @Builder.Default
    private Boolean isActive = true;
}

