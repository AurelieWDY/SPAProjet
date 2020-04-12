package testjunit;


import static org.junit.Assert.*;

public class Main {

@org.junit.Test

	public void testnbranimal1() {
	
		assertEquals(10, Exemple.nbrAnimal(10));
	}

@org.junit.Test

public void testnbranimal2() {

	assertEquals(9, Exemple.nbrAnimal(9));
}

@org.junit.BeforeClass

	public static void testBefore1() {
	
		System.out.println("Avant Class");
	}

@org.junit.Before

public void testBefore2() {

	System.out.println("Avant...");
}

@org.junit.After

	public void testAfter1() {
	
		System.out.println("Après...");
	}

@org.junit.AfterClass

public static void testAfter2() {

	System.out.println("Après Class");
}
}
