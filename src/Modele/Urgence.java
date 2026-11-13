package Modele;

public enum Urgence {

	PAS_URGENT("PAS URGENT"),
	URGENT("URGENT"),
	TRES_URGENT("TRES URGENT");
			
	private final String libelle;
	
	 Urgence(String libelle) {
		this.libelle= libelle;
	}
	
	 @Override
	 public String toString() {
		 return libelle;
	 }
}
