package com.example.ticketservice.enums;

import com.example.ticketservice.model.Ticket;

import java.util.List;

public enum TicketType {
    CHEAP,
    BUDGETARY,
    USUAL,
    VIP;

    public static List<TicketType> getLessTypes(TicketType type){
        return switch (type) {
            case VIP -> List.of(TicketType.CHEAP, TicketType.USUAL, TicketType.BUDGETARY);
            case USUAL -> List.of(TicketType.CHEAP, TicketType.BUDGETARY);
            case BUDGETARY -> List.of(TicketType.CHEAP);
            default -> List.of();
        };
    }
}
