package menu;

import java.util.Scanner;

import com.sun.tools.javac.Main;

import dao.Persistance;
import dao.factory.DAOFactory;
import modele.Revue;

public class MenuRevue {
	
private static DAOFactory DAO = null;
	
	private static int idRevue;
	private static String titre;
	private static String description;
	private static float tarifNumero;
	private static String visuel;
	private static int idPeriodicite;
	
	public static void choixPersistance() {
		
		Scanner entree = new Scanner(System.in);
		
		System.out.println("Selectionnez votre choix de persistance :");
		System.out.println("1) MySQL");
		System.out.println("2) Liste Memoire");
		
		int choix = entree.nextInt();
		
		
		try {
		
		switch (choix) {
		
			case(1) :
				DAO = DAOFactory.getDAOFactory(Persistance.MYSQL);
				break;
			case(2) :
				DAO = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE);
			break;
		}
		
	} catch(NumberFormatException iae) {
		System.out.println("Veuillez faire un choix valide.");
		entree.close();
		choixPersistance();
		
		}
	}

	public static void main(String[] args) throws Exception {
		
		Scanner entree = new Scanner(System.in);
		
		choixPersistance();
		
		System.out.println("Que voulez vous faire ? :");
		System.out.println("1) Créer une revue");
		System.out.println("2) Modifier une revue");
		System.out.println("3) Supprimer une revue");
		System.out.println("4) Retour au menu");
		
		int choix = entree.nextInt();
		
		try {
		
		switch (choix) {
		
		case(1) :
			System.out.println("Veuillez saisir le titre : ");
			titre = entree.next();
			System.out.println("Veuillez saisir la description : ");
			description = entree.next();
			System.out.println("Veuillez saisir le tarif : ");
			tarifNumero = entree.nextFloat();
			System.out.println("Veuillez saisir le visuel : ");
			visuel = entree.next();
			System.out.println("Veuillez saisir l'id de periodicite : ");
			idPeriodicite = entree.nextInt();
			
			Revue c = new Revue(titre, description, tarifNumero, visuel, idPeriodicite);
			DAO.getRevueDAO().create(c);
			break;
		case(2) :
			System.out.println("Veuillez saisir l'id de revue : ");
			idRevue = entree.nextInt();
			System.out.println("Veuillez saisir le titre : ");
			titre = entree.next();
			System.out.println("Veuillez saisir la description : ");
			description = entree.next();
			System.out.println("Veuillez saisir le tarif : ");
			tarifNumero = entree.nextFloat();
			System.out.println("Veuillez saisir le visuel : ");
			visuel = entree.next();
			System.out.println("Veuillez saisir l'id de periodicite : ");
			idPeriodicite = entree.nextInt();
		
			Revue u = new Revue(idRevue, titre, description, tarifNumero, visuel, idPeriodicite);
			DAO.getRevueDAO().update(u);
			break;
		case(3) :
			System.out.println("Veuillez saisir l'id de revue : ");
			idRevue = entree.nextInt();
			
			Revue d = new Revue(idRevue);
		
			DAO.getRevueDAO().delete(d);
			break;
		case(4) :
			Main.main(args);
			break;
	}
		entree.close();
		
		} catch(NumberFormatException iae) {
			System.out.println("Veuillez faire un choix valide.");
			main(args);
		}
		

	}

}
