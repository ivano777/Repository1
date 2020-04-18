package it.fides.cinema.entity;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

//rispecchia l'entità tenendo conto anche dei collegamenti e chiavi esterne e anche vincoli eventuali etc
@Entity
public class Sala {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SALA_SEQ")
	@SequenceGenerator(name="SALA_SEQ",sequenceName = "SALA_SEQ",allocationSize = 1)
	@Column(updatable = false, nullable = false)
	private Long id;
	@Column
	private String nomeSala;
	@Column
	private Long numeroPosti;
	@OneToMany(mappedBy = "sala", targetEntity = Posto.class, cascade = {CascadeType.REMOVE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
	private Set<Posto> postoSet;
    @OneToOne(mappedBy = "sala")
    private Proiezione proiezione;

	

    
	public Set<Posto> getPostoSet() {
		return postoSet;
	}
	public void setPostoSet(Set<Posto> postoSet) {
		this.postoSet = postoSet;
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
	public String getNomeSala() {
		return nomeSala;
	}
	public void setNomeSala(String nomeSala) {
		this.nomeSala = nomeSala;
	}
	public Long getNumeroPosti() {
		return numeroPosti;
	}
	public void setNumeroPosti(Long numeroPosti) {
		this.numeroPosti = numeroPosti;
	}
	
}
