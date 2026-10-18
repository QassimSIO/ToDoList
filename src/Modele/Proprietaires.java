package Modele;

import java.util.ArrayList;
import java.util.Random;

public abstract class Proprietaires {
	
	//Attributs//
	//tableau de sorts//
	private static final String [] lesSorts = {
			"AVADA KEDAVRA" , "WINGARDIUM LEVIOSA","EXPELIARMUS","STUPEFIX" , "ACTIO","INCENDIO","PETRIFICUS TOTALUS" , "ENDOLORIS","REDUCTO","RECTUSEMPRA" , "IMMOBILIS","EXPECTOPATRONUM"
	};
	
	//objet aleatoire//
	private static final Random Aleatoire= new Random();
	private String nom;
	private String prenom;
	private String statut;
	private String leSort;
	
	
	public Proprietaires(String nom, String prenom, String statut) {
		this.nom=nom;
		this.prenom=prenom;
		this.statut=statut;
		this.leSort=lesSorts[Aleatoire.nextInt(lesSorts.length)];//un sorts choisis aleatoirement/
		
	}
	
	
	public String getLeSort() {
		return leSort;
	}
	
	@Override
	public String toString() {
		return nom + " "+ prenom ;
	}

	public abstract String infoMessage(String prenom,String nom, String statut );

}
