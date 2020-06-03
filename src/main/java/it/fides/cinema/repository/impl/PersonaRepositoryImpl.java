package it.fides.cinema.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import it.fides.cinema.entity.Persona;
import it.fides.cinema.repository.custom.PersonaCustom;

public class PersonaRepositoryImpl implements PersonaCustom {

	 @PersistenceContext
	 protected EntityManager entityManager;

	@Override
	public List<Persona> testPersona(String nome) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Persona> query = cb.createQuery(Persona.class);
		Root<Persona> persona = query.from(Persona.class);
		return this.entityManager.createQuery(
			query.select(persona).where(cb.equal(persona.get("nome"), nome))
		).getResultList();
	}
}
