package com.example.demo.domain.dtos;

import java.time.LocalDateTime;

public record EventoDTO(
                        String name,
                        String email,
                        String url,
                        LocalDateTime dayEvento,
                        LocalDateTime hoursEvento,
                        String buyTickets,
                        byte[] image) {
}
