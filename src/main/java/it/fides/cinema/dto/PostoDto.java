package it.fides.cinema.dto;

import java.io.Serializable;

import org.dozer.Mapping;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PostoDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6077864272206253419L;
	private Long id;
	private Long numero;
	private String fila;
	@Mapping("this")
	private SalaDto sala;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFila() {
		return fila;
	}
	public void setFila(String fila) {
		this.fila = fila;
	}

	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public SalaDto getSala() {
		return sala;
	}
	//se non voglio vedere la sala basta mettere JsonIgnore
	@JsonIgnore
	public void setSala(SalaDto sala) {
		this.sala = sala;
	}
	
}
