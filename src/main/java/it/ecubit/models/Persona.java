package it.ecubit.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="persona")
public class Persona {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPersona;
	
	@Column(name="nome", columnDefinition = "Varchar(50)", nullable = false)
	private String nome;
	
	@Column(name="cognome", columnDefinition = "Varchar(255)", nullable = false)
	private String cognome;

	@Column(name="email", unique = true, columnDefinition = "Varchar(255)", nullable = true)
	private String email;
	
	@OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
	@JsonManagedReference
	@JsonIgnoreProperties({"persona"})
	private List<Task> tasks;

	public Persona() {
	}



	public Persona(String nome, String cognome, String email, List<Task> tasks) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.tasks = tasks;
	}

	public Persona(Long idPersona, String nome, String cognome, String email, List<Task> tasks) {
		this.idPersona = idPersona;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.tasks = tasks;
	}

	public Long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	public List<Task> getTasks() {
		return tasks;
	}



	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}



	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", nome=" + nome + ", cognome=" + cognome + ", email=" + email + "]";
	}
	
	
	
	
	
}
