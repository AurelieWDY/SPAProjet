package database;

import java.sql.*;

public class ClientBD {

	static Connection myConn;
	static Statement myStmt;
	static ResultSet myRs;
	
	public static Connection connectionBD() throws Exception{
	
	try {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3308/spa_database?useUnicode=true" + 
			"&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&" + 
			"serverTimezone=UTC";
	String user = "WDY";
	String password = "Aurelie2020*";
	Class.forName(driver);
	Connection myConn = DriverManager.getConnection(url, user, password);
	return myConn;
	}
	catch (SQLException e) {
		System.err.println("Erreur : " + e.getMessage());
		System.err.println("Code : " + e.getErrorCode());
		System.err.println("State : " + e.getSQLState());
	}
	return myConn;
	}

	public static void main(String[] args) throws Exception{
	
	ajouter(5, "Robert", "Schmitt", "1 rue Jean Jaurès", "Annecy", 74000);
	rechercher("Schmitt");
	modifier(5, "Robert", "Schmitt", "10 rue Honoré de Balzac", "Seynod", 74600);
	supprimer(5);
	rechercher("Schmitt");
	
	try {
		myConn = connectionBD();
		myStmt = myConn.createStatement();
		myRs = myStmt.executeQuery("select * from client");
	while (myRs.next()) {
		System.out.println("Numéro ID : " + myRs.getInt("id") + " Prenom : " + myRs.getString("prenom") + " Nom : " + myRs.getString("nom") + " Adresse : " + myRs.getString("adresse") + " Ville : " + myRs.getString("ville") + " Code Postal : " + myRs.getInt("code_postal"));
	}	
	}
	catch (SQLException e) {
		System.err.println("Erreur : " + e.getMessage());
		System.err.println("Code : " + e.getErrorCode());
		System.err.println("State : " + e.getSQLState());
	}
	}

	public static void ajouter(int id, String prenom, String nom, String adresse, String ville, int code_postal) throws Exception {
	
	try {
		myConn = connectionBD();
		myStmt = myConn.createStatement();
		String query = "insert into client values("+id+", '"+prenom+"', '"+nom+"', '"+adresse+"', '"+ville+"', "+code_postal+")";
		myStmt.executeUpdate(query);
		System.out.println("Nouveau client ajouté !");
	}
	catch (SQLException e) {
		System.err.println("Erreur : " + e.getMessage());
		System.err.println("Code : " + e.getErrorCode());
		System.err.println("State : " + e.getSQLState());
	}
	}

	public static void rechercher(String nom) throws Exception {
	
	try {
		myConn = connectionBD();
		myStmt = myConn.createStatement();
		String query = "select * from client where nom ='"+nom+"'";
		myRs = myStmt.executeQuery(query);
		myRs.last();
		int nbrRow = myRs.getRow();
		if(nbrRow!= 0) {
			System.out.println("Client trouvé !");
		}
		else {
			System.out.println("Client non trouvé !");
		}
	}
	catch (SQLException e) {
		System.err.println("Erreur : " + e.getMessage());
		System.err.println("Code : " + e.getErrorCode());
		System.err.println("State : " + e.getSQLState());
	}
	}

	public static void modifier(int id, String prenom, String nom, String adresse, String ville, int code_postal) throws Exception {
	
	try {
		myConn = connectionBD();
		myStmt = myConn.createStatement();
		String query = "update client set prenom = '"+prenom+"', nom = '"+nom+"', adresse = '"+adresse+"', ville = '"+ville+"', code_postal = "+code_postal+" where id = "+id;
		myStmt.executeUpdate(query);
		System.out.println("Client modifié !");
	}
	catch (SQLException e) {
		System.err.println("Erreur : " + e.getMessage());
		System.err.println("Code : " + e.getErrorCode());
		System.err.println("State : " + e.getSQLState());
	}
	}

	public static void supprimer(int id) throws Exception {
	
	try {
		myConn = connectionBD();
		myStmt = myConn.createStatement();
		String query = "delete from client where id ="+id;
		myStmt.executeUpdate(query);
		System.out.println("Client supprimé !");
	}
	catch (SQLException e) {
		System.err.println("Erreur : " + e.getMessage());
		System.err.println("Code : " + e.getErrorCode());
		System.err.println("State : " + e.getSQLState());
	}
	}
}
