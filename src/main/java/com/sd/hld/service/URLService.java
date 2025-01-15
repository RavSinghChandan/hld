package com.sd.hld.service;

import com.sd.hld.entity.URL;

import java.util.Optional;

public interface URLService {
      URL shortenUrl(URL request);
      Optional<URL> getUrlByShortUrl(String shortUrl);
      URL incrementClicks(URL url) ;
}
