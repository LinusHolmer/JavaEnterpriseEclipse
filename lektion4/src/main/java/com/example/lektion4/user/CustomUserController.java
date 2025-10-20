package com.example.lektion4.user;

import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
public class CustomUserController {

    private final CustomUserService customUserService;

    @Autowired
    public CustomUserController(CustomUserService customUserService) {
        this.customUserService = customUserService;
    }

    @GetMapping("/test")
    public void test(){
        throw new CustomUserException("The user does not exist... ");
    }

    @PostMapping
    public Mono<ResponseEntity<CustomUser>> createNewCustomUser(
            @Valid @RequestBody CustomUser customUser
    ) {
        return null;
        //return customUserService.createNewCustomUser(customUser);

    }

}
