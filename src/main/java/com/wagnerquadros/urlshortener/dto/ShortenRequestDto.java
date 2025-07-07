package com.wagnerquadros.urlshortener.dto;

import jakarta.validation.constraints.NotBlank;

public record ShortenRequestDto (
        @NotBlank(message = "URL cannot be empty")
        String url
){}
