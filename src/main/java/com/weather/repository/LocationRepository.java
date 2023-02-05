package com.weather.repository;

import com.alibaba.fastjson.JSONObject;
import com.weather.entity.Location;
import com.weather.httpRequest.HttpUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LocationRepository {

    private final HttpUtil httpUtil;

    public Location getLocation(String city){
        String url = "http://api.weatherapi.com/v1/current.json?key=191f04bd93bd40af97882243233001&q="+city+"&aqi=yes";
        String locationJsonString = httpUtil.sendGet(url);
        JSONObject jsonObject = JSONObject.parseObject(locationJsonString);
        String location = jsonObject.getString("location");
        Location locationObj = JSONObject.parseObject(location, Location.class);
        return locationObj;
    }
}
