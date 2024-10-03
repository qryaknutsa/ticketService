package com.example.ticketservice.repo;

import com.example.ticketservice.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


//TODO: filter and sort by multiple fields
public interface TicketRepo extends JpaRepository<Ticket, Integer> {

//    @Query("SELECT DISTINCT t.type FROM Ticket t")
//    List<Ticket.TicketType> findDistinctTicketTypes();

}
