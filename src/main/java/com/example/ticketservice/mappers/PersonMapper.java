package com.example.ticketservice.mappers;

import com.example.ticketservice.dto.PersonDto;
import com.example.ticketservice.model.Person;

public class PersonMapper {

    public static PersonDto toPersonDto(Person person) {
        PersonDto dto = new PersonDto();
        dto.setHeight(person.getHeight());
        dto.setHairColor(person.getHairColor());
        dto.setLocationDto(LocationMapper.toLocationDto(person.getLocation()));

        if(person.getNationality() != null) dto.setNationality(person.getNationality());
        if(person.getEyeColor() != null) dto.setEyeColor(person.getEyeColor());

        return dto;
    }

    public static Person toPerson(PersonDto personDto) {
        Person person = new Person();
        person.setHeight(personDto.getHeight());
        person.setHairColor(personDto.getHairColor());
        person.setLocation(LocationMapper.toLocation(personDto.getLocationDto()));

        if(personDto.getNationality() != null) person.setNationality(personDto.getNationality());
        if(personDto.getEyeColor() != null) person.setEyeColor(personDto.getEyeColor());

        return person;
    }
}
