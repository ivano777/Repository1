package it.fides.cinema.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.fides.cinema.entity.Biglietto;
import it.fides.cinema.entity.Persona;

public interface PersonaRepository extends CrudRepository<Persona,Long>{
	Persona findByUsernameAndPassword(String username, String password);
	public List<Persona> testAllPersona();

}
