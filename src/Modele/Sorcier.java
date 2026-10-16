package Modele;

public class Sorcier extends Proprietaires {

	
	
	//Constructeur//
	public Sorcier(String nom, String prenom, String statut) {
		super(nom,prenom,statut);
	}
	
	//methodes//
	
	@Override
	public String infoMessage(String prenom,String nom, String statut ) {
		return "Statut : "+ statut + " "+ prenom + "" + nom  ;
	}
}
