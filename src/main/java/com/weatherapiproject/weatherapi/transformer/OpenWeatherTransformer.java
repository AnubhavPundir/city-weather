package com.weatherapiproject.weatherapi.transformer;

import org.springframework.stereotype.Service;

import com.weatherapiproject.weatherapi.domain.CityWeather;
import com.weatherapiproject.weatherapi.entity.OpenWeatherResponseEntity;
import com.weatherapiproject.weatherapi.entity.WeatherResponse;

@Service
public class OpenWeatherTransformer 
{
    public CityWeather transformToDomain(final OpenWeatherResponseEntity entity)
    {
        double tempInCelcius= Math.round((Double.parseDouble(entity.getTemps().getTemp()) - 273.00)*100)/100;
        String finalTemp = Double.toString(tempInCelcius);
        return CityWeather.builder()
        .weather(entity.getWeather()[0].getMain())
        .details(entity.getWeather()[0].getDescription())
        .temprature(finalTemp) //providing temprature a value by accesing temps in OpenWeatherResopnse then getTemp means getting temp value
        .humidity(entity.getTemps().getHumidity())
        .build();
    }

    public WeatherResponse transformToEntity(final CityWeather cityWeather) 
    {
       return WeatherResponse.builder()
       .weather(cityWeather.getWeather())
       .details(cityWeather.getDetails())
       .temprature(cityWeather.getTemprature())
       .humidity(cityWeather.getHumidity()).build();
    }
}
