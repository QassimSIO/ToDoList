package Modele;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Taches {
	
	//Attributs//
	

	private String titre;
	private Proprietaires proprietaire;
	private String dateExpiration;
	private boolean etat;
	private Urgence urgence;
	private final LocalDate datePublication;
	

	public Taches(String titre, Proprietaires proprietaire,String dateExpiration, Urgence u) {
		this.titre=titre;
		this.proprietaire=proprietaire;
		this.dateExpiration=dateExpiration;
		this.urgence=u;
		this.datePublication=LocalDate.now();
		
		
	}
	
	
	@Override
	public String toString() {
	    return titre + " - " + proprietaire + " (" + urgence + ")" + " (" + dateExpiration +") ";
	}
	
	 public LocalDate getDatePublication() {
	        return datePublication;
	    }
	 
	 public void SetTitre(String leTitre) {
		  this.titre = leTitre;
	 }
	 
	 public String getTitre() {
		 return this.titre;
	 }
	 
	 public void SetDateExpiration(String laDateExpiration) {
		  this.dateExpiration = laDateExpiration;
	 }
	 public String getDateExpiration() {
		 return this.dateExpiration;
	 }
	 
	 public Urgence getUrgence() {
		 return this.urgence;
	 }
	 
	 public Proprietaires getProprietaire() {
		return this.proprietaire;
	 }
	 
}



