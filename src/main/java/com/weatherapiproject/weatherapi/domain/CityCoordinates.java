package com.weatherapiproject.weatherapi.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class CityCoordinates
{
    private String latitude;
    private String longitude;

}
