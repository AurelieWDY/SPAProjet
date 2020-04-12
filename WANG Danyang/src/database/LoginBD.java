package database;

import java.sql.*;

public class LoginBD {

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
	
	ajouter(2, "wdy", "test");
	rechercher("wdy");
	modifier(2, "wdy", "test123");
	supprimer(2);
	rechercher("wdy");
	
	try {
		myConn = connectionBD();
		myStmt = myConn.createStatement();
		myRs = myStmt.executeQuery("select * from login");
	while (myRs.next()) {
		System.out.println("Numéro ID : " + myRs.getInt("id") + " Nom d'utilisateur : " + myRs.getString("username") + " Mot de passe : " + myRs.getString("password"));
	}	
	}
	catch (SQLException e) {
		System.err.println("Erreur : " + e.getMessage());
		System.err.println("Code : " + e.getErrorCode());
		System.err.println("State : " + e.getSQLState());
	}
	}

	public static void ajouter(int id, String username, String password) throws Exception {
	
	try {
		myConn = connectionBD();
		myStmt = myConn.createStatement();
		String query = "insert into login values("+id+", '"+username+"', '"+password+"')";
		myStmt.executeUpdate(query);
		System.out.println("Nouveau utilisateur ajouté !");
	}
	catch (SQLException e) {
		System.err.println("Erreur : " + e.getMessage());
		System.err.println("Code : " + e.getErrorCode());
		System.err.println("State : " + e.getSQLState());
	}
	}

	public static void rechercher(String username) throws Exception {
	
	try {
		myConn = connectionBD();
		myStmt = myConn.createStatement();
		String query = "select * from login where username ='"+username+"'";
		myRs = myStmt.executeQuery(query);
		myRs.last();
		int nbrRow = myRs.getRow();
		if(nbrRow!= 0) {
			System.out.println("Utilisateur trouvé !");
		}
		else {
			System.out.println("Utilisateur non trouvé !");
		}
	}
	catch (SQLException e) {
		System.err.println("Erreur : " + e.getMessage());
		System.err.println("Code : " + e.getErrorCode());
		System.err.println("State : " + e.getSQLState());
	}
	}

	public static void modifier(int id, String username, String password) throws Exception {
	
	try {
		myConn = connectionBD();
		myStmt = myConn.createStatement();
		String query = "update login set username = '"+username+"', password = '"+password+"' where id = "+id;
		myStmt.executeUpdate(query);
		System.out.println("Utilisateur modifié !");
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
		String query = "delete from login where id ="+id;
		myStmt.executeUpdate(query);
		System.out.println("Utilisateur supprimé !");
	}
	catch (SQLException e) {
		System.err.println("Erreur : " + e.getMessage());
		System.err.println("Code : " + e.getErrorCode());
		System.err.println("State : " + e.getSQLState());
	}
	}
}
