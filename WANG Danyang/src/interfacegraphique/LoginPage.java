package interfacegraphique;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage {

	private JFrame frame;
	private JPasswordField password;
	private JTextField username;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage window = new LoginPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		password = new JPasswordField();
		password.setBounds(212, 104, 146, 26);
		panel.add(password);
		
		JLabel lblUtilisateur = new JLabel("Utilisateur");
		lblUtilisateur.setBounds(76, 54, 108, 26);
		panel.add(lblUtilisateur);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setBounds(76, 104, 108, 26);
		panel.add(lblMotDePasse);
		
		username = new JTextField();
		username.setBounds(212, 54, 146, 26);
		panel.add(username);
		username.setColumns(10);
		
		JButton btnSeConnecter = new JButton("Se connecter");
		btnSeConnecter.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					String url = "jdbc:mysql://localhost:3308/spa_database?useUnicode=true" + 
							"&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&" + 
							"serverTimezone=UTC";
					Connection myConn = DriverManager.getConnection(url,"WDY", "Aurelie2020*");
					String query = "select * from login where username = ? and password = ?";
					PreparedStatement myPst = myConn.prepareStatement(query);
					myPst.setString(1, username.getText());
					myPst.setString(2, password.getText());
					ResultSet myRs = myPst.executeQuery();
					if(myRs.next()) {
					JOptionPane.showMessageDialog(null, "Bienvenu à SPA Annecy !");
					LoadingPage field = new LoadingPage();
					field.setVisible(true);
					setVisible(false);
					}
					else {	
						JOptionPane.showMessageDialog(null, "Nom d'utilisateur ou/et mot de passe incorrect(s) !");
					username.setText("");
					password.setText("");
					}
					myConn.close();
				}
				catch (SQLException e) {
					System.err.println("Erreur : " + e.getMessage());
					System.err.println("Code : " + e.getErrorCode());
					System.err.println("State : " + e.getSQLState());
				} catch (Exception e) {
					JOptionPane.showConfirmDialog(null, e);
				}
			}

			private void setVisible(boolean b) {
				// TODO Auto-generated method stub
				
			}
		});
		btnSeConnecter.setBounds(48, 162, 136, 29);
		panel.add(btnSeConnecter);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				username.setText("");
				password.setText("");
			}
		});
		btnAnnuler.setBounds(242, 162, 136, 29);
		panel.add(btnAnnuler);
	}
}
