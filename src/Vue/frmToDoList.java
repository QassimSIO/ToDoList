package Vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controleur.Controle;

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
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmToDoList extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTitre;
	private JTextField txtDatePublication;
	private JTextField txtDateExpiration;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTextField txtStatut;
	private Controle controle;

	
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
	
	
	/***
	 * Methode pour creer un membres(proprietaires)
	 */
	
	
	

	/**
	 * Create the frame.
	 */
	public frmToDoList(Controle controle) {
		this.controle=controle;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 892, 636);
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
		
		JLabel lblNewLabel_1 = new JLabel("Date de publication :");
		lblNewLabel_1.setBounds(10, 84, 109, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Date d'expiration :");
		lblNewLabel_2.setBounds(10, 109, 109, 14);
		contentPane.add(lblNewLabel_2);
		
		txtTitre = new JTextField();
		txtTitre.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTitre.setBounds(142, 25, 231, 20);
		contentPane.add(txtTitre);
		txtTitre.setColumns(10);
		
		JComboBox cbbProprietaire = new JComboBox();
		cbbProprietaire.setBounds(142, 51, 231, 22);
		contentPane.add(cbbProprietaire);
		
		txtDatePublication = new JTextField();
		txtDatePublication.setHorizontalAlignment(SwingConstants.RIGHT);
		txtDatePublication.setBounds(142, 81, 231, 20);
		contentPane.add(txtDatePublication);
		txtDatePublication.setColumns(10);
		
		txtDateExpiration = new JTextField();
		txtDateExpiration.setHorizontalAlignment(SwingConstants.RIGHT);
		txtDateExpiration.setBounds(142, 106, 231, 20);
		contentPane.add(txtDateExpiration);
		txtDateExpiration.setColumns(10);
		
		JList lstTachesAFaire = new JList();
		lstTachesAFaire.setBounds(10, 220, 400, 332);
		contentPane.add(lstTachesAFaire);
		
		JButton btnSupprTachesAFaire = new JButton("Supprimer");
		btnSupprTachesAFaire.setBounds(10, 563, 89, 23);
		contentPane.add(btnSupprTachesAFaire);
		
		JButton btnModifTachesAFaire = new JButton("Modifier");
		btnModifTachesAFaire.setBounds(105, 563, 89, 23);
		contentPane.add(btnModifTachesAFaire);
		
		JLabel lblNewLabel_5 = new JLabel("Urgence :");
		lblNewLabel_5.setBounds(10, 134, 60, 14);
		contentPane.add(lblNewLabel_5);
		
		JButton btnViderTachesAFaire = new JButton("Vider");
		btnViderTachesAFaire.setBounds(204, 563, 89, 23);
		contentPane.add(btnViderTachesAFaire);
		
		JRadioButton rdbtnPasUrgent = new JRadioButton("Pas urgent");
		rdbtnPasUrgent.setForeground(Color.BLUE);
		rdbtnPasUrgent.setBounds(142, 130, 77, 23);
		contentPane.add(rdbtnPasUrgent);
		
		JRadioButton rdbtnUrgent = new JRadioButton("Urgent");
		rdbtnUrgent.setForeground(Color.ORANGE);
		rdbtnUrgent.setBounds(221, 130, 60, 23);
		contentPane.add(rdbtnUrgent);
		
		JRadioButton rdbtnTrsUrgent = new JRadioButton("Très urgent");
		rdbtnTrsUrgent.setForeground(Color.RED);
		rdbtnTrsUrgent.setBounds(283, 130, 90, 23);
		contentPane.add(rdbtnTrsUrgent);
		
		JList lstTachesFini = new JList();
		lstTachesFini.setBounds(461, 220, 400, 332);
		contentPane.add(lstTachesFini);
		
		JButton btnSupprTachesFini = new JButton("Supprimer");
		btnSupprTachesFini.setBounds(461, 563, 89, 23);
		contentPane.add(btnSupprTachesFini);
		
		JButton btnViderTachesFini = new JButton("Vider");
		btnViderTachesFini.setBounds(560, 563, 89, 23);
		contentPane.add(btnViderTachesFini);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(772, 563, 89, 23);
		contentPane.add(btnQuitter);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(208, 160, 89, 23);
		contentPane.add(btnAjouter);
		
		JLabel lblNewLabel_3 = new JLabel("MEMBRES");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(630, 11, 90, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(461, 28, 46, 14);
		contentPane.add(lblNom);
		
		JLabel lblNewLabel_6 = new JLabel("Prénom :");
		lblNewLabel_6.setBounds(461, 59, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblStatut = new JLabel("Statut :");
		lblStatut.setBounds(461, 87, 46, 14);
		contentPane.add(lblStatut);
		
		txtNom = new JTextField();
		txtNom.setHorizontalAlignment(SwingConstants.RIGHT);
		txtNom.setBounds(540, 28, 86, 20);
		contentPane.add(txtNom);
		txtNom.setColumns(10);
		
		txtPrenom = new JTextField();
		txtPrenom.setHorizontalAlignment(SwingConstants.RIGHT);
		txtPrenom.setBounds(540, 56, 86, 20);
		contentPane.add(txtPrenom);
		txtPrenom.setColumns(10);
		
		txtStatut = new JTextField();
		txtStatut.setHorizontalAlignment(SwingConstants.RIGHT);
		txtStatut.setBounds(540, 84, 86, 20);
		contentPane.add(txtStatut);
		txtStatut.setColumns(10);
		
		JButton btnCreer = new JButton("Nouveau");
		btnCreer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCreer.setBounds(537, 125, 89, 23);
		contentPane.add(btnCreer);

	}
}
