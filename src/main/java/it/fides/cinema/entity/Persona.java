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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSONA_SEQ")
	@SequenceGenerator(name="PERSONA_SEQ",sequenceName = "PERSONA_SEQ",allocationSize = 1)
	@Column(updatable = false, nullable = false)
	private Long id;
	@Column
	@NotEmpty(message = "*Il campo username non può essere vuoto")
	private String username;
	@Column
	@Length(min = 5, message = "*La password deve essere minimo 5 caratteri")
    @NotEmpty(message = "*Il campo password non può essere vuoto")
	private String password;
	@Column
	private String nome;
	@Column
	private String cognome;
	@Column 
	private Date annoNascita;
	@Column
	@Email(message = "*Inserisci una email valida")
	@NotEmpty(message = "*Il campo email non può essere vuoto")
	private String email;
	@Column
	private String ruolo;
	
	@OneToMany(targetEntity = Biglietto.class,fetch = FetchType.LAZY,cascade= CascadeType.ALL,mappedBy = "persona")
	private Set<Biglietto> bigliettoSet;

	
	
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

	public Set<Biglietto> getBigliettoSet() {
		return bigliettoSet;
	}

	public void setBigliettoSet(Set<Biglietto> bigliettoSet) {
		this.bigliettoSet = bigliettoSet;
	}
	
	
	
}
