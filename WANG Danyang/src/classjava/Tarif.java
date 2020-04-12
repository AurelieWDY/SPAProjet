package classjava;

public class Tarif implements Adopter {
	
	public Tarif() {
		
	}
	
	public double adp(Chien adoptionchien) {
		System.out.println("Tarif Chien : ");
		return adoptionchien.getPrice();
	}

	public double adp(Chat adoptionchat) {
		System.out.println("Tarif Chat : ");
		return adoptionchat.getPrice();
	}

	public double adp(Lapin adoptionlapin) {
		System.out.println("Tarif Lapin : ");
		return adoptionlapin.getPrice();
	}
}

