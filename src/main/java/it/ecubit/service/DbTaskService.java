package it.ecubit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import it.ecubit.models.Persona;
import it.ecubit.models.Task;
import it.ecubit.repository.ITaskRepository;

@Service("mainTaskService") 
public class DbTaskService implements ITaskService{
	
	@Autowired
	private ITaskRepository repository;
	
	@Autowired
	private IPersonaService personaService;
	
	@Override
	public Iterable<Task> getAll(){
		
		return repository.findAll();
	};
	
	@Override
	public Optional<Task> getById(Long id){
		
		Optional<Task> task = repository.findById(id);
		
		return task;
	};
	
	@Override
	public Task create(Task task){
		
	Optional<Persona> persona = personaService.getById(task.getPersona().getIdPersona());
	
	if(persona.isEmpty()) {
		
	}else {
	task.setPersona(persona.get());
	}
		
		repository.save(task);
		
		return task;
	};
	
	@Override
	public Optional<Task> update(Task task, Long id){
		
		Optional<Task> newTask = repository.findById(id);
		Optional<Persona> persona = personaService.getById(task.getPersona().getIdPersona());
		
		if(newTask.isEmpty()) {
			return Optional.empty();
		}
		
		newTask.get().setTitolo(task.getTitolo());
		newTask.get().setDescrizione(task.getDescrizione());
		newTask.get().setDataCreazione(task.getDataCreazione());
		newTask.get().setDataScadenza(task.getDataScadenza());
		newTask.get().setDone(task.isDone());
		if(persona.isEmpty()) {
			
		}else {
		newTask.get().setPersona(persona.get());
		}
		repository.save(newTask.get());		
		
		return newTask;
	}
	
	@Override
	public boolean delete(Long id){
		
		Optional<Task> task = repository.findById(id);
		
		if(task.isEmpty()) {

			return false;
		}
		repository.delete(task.get());
		
		return true;
		
	}

	@Override
	public Iterable<Task> getByPersonaId(Long idPersona) {

		Iterable<Task> task = repository.findByPersonaIdPersona(idPersona);
		
		return task;
	}
	
}
