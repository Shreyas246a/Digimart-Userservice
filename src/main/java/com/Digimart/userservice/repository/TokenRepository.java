package com.Digimart.userservice.repository;

import com.Digimart.userservice.Entity.EmailVerificationTokens;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TokenRepository extends JpaRepository<EmailVerificationTokens, UUID> {

    Optional<EmailVerificationTokens> findByOtpAndEmail(String otp,String email);
    Optional<EmailVerificationTokens> findByEmail(String email);
    boolean existsByEmail(String email);
    @Transactional
    void deleteByEmail(String email);
}
