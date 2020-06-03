package it.fides.cinema.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import it.fides.cinema.entity.Biglietto;
import it.fides.cinema.repository.custom.BigliettoCustom;

public class BigliettoRepositoryImpl implements BigliettoCustom {
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	@Override
	public List<Biglietto> testBiglietto(String fila) {
		
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Biglietto> query = cb.createQuery(Biglietto.class);
		Root<Biglietto> biglietto = query.from(Biglietto.class);
		
		return this.entityManager.createQuery(
				
				//query.select(query.from(Biglietto.class))
				query.select(biglietto).where(cb.equal(biglietto.get("fila"), fila))
				
				).getResultList();
	}
}