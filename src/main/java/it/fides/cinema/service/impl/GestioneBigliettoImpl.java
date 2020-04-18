package it.fides.cinema.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import it.fides.cinema.util.HibernateUtil;

@Service
public class GestioneBigliettoImpl implements GestioneBiglietto {
	
	public static GestioneBigliettoImpl gestioneBigliettoImpl=null;

	@Autowired
	private BigliettoRepository bigliettoRepository;
	private DozerBeanMapper mapper;
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
	
	public List<Biglietto> testBiglietto() {
		List<Biglietto> results = new ArrayList<Biglietto>();
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//se non lo metto mi da errore sessione non trovata
		session.beginTransaction();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Biglietto> cr = cb.createQuery(Biglietto.class);
		Root<Biglietto> root = cr.from(Biglietto.class);
		cr.select(root);
		 
		Query<Biglietto> query = session.createQuery(cr);
		results = query.getResultList();
		
//		List<BigliettoDto> resultsDto = new ArrayList<BigliettoDto>();
		
//		results.forEach( biglietto -> {
//			BigliettoDto bigliettoDto = new BigliettoDto();
//			bigliettoDto = EntityInDto.bigliettoEntityInDto(biglietto);
//			resultsDto.add(bigliettoDto);
//		});
		session.close();
		return results;
	}
	
	
	public List<BigliettoDto> testBiglietto2() {
		List<Biglietto> biglietti = new ArrayList<Biglietto>();
		List<BigliettoDto> bigliettiDto = new ArrayList<BigliettoDto>();
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			//togliendo quello di sotto mi da un vettore vuoto grrr e non mi da più l'errore della transazione
			session.beginTransaction();
			//Query query = session.createQuery("From Persona");
			Criteria criteria = session.createCriteria(Biglietto.class);
			criteria.setFirstResult(0);
			criteria.setMaxResults(2);
			biglietti = criteria.list();
			
			System.out.println("***********************************************************************************************");
			System.out.println(criteria.list().toString());
			System.out.println("            ");
			System.out.println(biglietti.toString());
			System.out.println("***********************************************************************************************");

		}catch(Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		
		biglietti.forEach(biglietto -> {
			BigliettoDto bigliettoDto = new BigliettoDto();
			bigliettoDto = mapper.map(biglietto, BigliettoDto.class);
			bigliettiDto.add(bigliettoDto);
		});
		return bigliettiDto;
	}
}