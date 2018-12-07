package dev.top.entities;

public class CollegueForm {
	
	String matricule;
	String pseudo;
	String imageUrl;
	
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

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	
	public CollegueForm() {}
	
	public CollegueForm(String matricule, String pseudo, String imageUrl) {
		this.matricule = matricule;
		this.pseudo = pseudo;
		this.imageUrl = imageUrl;
	}
}
