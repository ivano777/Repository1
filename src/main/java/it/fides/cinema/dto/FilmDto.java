package it.fides.cinema.dto;

import java.io.Serializable;

import org.dozer.Mapping;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class FilmDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1968370077353392050L;
	private Long id;
	private String titolo;
	private String genere;
	private String trama;
	private String durata;
	private String regista;
	@Mapping("this")
    private ProiezioneDto proiezione;

    
    
    
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
		FilmDto other = (FilmDto) obj;
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
	public String getRegista() {
		return regista;
	}
	public void setRegista(String regista) {
		this.regista = regista;
	}
	public ProiezioneDto getProiezione() {
		return proiezione;
	}
	@JsonIgnore
	public void setProiezione(ProiezioneDto proiezione) {
		this.proiezione = proiezione;
	}

}
