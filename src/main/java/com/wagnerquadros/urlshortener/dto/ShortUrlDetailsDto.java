package com.wagnerquadros.urlshortener.dto;

import java.time.LocalDateTime;

public record ShortUrlDetailsDto(
        String shortCode,
        String originalUrl,
        LocalDateTime createdAt,
        LocalDateTime expiration,
        boolean isExpired
) {
}
