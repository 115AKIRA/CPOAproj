package menu;

import dao.factory.DAOFactory;
import modele.Periodicite;

import java.util.Scanner;

import com.sun.tools.javac.Main;

import dao.Persistance;

public class MenuPeriodicite {
	
	private static DAOFactory DAO = null;
	
	private static int idPeriodicite;
	private static String libelle;
	
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
		System.out.println("1) Créer une periodicite");
		System.out.println("2) Modifier une periodicite");
		System.out.println("3) Supprimer une perodicite");
		System.out.println("4) Retour au menu");
		
		int choix = entree.nextInt();
		
		try {
		
		switch (choix) {
		
		case(1) :
			System.out.println("Veuillez saisir le libelle : ");
			libelle = entree.next();
			
			Periodicite c = new Periodicite(libelle);
			DAO.getPeriodiciteDAO().create(c);
			
			
			break;
		case(2) :
			System.out.println("Veuillez saisir l'id de periodicite : ");
			idPeriodicite = entree.nextInt();
			System.out.println("Veuillez saisir le libelle : ");
			libelle = entree.next();
		
			Periodicite u = new Periodicite(idPeriodicite, libelle);
			DAO.getPeriodiciteDAO().update(u);
			break;
		case(3) :
			System.out.println("Veuillez saisir l'id de periodicite : ");
			idPeriodicite = entree.nextInt();
			
			Periodicite d = new Periodicite(idPeriodicite);
		
			DAO.getPeriodiciteDAO().delete(d);
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
