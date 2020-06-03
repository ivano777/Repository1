package it.fides.cinema.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.fides.cinema.dto.BigliettoDto;
import it.fides.cinema.service.GestioneBiglietto;

@RestController
public class GestioneBigliettoController {
	//findAll BIGLIETTO
	
	@Autowired
	private GestioneBiglietto gestioneBiglietto;
	
	@GetMapping(value="/allBiglietto")
	public Set<BigliettoDto>allBiglietto(){
		return gestioneBiglietto.findAll();
	}
	@PostMapping(value="/testBiglietto")
	public List<BigliettoDto>testBiglietto(@RequestParam String fila){
		return gestioneBiglietto.testBiglietto(fila);
	}
	@PostMapping(value="/findByIdBiglietto")
	public <Optional> BigliettoDto findByIdBiglietto(@RequestParam Long id){
		try {
			return gestioneBiglietto.findById(id);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			System.out.println("BIGLIETTO NON TROVATO");
		}
		return null;
	}
}
