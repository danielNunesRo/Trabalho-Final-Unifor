package com.example.demo.repositories;

import com.example.demo.domain.InvalidToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InvalidTokenRepository extends JpaRepository<InvalidToken, Long> {

    Optional<InvalidToken> findByToken(String token);
}
