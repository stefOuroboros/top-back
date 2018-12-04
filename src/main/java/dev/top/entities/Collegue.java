package dev.top.entities;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Collegue {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	String pseudo;
	@ElementCollection
	List<String> imageUrl;
	int score;

	//Construct
	public Collegue(String pseudo, List<String> imageUrl, int score) {
		this.pseudo = pseudo;
		this.imageUrl = imageUrl;
		this.score = score;
	}
	
	public Collegue() {
		super();
	}
	
	//Getters
	public int getId() { return id; }
	public String getPseudo() { return pseudo; }
	public List<String> getImageUrl() { return imageUrl; }
	public int getScore() { return score; }
	//Setters
	public void setId(int id) { this.id = id; }
	public void setPseudo(String pseudo) { this.pseudo = pseudo; }
	public void setImageUrl(List<String> imageUrl) { this.imageUrl = imageUrl; }
	public void setScore(int score) { this.score = score; }
	
}
