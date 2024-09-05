package com.example.demo.controllers;

import com.example.demo.domain.User;
import com.example.demo.domain.dtos.EventoDTO;
import com.example.demo.services.EventosService;
import jdk.jfr.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventosService eventoService;

    @PostMapping(value = "/addevento")
    public ResponseEntity<?> createEvent(@RequestBody EventoDTO eventoDTO, @AuthenticationPrincipal User user) {
        try {
            eventoService.createEvent(eventoDTO, user);
            return ResponseEntity.status(201).build();
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao criar evento");
        }
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok().body("fUNCIONANDO!");
    }


}
