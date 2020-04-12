package classjava;

import database.ClientBD;

public class Client {
	private String Nomclient;
	private ClientBD cbd;

	public void setNomclient(String nc) {
		this.Nomclient = nc;
	}

	public String getNomclient() {
		return this.Nomclient;
	}
	
	public void setcbd(ClientBD c) {
		this.cbd = c;
	}

	public ClientBD getcbd() {
		return this.cbd;	
	}
}
