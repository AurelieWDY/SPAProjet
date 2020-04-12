package database;

import java.sql.*;

public class AdoptionBD {

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
	
	ajouter(5, "29/03/2020");
	rechercher(5);
	modifier(5, "31/03/2020");
	supprimer(5);
	rechercher(5);
	
	try {
		myConn = connectionBD();
		myStmt = myConn.createStatement();
		myRs = myStmt.executeQuery("select * from adoption");
	while (myRs.next()) {
		System.out.println("Numéro ID : " + myRs.getInt("id") + " Date : " + myRs.getString("date"));
	}	
	}
	catch (SQLException e) {
		System.err.println("Erreur : " + e.getMessage());
		System.err.println("Code : " + e.getErrorCode());
		System.err.println("State : " + e.getSQLState());
	}
	}

	public static void ajouter(int id, String date) throws Exception {
	
	try {
		myConn = connectionBD();
		myStmt = myConn.createStatement();
		String query = "insert into adoption values("+id+", '"+date+"')";
		myStmt.executeUpdate(query);
		System.out.println("Nouvelle adoption ajoutée !");
	}
	catch (SQLException e) {
		System.err.println("Erreur : " + e.getMessage());
		System.err.println("Code : " + e.getErrorCode());
		System.err.println("State : " + e.getSQLState());
	}
	}

	public static void rechercher(int id) throws Exception {
	
	try {
		myConn = connectionBD();
		myStmt = myConn.createStatement();
		String query = "select * from adoption where id ="+id+"";
		myRs = myStmt.executeQuery(query);
		myRs.last();
		int nbrRow = myRs.getRow();
		if(nbrRow!= 0) {
			System.out.println("Adoption trouvée !");
		}
		else {
			System.out.println("Adoption non trouvée !");
		}
	}
	catch (SQLException e) {
		System.err.println("Erreur : " + e.getMessage());
		System.err.println("Code : " + e.getErrorCode());
		System.err.println("State : " + e.getSQLState());
	}
	}

	public static void modifier(int id, String date) throws Exception {
	
	try {
		myConn = connectionBD();
		myStmt = myConn.createStatement();
		String query = "update adoption set date = '"+date+"' where id = "+id;
		myStmt.executeUpdate(query);
		System.out.println("Adoption modifiée !");
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
		String query = "delete from adoption where id ="+id;
		myStmt.executeUpdate(query);
		System.out.println("Adoption supprimée !");
	}
	catch (SQLException e) {
		System.err.println("Erreur : " + e.getMessage());
		System.err.println("Code : " + e.getErrorCode());
		System.err.println("State : " + e.getSQLState());
	}
	}
}
