package it.fides.cinema.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.dozer.DozerBeanMapper;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.fides.cinema.dto.BigliettoDto;
import it.fides.cinema.entity.Biglietto;
import it.fides.cinema.repository.BigliettoRepository;
import it.fides.cinema.service.GestioneBiglietto;

@Service
public class GestioneBigliettoImpl implements GestioneBiglietto {
	
	public static GestioneBigliettoImpl gestioneBigliettoImpl=null;

	@Autowired
	private BigliettoRepository bigliettoRepository;
	private DozerBeanMapper mapper;
	
	public List<Biglietto> testBiglietto2() {
		
		return bigliettoRepository.testBiglietto2();
			
}


	@Override
	public Set<BigliettoDto> findAll() {
		mapper = new DozerBeanMapper();
		Set<BigliettoDto> setBigliettoDto = new HashSet<BigliettoDto>();
		bigliettoRepository.findAll().forEach(biglietto -> {
			BigliettoDto bigliettoDto = new BigliettoDto();
			bigliettoDto = mapper.map(biglietto, BigliettoDto.class);
//			bigliettoDto = EntityInDto.bigliettoEntityInDto(biglietto);
//			bigliettoDto.setPersona(EntityInDto.personaEntityInDto(biglietto.getPersona()));
//			bigliettoDto.setProiezione(EntityInDto.proiezioneEntityInDto(biglietto.getProiezione()));

			setBigliettoDto.add(bigliettoDto);
		});
		 return setBigliettoDto;
	}
	
//	public List<Biglietto> testBiglietto() {
//		List<Biglietto> results = new ArrayList<Biglietto>();
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
////se non lo metto mi da errore sessione non trovata
//		session.beginTransaction();
//		CriteriaBuilder cb = session.getCriteriaBuilder();
//		CriteriaQuery<Biglietto> cr = cb.createQuery(Biglietto.class);
//		Root<Biglietto> root = cr.from(Biglietto.class);
//		cr.select(root);
//		 
//		Query<Biglietto> query = session.createQuery(cr);
//		results = query.getResultList();
//		
////		List<BigliettoDto> resultsDto = new ArrayList<BigliettoDto>();
//		
////		results.forEach( biglietto -> {
////			BigliettoDto bigliettoDto = new BigliettoDto();
////			bigliettoDto = EntityInDto.bigliettoEntityInDto(biglietto);
////			resultsDto.add(bigliettoDto);
////		});
//		session.close();
//		return results;
//	}
	
	

	@Override
	public List<Biglietto> testBiglietto() {
		// TODO Auto-generated method stub
		return null;
	}
	
}