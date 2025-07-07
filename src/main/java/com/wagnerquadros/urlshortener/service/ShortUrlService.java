package com.wagnerquadros.urlshortener.service;

import com.wagnerquadros.urlshortener.entity.ShortUrl;
import com.wagnerquadros.urlshortener.repository.ShortUrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ShortUrlService {

    private final ShortUrlRepository repository;

    public ShortUrl createShortUrl(String originalUrl) {
        String shortCode = generateShortCode();

        ShortUrl url = ShortUrl.builder()
                .shortCode(shortCode)
                .originalUrl(originalUrl)
                .createdAt(LocalDateTime.now())
                .expiration(LocalDateTime.now().plusHours(24))
                .build();

        return repository.save(url);
    }

    private String generateShortCode() {
        String code;
        do {
            code = UUID.randomUUID().toString().substring(0, 8);
        } while (repository.findByShortCode(code).isPresent());
        return code;
    }

    public Optional<ShortUrl> getValidUrl(String shortCode){
        return repository.findByShortCode(shortCode)
                .filter(url -> url.getExpiration().isAfter(LocalDateTime.now()));
    }

    @Scheduled(fixedRate = 60 * 60 * 1000) // Every 1 hour (in milliseconds)
    public void removeExpiredUrls() {
        repository.deleteAllByExpirationBefore(LocalDateTime.now());
        System.out.println("Expired URLs removed at: " + LocalDateTime.now());
    }
}
