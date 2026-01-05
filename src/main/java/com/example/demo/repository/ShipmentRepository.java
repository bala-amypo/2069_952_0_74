// src/main/java/com/example/demo/repository/ShipmentRepository.java
package com.example.demo.repository;

import com.example.demo.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
    List<Shipment> findByVehicleId(Long vehicleId);
}