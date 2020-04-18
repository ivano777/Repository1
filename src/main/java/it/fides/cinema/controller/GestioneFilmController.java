package it.fides.cinema.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import it.fides.cinema.dto.FilmDto;
import it.fides.cinema.service.GestioneFilm;

@RestController
public class GestioneFilmController {
	//findALL FILM
	
	@Autowired
	private GestioneFilm gestioneFilm;
	
	@GetMapping(value = "/allFilm")
	public Set<FilmDto> allFilm(){
		return gestioneFilm.findAll();
	}
}
