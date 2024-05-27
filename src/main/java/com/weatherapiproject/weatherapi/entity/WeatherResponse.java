package com.weatherapiproject.weatherapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WeatherResponse 
{
    private String weather;
    private String details;
    private String temprature;
    private String humidity;
}
