package com.example.cinetrailer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.cinetrailer.model.Pelicula;
import com.example.cinetrailer.repo.PeliculaRepository;

import java.util.List;

@Controller
@RequestMapping("")
public class HomeController {
    
    @Autowired
    private PeliculaRepository peliculaRepository;

    @GetMapping("")
    ModelAndView index(){
        List<Pelicula> ultimasPeliculas= peliculaRepository
                .findAll(PageRequest.of(0, 4, Sort.by("fechaEstreno").descending()))
                .toList();

        return new ModelAndView("index")
                .addObject("ultimasPeliculas", ultimasPeliculas);
    }
    @GetMapping("/peliculas")
    ModelAndView ListaPeliculas(@PageableDefault(sort = "fechaEstreno", direction = Sort.Direction.DESC) Pageable pageable){
        Page<Pelicula> peliculas = peliculaRepository.findAll(pageable);
        return new ModelAndView("peliculas")
            .addObject("peliculas", peliculas);
    }

    @GetMapping("/nosotros")
    ModelAndView sobreNosotros(){
        return new ModelAndView("nosotros");
    }

}
