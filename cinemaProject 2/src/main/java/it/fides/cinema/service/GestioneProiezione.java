package it.fides.cinema.service;

import java.util.Set;

import it.fides.cinema.dto.ProiezioneDto;
import it.fides.cinema.entity.Proiezione;

public interface GestioneProiezione {
	public Set<ProiezioneDto> findAll();
	public Proiezione createProiezione(ProiezioneDto proiezioneDto);
}
