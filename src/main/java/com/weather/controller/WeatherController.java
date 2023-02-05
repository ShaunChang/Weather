package com.weather.controller;

import com.weather.entity.Weather;
import com.weather.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("weather")
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping
    public Weather getCurrentWeather(){
        return weatherService.getCurrentWeather();
    }
}
