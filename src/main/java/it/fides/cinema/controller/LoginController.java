package it.fides.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import it.fides.cinema.entity.Persona;
import it.fides.cinema.service.GestionePersona;

@Controller
public class LoginController {
	@Autowired
	private GestionePersona gestionePersona;
	
	 @RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	 @RequestMapping(value = "/registration", method = RequestMethod.GET)
	 public ModelAndView registration() {
		 ModelAndView modelAndView = new ModelAndView();
		 Persona persona = new Persona();
		 modelAndView.addObject("persona",persona);
		 modelAndView.setViewName("registration");
		 return modelAndView;
	 }
	 @RequestMapping(value = "/admin/home", method = RequestMethod.GET)
	 public ModelAndView homeAdmin() {
		 ModelAndView modelAndView = new ModelAndView();
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		 Persona persona = gestionePersona.findByUsername(authentication.getName());
		 modelAndView.addObject("username",persona.getUsername() + " (" + persona.getEmail() + ")");
		 modelAndView.addObject("adminMessage","Contenuto disponibile solo per utenti con ruolo di amministratore");
		 modelAndView.setViewName("admin/home");
		 return modelAndView;
	 }
	 public ModelAndView homeUser() {
		 ModelAndView modelAndView = new ModelAndView();
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		 Persona persona = gestionePersona.findByUsername(authentication.getName());
        modelAndView.addObject("username", persona.getUsername() + " (" + persona.getEmail() + ")");
        modelAndView.setViewName("user/home");
		 return modelAndView;
	 }
}

