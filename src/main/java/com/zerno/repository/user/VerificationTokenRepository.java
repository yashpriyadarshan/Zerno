package com.zerno.repository.user;

import com.zerno.entity.user.VerificationToken;
import com.zerno.type.TokenType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.time.LocalDateTime;

@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {

    // Find a token by its string value
    Optional<VerificationToken> findByToken(String token);

    // Find a token by user and type
    Optional<VerificationToken> findByUserIdAndType(Long userId, TokenType type);

    // Find all active (not expired and not used) tokens of a certain type
    Optional<VerificationToken> findByUserIdAndTypeAndUsedFalseAndExpiresAtAfter(Long userId, TokenType type, LocalDateTime now);
}
