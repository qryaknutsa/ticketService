package com.example.ticketservice.service;

import com.example.ticketservice.dto.CoordinatesDto;
import com.example.ticketservice.mappers.CoordinatesMapper;
import com.example.ticketservice.model.Coordinates;
import com.example.ticketservice.repo.CoordinatesRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.NotActiveException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CoordinatesService {
    private final CoordinatesRepo coordinatesRepo;

    public List<Coordinates> getAll(){
        return coordinatesRepo.findAll();
    }

    public CoordinatesDto getById(int id) throws NotActiveException {
        return CoordinatesMapper.toCoordinatesDto(coordinatesRepo.findById(id).orElseThrow(NotActiveException::new));
    }

    public CoordinatesDto save(CoordinatesDto coordinatesDto) throws NotActiveException {
        return CoordinatesMapper.toCoordinatesDto(coordinatesRepo.save(CoordinatesMapper.toCoordinates(coordinatesDto)));
    }


    public void deleteById(int id) throws NotActiveException {
        coordinatesRepo.deleteById(id);
    }

    public void delete(CoordinatesDto coordinatesDto) throws NotActiveException {
        coordinatesRepo.delete(CoordinatesMapper.toCoordinates(coordinatesDto));
    }

}
