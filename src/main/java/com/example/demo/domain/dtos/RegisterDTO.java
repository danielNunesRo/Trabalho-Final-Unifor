package com.example.demo.domain.dtos;

import com.example.demo.domain.enums.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
