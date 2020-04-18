package it.fides.cinema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.fides.cinema.entity.Posto;

@Repository
public interface PostoRepository extends CrudRepository<Posto, Long> {
	public List<Posto> findByFila(String fila);
	@Query(value = "select * from Posto", nativeQuery = true)
	public List<Posto> testPosto();
}

//	@Query(value = "select posto.fila AS fila, posto.Numero as numero from biglietto join proiezione on biglietto.id_proiezione = proiezione.id join sala on proiezione.id_sala = sala.id join posto on posto.id_sala = sala.id join film on proiezione.id_film=film.id where (posto.numero != biglietto.numero or posto.fila != biglietto.fila) and film.titolo='Titanic'", nativeQuery = true)