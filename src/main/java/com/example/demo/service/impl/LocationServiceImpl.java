// src/main/java/com/example/demo/service/impl/LocationServiceImpl.java
package com.example.demo.service.impl;

import com.example.demo.entity.Location;
import com.example.demo.repository.LocationRepository;
import com.example.demo.service.LocationService;

import java.util.List;

public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public Location createLocation(Location location) {
        Double lat = location.getLatitude();
        if (lat == null || lat < -90.0 || lat > 90.0) {
            throw new IllegalArgumentException("Invalid latitude");
        }
        return locationRepository.save(location);
    }

    @Override
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }
}