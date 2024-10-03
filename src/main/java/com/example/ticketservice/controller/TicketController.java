package com.example.ticketservice.controller;

import com.example.ticketservice.dto.TicketDto;
import com.example.ticketservice.service.CoordinatesService;
import com.example.ticketservice.service.LocationService;
import com.example.ticketservice.service.PersonService;
import com.example.ticketservice.service.TicketService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.io.NotActiveException;

@RestController
@RequestMapping("${api.endpoints.base-url}/tickets")
@AllArgsConstructor
public class TicketController {
    private final TicketService ticketService;
    private final PersonService personService;
    private final CoordinatesService coordinatesService;
    private final LocationService locationService;


//    @GetMapping
//    public ResponseEntity<?> getAllTickets() {
//    }

    @PostMapping
    public ResponseEntity<?> saveTicket(@Valid @RequestBody TicketDto ticketDto) throws NotActiveException {

        System.out.println(ticketDto);
        System.out.println(ticketDto.getPersonDto());
        System.out.println(ticketDto.getPersonDto().getLocationDto());

//        if(ticketDto.getCoordinatesDto().getY() == null) throw new MethodArgumentNotValidException();

//        locationService.save(ticketDto.getPersonDto().getLocationDto());
//        coordinatesService.save(ticketDto.getCoordinatesDto());
//        personService.save(ticketDto.getPersonDto());
//        ticketService.save(ticketDto);

        return ResponseEntity.status(201).body(ticketDto);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<?> getTicketById(@PathVariable int id) throws NotActiveException {
        ticketService.findById(id);
        return ResponseEntity.status(200).body(ticketService.findById(id));
    }


    @PatchMapping(value = "{id}")
    public ResponseEntity<?> updateTicket(@PathVariable int id, @RequestBody TicketDto ticket) throws NotActiveException {
        TicketDto ticket1 = ticketService.findById(id);
//        ticketService.update(ticket1, ticket);
        ticketService.save(ticket1);
        return ResponseEntity.status(200).body(ticket);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> deleteTicketById(@PathVariable int id) throws NotActiveException {
        ticketService.deleteById(id);
        return ResponseEntity.status(204).body(ticketService.findById(id));
    }

    @GetMapping(value = "/discounts")
    public ResponseEntity<?> getDiscounts() {
        try {
            return ResponseEntity.status(200).body(ticketService.discountSum());
        } catch (RuntimeException e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping(value = "/types/less/{type}")
    public ResponseEntity<?> getUniqueTypes() {
        try {
            return ResponseEntity.status(200).body(ticketService.getUniqueTypes());
        } catch (RuntimeException e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}

