package com.example.ticketservice.repo;

import com.example.ticketservice.model.Coordinates;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoordinatesRepo extends JpaRepository<Coordinates, Integer> {
}
