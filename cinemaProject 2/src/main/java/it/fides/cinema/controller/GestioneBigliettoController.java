package it.fides.cinema.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import it.fides.cinema.dto.BigliettoDto;
import it.fides.cinema.entity.Biglietto;
import it.fides.cinema.service.GestioneBiglietto;

@RestController
public class GestioneBigliettoController {
	//findALL BIGLIETTO
	
	@Autowired
	private GestioneBiglietto gestioneBiglietto;
	
	@GetMapping(value="/allBiglietto")
	public Set<BigliettoDto>allBiglietto(){
		return gestioneBiglietto.findAll();
	}
	@GetMapping(value="/testBiglietto")
	public List<Biglietto>testBiglietto(){
		return gestioneBiglietto.testBiglietto();
	}
	@GetMapping(value="/testBiglietto2")
	public List<Biglietto>testBiglietto2(){
		return gestioneBiglietto.testBiglietto2();
	}
}
