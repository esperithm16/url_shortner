package com.rajat.demo2.controller;
import com.rajat.demo2.dto.UrlRequest;
import com.rajat.demo2.service.UrlService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class UrlController {

    private final UrlService urlService;

    public UrlController(UrlService urlService){
        this.urlService = urlService;
    }
    @GetMapping("/{shortCode}")
    public void redirect(@PathVariable String shortCode,
                         HttpServletResponse response) throws IOException {

        String originalUrl = urlService.getOriginalUrl(shortCode);

        response.sendRedirect(originalUrl);
    }
    @PostMapping("/shorten")
    public String shortenUrl(@RequestBody UrlRequest request){
        return urlService.createShortUrl(request.getUrl());
    }
}