package com.rajat.demo2.service;

import com.rajat.demo2.Repository.UrlMappingRepository;
import com.rajat.demo2.model.UrlMapping;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UrlService {

    private final UrlMappingRepository repository;

    public UrlService(UrlMappingRepository repository) {
        this.repository = repository;
    }

    public String createShortUrl(String originalUrl) {

        String shortCode = generateShortCode();

        UrlMapping mapping = new UrlMapping();
        mapping.setOriginalUrl(originalUrl);
        mapping.setShortCode(shortCode);

        repository.save(mapping);

        return shortCode;
    }
    public String getOriginalUrl(String shortCode) {

        UrlMapping mapping = repository
                .findByShortCode(shortCode)
                .orElseThrow(() -> new RuntimeException("URL not found"));

        return mapping.getOriginalUrl();
    }
    @Service
    public class UrlService {

        private final UrlMappingRepository repository;

        public UrlService(UrlMappingRepository repository) {
            this.repository = repository;
        }

    private String generateShortCode() {

        String chars =
                "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        Random random = new Random();

        StringBuilder code = new StringBuilder();

        for(int i=0;i<6;i++){
            code.append(chars.charAt(random.nextInt(chars.length())));
        }

        return code.toString();
    }
}