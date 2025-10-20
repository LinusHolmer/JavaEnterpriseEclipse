package com.example.demo.weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(@Qualifier("defaultWeatherService") WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    public Mono<ResponseEntity<String>> getWeatherByLatLon(
            @RequestParam double lat,
            @RequestParam double lon
    ) {
        return weatherService.getForecast(lat, lon)
                .map(weather -> ResponseEntity.ok().body(weather))
                .switchIfEmpty(Mono.just(
                        ResponseEntity.badRequest().build()
                ));
    }

    public WeatherService getWeatherService() {
        return weatherService;
    }
}
