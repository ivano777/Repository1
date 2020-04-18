package it.fides.cinema.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.fides.cinema.dto.FilmDto;
import it.fides.cinema.repository.FilmRepository;
import it.fides.cinema.service.GestioneFilm;

@Service
public class GestioneFilmImpl implements GestioneFilm {
	
	@Autowired
	private FilmRepository filmRepository;
	private DozerBeanMapper mapper;
	@Override
	public Set<FilmDto> findAll(){
		mapper = new DozerBeanMapper();
		Set<FilmDto> setFilmDto = new HashSet<FilmDto>();
		filmRepository.findAll().forEach(film -> {
			FilmDto filmDto = new FilmDto();
			filmDto = mapper.map(film, FilmDto.class);
			setFilmDto.add(filmDto);
		});
		return setFilmDto;
	}

}
