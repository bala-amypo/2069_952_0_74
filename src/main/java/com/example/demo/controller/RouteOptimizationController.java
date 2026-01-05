// src/main/java/com/example/demo/controller/RouteOptimizationController.java
package com.example.demo.controller;

import com.example.demo.entity.RouteOptimizationResult;
import com.example.demo.service.RouteOptimizationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/routes")
public class RouteOptimizationController {
    private final RouteOptimizationService routeOptimizationService;
    public RouteOptimizationController(RouteOptimizationService routeOptimizationService) {
        this.routeOptimizationService = routeOptimizationService;
    }

    @PostMapping("/optimize/{shipmentId}")
    public RouteOptimizationResult optimize(@PathVariable Long shipmentId) {
        return routeOptimizationService.optimizeRoute(shipmentId);
    }

    @GetMapping("/result/{id}")
    public RouteOptimizationResult getResult(@PathVariable Long id) {
        return routeOptimizationService.getResult(id);
    }
}