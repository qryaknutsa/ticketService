package com.example.ticketservice.model;


import com.example.ticketservice.enums.Country;
import com.example.ticketservice.enums.EyeColor;
import com.example.ticketservice.enums.HairColor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "person")
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "height", nullable = false)
    private int height;

    @Enumerated(EnumType.STRING)
    @Column(name = "eyeColor")
    private EyeColor eyeColor;

    @Enumerated(EnumType.STRING)
    @Column(name = "hairColor", nullable = false)
    private HairColor hairColor;

    @Enumerated(EnumType.STRING)
    @Column(name = "nationality")
    private Country nationality;

    @ManyToOne // more than one people per location
    @JoinColumn(name = "location", nullable = false)
    private Location location;

}
