package classjava;

public class Chat extends Animal implements Adoptable {

	public Chat(int id, String n, String s, int a) {
		super(id, n, s, a);
		
		typecri = new AnimalCrie();
	}

	private double price;
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double accept(Adopter adopter) {
		
		return adopter.adp(this);
	}
}
