package com.example.xyz.inventoryservice.repository;

import com.example.xyz.inventoryservice.entity.Venue;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueRepository extends JpaRepository<Venue, Long> {
}
