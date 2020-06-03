package it.fides.cinema.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.fides.cinema.entity.Persona;

@Repository
public interface PersonaRepository extends CrudRepository<Persona,Long>{
	public Persona findByUsernameAndPassword(String username, String password);	
	public List<Persona> testPersona (String nome);
	public Persona findByUsername(String username);
}
