package it.fides.cinema.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.fides.cinema.dto.FilmDto;
import it.fides.cinema.dto.ProiezioneDto;
import it.fides.cinema.dto.SalaDto;
import it.fides.cinema.entity.Film;
import it.fides.cinema.entity.Proiezione;
import it.fides.cinema.repository.ProiezioneRepository;
import it.fides.cinema.service.GestioneProiezione;

@Service
@Transactional
public class GestioneProiezioneImpl implements GestioneProiezione{
	@Autowired
	private ProiezioneRepository proiezioneRepository;
	DozerBeanMapper mapper;
	
	@Override
	public Set<ProiezioneDto> findAll(){
		mapper = new DozerBeanMapper();
		Set<ProiezioneDto> setProiezioneDto = new HashSet<ProiezioneDto>();
		proiezioneRepository.findAll().forEach(proiezione -> {
			ProiezioneDto proiezioneDto = new ProiezioneDto();
			
			proiezioneDto.setFilm(new FilmDto());
			proiezioneDto.setSala(new SalaDto());
			
			System.out.println("************************************************E"+proiezione.getFilm().getTitolo());
			System.out.println("************************************************E"+proiezione.getSala().getNomeSala());
			
		//	proiezioneDto.setFilm(mapper.map(proiezione.getFilm(), FilmDto.class));
		//	proiezioneDto.setSala(mapper.map(proiezione.getSala(), SalaDto.class));
			
			System.out.println("************************************************D"+proiezioneDto.getFilm().getTitolo());

			//proiezione.setFilm(new Film());
			//proiezione.setSala(new Sala());
			
			proiezioneDto = mapper.map(proiezione, ProiezioneDto.class);
			
			//proiezioneDto.setFilm(mapper.map(proiezione.getFilm(), FilmDto.class));
			//proiezioneDto.setSala(mapper.map(proiezione.getSala(), SalaDto.class));
			System.out.println("************************************************D"+proiezioneDto.getId());
			Film filmTemp = new Film(proiezione.getFilm().getId(),proiezione.getFilm().getTitolo(),proiezione.getFilm().getGenere(),proiezione.getFilm().getTrama(),proiezione.getFilm().getDurata(),proiezione.getFilm().getRegista(),proiezione);
			//passare i valori prima in una variabile
			System.out.println("************************************************E"+proiezione.getFilm().getTitolo());
			System.out.println("************************************************E"+filmTemp.getTitolo());
			System.out.println("************************************************D"+proiezioneDto.getSala().getNomeSala());
		
			
			setProiezioneDto.add(proiezioneDto);
		});	
		return setProiezioneDto;
	}

	@Override
	public Proiezione createProiezione(ProiezioneDto proiezioneDto) {
		// TODO Auto-generated method stub
		return null;
	}
}
