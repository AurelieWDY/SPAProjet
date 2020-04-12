package interfacegraphique;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoadingPage extends JFrame {

	/**
	 * Loading page
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField ID;
	private JTextField Nom;
	private JTextField Age;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTable table;
	String Sexe;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoadingPage frame = new LoadingPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoadingPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1472, 304);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(84, 19, 69, 20);
		panel.add(lblId);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(84, 55, 69, 20);
		panel.add(lblNom);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(84, 91, 69, 20);
		panel.add(lblAge);
		
		JLabel lblSexe = new JLabel("Sexe");
		lblSexe.setBounds(84, 126, 69, 20);
		panel.add(lblSexe);
		
		JLabel lblRace = new JLabel("Race");
		lblRace.setBounds(84, 162, 69, 20);
		panel.add(lblRace);
		
		JLabel lblPrix = new JLabel("Prix");
		lblPrix.setBounds(84, 198, 69, 20);
		panel.add(lblPrix);
		
		ID = new JTextField();
		ID.setBounds(178, 16, 146, 26);
		panel.add(ID);
		ID.setColumns(10);
		
		Nom = new JTextField();
		Nom.setBounds(178, 52, 146, 26);
		panel.add(Nom);
		Nom.setColumns(10);
		
		Age = new JTextField();
		Age.setBounds(178, 88, 146, 26);
		panel.add(Age);
		Age.setColumns(10);
		
		JComboBox CbRace = new JComboBox();
		CbRace.setModel(new DefaultComboBoxModel(new String[] {" ", "Chien", "Chat", "Lapin"}));
		CbRace.setBounds(178, 159, 146, 26);
		panel.add(CbRace);
		
		JComboBox CbPrix = new JComboBox();
		CbPrix.setModel(new DefaultComboBoxModel(new String[] {" ", "125", "90", "45", "0"}));
		CbPrix.setBounds(178, 195, 146, 26);
		panel.add(CbPrix);
		
		JRadioButton Male = new JRadioButton("Mâle");
		buttonGroup_1.add(Male);
		Male.setBounds(174, 123, 69, 27);
		panel.add(Male);
		
		JRadioButton Femelle = new JRadioButton("Femelle");
		buttonGroup_1.add(Femelle);
		Femelle.setBounds(242, 122, 87, 29);
		panel.add(Femelle);
		
		JScrollPane TableAnimal = new JScrollPane();
		TableAnimal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i = table.getSelectedRow();
				TableModel model = table.getModel();
				ID.setText(model.getValueAt(i, 0).toString());
				Nom.setText(model.getValueAt(i, 1).toString());
				Age.setText(model.getValueAt(i, 2).toString());
				String Sexe = model.getValueAt(i, 3).toString();
					if(Sexe.equals("Mâle")) {
						Male.setSelected(true);
					}
					else {
						Femelle.setSelected(true);
					}
				String Race = model.getValueAt(i, 4).toString();
					switch(Race) {
					case " " :
						CbPrix.setSelectedIndex(0);
						break;
					case "Chien" :
						CbRace.setSelectedIndex(1);
						break;
					case "Chat" :
						CbRace.setSelectedIndex(2);
						break;
					case "Lapin" :
						CbRace.setSelectedIndex(3);
						break;
					}
				String Prix = model.getValueAt(i, 5).toString();
					switch(Prix) {
					case " " :
						CbPrix.setSelectedIndex(0);
						break;
					case "125" :
						CbPrix.setSelectedIndex(1);
						break;
					case "90" :
						CbPrix.setSelectedIndex(2);
						break;
					case "45" :
						CbPrix.setSelectedIndex(3);
						break;
					case "0" :	
						CbPrix.setSelectedIndex(4);
						break;
					}
			}
		});
		TableAnimal.setBounds(383, 16, 794, 206);
		panel.add(TableAnimal);
		
		table = new JTable();
		TableAnimal.setViewportView(table);
		
		JButton Afficher = new JButton("Afficher");
		Afficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					String url = "jdbc:mysql://localhost:3308/spa_database?useUnicode=true" + 
							"&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&" + 
							"serverTimezone=UTC";
					Connection myConn = DriverManager.getConnection(url,"WDY", "Aurelie2020*");
					String query = "select * from animal";
					Statement myStmt = myConn.createStatement();
					ResultSet myRs = myStmt.executeQuery(query);
					table.setModel(DbUtils.resultSetToTableModel(myRs));
					//JOptionPane.showMessageDialog(null, "Liste des animaux à SPA Annecy !");
				}
				catch (SQLException exp) {
					System.err.println("Erreur : " + exp.getMessage());
					System.err.println("Code : " + exp.getErrorCode());
					System.err.println("State : " + exp.getSQLState());
				} catch (Exception exp) {
					JOptionPane.showConfirmDialog(null, exp);
				}
			}
		});
		Afficher.setBounds(1238, 15, 115, 29);
		panel.add(Afficher);
		
		JButton Ajouter = new JButton("Ajouter");
		Ajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					String url = "jdbc:mysql://localhost:3308/spa_database?useUnicode=true" + 
							"&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&" + 
							"serverTimezone=UTC";
					Connection myConn = DriverManager.getConnection(url,"WDY", "Aurelie2020*");
					String query = "insert into animal(id, nom, age, sexe, race, prix) values(?,?,?,?,?,?)";
					PreparedStatement myPst = myConn.prepareStatement(query);
					
					myPst.setString(1, ID.getText());
					
					myPst.setString(2, Nom.getText());
					
					myPst.setString(3, Age.getText());
					
					if(Male.isSelected()) {
						Sexe = "Mâle";
					}
					if(Femelle.isSelected()) {
						Sexe = "Femelle";
					}
					myPst.setString(4, Sexe);
					
					String Race;
					Race = CbRace.getSelectedItem().toString();
					myPst.setString(5, Race);
					
					String Prix;
					Prix = CbPrix.getSelectedItem().toString();
					myPst.setString(6, Prix);
					
					myPst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Animal bien ajouté !");
				}
				catch (SQLException exp) {
					System.err.println("Erreur : " + exp.getMessage());
					System.err.println("Code : " + exp.getErrorCode());
					System.err.println("State : " + exp.getSQLState());
				} catch (Exception exp) {
					JOptionPane.showConfirmDialog(null, exp);
				}
			}
		});
		Ajouter.setBounds(1238, 60, 115, 29);
		panel.add(Ajouter);
		
		JButton Modifier = new JButton("Modifier");
		Modifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					String url = "jdbc:mysql://localhost:3308/spa_database?useUnicode=true" + 
							"&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&" + 
							"serverTimezone=UTC";
					Connection myConn = DriverManager.getConnection(url,"WDY", "Aurelie2020*");
					String query = "update animal set nom = ?, age = ?, sexe = ?, race = ?, prix = ? where id = ?";
					PreparedStatement myPst = myConn.prepareStatement(query);
					
					myPst.setString(6, ID.getText());
					
					myPst.setString(1, Nom.getText());
					
					myPst.setString(2, Age.getText());
					
					if(Male.isSelected()) {
						Sexe = "Mâle";
					}
					if(Femelle.isSelected()) {
						Sexe = "Femelle";
					}
					myPst.setString(3, Sexe);
					
					String Race;
					Race = CbRace.getSelectedItem().toString();
					myPst.setString(4, Race);
					
					String Prix;
					Prix = CbPrix.getSelectedItem().toString();
					myPst.setString(5, Prix);
					
					myPst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Animal bien modifié !");
				}
				catch (SQLException exp) {
					System.err.println("Erreur : " + exp.getMessage());
					System.err.println("Code : " + exp.getErrorCode());
					System.err.println("State : " + exp.getSQLState());
				} catch (Exception exp) {
					JOptionPane.showConfirmDialog(null, exp);
				}
			}
		});
		Modifier.setBounds(1238, 105, 115, 29);
		panel.add(Modifier);
		
		JButton Supprimer = new JButton("Supprimer");
		Supprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					String url = "jdbc:mysql://localhost:3308/spa_database?useUnicode=true" + 
							"&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&" + 
							"serverTimezone=UTC";
					Connection myConn = DriverManager.getConnection(url,"WDY", "Aurelie2020*");
					String query = "delete from animal where id = ?";
					PreparedStatement myPst = myConn.prepareStatement(query);
					
					myPst.setString(1, ID.getText());
					
					myPst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Animal bien supprimé !");
				}
				catch (SQLException exp) {
					System.err.println("Erreur : " + exp.getMessage());
					System.err.println("Code : " + exp.getErrorCode());
					System.err.println("State : " + exp.getSQLState());
				} catch (Exception exp) {
					JOptionPane.showConfirmDialog(null, exp);
				}
			}
		});
		Supprimer.setBounds(1238, 150, 115, 29);
		panel.add(Supprimer);
		
		JButton Annuler = new JButton("Annuler");
		Annuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ID.setText("");
				Nom.setText("");
				Age.setText("");
				buttonGroup_1.clearSelection();
				CbRace.setSelectedIndex(0);
				CbPrix.setSelectedIndex(0);
			}
		});
		Annuler.setBounds(1238, 194, 115, 29);
		panel.add(Annuler);
	}
}
