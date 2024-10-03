package com.example.ticketservice.service;

import com.example.ticketservice.dto.LocationDto;
import com.example.ticketservice.mappers.LocationMapper;
import com.example.ticketservice.model.Location;
import com.example.ticketservice.repo.LocationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.NotActiveException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LocationService {
    private final LocationRepo locationRepo;

    public List<LocationDto> findAll() {
        return locationRepo.findAll().stream().map(LocationMapper::toLocationDto).toList();
    }

    public LocationDto findById(int id) throws NotActiveException {
        return LocationMapper.toLocationDto(locationRepo.findById(id).orElseThrow(NotActiveException::new));
    }

    public LocationDto save(LocationDto locationDto) {
        return LocationMapper.toLocationDto(locationRepo.save(LocationMapper.toLocation(locationDto)));
    }

    public void deleteById(int id) {
        locationRepo.deleteById(id);
    }

    public void delete(LocationDto locationDto) {
        locationRepo.delete(LocationMapper.toLocation(locationDto));
    }
}