package com.weatherapiproject.weatherapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

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
@JsonIgnoreProperties(ignoreUnknown = true) // ignore other json fields but what req
public class GeocodingCoordinatesEntity 
{
    @JsonProperty("lat") // fileds in json response as mentioned
private String latitude;
    @JsonProperty("lon") // fileds in json response as mentioned
private String longitude;

}
