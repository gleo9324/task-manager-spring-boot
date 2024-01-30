package it.ecubit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.ecubit.models.Task;

@Repository
public interface ITaskRepository extends JpaRepository<Task, Long> {

	public Iterable<Task> findByPersonaIdPersona(Long idPersona);
	
}
