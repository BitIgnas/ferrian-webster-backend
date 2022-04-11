package com.ferrianwebsterdictionary.app.demo.controller;

import com.ferrianwebsterdictionary.app.demo.service.RandomWordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v2/random-word")
public class RandomWordController {

    private final RandomWordService randomWordService;

    public RandomWordController(RandomWordService randomWordService) {
        this.randomWordService = randomWordService;
    }

    @GetMapping("/")
    public ResponseEntity<String> getRandomWord() {
        URI location = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v2/random-word/").toUriString());
        return ResponseEntity.created(location).body(randomWordService.generateRandomWord());
    }

    @GetMapping("/topics")
    public ResponseEntity<String> getRandomWordWithTopics(@RequestBody String[] topics) {
        URI location = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v2/random-word/topics").toUriString());
        return ResponseEntity.created(location).body(randomWordService.generateRandomWordWithTopics(Arrays.asList(topics)));
    }
}
