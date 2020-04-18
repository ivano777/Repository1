package it.fides.cinema.service;

import java.util.Set;

import it.fides.cinema.dto.FilmDto;

public interface GestioneFilm {
	public Set<FilmDto> findAll();
}
