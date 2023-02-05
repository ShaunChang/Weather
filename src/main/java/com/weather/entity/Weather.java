package com.weather.entity;

import lombok.*;

@Getter
@Setter
@Builder
public class Weather {
    private Integer temp_c;
    private Integer wind_kph;
    private Integer humidity;
    private String text;
    private Integer pm2_5;
}
