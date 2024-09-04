package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

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
    private String email;
    @Column(nullable = false)
    private String url;
    @Column(nullable = false)
    private LocalDateTime dayEvento;
    @Column(nullable = false)
    private LocalDateTime hoursEvento;
    @Column(nullable = false)
    private String buyTickets;
    @Column(nullable = false)
    private byte[] image;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
