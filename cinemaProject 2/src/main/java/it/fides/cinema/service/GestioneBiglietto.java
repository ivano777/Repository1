package it.fides.cinema.service;

import java.util.List;
import java.util.Set;

import it.fides.cinema.dto.BigliettoDto;
import it.fides.cinema.entity.Biglietto;

public interface GestioneBiglietto {
	public Set<BigliettoDto> findAll();
	public List<Biglietto> testBiglietto();
	public List<Biglietto> testBiglietto2();

}
