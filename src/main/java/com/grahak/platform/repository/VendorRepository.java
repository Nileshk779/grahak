package com.grahak.platform.repository;

import com.grahak.platform.domain.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VendorRepository extends JpaRepository<Vendor, Long> {

    @Query(value = "SELECT * FROM vendors v WHERE ST_DWithin(" +
            "v.location::geography, ST_SetSRID(ST_MakePoint(:lng, :lat), 4326)::geography, :radiusMeters)",
            nativeQuery = true)
    List<Vendor> findWithinRadius(@Param("lat") double lat, @Param("lng") double lng, @Param("radiusMeters") double radiusMeters);
}