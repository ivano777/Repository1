package it.fides.cinema.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.fides.cinema.dto.LoginDto;
import it.fides.cinema.dto.PersonaDto;
import it.fides.cinema.service.GestionePersona;

@RestController
public class GestionePersonaController {
	//findALL PERSONA
	
	@Autowired
	private GestionePersona gestionePersona;
	
	@GetMapping(value="/allPersona")
	public Set<PersonaDto> allPersona(){
		return gestionePersona.findAll();
	}
	
	@PostMapping(value = "/login")
	public ResponseEntity<?> login (@RequestBody LoginDto loginDto, HttpServletRequest request){
		PersonaDto personaDto = gestionePersona.findUser(loginDto);
		if(personaDto!=null) {
			HttpSession httpSession = request.getSession();
			if(httpSession.getAttribute("ruolo")!=null) {
				return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			}
			httpSession.setAttribute("ruolo", personaDto.getRuolo());
			return ResponseEntity.ok(HttpStatus.OK);
		}
		return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
	}
	@PostMapping(value = "/logout")
	public ResponseEntity<?> login (HttpServletRequest request){
		HttpSession httpSession = request.getSession();
		if(httpSession.getAttribute("ruolo")==null) {
			return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
		}
		httpSession.removeAttribute("ruolo");
		httpSession.invalidate();
		return ResponseEntity.ok(HttpStatus.OK);
	}
	@PostMapping(value="/testPersona")
	public List<PersonaDto> testPersona(@RequestParam String nome){
		return gestionePersona.testPersona(nome);
	}
}
