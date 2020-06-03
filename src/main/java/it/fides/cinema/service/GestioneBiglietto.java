package it.fides.cinema.service;

import java.util.List;
import java.util.Set;

import it.fides.cinema.dto.BigliettoDto;

public interface GestioneBiglietto {
	public Set<BigliettoDto> findAll();
	public List<BigliettoDto> testBiglietto(String fila);
	public <Optional>BigliettoDto findById(Long id);
}
