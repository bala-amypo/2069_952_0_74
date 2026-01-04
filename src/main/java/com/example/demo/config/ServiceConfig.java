// src/main/java/com/example/demo/config/ServiceConfig.java
package com.example.demo.config;

import com.example.demo.repository.*;
import com.example.demo.service.*;
import com.example.demo.service.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class ServiceConfig {

    @Bean
    public UserService userService(UserRepository userRepository, BCryptPasswordEncoder encoder) {
        return new UserServiceImpl(userRepository, encoder);
    }

    @Bean
    public VehicleService vehicleService(VehicleRepository vehicleRepository, UserRepository userRepository) {
        return new VehicleServiceImpl(vehicleRepository, userRepository);
    }

    @Bean
    public LocationService locationService(LocationRepository locationRepository) {
        return new LocationServiceImpl(locationRepository);
    }

    @Bean
    public ShipmentService shipmentService(ShipmentRepository shipmentRepository,
                                           VehicleRepository vehicleRepository,
                                           LocationRepository locationRepository) {
        return new ShipmentServiceImpl(shipmentRepository, vehicleRepository, locationRepository);
    }

    @Bean
    public RouteOptimizationService routeOptimizationService(ShipmentRepository shipmentRepository,
                                                             RouteOptimizationResultRepository resultRepository) {
        return new RouteOptimizationServiceImpl(shipmentRepository, resultRepository);
    }
}