package com.sd.hld.repository;

import com.sd.hld.entity.URL;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface URLRepository extends JpaRepository<URL, Long> {
    Optional<URL> findByShortUrl(String shortUrl);
}
