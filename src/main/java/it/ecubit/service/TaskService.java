package it.ecubit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import it.ecubit.models.Task;

@Service
public class TaskService implements ITaskService{

	private ArrayList<Task> taskList;
	
	
	
	public TaskService() {
		taskList = new ArrayList<Task>();
		taskList.add(new Task(1l, "Task01", "Descrzione01", null));
		taskList.add(new Task(2l, "Task02", "Descrzione02", null));
	}
	
	@Override
	public List<Task> getAll(){
		
		return taskList;
	};
	
	@Override
	public Optional<Task> getById(Long id){
		
		Optional<Task> task = taskList.stream().filter(item->item.getId()== id).findFirst();
		
		return task;
	};
	
	@Override
	public Task create(Task task){
		
		taskList.add(task);
		
		return task;
	};
	
	@Override
	public Optional<Task> update(Task task, Long id){
		
		Optional<Task> newTask = taskList.stream().filter(item->item.getId()==id).findFirst();
		
		newTask.get().setTitolo(task.getTitolo());
		newTask.get().setDescrizione(task.getDescrizione());
		
		return newTask;
	}
	
	@Override
	public boolean delete(Long id){
		
		Optional<Task> task = taskList.stream().filter(item->item.getId()==id).findFirst();
		
		if(task.isEmpty()) {
			System.out.println("è falso");
			return false;
		}else {
		taskList.remove(task.get());
		System.out.println("è vero");
		return true;
		}
	}

	@Override
	public Iterable<Task> getByPersonaId(Long idPersona) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
