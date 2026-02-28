package com.rajat.demo2.controller;

import com.rajat.demo2.model.UrlRequest;
import com.rajat.demo2.service.UrlService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class HealthController {

    private final UrlService urlService;

    public HealthController(UrlService urlService) {
        this.urlService = urlService;
    }

    // Day 1 API
    @GetMapping("/test")
    public String test() {
        return "Spring Boot Running 🚀";
    }

    // Day 2 API
    @PostMapping("/shorten")
    public String shorten(@RequestBody UrlRequest request) {
        return urlService.generateShortUrl(request.getUrl());
    }
    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> redirect(@PathVariable String shortCode) {

        String originalUrl = urlService.getOriginalUrl(shortCode);

        if (originalUrl == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity
                .status(HttpStatus.FOUND)
                .location(URI.create(originalUrl))
                .build();
    }
}