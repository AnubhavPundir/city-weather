package com.weatherapiproject.weatherapi.transformer;

import org.springframework.stereotype.Service;

import com.weatherapiproject.weatherapi.domain.CityCoordinates;
import com.weatherapiproject.weatherapi.entity.GeocodingCoordinatesEntity;

@Service
public class GeocodingCoordinatesTransformer 
{
public CityCoordinates transformToDomain(final GeocodingCoordinatesEntity entity)
{
    return CityCoordinates.builder()
    .latitude(entity.getLatitude())
    .longitude(entity.getLongitude()).build();
}

}
