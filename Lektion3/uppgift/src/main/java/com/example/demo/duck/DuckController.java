package com.example.demo.duck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class DuckController {

    private final DuckService duckService;

    @Autowired
    public DuckController(@Qualifier("defaultDuckService") DuckService duckService) {
        this.duckService = duckService;
    }

    // gjorde så man kan får bilden på duck i jpeg format
     @GetMapping
    public Mono<ResponseEntity<byte[]>> getDuck(
            @RequestParam String imageFile
     ) {
        return duckService.getDuck(imageFile)
                .map(duck -> ResponseEntity.ok().header("Content-Type", "image/jpeg")
                        .body(duck))
                .defaultIfEmpty(ResponseEntity.badRequest().build());
     }


}
