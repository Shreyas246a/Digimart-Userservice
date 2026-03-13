package com.Digimart.userservice.Entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Valid
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true,nullable = false,name = "username")
    private String name;
    @Column(unique = true,nullable = false,name = "email")
    private String email;
    @Column(nullable = false,name = "password")
    private String password;
    @Enumerated(EnumType.STRING)
    private Roles role;
    private boolean enabled;
}
