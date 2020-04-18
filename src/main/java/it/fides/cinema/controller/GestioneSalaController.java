package it.fides.cinema.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.fides.cinema.dto.SalaDto;
import it.fides.cinema.dto.SearchSalaDto;
import it.fides.cinema.enumeration.RuoloEnum;
import it.fides.cinema.service.GestioneSala;

//a livello di controller è meglio evitare la logica
//il controller sta piu in cima espone api al font-end in mezzo c'è la parte di logica buisness cioe servizi in fondo parte db entita repository e dao

@RestController
public class GestioneSalaController {
	@Autowired
	private GestioneSala gestioneSala; //aggiungere il servizione nel controller

	//findALL SALA
	@GetMapping(value = "/allSala")
	public Set<SalaDto> allSala(){
		return gestioneSala.findAll();
	}
	//findById SALA
	@GetMapping(value = "/findByIdSala")
	public SalaDto findById(@RequestParam Long idSala) throws Exception{
		return gestioneSala.findById(idSala);
	}
	
	@PostMapping(value="/createSala")
	public String createSala(@RequestBody SalaDto salaDto, HttpServletRequest request) {
		if(salaDto.getNomeSala()!=null && !salaDto.getNomeSala().isEmpty()) {
			HttpSession session = request.getSession();
			String ruolo = (String) session.getAttribute("ruolo");
			if(RuoloEnum.ADMIN.ruolo().equals(ruolo)) {
				gestioneSala.createSala(salaDto.getNomeSala(), salaDto.getNumeroPosti());
			return "OK";
			}
			else if(ruolo==null || ruolo.isEmpty()) {
				return "Utente non loggato";
			}
			else {
				return "L'inserimento di sale è riservato agli admin";
			}
		}
		else {
			return "nomeSala non valorizzato";
		}
	}
	@PostMapping(value="/insertSala")
	public void insertSala(@RequestBody SalaDto salaDto, HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		String ruolo = (String) session.getAttribute("ruolo");
		if(RuoloEnum.ADMIN.ruolo().equals(ruolo)) {
			gestioneSala.insertSala(salaDto);
		}		
		else {
			throw new Exception("L'inserimento di sale è riservato agli admin");
		}	
	}
	
	@PostMapping(value="/updateSala")
	public void updateSala(@RequestBody SalaDto salaDto) {
		gestioneSala.updateSala(salaDto);
	}
	@DeleteMapping(value="/deleteSala")
	public String deleteSala(@RequestParam Long idSala) {
		return gestioneSala.deleteSala(idSala);
	}
	@PostMapping(value = "/searchSala")
	public ResponseEntity<?> searchSala(@Valid @RequestBody SearchSalaDto searchSalaDto, Errors errors){
		List<SalaDto> result = gestioneSala.findByNomeSala(searchSalaDto);
		return ResponseEntity.ok(result);
	}
}