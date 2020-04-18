package it.fides.cinema.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import it.fides.cinema.dto.LoginDto;
import it.fides.cinema.dto.PersonaDto;
import it.fides.cinema.entity.Persona;

public interface GestionePersona {
	public Set<PersonaDto> findAll();

	public PersonaDto findUser(LoginDto loginDto);
	
	public List<PersonaDto> testPersona();
	
	public List<Persona> testPersona2();
}
