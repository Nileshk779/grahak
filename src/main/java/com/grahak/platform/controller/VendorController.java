package com.grahak.platform.controller;

import com.grahak.platform.domain.Vendor;
import com.grahak.platform.dto.VendorResponse;
import com.grahak.platform.repository.VendorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/vendors")
public class VendorController {

    private final VendorRepository vendorRepository;

    public VendorController(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    private VendorResponse toResponse(Vendor v) {
        return new VendorResponse(
                v.getId(),
                v.getName(),
                v.getAddress(),
                v.getLocation().getY(), // latitude
                v.getLocation().getX(), // longitude
                v.getStockCapacity()
        );
    }

    @GetMapping
    public List<VendorResponse> getAllVendors() {
        return vendorRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/nearby")
    public List<VendorResponse> getNearbyVendors(
            @RequestParam double lat,
            @RequestParam double lng,
            @RequestParam(defaultValue = "3000") double radiusMeters) {
        return vendorRepository.findWithinRadius(lat, lng, radiusMeters).stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}