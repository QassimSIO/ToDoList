package Controleur;

import java.util.ArrayList;
import Modele.Proprietaires;
import Vue.frmToDoList;



public class Controle {
	
	//Attributs//
	private frmToDoList frmToDoList;
	private ArrayList lesProprietaires=new ArrayList<Proprietaires>();
	
	//Controleur//
	public Controle() {
		
		frmToDoList= new frmToDoList(this);
		frmToDoList.setVisible(true);
	
	}
	
	//Methodes//
	
	//methode pour creer un proprietaires//
	
	
	
	
	//lancement de l'application//
	public static void Main(String[] args) {
		new Controle();
	}
}
