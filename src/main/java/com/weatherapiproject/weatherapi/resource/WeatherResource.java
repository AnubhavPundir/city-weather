package com.weatherapiproject.weatherapi.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping; // to map req to controller methods
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController; //used for RESTful webservices

import com.weatherapiproject.weatherapi.domain.WeatherRequestDetails;// class we created 
import com.weatherapiproject.weatherapi.entity.WeatherResponse;// importing our created weatherResponse class in entity
import com.weatherapiproject.weatherapi.service.WeatherService;


/* 
this class will 
act as the main entry point for application
as it will hold the endpoint where user/customer will interact
with the api from
*/ 
@RestController
@RequestMapping("/api/v1")
public class WeatherResource 
{

    private WeatherService weatherService; //service class needs to be returned from WeatherResponse function

    @Autowired    // used for automatic Dependency injection
    public WeatherResource (final WeatherService weatherService) // constructor for dependency injection
    {
        this.weatherService = weatherService;
    }

    @CrossOrigin(origins = {"https://anubhavpundir.github.io","https://anubhavpundir.github.io/city_weather_frontend/"})
    @GetMapping("/weather/{city}")
    public  @ResponseBody WeatherResponse weather(@PathVariable("city") String city)throws Exception
    {
        final WeatherRequestDetails weatherRequestDetails =  WeatherRequestDetails.builder()
        .city(city).build(); //providing value to variable defined in WeatherRequestDetails class
        
        return weatherService.getWeather(weatherRequestDetails);
    }
}
