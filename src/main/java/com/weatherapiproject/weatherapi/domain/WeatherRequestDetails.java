package com.weatherapiproject.weatherapi.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder //reduce boilerplate code
@Setter
@Getter
public class WeatherRequestDetails 
{
    private String city;
}
