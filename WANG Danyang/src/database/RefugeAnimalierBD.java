package database;

import java.sql.*;

public class RefugeAnimalierBD {

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
	
	ajouter(190081679, "SPA Sillingy", "1240 rte de Clermont", "Sillingy", 74330, 450687053, "Du Lundi au Samedi de 14h à 18h");
	rechercher("SPA Sillingy");
	modifier(190081679, "SPA Sillingy", "1240 rte de Clermont", "Sillingy", 74330, 450687053, "Du Lundi au Samedi de 14h30 à 18h30");
	supprimer(190081679);
	rechercher("SPA Sillingy");
	
	try {
		myConn = connectionBD();
		myStmt = myConn.createStatement();
		myRs = myStmt.executeQuery("select * from refugeanimalier");
	while (myRs.next()) {
		System.out.println("Numéro ID : " + myRs.getInt("id") + " Nom : " + myRs.getString("nom") + " Adresse : " + myRs.getString("adresse") + " Ville : " + myRs.getString("ville") + " Code postal : " + myRs.getInt("code_postal") + " Contact : " + myRs.getInt("contact") + " Horaire d'ouverture : " + myRs.getString("ouverture"));
	}
	}
	catch (SQLException e) {
		System.err.println("Erreur : " + e.getMessage());
		System.err.println("Code : " + e.getErrorCode());
		System.err.println("State : " + e.getSQLState());
	}
	}

	public static void ajouter(int id, String nom, String adresse, String ville, int code_postal, int contact, String ouverture) throws Exception {
	
	try {
		myConn = connectionBD();
		myStmt = myConn.createStatement();
		String query = "insert into refugeanimalier values("+id+", '"+nom+"', '"+adresse+"', '"+ville+"', "+code_postal+", "+contact+", '"+ouverture+"')";
		myStmt.executeUpdate(query);
		System.out.println("Nouveau refuge ajouté !");
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
		String query = "select * from refugeanimalier where nom ='"+nom+"'";
		myRs = myStmt.executeQuery(query);
		myRs.last();
		int nbrRow = myRs.getRow();
		if(nbrRow!= 0) {
			System.out.println("Refuge trouvé !");
		}
		else {
			System.out.println("Refuge non trouvé !");
		}
	}
	catch (SQLException e) {
		System.err.println("Erreur : " + e.getMessage());
		System.err.println("Code : " + e.getErrorCode());
		System.err.println("State : " + e.getSQLState());
	}
	}

	public static void modifier(int id, String nom, String adresse, String ville, int code_postal, int contact, String ouverture) throws Exception {
	
	try {
		myConn = connectionBD();
		myStmt = myConn.createStatement();
		String query = "update refugeanimalier set nom = '"+nom+"', adresse = '"+adresse+"', ville = '"+ville+"', code_postal = "+code_postal+", contact = "+contact+", ouverture = '"+ouverture+"' where id = "+id;
		myStmt.executeUpdate(query);
		System.out.println("Refuge modifié !");
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
		String query = "delete from refugeanimalier where id ="+id;
		myStmt.executeUpdate(query);
		System.out.println("Refuge supprimé !");
	}
	catch (SQLException e) {
		System.err.println("Erreur : " + e.getMessage());
		System.err.println("Code : " + e.getErrorCode());
		System.err.println("State : " + e.getSQLState());
	}
	}
}
