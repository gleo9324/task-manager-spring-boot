package it.ecubit.service;

import java.util.Optional;

import it.ecubit.models.Persona;

public interface IPersonaService {
	
	public Iterable<Persona> getAll();
	
	public Optional<Persona> getById(Long id);
	
	public Persona create(Persona persona);
	
	public Optional<Persona> update(Persona persona, Long id);
	
	public boolean delete (Long id);
	
	public Iterable<Persona> findByCognome(String cognome);
	
}
