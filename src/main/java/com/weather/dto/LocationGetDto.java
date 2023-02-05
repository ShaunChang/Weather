package com.weather.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LocationGetDto {
    String region;
    String country;
    String localtime;
}
