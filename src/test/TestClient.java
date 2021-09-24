package test;

import modele.*;

public class TestClient {
	
	@SuppressWarnings("unused")
	public static void main (String[] args) {
	
	Periodicite p = new Periodicite();
	Revue r = new Revue();
	Client c = new Client();
	Abonnement a = new Abonnement();
	
	CharSequence datedeb = "26/07/2003";
	CharSequence datefin = "30/07/2003";
	
	a.AbonnemSuppr(1);

	}
	

}
