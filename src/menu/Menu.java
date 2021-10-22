package menu;

import java.util.*;

public class Menu {

	public static void main (String[] args) throws Exception {
		
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
				MenuAbonnement.main(args);
				break;
			case(2):
				MenuClient.main(args);
				break;
			case(3):
				MenuPeriodicite.main(args);
				break;
			case(4):
				MenuRevue.main(args);
				break;
			case(5):
				System.exit(0);
				
			}
		} catch(NumberFormatException iae ) {
			System.out.println("Veuillez faire un choix valide.");
			main(args);
	}
		entree.close();	
	}
}
