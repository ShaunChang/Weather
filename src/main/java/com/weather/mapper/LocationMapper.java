package com.weather.mapper;


import com.weather.dto.LocationGetDto;
import com.weather.entity.Location;
import org.springframework.stereotype.Component;

@Component
public class LocationMapper {

    public LocationGetDto mapperLocationToLocationGetDto(Location location){
        return LocationGetDto.builder().country(location.getCountry()).region(location.getRegion()).localtime(location.getLocaltime()).build();
    }

}
