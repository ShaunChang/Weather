package com.weather.repository;

import com.alibaba.fastjson.JSONObject;
import com.weather.entity.Weather;
import com.weather.httpRequest.HttpUtil;
import org.springframework.stereotype.Component;

@Component
public class WeatherRepository {

    private final HttpUtil httpUtil = new HttpUtil();


    public Weather getCurrentWeather(){
        String url = "http://api.weatherapi.com/v1/current.json?key=191f04bd93bd40af97882243233001&q=Adelaide&aqi=yes";

        String currentWeatherJsonString = httpUtil.sendGet(url);
        JSONObject jsonObject = httpUtil.convertStringToJSONObject(currentWeatherJsonString);

        String currentJsonString = jsonObject.getString("current");
        JSONObject currentJsonObject = httpUtil.convertStringToJSONObject(currentJsonString);

        String conditionJsonString = currentJsonObject.getString("condition");
        JSONObject conditionJsonObject = httpUtil.convertStringToJSONObject(conditionJsonString);

        String air_qualityJsonString = currentJsonObject.getString("air_quality");
        JSONObject air_qualityJsonObject = httpUtil.convertStringToJSONObject(air_qualityJsonString);

        Weather weather = Weather.builder().temp_c(currentJsonObject
                        .getInteger("temp_c"))
                .wind_kph(currentJsonObject.getInteger("wind_kph"))
                .humidity(currentJsonObject.getInteger("humidity"))
                .text(conditionJsonObject.getString("text"))
                .pm2_5(air_qualityJsonObject.getInteger("pm2_5")).build();
        return weather;
    }



}
