package com.example.ticketservice.service;

import com.example.ticketservice.dto.TicketDto;
import com.example.ticketservice.enums.TicketType;
import com.example.ticketservice.mappers.TicketMapper;
import com.example.ticketservice.model.Ticket;
import com.example.ticketservice.repo.TicketRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.NotActiveException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final TicketRepo ticketRepo;

    public List<TicketDto> findAll() {
        return ticketRepo.findAll().stream().map(TicketMapper::toTicketDto).toList();
    }

    public TicketDto findById(int id) throws NotActiveException {
        return TicketMapper.toTicketDto(ticketRepo.findById(id).orElseThrow(NotActiveException::new));
    }

    public TicketDto save(TicketDto ticketDto) {
        return TicketMapper.toTicketDto(ticketRepo.save(TicketMapper.toTicket(ticketDto)));
    }


    public void deleteById(int id) {
        ticketRepo.deleteById(id);
    }

    public void delete(TicketDto ticketDto) {
        ticketRepo.delete(TicketMapper.toTicket(ticketDto));
    }


    // Доп операции
    public double discountSum() {
        return ticketRepo.findAll().stream()
                .mapToDouble(Ticket::getDiscount)
                .sum();
    }

    public long getAmountLessThanType(TicketType type){
        List<TicketType> list = TicketType.getLessTypes(type);
        return ticketRepo.findAll().stream().filter(ticket -> list.contains(ticket.getType())).count();
    }

    public Set<String> getUniqueTypes(){
        return ticketRepo.findAll().stream()
                .map(ticket -> ticket.getType().name())
                .collect(Collectors.toSet());
    }

}