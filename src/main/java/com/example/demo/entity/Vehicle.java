// src/main/java/com/example/demo/entity/Vehicle.java
package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vehicles", uniqueConstraints = @UniqueConstraint(columnNames = "vehicleNumber"))
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Vehicle {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true) private String vehicleNumber;
    @Column(nullable = false) private Double capacityKg;
    @Column(nullable = false) private Double fuelEfficiency;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}