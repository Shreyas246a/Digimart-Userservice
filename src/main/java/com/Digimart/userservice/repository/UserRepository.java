package com.Digimart.userservice.repository;

import com.Digimart.userservice.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<Users, UUID> {
    boolean existsByEmail(String email);
    boolean existsByName(String name);
    Optional<Users> findByEmail(String email);
}
