package menu;

//import modele.*;

import dao.factory.*;
import java.util.*;

import dao.*;

public class Menu {
	
	@SuppressWarnings("unused")
	public static void main (String[] args) {
		
		Scanner entree = new Scanner(System.in);
	
		/* test 1
		  
		  Periodicite p = new Periodicite(); Revue r = new Revue(); Client c = new
		  Client(); Abonnement a = new Abonnement();
		  
		  CharSequence datedeb = "26/07/2003"; CharSequence datefin = "30/07/2003";
		  
		  a.AbonnemSuppr(1);
		 */
	
	System.out.println("Bienvenue bla bla que voulez vous faire ?");
	System.out.println("1) Abonnement");
	System.out.println("2) Client");
	System.out.println("3) Periodicite");
	System.out.println("4) Revue");
	System.out.println("5) Quitter");
	
	int choix = entree.nextInt();
	
	try {
		switch (choix) {
			case(1):
				
			case(2):
				MenuClient.main(args);
			case(3):
				
			case(4):
				
			case(5):
				
			}
		} catch(NumberFormatException iae ) {
			System.out.println("Veuillez faire un choix valide.");
			main(args);
		
	}
	
	
		entree.close();
		
	}

	

}
