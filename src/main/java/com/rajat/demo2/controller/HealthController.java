package com.rajat.demo2.controller;

import com.rajat.demo2.model.UrlRequest;
import com.rajat.demo2.service.UrlService;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/(shortCode)")
    public String redirect(@PathVariable String shortCode){
        String originalUrl=urlService.getOriginalUrl(shortCode);
        if(originalUrl==null){
            return "User not found";
        }
        return originalUrl;
    }
}