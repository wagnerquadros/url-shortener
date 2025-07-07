package com.wagnerquadros.urlshortener.repository;

import com.wagnerquadros.urlshortener.entity.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShortUrlRepository extends JpaRepository<ShortUrl,Long> {

    Optional<ShortUrl> findByShortCode(String shortCode);

    /**
     * Deletes all ShortUrl entries that have already expired.
     *
     * @param now The current time. All records with expiration before this will be deleted.
     */
    void deleteAllByExpirationBefore(java.time.LocalDateTime now);
}
