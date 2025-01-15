package com.sd.hld.controller;

import com.sd.hld.entity.URL;
import com.sd.hld.repository.URLRepository;
import com.sd.hld.service.URLService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("")
public class URLController {

    @Autowired
    private URLService urlService;

    @Operation(summary = "Get user by ID", description = "Provide an ID to lookup a specific user")
    @PostMapping("/shorten")
    public ResponseEntity<?> shortenUrl(@RequestBody URL request) {
        URL savedUrl = urlService.shortenUrl(request);
        return ResponseEntity.ok(savedUrl);
    }

    @GetMapping("/{shortUrl}")
    public RedirectView redirectUrl(@PathVariable String shortUrl) {
        Optional<URL> urlOptional = urlService.getUrlByShortUrl(shortUrl);

        if (urlOptional.isPresent()) {
            URL url = urlOptional.get();
            urlService.incrementClicks(url);
            return new RedirectView(url.getOriginalUrl());
        } else {
            throw new RuntimeException("URL not found");
        }
    }

    @GetMapping("/analytics/{shortUrl}")
    public ResponseEntity<?> getAnalytics(@PathVariable String shortUrl) {
        Optional<URL> urlOptional = urlService.getUrlByShortUrl(shortUrl);

        if (urlOptional.isPresent()) {
            return ResponseEntity.ok(urlOptional.get());
        } else {
            return ResponseEntity.status(404).body("URL not found");
        }
    }

}
