package it.fides.cinema.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.fides.cinema.entity.Film;

@Repository
public interface FilmRepository extends CrudRepository<Film, Long>{

}
