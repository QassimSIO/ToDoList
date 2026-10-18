package Controleur;

import java.util.ArrayList;

import Modele.Moldu;
import Modele.Proprietaires;
import Modele.Sorcier;
import Vue.frmToDoList;



public class Controle {
	
	//Attributs//
	private frmToDoList frmToDoList;
	private ArrayList <Proprietaires> lesProprietaires=new ArrayList<Proprietaires>();
	
	//Controleur//
	public Controle() {
		
		frmToDoList= new frmToDoList(this);
		frmToDoList.setVisible(true);
	
	}
	
	
	
	//lancement de l'application//
		public static void main(String[] args) {
			new Controle();
		}
	
	//methode pour creer un proprietaires//
	public void creeMembre(String nom, String prenom, String statut) {
		Proprietaires unProprietaire;
		if(statut=="Sorcier") {
			unProprietaire= new Sorcier( nom,prenom,  statut);
		}else{
			 
				unProprietaire= new Moldu( nom,prenom,  statut);
		}
		lesProprietaires.add(unProprietaire);
		frmToDoList.majCbbProprietaire(lesProprietaires);
		
	}



	}
