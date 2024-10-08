package com.example.ticketservice.mappers;

import com.example.ticketservice.dto.CoordinatesDto;
import com.example.ticketservice.model.Coordinates;

public class CoordinatesMapper {

    public static CoordinatesDto toCoordinatesDto(Coordinates coordinates) {
        CoordinatesDto coordinatesDto = new CoordinatesDto();
        coordinatesDto.setX(coordinates.getX());
        coordinatesDto.setY(coordinates.getY());

        return coordinatesDto;
    }

    public static Coordinates toCoordinates(CoordinatesDto coordinatesDto) {
        Coordinates coordinates = new Coordinates();
        coordinates.setX(coordinatesDto.getX());
        coordinates.setY(coordinatesDto.getY());
        return coordinates;
    }
}
