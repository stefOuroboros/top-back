package dev.top.entities;

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
	String[] imageUrl;
	int score;

	//Construct
	public Collegue(String pseudo, String[] imageUrl, int score) {
		this.pseudo = pseudo;
		this.imageUrl = imageUrl;
		this.score = score;
	}
	
	//Getters
	public int getId() { return id; }
	public String getPseudo() { return pseudo; }
	public String[] getImageUrl() { return imageUrl; }
	public int getScore() { return score; }
	//Setters
	public void setId(int id) { this.id = id; }
	public void setPseudo(String pseudo) { this.pseudo = pseudo; }
	public void setImageUrl(String[] imageUrl) { this.imageUrl = imageUrl; }
	public void setScore(int score) { this.score = score; }
	
}
