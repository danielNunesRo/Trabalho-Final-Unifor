package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "tb_eventos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Eventos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String url;
    @Column(nullable = false)
    private LocalDate dayEvento;
    @Column(nullable = false)
    private LocalTime hoursEvento;
    private String buyTickets;
    private boolean status;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
