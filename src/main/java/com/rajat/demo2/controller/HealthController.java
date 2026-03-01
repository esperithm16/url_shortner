package com.rajat.demo2.controller;

import com.rajat.demo2.model.UrlRequest;
import com.rajat.demo2.service.UrlService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

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
    public Map<String,String> shorten(@RequestBody String longUrl) {
        String shortCode=urlService.generateShortUrl(longUrl);
Map<String ,String>response=new HashMap<>();
response.put("shortUrl",shortCode);
return response;
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