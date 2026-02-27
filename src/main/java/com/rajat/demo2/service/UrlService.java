package com.rajat.demo2.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UrlService {
    private Map<String ,String> urlMap=new HashMap<>();

    public String generateShortUrl(String longUrl) {
        return "short123";
    }
}