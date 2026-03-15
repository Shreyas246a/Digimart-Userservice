package com.Digimart.userservice.Service;

public interface OtpService {
    String generateOtp(String email);
    boolean validateOtp(String email, String otp);
}