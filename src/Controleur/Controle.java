package Controleur;

import java.util.ArrayList;

import Modele.Moldu;
import Modele.Proprietaires;
import Modele.Sorcier;
import Modele.Taches;
import Modele.Urgence;
import Vue.frmToDoList;



public class Controle {
	
	//Attributs//
	private frmToDoList frmToDoList;
	private ArrayList <Proprietaires> lesProprietaires=new ArrayList<Proprietaires>();
	private ArrayList <Taches> lesTaches = new ArrayList<Taches>();
	/*private ArrayList <Urgence> lesNivUrgence = new ArrayList<Urgence>();*/
	
	//Controleur//
	public Controle() {
		
		frmToDoList= new frmToDoList(this);
		frmToDoList.setVisible(true);
	
	}
	
	
	
	//lancement de l'application//
		public static void main(String[] args) {
			new Controle();
		}
		
	/*	
	//Mehtode pour remplir le comboUrgence	
		public void rempliComboUrgence() {
			lesNivUrgence.add(Urgence.PAS_URGENT);
			lesNivUrgence.add(Urgence.URGENT);
			lesNivUrgence.add(Urgence.TRES_URGENT);
			frmToDoList.RempCbbUrgence(lesNivUrgence);
		}
	
		*/
	//methode pour creer un proprietaires//
	public void creeMembre(String nom, String prenom, String statut) {
		Proprietaires unProprietaire;
		if("Sorcier".equals(statut)) {
			unProprietaire= new Sorcier( nom,prenom,  statut);
		}else{
			 
				unProprietaire= new Moldu( nom,prenom,  statut);
		}
	
		lesProprietaires.add(unProprietaire);
		frmToDoList.majCbbProprietaire(lesProprietaires);
		
	}

	//methode pour creer une taches//
	
	public void creeTaches(String titre, Proprietaires proprietaire,String dateExpiration, Urgence u) {
		Taches uneTache;
		uneTache = new Taches(titre,proprietaire,dateExpiration,u);
		lesTaches.add(uneTache);
		frmToDoList.majlstTachesAFaire(lesTaches);
	}
	
	
	//methode pour supprimer une tache //
	
	public void SupprimeUneTache(Taches laTache) {
		lesTaches.remove(laTache);
		frmToDoList.majFormulaire();
		frmToDoList.majlstTachesAFaire(lesTaches);
		
		
	}
	
	//methode pour modifier une tache //
	
	public void ModifierUneTache(Taches laTache) {
		lesTaches.remove(laTache);
		frmToDoList.majlstTachesAFaire(lesTaches);
		
	}

	}
