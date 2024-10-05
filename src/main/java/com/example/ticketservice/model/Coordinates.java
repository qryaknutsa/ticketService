package com.example.ticketservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@Table(name = "coordinates")
@AllArgsConstructor
@NoArgsConstructor
public class Coordinates implements Serializable {

    //    @EmbeddedId
//    private CoordinatesId coordinates;
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "x")
    private float x;

    @Column(name = "y", nullable = false)
    private Float y;

}
