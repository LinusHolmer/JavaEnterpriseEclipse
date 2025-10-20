package com.example.demo.weather;

import com.example.demo.weather.domain.Weather;
import reactor.core.publisher.Mono;

public interface WeatherService {
    Mono<Weather> getForecast(double lat, double lon);
}
