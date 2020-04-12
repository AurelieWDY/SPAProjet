package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AnimalBD {

	public static Connection myConn;
	public static Statement myStmt;
	public static ResultSet myRs;
	
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
	
	ajouter(2020010, "Zoé", 10, "Femelle", "Chien", 0);
	rechercher("Zoé");
	modifier(2020010, "Zoé", 9, "Femelle", "Chien", 125);
	supprimer(2020010);
	rechercher("Zoé");
	
	try {
		myConn = connectionBD();
		myStmt = myConn.createStatement();
		myRs = myStmt.executeQuery("select * from animal");
	while (myRs.next()) {
		System.out.println("Numéro ID : " + myRs.getInt("id") + " Nom : " + myRs.getString("nom") + " Age : " + myRs.getInt("age") + " Sexe : " + myRs.getString("sexe") + " Race : " + myRs.getString("race") + " Prix : " + myRs.getInt("prix"));
	}	
	}
	catch (SQLException e) {
		System.err.println("Erreur : " + e.getMessage());
		System.err.println("Code : " + e.getErrorCode());
		System.err.println("State : " + e.getSQLState());
	}
	}

	public static void ajouter(int id, String nom, int age, String sexe, String race, int prix) throws Exception {
	
	try {
		myConn = connectionBD();
		myStmt = myConn.createStatement();
		String query = "insert into animal values("+id+", '"+nom+"', "+age+", '"+sexe+"', '"+race+"', "+prix+")";
		myStmt.executeUpdate(query);
		System.out.println("Nouveau animal ajouté !");
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
		String query = "select * from animal where nom ='"+nom+"'";
		myRs = myStmt.executeQuery(query);
		myRs.last();
		int nbrRow = myRs.getRow();
		if(nbrRow!= 0) {
			System.out.println("Animal trouvé !");
		}
		else {
			System.out.println("Animal non trouvé !");
		}
	}
	catch (SQLException e) {
		System.err.println("Erreur : " + e.getMessage());
		System.err.println("Code : " + e.getErrorCode());
		System.err.println("State : " + e.getSQLState());
	}
	}

	public static void modifier(int id, String nom, int age, String sexe, String race, int prix) throws Exception {
	
	try {
		myConn = connectionBD();
		myStmt = myConn.createStatement();
		String query = "update animal set nom = '"+nom+"', age = "+age+", sexe = '"+sexe+"', race = '"+race+"', prix = "+prix+" where id = "+id;
		myStmt.executeUpdate(query);
		System.out.println("Animal modifié !");
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
		String query = "delete from animal where id ="+id;
		myStmt.executeUpdate(query);
		System.out.println("Animal supprimé !");
	}
	catch (SQLException e) {
		System.err.println("Erreur : " + e.getMessage());
		System.err.println("Code : " + e.getErrorCode());
		System.err.println("State : " + e.getSQLState());
	}
	}
}
