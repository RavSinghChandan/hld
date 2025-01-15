package com.sd.hld.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class URL {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String originalUrl;
    private String shortUrl;
    private int clicks;
    private LocalDateTime creationDate = LocalDateTime.now();
    private LocalDateTime expiryDate;

    public URL(LocalDateTime expiryDate, LocalDateTime creationDate, int clicks, String shortUrl, String originalUrl, Long id) {
        this.expiryDate = expiryDate;
        this.creationDate = creationDate;
        this.clicks = clicks;
        this.shortUrl = shortUrl;
        this.originalUrl = originalUrl;
        this.id = id;
    }

    public URL() {
    }

    public Long getId() {
        return id;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public int getClicks() {
        return clicks;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public void setClicks(int clicks) {
        this.clicks = clicks;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "URL{" +
                "id=" + id +
                ", originalUrl='" + originalUrl + '\'' +
                ", shortUrl='" + shortUrl + '\'' +
                ", clicks=" + clicks +
                ", creationDate=" + creationDate +
                ", expiryDate=" + expiryDate +
                '}';
    }

}
