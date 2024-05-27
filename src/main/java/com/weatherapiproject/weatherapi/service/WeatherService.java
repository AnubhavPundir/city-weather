package com.weatherapiproject.weatherapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weatherapiproject.weatherapi.domain.CityCoordinates;
import com.weatherapiproject.weatherapi.domain.CityWeather;
import com.weatherapiproject.weatherapi.domain.WeatherRequestDetails;
import com.weatherapiproject.weatherapi.entity.WeatherResponse;
import com.weatherapiproject.weatherapi.provider.GeocodingProvider;
import com.weatherapiproject.weatherapi.provider.WeatherProvider;
import com.weatherapiproject.weatherapi.transformer.GeocodingCoordinatesTransformer;
import com.weatherapiproject.weatherapi.transformer.OpenWeatherTransformer;

@Service
public class WeatherService 
{
    private GeocodingProvider geocodingProvider ;
    private GeocodingCoordinatesTransformer geocodingCoordinatesTransformer;
    private WeatherProvider weatherProvider;
    private OpenWeatherTransformer openWeatherTransformer;

    @Autowired            // constructor dependency injection
    public WeatherService(final GeocodingProvider geocodingProvider,
    final GeocodingCoordinatesTransformer geocodingCoordinatesTransformer,
    final WeatherProvider weatherProvider,
    final OpenWeatherTransformer openWeatherTransformer)
    {
        this.geocodingProvider =geocodingProvider;
        this.geocodingCoordinatesTransformer =geocodingCoordinatesTransformer;
        this.weatherProvider =weatherProvider;
        this.openWeatherTransformer=openWeatherTransformer;
    }
    public WeatherResponse getWeather(final WeatherRequestDetails weatherRequestDetails) throws Exception //getWeather is in WeatherResource class , and has to send response as WeatherResponse type
    {

        //retrieve latitude and longitude
        final CityCoordinates cityCoordinates = geocodingCoordinatesTransformer
        .transformToDomain(geocodingProvider.getCoordinates(weatherRequestDetails));

        //retrieve city weather details based on latitude and longitude ie CityCoordinates
        final CityWeather cityWeather = openWeatherTransformer
        .transformToDomain(weatherProvider.getWeather(cityCoordinates));
        
        return openWeatherTransformer.transformToEntity(cityWeather);

    }
}
