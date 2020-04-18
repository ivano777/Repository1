package it.fides.cinema.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.fides.cinema.dto.PostoDto;
import it.fides.cinema.service.GestionePosto;

@RestController
public class GestionePostoController {
	//findALL POSTO
	
	@Autowired
	private GestionePosto gestionePosto;
	
	@GetMapping(value = "/allPosto")
	public Set<PostoDto> allPosto(){
		return gestionePosto.findAll();
	}
	@GetMapping(value = "findByIdPosto")
	public PostoDto findById (@RequestParam Long idPosto) throws Exception {
		return gestionePosto.findById(idPosto);
	}
	@PostMapping(value="/insertPosto")
	public void insertPosto(@RequestBody PostoDto postoDto){
		gestionePosto.insertPosto(postoDto);
	}
	@PostMapping(value = "/testPosto")
	public String testPosto(){
		return gestionePosto.findPosto().toString();
	}
 
	
}
