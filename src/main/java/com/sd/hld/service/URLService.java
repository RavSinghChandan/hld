package com.sd.hld.service;

import com.sd.hld.entity.URL;
import com.sd.hld.repository.URLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class URLService {

    @Autowired
    private URLRepository urlRepository;

    // Define the base URL for the short URL
    private static final String BASE_URL = "https://short.ly/";

    public URL shortenUrl(URL request) {
        // Generate a random hash code
        String hashCode = UUID.randomUUID().toString().substring(0, 8);

        // Combine the base URL with the hash code
        String shortUrl = BASE_URL + hashCode;

        // Set the short URL in the request object
        request.setShortUrl(shortUrl);

        // Save the entity to the database
        return urlRepository.save(request);
    }

    public Optional<URL> getUrlByShortUrl(String shortUrl) {
        return urlRepository.findByShortUrl(shortUrl);
    }

    public URL incrementClicks(URL url) {
        url.setClicks(url.getClicks() + 1);
        return urlRepository.save(url);
    }
}
