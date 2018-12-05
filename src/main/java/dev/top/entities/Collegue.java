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
	
	String nom;
	String prenom;
	String email;
	String adresse;

	//Construct
	public Collegue(String pseudo, List<String> imageUrl, int score) {
		this.pseudo = pseudo;
		this.imageUrl = imageUrl;
		this.score = score;
	}
	
	public Collegue() {
		super();
	}
	
	public Collegue(String pseudo, List<String> imageUrl, int score, String nom, String prenom, String email, String adresse) {
		this.pseudo = pseudo;
		this.imageUrl = imageUrl;
		this.score = score;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
	}

	//Getters
	public int getId() { return id; }
	public String getPseudo() { return pseudo; }
	public List<String> getImageUrl() { return imageUrl; }
	public int getScore() { return score; }
	public String getNom() { return nom; }
	public String getPrenom() { return prenom; }
	public String getEmail() { return email; }
	public String getAdresse() { return adresse; }
	
	//Setters
	public void setId(int id) { this.id = id; }
	public void setPseudo(String pseudo) { this.pseudo = pseudo; }
	public void setImageUrl(List<String> imageUrl) { this.imageUrl = imageUrl; }
	public void setScore(int score) { this.score = score; }
	public void setNom(String nom) { this.nom = nom; }
	public void setPrenom(String prenom) { this.prenom = prenom; }
	public void setEmail(String email) { this.email = email; }
	public void setAdresse(String adresse) { this.adresse = adresse; }
	
}
