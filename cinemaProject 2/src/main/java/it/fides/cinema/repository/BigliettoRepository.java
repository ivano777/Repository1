package it.fides.cinema.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.fides.cinema.dto.BigliettoDto;
import it.fides.cinema.entity.Biglietto;


public interface BigliettoRepository extends CrudRepository<Biglietto, Long>{

	public List<Biglietto> testBiglietto2();
	
}
