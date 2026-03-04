package com.example.demo2.dto;

import jakarta.validation.constraints.NotBlank;

public class UrlRequest {

    @NotBlank
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}