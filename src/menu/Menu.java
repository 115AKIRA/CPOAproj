package menu;

import modele.*;

import dao.factory.*;

import dao.*;

public class Menu {
	
	@SuppressWarnings("unused")
	public static void main (String[] args) {
		java.util.Scanner entree =   new java.util.Scanner(System.in);
	
		/* test 1
		 * 
		 * Periodicite p = new Periodicite(); Revue r = new Revue(); Client c = new
		 * Client(); Abonnement a = new Abonnement();
		 * 
		 * CharSequence datedeb = "26/07/2003"; CharSequence datefin = "30/07/2003";
		 * 
		 * a.AbonnemSuppr(1);
		 */
	
	MySQLDAOFactory Sql = new MySQLDAOFactory();
	ListeMemoireDAOFactory Listememoire = new ListeMemoireDAOFactory();
	
	System.out.println("Veuillez chosir votre type de sauvegarde : 1) Liste memoire ; 2) MySQL");
	
	int choix = entree.nextInt();
	
	switch (choix) {
		case(1):
			DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE);
		case(2):
			DAOFactory.getDAOFactory(Persistance.MYSQL);
	}
	
	
		
	}

	

}
