package com.rajat.demo2.service;

import com.rajat.demo2.dto.ShortenResponse;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class UrlService {

    private Map<String, String> urlMap = new HashMap<>();

    public ShortenResponse shortenUrl(String longUrl) {

        String shortCode;

        do {
            shortCode = generateRandomCode();
        } while (urlMap.containsKey(shortCode));

        urlMap.put(shortCode, longUrl);

        return new ShortenResponse(shortCode);
    }

    public String getOriginalUrl(String shortCode) {
        return urlMap.get(shortCode);
    }

    private String generateRandomCode() {

        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        StringBuilder shortCode = new StringBuilder();

        Random random = new Random();

        for (int i = 0; i < 6; i++) {

            int index = random.nextInt(characters.length());

            shortCode.append(characters.charAt(index));
        }

        return shortCode.toString();
    }
}