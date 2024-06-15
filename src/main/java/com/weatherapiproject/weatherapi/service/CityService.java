package com.weatherapiproject.weatherapi.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

@Service
public class CityService {
    public static Set<String> cities = new HashSet<>();
    @PostConstruct
    public void init() {
        try (InputStream inputStream = getClass().getResourceAsStream("/cities.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) 
            {
                cities.add(line.trim().toLowerCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isCityValid(String cityName) 
    {
        return cities.contains(cityName.trim().toLowerCase());
    }
}