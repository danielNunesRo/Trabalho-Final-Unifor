package com.example.demo.controllers;

import com.example.demo.domain.User;
import com.example.demo.domain.dtos.EventoDTO;
import com.example.demo.services.EventosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventosService eventoService;

    @PostMapping("/addevento")
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
