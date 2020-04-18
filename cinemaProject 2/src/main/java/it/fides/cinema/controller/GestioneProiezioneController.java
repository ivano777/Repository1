package it.fides.cinema.controller;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.fides.cinema.dto.ProiezioneDto;
import it.fides.cinema.service.GestioneProiezione;

@RestController

public class GestioneProiezioneController {
	//findALL PROIEZIONE
	
	@Autowired
	private GestioneProiezione gestioneProiezione;
	
	@GetMapping(value = "/allProiezione")
	public Set<ProiezioneDto> allProiezione(){
		return gestioneProiezione.findAll();
	}
	
	@PostMapping(value = "/createProiezione")
	public String createProiezione (@RequestBody ProiezioneDto proiezioneDto, HttpServletRequest httpServletRequest) {
		
		return "OK";
	}
	
}
