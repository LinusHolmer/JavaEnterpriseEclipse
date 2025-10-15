package com.example.demo.weather;

import com.example.demo.weather.domain.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class DefaultWeatherService implements WeatherService {

    private final WebClient webClient;

    @Autowired
    public DefaultWeatherService(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Mono<Weather> getForecast(double lat, double lon) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/forecast")
                        .queryParam("latitude", lat)
                        .queryParam("longitude", lon)
                        .query("hourly=temperature_2m")
                        .build()
                )
                .retrieve()
                .onStatus(
                        httpStatusCode -> httpStatusCode.is4xxClientError(),
                        clientResponse -> Mono.error(new RuntimeException("Not Found"))
                )
                .onStatus(
                        httpStatusCode -> httpStatusCode.is4xxClientError(),
                        clientResponse -> Mono.error(new RuntimeException("Not Found"))

                )
                .bodyToMono(Weather.class);
    }

    public WebClient getWebClient() {
        return webClient;
    }
}
