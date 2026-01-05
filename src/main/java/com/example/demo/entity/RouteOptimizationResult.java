// src/main/java/com/example/demo/entity/RouteOptimizationResult.java
package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "route_optimization_results")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class RouteOptimizationResult {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "shipment_id", nullable = false)
    private Shipment shipment;

    @Column(nullable = false) private Double optimizedDistanceKm;
    @Column(nullable = false) private Double estimatedFuelUsageL;
    @Column(nullable = false) private LocalDateTime generatedAt;

    @PrePersist
    public void prePersist() {
        if (generatedAt == null) generatedAt = LocalDateTime.now();
    }
}