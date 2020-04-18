package it.fides.cinema.enumeration;

public enum RuoloEnum {
	ADMIN("admin"),
	UTENTE("utente");

	private String ruolo;

	RuoloEnum(String ruolo){
		this.ruolo=ruolo;
	}
	public String ruolo() {
		return this.ruolo;
	}
}
