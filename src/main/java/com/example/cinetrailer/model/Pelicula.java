package com.example.cinetrailer.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


@Data
@Entity
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpelicula")
    private Integer id;

    @NotBlank
    private String titulo;

    @NotBlank
    private String sinopsis;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaEstreno;

    @NotBlank
    private String youtubeTrailerId;

    private String rutaPortada;

    @NotEmpty
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "generopelicula",
    joinColumns = @JoinColumn(name = "idpelicula"),
    inverseJoinColumns = @JoinColumn(name = "idgenero"))
    private List<Genero> generos;

    @Transient
    private MultipartFile portada;
}