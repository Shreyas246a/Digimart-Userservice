package com.Digimart.userservice.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmailVerificationTokens {

    @Id
    private Long id;
    private String otp;
    private String email;
    private boolean verified;
    private LocalDateTime expiryDate;

}
