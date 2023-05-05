package com.example.cinetrailer.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cinetrailer.model.Pelicula;

public interface PeliculaRepository extends JpaRepository<Pelicula, Integer>{
    
}
