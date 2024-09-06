package com.example.demo.services;

import com.example.demo.domain.Eventos;
import com.example.demo.domain.User;
import com.example.demo.domain.dtos.EventoDTO;
import com.example.demo.repositories.EventosRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class EventosService {

    @Autowired
    private EventosRepository eventosRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    public EventosService(EventosRepository eventosRepository, UserRepository userRepository) {
        this.eventosRepository = eventosRepository;
        this.userRepository = userRepository;
    }

    public void createEvent(EventoDTO eventoDTO, @AuthenticationPrincipal User user) throws IOException {
        Eventos newEvento = new Eventos();
        newEvento.setName(eventoDTO.name());
        newEvento.setEmail(eventoDTO.email());
        newEvento.setUrl(eventoDTO.url());
        newEvento.setDayEvento(eventoDTO.dayEvento());
        newEvento.setHoursEvento(eventoDTO.hoursEvento());
        newEvento.setBuyTickets(eventoDTO.buyTickets());
        newEvento.setUser(user);


        eventosRepository.save(newEvento);
    }

    public void updateStatusEvent(Long id) {
        eventosRepository.updateStatusToTrueById(id);
    }

    public List<Eventos> eventosTrue() {
        List<Eventos> list = eventosRepository.findByStatusTrue();
        return list;
    }

    public List<Eventos> allEvents() {
        List<Eventos> list = eventosRepository.findAll();
        return list;
    }

    public void deleteEvent(Long id) {
       var eventoExisting = eventosRepository.findById(id).orElseThrow(() -> new RuntimeException(("Não há eventos com esse id")));
        eventosRepository.deleteById(id);
    }

    public void eventRemoved(Long id) {
        var eventoExisting = eventosRepository.findById(id).orElseThrow(() -> new RuntimeException(("Não há eventos com esse id")));
        eventosRepository.updateStatusToFalseById(id);
    }


}
