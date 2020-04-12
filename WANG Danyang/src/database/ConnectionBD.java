package database;

import java.sql.*;

public class ConnectionBD {
	
	public static void main(String[] args) throws Exception{
		
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3308/spa_database?useUnicode=true" + 
			"&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&" + 
			"serverTimezone=UTC";
	String user = "WDY";
	String password = "Aurelie2020*";
	Class.forName(driver);
		
	try {
		Connection myConn = DriverManager.getConnection(url, user, password);
		if(myConn != null) {	
			System.out.println("La base de données connectée !");
		}
	}
	catch (SQLException e) {
		System.err.println("Erreur : " + e.getMessage());
		System.err.println("Code : " + e.getErrorCode());
		System.err.println("State : " + e.getSQLState());
		}
  }
}
