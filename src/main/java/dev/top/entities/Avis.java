package dev.top.entities;

public enum Avis {
	AIMER("AIMER"), DETESTER("DETESTER");
	private String avis;
	
	Avis(String avis){ this.avis = avis; }

	public String getAvis() { return avis; }

	public void setAvis(String avis) { this.avis = avis; }
	
}