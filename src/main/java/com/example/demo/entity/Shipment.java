// src/main/java/com/example/demo/entity/Shipment.java
package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "shipments")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Shipment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "pickup_location_id", nullable = false)
    private Location pickupLocation;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "drop_location_id", nullable = false)
    private Location dropLocation;

    @Column(nullable = false) private Double weightKg;
    @Column(nullable = false) private LocalDate scheduledDate;
}