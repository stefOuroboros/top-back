package dev.top.entities;

import java.util.List;

public class CollegueForm {
	String matricule;
	String pseudo;
	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public List<String> getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(List<String> imageUrl) {
		this.imageUrl = imageUrl;
	}

	List<String> imageUrl;
	
	public CollegueForm() {}
	
	public CollegueForm(String matricule, String pseudo, List<String> imageUrl) {
		this.matricule = matricule;
		this.pseudo = pseudo;
		this.imageUrl = imageUrl;
	}
}
