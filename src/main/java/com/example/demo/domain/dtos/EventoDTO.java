package com.example.demo.domain.dtos;

import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record EventoDTO(
                        String name,
                        String email,
                        String url,
                        LocalDate dayEvento,
                        LocalTime hoursEvento,
                        String buyTickets) {
}
