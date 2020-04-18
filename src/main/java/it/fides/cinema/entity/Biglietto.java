package it.fides.cinema.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Biglietto {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BIGLIETTO_SEQ")
	@SequenceGenerator(name="BIGLIETTO_SEQ",sequenceName = "BIGLIETTO_SEQ",allocationSize = 1)
	@Column(updatable = false, nullable = false)
	private Long id;
	@Column
	private String fila;
	@Column
	private Long numero;
	@ManyToOne
	@JoinColumn(name = "ID_PROIEZIONE",referencedColumnName = "id")
	private Proiezione proiezione;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_PERSONA",referencedColumnName = "id")
	private Persona persona;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public Proiezione getProiezione() {
		return proiezione;
	}
	public void setProiezione(Proiezione proiezione) {
		this.proiezione = proiezione;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
}