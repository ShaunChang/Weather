package com.weather.controller;


import com.weather.dto.LocationGetDto;
import com.weather.service.LocationService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("locations")
public class LocationController {

    private final LocationService locationService;

    @GetMapping("/{city}")
    public LocationGetDto getLocation(@PathVariable String city){
        return locationService.getLocation(city);
    }
}
