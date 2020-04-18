package it.fides.cinema.service;

import java.util.Set;

import it.fides.cinema.dto.PostoDto;

public interface GestionePosto {
	public Set<PostoDto> findAll();
    public void insertPosto (PostoDto postoDto);
	public PostoDto findById(Long idPosto) throws Exception;
    public Set<PostoDto> findPosto();
}
