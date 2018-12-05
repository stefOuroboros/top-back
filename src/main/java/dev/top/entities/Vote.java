package dev.top.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Vote {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Avis avis;
	@ManyToOne
	private Collegue collegue;
	@Column(name="local_date_time")
	private LocalDateTime localDateTime;
	
	//Getters
	public int getId() { return id; }
	public Avis getAvis() { return avis; }
	public Collegue getCollegue() { return collegue; }
	public LocalDateTime getLocalDateTime() { return localDateTime; }
	//Setters
	public void setAvis(Avis avis) { this.avis = avis; }
	public void setId(int id) { this.id = id; }
	public void setCollegue(Collegue collegue) { this.collegue = collegue; }
	public void setLocalDateTime(LocalDateTime localDateTime) { this.localDateTime = localDateTime; }
	
}
