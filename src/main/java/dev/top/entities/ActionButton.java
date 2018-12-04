package dev.top.entities;

public class ActionButton {
	
	private Avis action;
	
	public ActionButton() {}
	
	public ActionButton(Avis action) {
		this.action = action;
	}

	public Avis getAction() {
		return action;
	}

	public void setAction(Avis action) {
		this.action = action;
	}
	
}
