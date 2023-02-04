package com.weather.entity;


import com.weather.httpRequest.HttpUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Weather {
    private final HttpUtil httpUtil;


}
