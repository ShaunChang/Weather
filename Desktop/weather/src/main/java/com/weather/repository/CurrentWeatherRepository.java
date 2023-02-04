package com.weather.repository;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.httpRequest.HttpUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

public class CurrentWeatherRepository {

    private final HttpUtil httpUtil = new HttpUtil();

    public CurrentWeatherRepository() {
    }

    public String getCurrentWeather(String url){
        String s = httpUtil.sendGet(url);
        return s;
    }

    public static void main(String[] args) throws JsonProcessingException {
        String url = "http://api.weatherapi.com/v1/current.json?key=191f04bd93bd40af97882243233001&q=London&aqi=yes";


        CurrentWeatherRepository currentWeatherRepository = new CurrentWeatherRepository();
        String currentWeather = currentWeatherRepository.getCurrentWeather(url);

        //json字符串-->json对象
        JSONObject jsonObject = JSONObject.parseObject(currentWeather);
//        JSONObject jsonObject1 = jsonObject.getJSONObject("location");
        String location = jsonObject.getString("location");
//        JSONObject locationJson = JSONObject.parseObject(location);
        Location cxc = JSONObject.parseObject(location, Location.class);

        System.out.println("------");
        System.out.println(cxc);
    }

    static class Location{
        String name;
        String region;
        String country;
        String lat;
        String lon;
        String tz_id;
        String localtime_epoch;
        String localtime;

        @Override
        public String toString() {
            return "Location:::::::::::::::::{" +
                    "name='" + name + '\'' +
                    ", region='" + region + '\'' +
                    ", country='" + country + '\'' +
                    ", lat='" + lat + '\'' +
                    ", lon='" + lon + '\'' +
                    ", tz_id='" + tz_id + '\'' +
                    ", localtime_epoch='" + localtime_epoch + '\'' +
                    ", localtime='" + localtime + '\'' +
                    '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getLon() {
            return lon;
        }

        public void setLon(String lon) {
            this.lon = lon;
        }

        public String getTz_id() {
            return tz_id;
        }

        public void setTz_id(String tz_id) {
            this.tz_id = tz_id;
        }

        public String getLocaltime_epoch() {
            return localtime_epoch;
        }

        public void setLocaltime_epoch(String localtime_epoch) {
            this.localtime_epoch = localtime_epoch;
        }

        public String getLocaltime() {
            return localtime;
        }

        public void setLocaltime(String localtime) {
            this.localtime = localtime;
        }
    }

}
