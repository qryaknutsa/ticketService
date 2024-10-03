package com.example.ticketservice.model;

import com.example.ticketservice.enums.TicketType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "ticket")
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne // more than one ticket to one pair of coordinates
    @JoinColumn(name = "coordinates", nullable = false)
    private Coordinates coordinates;

    @Column(name = "creationDate", nullable = false)
    ZonedDateTime creationDate = ZonedDateTime.now();

    @Column(name = "price", nullable = false)
    private int price;

    //TODO: попроавить Swagger - required
    @Column(name = "discount", nullable = false)
    private double discount;



    @Column(name = "refundable")
    private Boolean refundable;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private TicketType type;

    @ManyToOne // more than one ticket to one person
    @JoinColumn(name = "person")
    private Person person;
}
