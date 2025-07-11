package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class GithubController {
    private final WebClient webClient;

    @Autowired
    public GithubController(WebClient webClient) {
        this.webClient = webClient;
    }

    @GetMapping("/users/{username}")
    public Mono<String> getUserDetails(@PathVariable String username) {
        return webClient.get()
                .uri("/users/" + username)
                .retrieve()
                .bodyToMono(String.class);
    }
}
