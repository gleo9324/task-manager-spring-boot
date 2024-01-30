package it.ecubit.service;

import java.util.List;
import java.util.Optional;

import it.ecubit.models.Task;

public interface ITaskService{

	public Iterable<Task> getAll();
	
	public Optional<Task> getById(Long id);
	
	public Task create(Task task);
	
	public Optional<Task> update(Task task, Long id);
	
	public boolean delete(Long id);
	
	public Iterable<Task> getByPersonaId(Long idPersona);
	
	
}
