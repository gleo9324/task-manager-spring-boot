package it.ecubit.controller.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import it.ecubit.models.Persona;
import it.ecubit.models.Task;
import it.ecubit.service.DbPersonaService;
import it.ecubit.service.IPersonaService;
import it.ecubit.service.ITaskService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TaskController {

	@Autowired
	@Qualifier("mainTaskService")
	private ITaskService taskService;
	

	
	@RequestMapping("/api/task")
	public Iterable<Task> getAll(){
		
		return taskService.getAll();
	};
	
	@RequestMapping("/api/task/findById/{id}")
	public Optional<Task> getById(@PathVariable Long id){
		
		if(taskService.getById(id).isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"item not found");
		}
		
		return taskService.getById(id);
	};
	
	@RequestMapping(value = "/api/task", method = RequestMethod.POST)
	public Task create(@RequestBody Task task) {
		
		
		
		return taskService.create(task);
	}
	
	@RequestMapping(value = "/api/task/{id}", method = RequestMethod.PUT)
	public Task update(@RequestBody Task task,@PathVariable Long id){
		
		Optional<Task> update = taskService.update(task, id);
		
		if(update.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"item not found");
		}
		
		return update.get();
	}
	
	@RequestMapping(value = "/api/task/{id}", method = RequestMethod.DELETE)
	public boolean delete(@PathVariable Long id) {
		
		boolean isDeleted = taskService.delete(id);
		
		
		if(isDeleted == false) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"item not found");
		}
		
		return isDeleted;
	}
	
	@RequestMapping("/api/task/findByPersona/{idPersona}")
	public Iterable<Task> getByPersonaId(@PathVariable Long idPersona) {
		
		Iterable<Task> task = taskService.getByPersonaId(idPersona);
		
		return task;
	}
	
}
