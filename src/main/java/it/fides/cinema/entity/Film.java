package it.fides.cinema.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Film {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FILM_SEQ")
	@SequenceGenerator(name="FILM_SEQ",sequenceName = "FILM_SEQ",allocationSize = 1)
	@Column(updatable = false, nullable = false)
	private Long id;
	@Column
	private String titolo;
	@Column
	private String genere;
	@Column
	private String trama;
	@Column
	private String durata;
	@Column
	private String regista;
    @OneToOne(mappedBy = "film")
    private Proiezione proiezione;
    
     
    
	public Film() {}
	
	
	
	public Film(Long id, String titolo, String genere, String trama, String durata, String regista,
			Proiezione proiezione) {
		super();
		this.id = id;
		this.titolo = titolo;
		this.genere = genere;
		this.trama = trama;
		this.durata = durata;
		this.regista = regista;
		this.proiezione = proiezione;
	}



	public Film(Film film) {
		super();
		this.id = film.getId();
		this.titolo = film.getTitolo();
		this.genere = film.getGenere();
		this.trama = film.getTrama();
		this.durata = film.getDurata();
		this.regista = film.getRegista();
		this.proiezione = film.getProiezione();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((durata == null) ? 0 : durata.hashCode());
		result = prime * result + ((genere == null) ? 0 : genere.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((proiezione == null) ? 0 : proiezione.hashCode());
		result = prime * result + ((regista == null) ? 0 : regista.hashCode());
		result = prime * result + ((titolo == null) ? 0 : titolo.hashCode());
		result = prime * result + ((trama == null) ? 0 : trama.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		if (durata == null) {
			if (other.durata != null)
				return false;
		} else if (!durata.equals(other.durata))
			return false;
		if (genere == null) {
			if (other.genere != null)
				return false;
		} else if (!genere.equals(other.genere))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (proiezione == null) {
			if (other.proiezione != null)
				return false;
		} else if (!proiezione.equals(other.proiezione))
			return false;
		if (regista == null) {
			if (other.regista != null)
				return false;
		} else if (!regista.equals(other.regista))
			return false;
		if (titolo == null) {
			if (other.titolo != null)
				return false;
		} else if (!titolo.equals(other.titolo))
			return false;
		if (trama == null) {
			if (other.trama != null)
				return false;
		} else if (!trama.equals(other.trama))
			return false;
		return true;
	}
	public String getRegista() {
		return regista;
	}
	public void setRegista(String regista) {
		this.regista = regista;
	}
	public Proiezione getProiezione() {
		return proiezione;
	}
	public void setProiezione(Proiezione proiezione) {
		this.proiezione = proiezione;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getGenere() {
		return genere;
	}
	public void setGenere(String genere) {
		this.genere = genere;
	}
	public String getTrama() {
		return trama;
	}
	public void setTrama(String trama) {
		this.trama = trama;
	}
	public String getDurata() {
		return durata;
	}
	public void setDurata(String durata) {
		this.durata = durata;
	}

	
	
}
