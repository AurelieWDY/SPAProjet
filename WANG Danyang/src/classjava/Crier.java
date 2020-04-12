package classjava;

public interface Crier {
	
	String crier();
}

class AnimalCrie implements Crier{

	public String crier() {
		
		return "on peut crier";
	}
}

class AnimalNeCriePas implements Crier{

	public String crier() {
			
		return "on ne peut pas crier en général";
	}
}

class Aboiement implements Crier{

	public String crier() {
		
		return "on aboie";
	}
}

class Miaulement implements Crier{

	public String crier() {
		
		return "on miaule";
	}
}

class Crilapin implements Crier{

	public String crier() {
		
		return "on clapit si nécessaire";
	}
}
