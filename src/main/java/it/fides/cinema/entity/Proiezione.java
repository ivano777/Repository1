package it.fides.cinema.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Proiezione {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROIEZIONE_SEQ")
	@SequenceGenerator(name="PROIEZIONE_SEQ",sequenceName = "PROIEZIONE_SEQ",allocationSize = 1)
	@Column(updatable = false, nullable = false)
	private Long id;
	@Column
	private Date dataProiezione;
	@Column
	private Long postiDisponibili;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_sala", referencedColumnName = "id")
	private Sala sala;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_film", referencedColumnName = "id")
	private Film film;

	@OneToMany(targetEntity = Biglietto.class,fetch = FetchType.LAZY,cascade= CascadeType.ALL,mappedBy = "proiezione")
	private Set<Biglietto> bigliettoSet;

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

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Set<Biglietto> getBigliettoSet() {
		return bigliettoSet;
	}

	public void setBigliettoSet(Set<Biglietto> bigliettoSet) {
		this.bigliettoSet = bigliettoSet;
	}
    
	
	
}
