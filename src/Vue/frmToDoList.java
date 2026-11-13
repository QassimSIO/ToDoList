package Vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controleur.Controle;
import Modele.Proprietaires;
import Modele.Sorcier;
import Modele.Taches;
import Modele.Urgence;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.JProgressBar;
import javax.swing.JCheckBox;
import javax.swing.JSplitPane;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JSlider;

public class frmToDoList extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTitre;
	private JTextField txtDateExpiration;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTextField txtStatut;
	private Controle controle;
	private JComboBox <Proprietaires> cbbProprietaire;
	private JComboBox<Urgence> cbbUrgence;
	
	private JButton btnAjouter;
	private DefaultListModel<Taches> modeleTachesAFaire = new DefaultListModel<>();
	private JList<Taches> lstTachesAFaire;


	
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmToDoList frame = new frmToDoList();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	
	
	//methode mise a jours formulaire //
	public void majFormulaire() {
		txtTitre.setText("");
		 cbbProprietaire.setSelectedItem(null);
		 txtDateExpiration.setText("");
		 cbbUrgence.setSelectedItem(null);
	}
	
	
	//methode pour afficher message d'erreur//
	 public void afficherErreur(String message) {JOptionPane.showMessageDialog(this, message, "Information", JOptionPane.INFORMATION_MESSAGE);
	};
	
	
	 public void afficherTache(Taches t){
		 txtTitre.setText(t.getTitre());
		 cbbProprietaire.setSelectedItem(t.getProprietaire());
		 txtDateExpiration.setText(t.getDateExpiration());
		 cbbUrgence.setSelectedItem(t.getUrgence());
	 };
	
	
	/***
	 * Clique sur une tache
	 */
	public void CliqueSurTache() {
		lstTachesAFaire.addListSelectionListener(e -> {
		    if (e.getValueIsAdjusting()) {
		        return;                                    // on ignore le premier des deux événements evennement sur un clique au lieu de 2
		    }
		    Taches choisie = lstTachesAFaire.getSelectedValue();
		    if (choisie != null) {
		    	 afficherTache(choisie);
		    }
		});
	}
	
	
	
	
	/***
	 * Clique sur le bouton Modifier
	 */
	public void cliqueBtnModif() 
	{Taches choisie = lstTachesAFaire.getSelectedValue();//la tache selectionné//
	if(choisie == null) {//si aucune tache n'est choisie//
		 afficherErreur("Sélectionne une tâche à modifier");
	        return;
	}
	
	 int reponse = JOptionPane.showConfirmDialog(this,
	            "Modifier « " + choisie + " » ?", "Confirmation", JOptionPane.YES_NO_OPTION);
	 
	 if(reponse == JOptionPane.YES_OPTION) {
		 controle.SupprimeUneTache(choisie);
		 controle.creeTaches(txtTitre.getText(),(Proprietaires)cbbProprietaire.getSelectedItem(), txtDateExpiration.getText(), (Urgence)cbbUrgence.getSelectedItem());
			
		 
	 }
	}
	
	
	
	/***
	 * Clique sur le bouton Supprimer
	 */
	public void cliqueBtnSuppr() 
	{Taches choisie = lstTachesAFaire.getSelectedValue();//la tache selectionné//
	if(choisie == null) {//si aucune tache n'est choisie//
		 afficherErreur("Sélectionne une tâche à supprimer");
	        return;
	}
	 int reponse = JOptionPane.showConfirmDialog(this,
	            "Supprimer « " + choisie + " » ?", "Confirmation", JOptionPane.YES_NO_OPTION);
	 
	 if(reponse == JOptionPane.YES_OPTION) {
		
		 controle.SupprimeUneTache(choisie);
	 }
	}
	
	
	/***
	 * Clique sur le bouton ajouter 
	 */
	public void cliqueBtnAjouter() {
		controle.creeTaches(txtTitre.getText(),(Proprietaires)cbbProprietaire.getSelectedItem(), txtDateExpiration.getText(), (Urgence)cbbUrgence.getSelectedItem());
		majFormulaire();
	}
	
	/**
	 * 
	 * 
	 * @param lesTaches
	 */
	public void majlstTachesAFaire(ArrayList<Taches> lesTaches) {
	    modeleTachesAFaire.clear();
	    for (Taches t : lesTaches) {
	        modeleTachesAFaire.addElement(t);
	    }
	}
	
	
	/***
	 * Clique sur le bouton nouveau et ajout dan le tableau proprietaire et le combo box 
	 */
	public void cliqueBtnNouveau() {
		controle.creeMembre(txtNom.getText(), txtPrenom.getText(), txtStatut.getText());
		txtNom.setText("");
		txtPrenom.setText("");
		txtStatut.setText("");
				
	}
	
	/***
	 * methode mise a jours du comboBox
	 * @param lesProprietaires
	 */
	public void majCbbProprietaire(ArrayList<Proprietaires> lesProprietaires) {
		cbbProprietaire.removeAllItems(); //suppr tout dans le combobox
		for(Proprietaires p : lesProprietaires) {
			
			cbbProprietaire.addItem(p);//rajoute le contenu du tableau
		}
	}
	
	/*
	/**
	 * 
	 * @param lesNivUrgence
	 
	public void RempCbbUrgence( ArrayList <Urgence> lesNivUrgence) {
		for(Urgence p : lesNivUrgence) {
			
			cbbUrgence.addItem(p);//rajoute le contenu du tableau
		}
	}
	*/
	
	
	

	/**
	 * Create the frame.
	 */
	public frmToDoList(Controle controle) {
		
		this.controle=controle;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 579, 636);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl1 = new JLabel("TITRE :");
		lbl1.setBounds(10, 28, 46, 14);
		contentPane.add(lbl1);
		
		JLabel lblNewLabel = new JLabel("PROPRIETAIRE :");
		lblNewLabel.setBounds(10, 59, 90, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Date d'expiration :");
		lblNewLabel_2.setBounds(10, 90, 109, 14);
		contentPane.add(lblNewLabel_2);
		
		txtTitre = new JTextField();
		txtTitre.setHorizontalAlignment(SwingConstants.LEFT);
		txtTitre.setBounds(142, 25, 231, 20);
		contentPane.add(txtTitre);
		txtTitre.setColumns(10);
		
		cbbProprietaire = new JComboBox<Proprietaires>();
		cbbProprietaire.setBounds(142, 51, 231, 22);
		contentPane.add(cbbProprietaire);
		cbbProprietaire.setRenderer(new DefaultListCellRenderer() {
		     @Override
		      public Component getListCellRendererComponent(JList<?> list, Object value,
		              int index, boolean isSelected, boolean cellHasFocus) {
		
		         Component c = super.getListCellRendererComponent(list, value, index,
		                   isSelected, cellHasFocus);
	
		          
		              if (value instanceof Sorcier) {
		                  c.setForeground(Color.BLUE);
		              } else {
		                 c.setForeground(Color.RED);
		             
		         }
		         return c;
		     }
		  });
		
		cbbUrgence = new JComboBox<Urgence>(Urgence.values());
		cbbUrgence.setBounds(142, 115, 231, 22);
		contentPane.add(cbbUrgence);
		
		txtDateExpiration = new JTextField();
		txtDateExpiration.setHorizontalAlignment(SwingConstants.LEFT);
		txtDateExpiration.setBounds(142, 84, 231, 20);
		contentPane.add(txtDateExpiration);
		txtDateExpiration.setColumns(10);
		
		lstTachesAFaire = new JList<Taches>(modeleTachesAFaire);
		JScrollPane scrollAFaire = new JScrollPane(lstTachesAFaire);
		scrollAFaire.setBounds(10, 220, 400, 332);
		contentPane.add(scrollAFaire);
		
		JButton btnSupprTachesAFaire = new JButton("Supprimer");
		btnSupprTachesAFaire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 cliqueBtnSuppr() ;
			}
		});
		btnSupprTachesAFaire.setBounds(10, 563, 89, 23);
		contentPane.add(btnSupprTachesAFaire);
		
		JButton btnModifTachesAFaire = new JButton("Modifier");
		btnModifTachesAFaire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cliqueBtnModif();
			}
		});
		btnModifTachesAFaire.setBounds(105, 563, 89, 23);
		contentPane.add(btnModifTachesAFaire);
		
		JLabel lblNewLabel_5 = new JLabel("Urgence :");
		lblNewLabel_5.setBounds(10, 115, 60, 14);
		contentPane.add(lblNewLabel_5);
		
		JButton btnViderTachesAFaire = new JButton("Vider");
		btnViderTachesAFaire.setBounds(204, 563, 89, 23);
		contentPane.add(btnViderTachesAFaire);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(321, 563, 89, 23);
		contentPane.add(btnQuitter);
		
		btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cliqueBtnAjouter();
			}
		});
		btnAjouter.setBounds(208, 160, 89, 23);
		contentPane.add(btnAjouter);
		
		JLabel lblNewLabel_3 = new JLabel("MEMBRES");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(449, 28, 90, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(407, 59, 46, 14);
		contentPane.add(lblNom);
		
		JLabel lblNewLabel_6 = new JLabel("Prénom :");
		lblNewLabel_6.setBounds(407, 90, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblStatut = new JLabel("Statut :");
		lblStatut.setBounds(407, 123, 46, 14);
		contentPane.add(lblStatut);
		
		txtNom = new JTextField();
		txtNom.setHorizontalAlignment(SwingConstants.RIGHT);
		txtNom.setBounds(453, 56, 86, 20);
		contentPane.add(txtNom);
		txtNom.setColumns(10);
		
		txtPrenom = new JTextField();
		txtPrenom.setHorizontalAlignment(SwingConstants.RIGHT);
		txtPrenom.setBounds(453, 87, 86, 20);
		contentPane.add(txtPrenom);
		txtPrenom.setColumns(10);
		
		txtStatut = new JTextField();
		txtStatut.setHorizontalAlignment(SwingConstants.RIGHT);
		txtStatut.setBounds(453, 116, 86, 20);
		contentPane.add(txtStatut);
		txtStatut.setColumns(10);
		
		JButton btnCreer = new JButton("Nouveau");
		btnCreer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cliqueBtnNouveau();
			}
		});
		btnCreer.setBounds(453, 160, 89, 23);
		contentPane.add(btnCreer);
		
		CliqueSurTache();
		
		
		

	}
}
