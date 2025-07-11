package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@Configuration
public class RouterConfig {
    @Bean
    public RouterFunction<ServerResponse> routes() {
        return route(GET("/hello"), request -> ServerResponse.ok().bodyValue("Hello Functional"))
                .andRoute(GET("/time"), request -> ServerResponse.ok().body(Mono.just(LocalDateTime.now().toString()), String.class));
    }
}
