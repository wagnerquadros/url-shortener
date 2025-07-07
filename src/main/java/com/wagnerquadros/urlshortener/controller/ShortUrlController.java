package com.wagnerquadros.urlshortener.controller;

import com.wagnerquadros.urlshortener.dto.ShortUrlDetailsDto;
import com.wagnerquadros.urlshortener.dto.ShortenRequestDto;
import com.wagnerquadros.urlshortener.dto.ShortenResponseDto;
import com.wagnerquadros.urlshortener.entity.ShortUrl;
import com.wagnerquadros.urlshortener.service.ShortUrlService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class ShortUrlController {

    private final ShortUrlService service;

    @PostMapping("/shorten")
    public ResponseEntity<?> shortenUrl(@RequestBody @Valid ShortenRequestDto request) {
        ShortUrl shortUrl = service.createShortUrl(request.url());
        String shortUrlFull = "https://seulink.com/" + shortUrl.getShortCode();
        return ResponseEntity.ok(new ShortenResponseDto(shortUrlFull));
    }

    @GetMapping("/details/{shortCode}")
    public ResponseEntity<ShortUrlDetailsDto> getDetails(@PathVariable String shortCode) {
        ShortUrlDetailsDto details = service.getUrlDetails(shortCode);
        return ResponseEntity.ok(details);
    }
}
