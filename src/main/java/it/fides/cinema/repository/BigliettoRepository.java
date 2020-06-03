package it.fides.cinema.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.fides.cinema.entity.Biglietto;

@Repository
public interface BigliettoRepository extends CrudRepository<Biglietto, Long>{
	public List<Biglietto> testBiglietto(String fila);	
	public Optional<Biglietto> findById(Long id);
}
