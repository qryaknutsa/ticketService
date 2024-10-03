package com.example.ticketservice.dto;

import com.example.ticketservice.enums.Country;
import com.example.ticketservice.enums.EyeColor;
import com.example.ticketservice.enums.HairColor;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {
    @Min(value = 50, message = "Значение должно быть больше 50")
    @Max(value = 300, message = "Значение должно быть меньше 300")
    @NotNull
    private int height;

    @Size(min = 3, max = 5)
    private EyeColor eyeColor;

    @NotNull
    @Size(min = 3, max = 6)
    private HairColor hairColor;

    @Size(min = 5, max = 11)
    private Country nationality;

    @JsonProperty("location")
    @NotNull
    private LocationDto locationDto;


    public PersonDto(int height, HairColor hairColor, LocationDto locationDto) {
        this.height = height;
        this.hairColor = hairColor;
        this.locationDto = locationDto;
    }


    public PersonDto(int height, EyeColor eyeColor, HairColor hairColor, LocationDto locationDto) {
        this.height = height;
        this.hairColor = hairColor;
        this.locationDto = locationDto;
        this.eyeColor = eyeColor;
    }

    public PersonDto(int height, HairColor hairColor, Country nationality, LocationDto locationDto) {
        this.height = height;
        this.hairColor = hairColor;
        this.locationDto = locationDto;
        this.nationality = nationality;
    }

}
