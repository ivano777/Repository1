package it.fides.cinema.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import it.fides.cinema.entity.Persona;
import it.fides.cinema.service.GestionePersona;

@Service
public class GestionePersonaDetails implements UserDetailsService {
	@Autowired
	private GestionePersona gestionePersona;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Persona persona = gestionePersona.findByUsername(username);
		List<GrantedAuthority> authorities = getAccountAuthority(persona.getRuolo());
		return buildUserForAuthentication(persona, authorities);
	}
	
	private List<GrantedAuthority> getAccountAuthority(String ruolo) {
        Set<GrantedAuthority> ruoli = new HashSet<GrantedAuthority>();
            ruoli.add(new SimpleGrantedAuthority(ruolo));
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(ruoli);
        
        return grantedAuthorities;
    }
	
	 private UserDetails buildUserForAuthentication(Persona persona, List<GrantedAuthority> authorities) {
	        return new org.springframework.security.core.userdetails.User(persona.getUsername(), persona.getPassword(),
	                true, true, true, true, authorities);
	    }

}
