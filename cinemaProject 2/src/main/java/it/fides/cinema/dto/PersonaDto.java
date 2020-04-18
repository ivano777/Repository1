package it.fides.cinema.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import org.dozer.Mapping;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PersonaDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6955457384095865750L;
	private Long id;
	private String username;
	private String password;
	private String nome;
	private String cognome;
	private Date annoNascita;
	private String email;
	private String ruolo;
	@Mapping("this")
	private Set<BigliettoDto> bigliettoSet;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public Date getAnnoNascita() {
		return annoNascita;
	}
	public void setAnnoNascita(Date annoNascita) {
		this.annoNascita = annoNascita;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRuolo() {
		return ruolo;
	}
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	public Set<BigliettoDto> getBigliettoSet() {
		return bigliettoSet;
	}
	@JsonIgnore
	public void setBigliettoSet(Set<BigliettoDto> bigliettoSet) {
		this.bigliettoSet = bigliettoSet;
	}

}
