package Modele;

public class Moldu extends Proprietaires {

	
	
	//Constructeur//
	public Moldu(String nom, String prenom, String statut) {
		super(nom,prenom,statut);
	}
	
	//methodes//
	
	@Override
	public String infoMessage(String prenom,String nom, String statut ) {
		return "Statut : "+ statut + " "+ prenom + "" + nom ;
	}
}
