package com.example.ticketservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name = "location")
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "x", nullable = false)
    private int x;

    @Column(name = "y")
    private double y;

    @Column(name = "z", nullable = false)
    private double z;

    @Column(name = "name")
    private String name;

}
