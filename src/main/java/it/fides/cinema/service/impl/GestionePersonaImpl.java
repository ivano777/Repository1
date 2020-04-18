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
import org.springframework.transaction.annotation.Transactional;

import it.fides.cinema.dto.BigliettoDto;
import it.fides.cinema.dto.LoginDto;
import it.fides.cinema.dto.PersonaDto;
import it.fides.cinema.entity.Persona;
import it.fides.cinema.repository.PersonaRepository;
import it.fides.cinema.service.GestionePersona;
import it.fides.cinema.util.HibernateUtil;



@Service
@Transactional
public class GestionePersonaImpl implements GestionePersona {
	@Autowired
	private PersonaRepository personaRepository;
	DozerBeanMapper mapper;
	
	@Override
	public Set<PersonaDto> findAll(){
		mapper = new DozerBeanMapper();
		Set<PersonaDto> setPersonaDto = new HashSet<PersonaDto>();
		personaRepository.findAll().forEach(persona -> {
        	PersonaDto personaDto = new PersonaDto();
        	personaDto = mapper.map(persona, PersonaDto.class);
        	
        	//inizio setto biglietto
        	Set<BigliettoDto> setBigliettoDto = new HashSet<BigliettoDto>();
        	persona.getBigliettoSet().forEach(biglietto -> {
        		BigliettoDto bigliettoDto = new BigliettoDto();
        		bigliettoDto = mapper.map(biglietto,BigliettoDto.class);
        		setBigliettoDto.add(bigliettoDto);
        	});
        	personaDto.setBigliettoSet(setBigliettoDto);
        	//fine setto biglietto

        	setPersonaDto.add(personaDto);
		});
		return setPersonaDto;
	}
	@Override
	public PersonaDto findUser(LoginDto loginDto) {
		Persona persona = personaRepository.findByUsernameAndPassword(loginDto.getUsername(), loginDto.getPassword());
		PersonaDto personaDto = new PersonaDto();
		personaDto.setId(persona.getId());
		personaDto.setNome(persona.getNome());
		personaDto.setCognome(persona.getCognome());
		//importante
		personaDto.setRuolo(persona.getRuolo());
		return personaDto;
	}
	
	
	
	
	public List<PersonaDto> testPersona() {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//se non lo metto mi da errore sessione non trovata
		session.beginTransaction();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Persona> cr = cb.createQuery(Persona.class);
		Root<Persona> root = cr.from(Persona.class);
		cr.select(root);
		 
		Query<Persona> query = session.createQuery(cr);
		List<Persona> results = query.getResultList();
		
		List<PersonaDto> resultsDto = new ArrayList<PersonaDto>();
		
		results.forEach( persona -> {
			PersonaDto personaDto = new PersonaDto();
			personaDto = mapper.map(persona, PersonaDto.class);
			resultsDto.add(personaDto);
		});
		session.close();
		return resultsDto;
	}
	
	public List<PersonaDto> testPersona2() {

		List <Persona> persone = new ArrayList<Persona>();
		List <PersonaDto> personeDto = new ArrayList<PersonaDto>();

		Session session = HibernateUtil.getSessionFactory().openSession();


		try {
			//togliendo quello di sotto mi da un vettore vuoto grrr e non mi da più l'errore della transazione
			session.beginTransaction();
			//Query query = session.createQuery("From Persona");
			Criteria criteria = session.createCriteria(Persona.class);
			criteria.setFirstResult(0);
			criteria.setMaxResults(2);
			persone = criteria.list();
			
			System.out.println("***********************************************************************************************");
			System.out.println(criteria.list().toString());
			System.out.println("            ");
			System.out.println(persone.toString());
			System.out.println("***********************************************************************************************");

		}catch(Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		
		persone.forEach( persona -> {
			PersonaDto personaDto = new PersonaDto();
			personaDto = mapper.map(persona, PersonaDto.class);
			personeDto.add(personaDto);
		});

		return personeDto;
	}
	
	
}
