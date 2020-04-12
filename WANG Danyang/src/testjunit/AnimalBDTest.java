package testjunit;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import database.AnimalBD;
import java.sql.*;
import static database.AnimalBD.myStmt;
import static database.AnimalBD.myConn;
import static database.AnimalBD.myRs;
import static database.AnimalBD.connectionBD;

public class AnimalBDTest {
	
	@Test
	public void testConnectionBD() throws Exception{
		
		System.out.println("Connexion réussie");
		Connection result = AnimalBD.connectionBD();
		assertEquals(result != null, true);
	}
	
	@Test
	public void testAfficher() throws Exception{
		
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
	
	@Test
	public void testAjouter() throws Exception{
		
		try {
			myConn = connectionBD();
			myStmt = myConn.createStatement();
			String query = "insert into animal values('2020010', 'Zoé', '10', 'Femelle', 'Chien', '0')";
			int myRs = myStmt.executeUpdate(query);
			if(myRs > 0) {
				System.out.println("Ajout réussi ");
			}
			else {
				System.out.println("Ajout non réussi");
			}
		}
		catch (SQLException e) {
				System.err.println("Erreur : " + e.getMessage());
				System.err.println("Code : " + e.getErrorCode());
				System.err.println("State : " + e.getSQLState());
		}
	}

	@Test
	public void testRechercher() throws Exception{
		
		try {
			myConn = connectionBD();
			myStmt = myConn.createStatement();
			String query = "select * from animal where nom = 'Luca'";
			ResultSet myRs = myStmt.executeQuery(query);
			myRs.last();
			int nbrRow = myRs.getRow();
			if(nbrRow!= 0) {
				System.out.println("Recherche réussie");
			}
			else {
				System.out.println("Recherche non réussie");
			}
		}
		catch (SQLException e) {
			System.err.println("Erreur : " + e.getMessage());
			System.err.println("Code : " + e.getErrorCode());
			System.err.println("State : " + e.getSQLState());
		}
	}
	
	@Test
	public void testModifier() throws Exception{
		
		try {
			myConn = connectionBD();
			myStmt = myConn.createStatement();
			String query = "update animal set nom = 'Zoé', age = '9', sexe = 'Femelle', race = 'Chien', prix = '125' where id = '2020010'";
			int myRs = myStmt.executeUpdate(query);
			if(myRs > 0) {
				System.out.println("Modification réussie ");
			}
			else {
				System.out.println("Modification non réussie");
			}
		}
		catch (SQLException e) {
				System.err.println("Erreur : " + e.getMessage());
				System.err.println("Code : " + e.getErrorCode());
				System.err.println("State : " + e.getSQLState());
		}
	}
	
	@Test
	public void testSupprimer() throws Exception{
		
		try {
			myConn = connectionBD();
			myStmt = myConn.createStatement();
			String query = "delete from animal where id = '2020010'";
			int myRs = myStmt.executeUpdate(query);
			if(myRs > 0) {
				System.out.println("Suppression réussie ");
			}
			else {
				System.out.println("Suppression non réussie");
			}
		}
		catch (SQLException e) {
				System.err.println("Erreur : " + e.getMessage());
				System.err.println("Code : " + e.getErrorCode());
				System.err.println("State : " + e.getSQLState());
		}
	}
}