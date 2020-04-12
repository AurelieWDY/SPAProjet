package classjava;

import database.AdoptionBD;

public class Adoption {
	private String Date;
	private Client client;
	private AdoptionBD abd;
	
	//private static double[] tarif = new double [3];
	
	//public static void setTarif (double[] t) {
	//	Adoption.tarif = t;
	//}
	
	//public static double[] getTarif() {
	//	return Adoption.tarif;
	//}

	public void setDate(String d) {
		this.Date = d;
	}

	public String getDate() {
		return this.Date;
	}

	public void setclient(Client c) {
		this.client = c;
	}

	public Client getclient() {
		return this.client;	
	}
	
	public void setabd(AdoptionBD a) {
		this.abd = a;
	}
	
	public AdoptionBD getabd() {
		return this.abd;	
	}
}
