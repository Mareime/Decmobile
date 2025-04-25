package com.example.backendrecette.jwtModule.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.backendrecette.jwtModule.models.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByUsername(String username);
}
