package it.ecubit.controller.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import it.ecubit.models.Persona;
import it.ecubit.service.DbPersonaService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {

	@Autowired
	DbPersonaService personaService;
	
	@RequestMapping("/api/persona")
	public Iterable<Persona> getAll() {
		
		return personaService.getAll();
	}
	
	@RequestMapping("/api/persona/{id}")
	public Optional<Persona> getById(@PathVariable Long id){
		
		Optional<Persona> persona = personaService.getById(id);
		
		return persona;
	}
	
	@RequestMapping(value="/api/persona", method = RequestMethod.POST)
	public Persona create(@RequestBody Persona persona) {
		
		Persona newPersona = personaService.create(persona);
		
		return newPersona;
		
	}
	
	@RequestMapping(value="/api/persona/{id}", method = RequestMethod.PUT)
	public Optional<Persona> update(@RequestBody Persona persona,@PathVariable Long id){
		
		Optional<Persona> updatePersona = personaService.update(persona, id);
		
		if(updatePersona.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"item not found");
		}
		
		
		return updatePersona;
	}
	
	@RequestMapping(value="/api/persona/byId/{id}", method = RequestMethod.DELETE)
	public boolean delete (@PathVariable Long id) {
		
		boolean isDelete = personaService.delete(id);
		
		if(isDelete == false) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"item not found");
		}
		
		return isDelete;
	}
	
	@RequestMapping(value="/api/persona/byCognome/{cognome}")
	public Iterable<Persona> findByCognome(@PathVariable String cognome){
		
		Iterable<Persona> persona = personaService.findByCognome(cognome);
		
		
		return persona;
	}
}
