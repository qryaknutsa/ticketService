package com.example.ticketservice.service;


import com.example.ticketservice.dto.PersonDto;
import com.example.ticketservice.mappers.PersonMapper;
import com.example.ticketservice.model.Person;
import com.example.ticketservice.repo.PersonRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.NotActiveException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepo personRepo;

    public List<PersonDto> findAll() {
        return personRepo.findAll().stream().map(PersonMapper::toPersonDto).toList();
    }

    public PersonDto findById(int id) throws NotActiveException {
        return PersonMapper.toPersonDto(personRepo.findById(id).orElseThrow(NotActiveException::new));
    }

    public PersonDto save(PersonDto personDto) {
        return PersonMapper.toPersonDto(personRepo.save(PersonMapper.toPerson(personDto)));
    }


    public void deleteById(int id) {
        personRepo.deleteById(id);
    }

    public void delete(PersonDto personDto) {
        personRepo.delete(PersonMapper.toPerson(personDto));
    }
}
