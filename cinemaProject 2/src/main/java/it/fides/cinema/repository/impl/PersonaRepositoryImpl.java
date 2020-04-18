package it.fides.cinema.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;

import it.fides.cinema.entity.Persona;
import it.fides.cinema.repository.PersonaRepository;

@Repository
public class PersonaRepositoryImpl implements PersonaRepository {

	@PersistenceContext
	protected EntityManager entityManager;
	
	@Override
	public List<Persona> testAllPersona() {
		
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Persona> query = cb.createQuery(Persona.class);
		
		return this.entityManager.createQuery(
				query.select(query.from(Persona.class))).getResultList();
	}
	
	
	@Override
	public <S extends Persona> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Persona> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Persona> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Persona> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Persona> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Persona entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Persona> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Persona findByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
