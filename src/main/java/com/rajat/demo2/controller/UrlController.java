package com.rajat.demo2.controller;

import com.rajat.demo2.dto.UrlRequest;
import com.rajat.demo2.dto.ShortenResponse;
import com.rajat.demo2.service.UrlService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class UrlController {

    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping("/shorten")
    public ShortenResponse shortenUrl(@Valid @RequestBody UrlRequest request) {

        return urlService.shortenUrl(request.getUrl());
    }
    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> redirect(@PathVariable String shortCode) {

        String originalUrl = urlService.getOriginalUrl(shortCode);

        return ResponseEntity
                .status(HttpStatus.FOUND)
                .location(URI.create(originalUrl))
                .build();
    }
}