package com.example.lektion3.consumer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
public class ConsumerController {

    @GetMapping("/sayHelloAPI")
    public String sayHelloAPI(){
        return "Hello world from API";
    }

    @GetMapping("/fetchAPI")
    public List<Object> fetchAPI(){

        String uri = "https://api.open-meteo.com/v1/forecast?latitude=59.33&longitude=18.07&hourly=temperature_2m,snowfall";
        RestTemplate restTemplate = new RestTemplate();
        WeatherModel weatherModel;

        try {
            weatherModel = restTemplate.getForObject(uri, WeatherModel.class);

            if(weatherModel != null) {
                System.out.println(weatherModel.generationtime_ms);
            }
            return Collections.singletonList(weatherModel);
        } catch (Error e) {
            e.printStackTrace();
        }
        return null;
    }
}
