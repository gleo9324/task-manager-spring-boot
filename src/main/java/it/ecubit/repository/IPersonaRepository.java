package it.ecubit.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.ecubit.models.Persona;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Long>{

	Iterable<Persona> findByCognome(String cognome);
}
