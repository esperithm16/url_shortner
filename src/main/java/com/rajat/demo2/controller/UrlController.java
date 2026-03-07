package com.yourproject.controller;

package com.rajat.demo2.controller;
import com.rajat.demo2.service.UrlService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UrlController {

    private final UrlService urlService;

    public UrlController(UrlService urlService){
        this.urlService = urlService;
    }

    @PostMapping("/shorten")
    public String shortenUrl(@RequestBody String url){

        return urlService.createShortUrl(url);

    }
}