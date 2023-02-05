package com.weather.service;

import com.weather.entity.Weather;
import com.weather.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequiredArgsConstructor
public class WeatherService {
    private final WeatherRepository weatherRepository;

    public Weather getCurrentWeather(){
        Weather currentWeather = weatherRepository.getCurrentWeather();
        return currentWeather;
    }

}
