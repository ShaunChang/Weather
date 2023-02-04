package com.weather.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @PostMapping("/weather")
    public String getCurrentWeather(){
        return "ccc";
    }

}
