package it.ecubit.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.ecubit.models.Persona;
import it.ecubit.repository.IPersonaRepository;

@Service
public class DbPersonaService implements IPersonaService{

	@Autowired
	IPersonaRepository personaRepository;
	
	@Override
	public Iterable<Persona> getAll() {
		
		return personaRepository.findAll();
	}

	@Override
	public Optional<Persona> getById(Long id) {

		Optional<Persona> persona= personaRepository.findById(id);
		
		return persona;
	}

	@Override
	public Persona create(Persona persona) {

		Persona newPersona = personaRepository.save(persona);
		
		return newPersona;
	}

	@Override
	public Optional<Persona> update(Persona persona, Long id) {

		Optional<Persona> updatePersona = personaRepository.findById(id);
		
		if(updatePersona.isEmpty()) {
			return updatePersona;
		}
		
		updatePersona.get().setNome(persona.getNome());
		updatePersona.get().setCognome(persona.getCognome());
		updatePersona.get().setEmail(persona.getEmail());
		
		personaRepository.save(updatePersona.get());
		
		return updatePersona;
	}

	@Override
	public boolean delete(Long id) {

		Optional<Persona> persona =  personaRepository.findById(id);
		
		if(persona.isEmpty()) {
			return false;
		}
		
		personaRepository.delete(persona.get());
		
		return true;
	}

	@Override
	public Iterable<Persona> findByCognome(String cognome) {

		Iterable<Persona> persona = personaRepository.findByCognome(cognome);
		
		return persona;
	}

}
