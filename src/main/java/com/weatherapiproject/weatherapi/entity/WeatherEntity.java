package com.weatherapiproject.weatherapi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter

// we are not using jsonIgnoreProperty = true because all fields in weather are mentioned below
public class WeatherEntity 
{
    @JsonProperty("id")
    private String id;

    @JsonProperty("main")
    private String main;

    @JsonProperty("description")
    private String description;

    @JsonProperty("icon") //key present in json object
    private String icon; // this can be named anything it holds value of the value of field above in jsonProperty
}
