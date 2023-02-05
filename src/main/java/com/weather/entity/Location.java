package com.weather.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Location {
    private String name;
    private String region;
    private String country;
    private String lat;
    private String lon;
    private String tz_id;
    private String localtime_epoch;
    private String localtime;
}
