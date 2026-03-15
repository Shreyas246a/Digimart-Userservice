package com.Digimart.userservice.Service.Implementations;

import com.Digimart.userservice.Entity.EmailVerificationTokens;
import com.Digimart.userservice.Service.OtpService;
import com.Digimart.userservice.repository.TokenRepository;
import com.Digimart.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
@Service
public class OtpServiceImplementation implements OtpService {
    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    EmailService emailService = new EmailService(null);
    OtpServiceImplementation(UserRepository userRepository, TokenRepository tokenRepository){
        this.userRepository = userRepository;
        this.tokenRepository = tokenRepository;
    }

    @Override
    public String generateOtp(String email) {
        if(userRepository.existsByEmail(email)){
            throw new RuntimeException("Email already exists");
        }
        String otp = String.valueOf(100000 + new SecureRandom().nextInt(900000));
        if(tokenRepository.existsByEmail(email)){
            tokenRepository.deleteByEmail(email);
        }
        EmailVerificationTokens token = new EmailVerificationTokens();
        token.setOtp(otp);
        token.setEmail(email);
        tokenRepository.save(token);
        emailService.sendEmail(email,"Your OTP for Digimart Registration","Your OTP is: " + otp);
        return otp;
    }

    @Override
    public boolean validateOtp(String email, String otp) {
        EmailVerificationTokens token = tokenRepository.findByOtpAndEmail(otp,email).orElseThrow(
                () -> new RuntimeException("Invalid OTP or email")
        );
        if(token.isVerified()){
            throw new RuntimeException("Email already verified");
        }
        if(token.getExpiry().isBefore(java.time.LocalDateTime.now())) {
            tokenRepository.delete(token);
            throw new RuntimeException("OTP expired");
        }
        token.setVerified(true);
        tokenRepository.save(token);
        return true;
    }
}
