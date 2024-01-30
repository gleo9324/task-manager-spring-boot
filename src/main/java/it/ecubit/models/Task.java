package it.ecubit.models;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table; 



@Entity
@Table(name="tasks")
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="titolo", columnDefinition = "Varchar(50)", nullable = false )
	private String titolo;
	
	@Column(name="descrizione", columnDefinition = "Varchar(255)", nullable = true)
	private String descrizione;
	
	@Column(name="isdone", nullable = true)
	private boolean isDone;
	
	@Column(name="datacreazione", nullable = true)
	private LocalDate dataCreazione;
	
	@Column(name="datascadenza", nullable = true)
	private LocalDate dataScadenza;
	
	@JsonIgnoreProperties({"tasks"})
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "persona_id")
	@JsonBackReference
	private Persona persona;
	
	public Task() {
	}

	public Task(Long id, String titolo, String descrizione, Persona persona) {
		this.id = id;
		this.titolo = titolo;
		this.descrizione = descrizione;
		this.persona = persona;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	public LocalDate getDataCreazione() {
		return dataCreazione;
	}

	public void setDataCreazione(LocalDate dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	public LocalDate getDataScadenza() {
		return dataScadenza;
	}

	public void setDataScadenza(LocalDate dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Override
	public String toString() {
		return "Task [titolo=" + titolo + ", descrizione=" + descrizione + ", isDone=" + isDone + ", dataCreazione="
				+ dataCreazione + ", dataScadenza=" + dataScadenza + ", persona=" + persona + "]";
	}
	
	

}
