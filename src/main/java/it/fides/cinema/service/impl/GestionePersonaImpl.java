package it.fides.cinema.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.fides.cinema.dto.BigliettoDto;
import it.fides.cinema.dto.LoginDto;
import it.fides.cinema.dto.PersonaDto;
import it.fides.cinema.entity.Persona;
import it.fides.cinema.repository.PersonaRepository;
import it.fides.cinema.service.GestionePersona;



@Service
@Transactional
public class GestionePersonaImpl implements GestionePersona {
	@Autowired
	private PersonaRepository personaRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	private DozerBeanMapper mapper;

	@Override
	public Set<PersonaDto> findAll(){
		mapper = new DozerBeanMapper();
		Set<PersonaDto> setPersonaDto = new HashSet<PersonaDto>();
		personaRepository.findAll().forEach(persona -> {
			PersonaDto personaDto = new PersonaDto();
			personaDto = mapper.map(persona, PersonaDto.class);

			//inizio setto biglietto
			Set<BigliettoDto> setBigliettoDto = new HashSet<BigliettoDto>();
			persona.getBigliettoSet().forEach(biglietto -> {
				BigliettoDto bigliettoDto = new BigliettoDto();
				bigliettoDto = mapper.map(biglietto,BigliettoDto.class);
				setBigliettoDto.add(bigliettoDto);
			});
			personaDto.setBigliettoSet(setBigliettoDto);
			//fine setto biglietto

			setPersonaDto.add(personaDto);
		});
		return setPersonaDto;
	}
	@Override
	public PersonaDto findUser(LoginDto loginDto) {
		Persona persona = personaRepository.findByUsernameAndPassword(loginDto.getUsername(), loginDto.getPassword());
		PersonaDto personaDto = new PersonaDto();
		personaDto.setId(persona.getId());
		personaDto.setNome(persona.getNome());
		personaDto.setCognome(persona.getCognome());
		//importante
		personaDto.setRuolo(persona.getRuolo());
		return personaDto;
	}




	public List<PersonaDto> testPersona(String nome) {
		mapper = new DozerBeanMapper();
		List<PersonaDto> resultsDto = new ArrayList<PersonaDto>();
		personaRepository.testPersona(nome).forEach( persona -> {
			PersonaDto personaDto = new PersonaDto();
			personaDto = mapper.map(persona, PersonaDto.class);
			resultsDto.add(personaDto);
		});
		return resultsDto;
	}
	@Override
	public Persona savePersona (PersonaDto personaDto) {
		mapper = new DozerBeanMapper();
		Persona persona= new Persona();
		persona = mapper.map(personaDto, Persona.class);
		persona.setPassword(bCryptPasswordEncoder.encode(persona.getPassword()));
		return personaRepository.save(persona);

	}
	@Override
	public Persona findByUsername(String username) {
		return personaRepository.findByUsername(username);
	}
}
