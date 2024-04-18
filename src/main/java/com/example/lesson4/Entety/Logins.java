package com.example.lesson4.Entety;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "logins")
@Data
public class Logins {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    LocalDate accessDate;

    @OneToOne(fetch = FetchType.LAZY)
    Users user;

    String application;
}
