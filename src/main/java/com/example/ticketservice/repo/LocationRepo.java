package com.example.ticketservice.repo;

import com.example.ticketservice.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepo extends JpaRepository<Location, Integer> {
}
