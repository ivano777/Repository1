package it.fides.cinema.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.fides.cinema.entity.Proiezione;

@Repository
public interface ProiezioneRepository extends CrudRepository<Proiezione, Long>{

}
