package it.fides.cinema.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;

import it.fides.cinema.dto.BigliettoDto;
import it.fides.cinema.entity.Biglietto;
import it.fides.cinema.repository.BigliettoRepository;

@Repository
public class BigliettoRepositoryImpl implements BigliettoRepository {

	@PersistenceContext
	protected EntityManager entityManager;
	
	@Override
	public List<Biglietto> testBiglietto2() {
		
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Biglietto> query = cb.createQuery(Biglietto.class);
		
		return this.entityManager.createQuery(
				query.select(query.from(Biglietto.class))).getResultList();
	}
	
	@Override
	public <S extends Biglietto> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Biglietto> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Biglietto> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Biglietto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Biglietto> findAllById(Iterable<Long> ids) {
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
	public void delete(Biglietto entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Biglietto> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}


}
