package it.fides.cinema.dto;

import java.io.Serializable;
import java.sql.Date;


public class ProiezioneDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -908589970471485868L;
	private Long id;
	private Date dataProiezione;
	private Long postiDisponibili;
	private SalaDto sala;
	private FilmDto film;

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDataProiezione() {
		return dataProiezione;
	}
	public void setDataProiezione(Date dataProiezione) {
		this.dataProiezione = dataProiezione;
	}
	public Long getPostiDisponibili() {
		return postiDisponibili;
	}
	public void setPostiDisponibili(Long postiDisponibili) {
		this.postiDisponibili = postiDisponibili;
	}
	public SalaDto getSala() {
		return sala;
	}
	public void setSala(SalaDto sala) {
		this.sala = sala;
	}
	public FilmDto getFilm() {
		return film;
	}
	public void setFilm(FilmDto film) {
		this.film = film;
	}
}
