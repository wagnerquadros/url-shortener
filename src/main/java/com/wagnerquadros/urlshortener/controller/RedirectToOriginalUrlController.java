package com.wagnerquadros.urlshortener.controller;

import com.wagnerquadros.urlshortener.service.ShortUrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RedirectToOriginalUrlController {

    private final ShortUrlService service;

    @GetMapping("/{shortCode}")
    public ResponseEntity<?> redirectToOriginalUrl(@PathVariable String shortCode) {
        return service.getValidUrl(shortCode)
                .map(url -> ResponseEntity.status(HttpStatus.FOUND)
                        .header(HttpHeaders.LOCATION, url.getOriginalUrl())
                        .build())
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Short URL not found or expired"));
    }
}
