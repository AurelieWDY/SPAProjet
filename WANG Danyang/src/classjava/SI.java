package classjava;

public class SI {
	public static void main(String[] args) {
	
	System.out.println("Mon app fonctionne !" + "\n");
	
	Refugeanimalier r = new Refugeanimalier();
	Chien a = new Chien(2020001,"Luca","M�le",2);
	Chat b = new Chat(2020002,"Tina","Femelle",5);
	Lapin c = new Lapin(2020003,"L�o","M�le",3);
	
	r.setNom("SPA Annecy");
	r.getNom();
	System.out.println("Bienvenu � " + r.getNom() + "\n");
	
	r.ajouterAnimal(a, 0);
	r.ajouterAnimal(b, 1);
	r.ajouterAnimal(c, 2);
	r.afficherlisting();
	
	Adoption e,f,g;
	
	e = new Adoption();
	f = new Adoption();
	g = new Adoption();
	
	e.setDate("12/02/2020");
	f.setDate("15/03/2020");
	g.setDate("25/03/2020");
	
	Client h,i,j;
	
	h = new Client();
	i = new Client();
	j = new Client();
	
	h.setNomclient("Aur�lie");
	i.setNomclient("Lora");
	j.setNomclient("Victor");
	
	e.setclient(h);
	System.out.print("Nom de client qui a adopt� Luca est " + e.getclient().getNomclient() + " � " + e.getDate() + "\n");
	f.setclient(i);
	System.out.print("Nom de client qui a adopt� Tina est " + f.getclient().getNomclient() + " � " + f.getDate() + "\n");
	g.setclient(j);
	System.out.print("Nom de client qui a adopt� L�o est " + g.getclient().getNomclient() + " � " + g.getDate() + "\n" + "\n");
	
	System.out.println("Chien : " + a.getcrier() + "\n" + "Chat : " + b.getcrier() + "\n" + "Lapin : " + c.getcrier() + "\n");
	
	a.setcrier(new Aboiement());
	b.setcrier(new Miaulement());
	c.setcrier(new Crilapin());
	
	System.out.println("Chien : " + a.getcrier() + "\n" + "Chat : " + b.getcrier() + "\n" + "Lapin : " + c.getcrier() + "\n");
	
	Tarif t = new Tarif();
	a.setPrice(125);
	b.setPrice(90);
	c.setPrice(45);
	System.out.print(a.accept(t) + " �" + "\n");
	System.out.print(b.accept(t) + " �" + "\n");
	System.out.print(c.accept(t) + " �" + "\n");
	}
}
