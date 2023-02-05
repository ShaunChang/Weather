package com.weather.service;

import com.weather.mapper.LocationMapper;
import com.weather.dto.LocationGetDto;
import com.weather.entity.Location;
import com.weather.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;


    public LocationGetDto getLocation(String city){
        Location location = locationRepository.getLocation(city);
        return locationMapper.mapperLocationToLocationGetDto(location);
    }
}
