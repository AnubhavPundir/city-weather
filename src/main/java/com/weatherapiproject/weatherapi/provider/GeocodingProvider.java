package com.weatherapiproject.weatherapi.provider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import com.weatherapiproject.weatherapi.domain.WeatherRequestDetails;
import com.weatherapiproject.weatherapi.entity.GeocodingCoordinatesEntity; 

@Service
public class GeocodingProvider
{
    @Value("${api.key}")
    private String apiKey; // storing apikey from properties into variable

    @Value("${geocoding.url}")
    private String geocodingUrl; // storing geocoding url from properties into variable

    public GeocodingCoordinatesEntity getCoordinates(final WeatherRequestDetails weatherRequestDetails) throws Exception
    {
        // calling geocoding api to fetch latitude and longitude
        RestTemplate restTeamplate = new RestTemplate();
        final ResponseEntity<GeocodingCoordinatesEntity[]> responseEntity;

        HttpEntity<String> requestEntity = new HttpEntity<>(null,null);
        //build url
        UriComponents uriBuilder = UriComponentsBuilder.fromHttpUrl(geocodingUrl)
        .queryParam("q",weatherRequestDetails.getCity())
        .queryParam("limit","1")
        .queryParam("appid",apiKey).build(); //building query with qparams

        try
        {
            responseEntity = restTeamplate
            .exchange(uriBuilder.toUriString(),
            HttpMethod.GET,
            requestEntity,
            GeocodingCoordinatesEntity[].class
            );
        }
        catch(HttpStatusCodeException e)
        {
            throw new Exception(e.getMessage());
        }
        return responseEntity.getBody()[0]; // we just need one entity  it will be one only as value is set 1 for limit queryParam
    }
}
