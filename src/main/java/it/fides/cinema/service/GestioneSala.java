package it.fides.cinema.service;

import it.fides.cinema.dto.SalaDto;
import it.fides.cinema.dto.SearchSalaDto;
import it.fides.cinema.entity.Sala;

import java.util.List;
import java.util.Set;

//quando invoco un service in service.impl non faccio uscire entity ma dto

public interface GestioneSala {
	public Set<SalaDto> findAll();
	public SalaDto findById(Long idSala) throws Exception;
	public void insertSala(SalaDto salaDto) throws Exception;
	public void updateSala(SalaDto salaDto);
	public String deleteSala(Long idSala);
	public List<SalaDto> findByNomeSala(SearchSalaDto searchSalaDto);
	public Sala createSala(String nomeSala, Long numeroPosti);
}