package classjava;

import database.RefugeAnimalierBD;

public class Refugeanimalier {
	private String Nom;
	private RefugeAnimalierBD rbd;
	public Animal[] animaux = new Animal[3];

	public Animal[] getanimaux() {
		if (this.animaux == null) {
			this.animaux = new Animal[3];
		}
		return this.animaux;
	}

	public void ajouterAnimal(Animal a, int i) {
		this.getanimaux()[i] = a;
	}
	
	public void afficherlisting() {
		System.out.println("Liste des animaux : " + "\n");
		for(int i = 0; i < this.animaux.length; i++) {
			if (this.getanimaux()[i]!=null){
			this.getanimaux()[i].afficherinfo();
			}
		}
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}
	
	public void setrbd(RefugeAnimalierBD r) {
		this.rbd = r;
	}

	public RefugeAnimalierBD getrbd() {
		return this.rbd;	
	}
}
