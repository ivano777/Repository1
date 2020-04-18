package it.fides.cinema.traduttori.util;

import it.fides.cinema.dto.BigliettoDto;
import it.fides.cinema.dto.FilmDto;
import it.fides.cinema.dto.PersonaDto;
import it.fides.cinema.dto.PostoDto;
import it.fides.cinema.dto.ProiezioneDto;
import it.fides.cinema.dto.SalaDto;
import it.fides.cinema.entity.Biglietto;
import it.fides.cinema.entity.Film;
import it.fides.cinema.entity.Persona;
import it.fides.cinema.entity.Posto;
import it.fides.cinema.entity.Proiezione;
import it.fides.cinema.entity.Sala;

public class EntityInDto {
	
	/***********************************************BIGLIETTO****************************************************/
	//traduzione da Biglietto entity a BigliettoDto
	public static BigliettoDto bigliettoEntityInDto(Biglietto entity) {
		BigliettoDto bigliettoDto = new BigliettoDto();
		if(entity!=null) {
			bigliettoDto.setId(entity.getId());
			bigliettoDto.setFila(entity.getFila());
			bigliettoDto.setNumero(entity.getNumero());
		    //bigliettoDto.setPersonaDto(entity.getPersona()); non la implemento per evitare ricorsione
		}
		return bigliettoDto;
	}
	
	/**************************************************FILM******************************************************/
	 //traduzione da Film entity a FilmDto
	 public static FilmDto filmEntityInDto(Film entity) {
		 FilmDto filmDto =new FilmDto();
		 if(entity!=null) {
			filmDto.setId(entity.getId());
			filmDto.setTitolo(entity.getTitolo());
			filmDto.setGenere(entity.getGenere());
			filmDto.setTrama(entity.getTrama());
			filmDto.setDurata(entity.getDurata());
			filmDto.setRegista(entity.getRegista());
		//	if(filmDto.getProiezioneDto()==null)
		//		filmDto.setProiezioneDto(proiezioneEntityInDto(entity.getProiezione()));
		 }
		 return filmDto;
	 }
	 
	/**************************************************PERSONA***************************************************/
	 public static PersonaDto personaEntityInDto(Persona entity) {
		 PersonaDto personaDto = new PersonaDto();
		 if(entity!=null) {
			 personaDto.setId(entity.getId());
			 personaDto.setUsername(entity.getUsername());
			 personaDto.setPassword(entity.getPassword());
			 personaDto.setNome(entity.getNome());
			 personaDto.setCognome(entity.getCognome());
			 personaDto.setAnnoNascita(entity.getAnnoNascita());
			 personaDto.setEmail(entity.getEmail());
			 personaDto.setRuolo(entity.getRuolo());
			 //personaDto.setBigliettoDtoSet(entity.getBigliettoSet()); non va implementata problemi ricorsione
		 }
		 return personaDto;
	 }
	 
	/**************************************************POSTO*****************************************************/
	 public static PostoDto postoEntityInDto(Posto entity) {
		 PostoDto postoDto = new PostoDto();
		 if(entity!=null) {
			 postoDto.setId(entity.getId());
			 postoDto.setFila(entity.getFila());
			 postoDto.setNumero(entity.getNumero());
			 //postoDto.setSalaDto(entity.getSala()); non lo implemento per evitare ricorsione
		 }
		 return postoDto;
	 }
	 
	/**************************************************PROIEZIONE************************************************/
	//traduzione da Proiezione entity a ProiezioneDto
	 public static ProiezioneDto proiezioneEntityInDto(Proiezione entity) {
		ProiezioneDto proiezioneDto = new ProiezioneDto();
        if(entity!=null) {
			proiezioneDto.setId(entity.getId());
			proiezioneDto.setDataProiezione(entity.getDataProiezione());
			proiezioneDto.setPostiDisponibili(entity.getPostiDisponibili());
		//	if(proiezioneDto.getSalaDto()==null)
		//		proiezioneDto.setSalaDto(salaEntityInDto(entity.getSala())); //implementare salaEntityInDto
		//	if(proiezioneDto.getFilmDto()==null)
		//		proiezioneDto.setFilmDto(filmEntityInDto(entity.getFilm())); //implementare filmEntityInDto
        }
        return proiezioneDto;
	}

	/**************************************************SALA******************************************************/
	//traduzione da Sala entity a SalaDto
	 public static SalaDto salaEntityInDto(Sala entity) {
		SalaDto salaDto = new SalaDto();
        if(entity!=null) {
	        salaDto.setId(entity.getId());
	        salaDto.setNomeSala(entity.getNomeSala());
	        salaDto.setNumeroPosti(entity.getNumeroPosti());
	        //salaDto.setPostoDtoSet(postoDtoSet); implementare postoEntityInDto
	        //salaDto.setProiezioneDto(proiezioneDto); implementare proiezioneDto
        }
        return salaDto;
	}
	
}
