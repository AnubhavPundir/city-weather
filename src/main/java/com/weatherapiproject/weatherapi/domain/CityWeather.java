package com.weatherapiproject.weatherapi.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class CityWeather 
{
    private String weather;
    private String details;
    private String temprature;
    private String humidity;
}
