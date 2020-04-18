package it.fides.cinema.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


//a livello di controller è meglio evitare la logica
//il controller sta piu in cima espone api al font-end in mezzo c'è la parte di logica buisness cioe servizi in fondo parte db entita repository e dao
@RestController
public class Test {
	
	@GetMapping(value = "/hello")
	public String hello(@RequestParam Long idSala)
	{
		return "hello " + idSala;
	}
}
