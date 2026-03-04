package com.rajat.demo2.controller;

import com.rajat.demo2.dto.UrlRequest;
import com.rajat.demo2.dto.ShortenResponse;
import com.rajat.demo2.service.UrlService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

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
}