package classjava;

import database.AnimalBD;

public class Animal {
	
	private String Nom, Sexe;
	private int Age,NumID;
	private Adoption adoption;
	private AnimalBD abd;
	
	public Crier typecri;
	
	public Animal(int id, String n, String s, int a) {
		this.NumID = id;
		this.Nom = n;
		this.Sexe = s;
		this.Age = a;
	}

	public void afficherinfo () {
		System.out.println("ID : " + this.NumID + " Nom : " + this.Nom + " Sexe : " + this.Sexe + " Age : " + this.Age + "\n");
	}
	
	public void setadoption(Adoption a) {
		this.adoption = a;
	}

	public Adoption getadoption() {
		return this.adoption;	
	}
	
	public String getcrier() {
		return typecri.crier();
	}
	
	public void setcrier(Crier newtypecri) {
		typecri = newtypecri;
	}
	
	public void setabd(AnimalBD a) {
		this.abd = a;
	}
	
	public AnimalBD getabd() {
		return this.abd;	
	}
}