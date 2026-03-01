package com.rajat.demo2.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class UrlService {
    private Map<String ,String> urlMap=new HashMap<>();

    public String generateShortUrl(String longUrl) {
       String shortCode="abc123";
       urlMap.put(shortCode,longUrl);
       return shortCode;
    }
    public String getOriginalUrl(String shortCode){
       return urlMap.get(shortCode);
    }
    private String generateRandomCode(){
        String characters="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder shortCode=new StringBuilder();
        Random random=new Random();
        for (int i = 0 ; i<6;i++){
            shortCode.append(characters.charAt(random.nextInt(characters.length())));
        }
        return shortCode.toString();
    }
}