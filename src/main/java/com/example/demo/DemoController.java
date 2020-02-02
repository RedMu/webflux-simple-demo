package com.example.demo;

import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

import java.time.Duration;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class DemoController {

    @GetMapping(value="/", produces = "application/stream+json")
    public Flux<String> getMethodName() {
        return Flux.interval(Duration.ofSeconds(1), Duration.ofMillis(100))
            .map(l -> {
                System.out.println("Hello " + l);
                return "Hello " + l;
            });
    }
    
}   