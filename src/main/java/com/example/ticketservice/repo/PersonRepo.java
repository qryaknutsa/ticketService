package com.example.ticketservice.repo;

import com.example.ticketservice.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonRepo extends JpaRepository<Person, Integer> {
}
