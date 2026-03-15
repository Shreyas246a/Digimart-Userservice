package com.Digimart.userservice.DTO.Request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class LoginRequestDTO {
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private  String password;
}
