// src/main/java/com/example/demo/service/impl/RouteOptimizationServiceImpl.java
package com.example.demo.service.impl;

import com.example.demo.entity.Location;
import com.example.demo.entity.RouteOptimizationResult;
import com.example.demo.entity.Shipment;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.RouteOptimizationResultRepository;
import com.example.demo.repository.ShipmentRepository;
import com.example.demo.service.RouteOptimizationService;

public class RouteOptimizationServiceImpl implements RouteOptimizationService {
    private final ShipmentRepository shipmentRepository;
    private final RouteOptimizationResultRepository resultRepository;

    public RouteOptimizationServiceImpl(ShipmentRepository shipmentRepository,
                                        RouteOptimizationResultRepository resultRepository) {
        this.shipmentRepository = shipmentRepository;
        this.resultRepository = resultRepository;
    }

    @Override
    public RouteOptimizationResult optimizeRoute(Long shipmentId) {
        Shipment s = shipmentRepository.findById(shipmentId)
            .orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));

        Location p = s.getPickupLocation();
        Location d = s.getDropLocation();
        double dx = d.getLatitude() - p.getLatitude();
        double dy = d.getLongitude() - p.getLongitude();
        double distanceKm = Math.sqrt(dx * dx + dy * dy) * 111.0;
        if (distanceKm <= 0) distanceKm = 1.0;

        double kmPerLiter = s.getVehicle().getFuelEfficiency();
        double fuelL = Math.max(distanceKm / Math.max(kmPerLiter, 0.1), 0.1);

        RouteOptimizationResult result = RouteOptimizationResult.builder()
            .shipment(s)
            .optimizedDistanceKm(distanceKm)
            .estimatedFuelUsageL(fuelL)
            .build();

        return resultRepository.save(result);
    }

    @Override
    public RouteOptimizationResult getResult(Long id) {
        return resultRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Result not found"));
    }
}