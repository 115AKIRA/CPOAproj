package menu;

import java.util.Scanner;

import com.sun.tools.javac.Main;

import dao.Persistance;
import dao.factory.DAOFactory;
import modele.Client;

public class MenuClient {
	
	private static DAOFactory DAO = null;
	
	private static int idClient;
	private static String nom;
	private static String prenom;
	private static String noRue ;
	private static String voie ;
	private static String codePostal ;
	private static String ville ;
	private static String pays ; 
	
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
		System.out.println("1) Créer un client");
		System.out.println("2) Modifier un client");
		System.out.println("3) Supprimer un client");
		System.out.println("4) Retour au menu");
		
		int choix = entree.nextInt();
		
		try {
		
		switch (choix) {
		
		case(1) :
			System.out.println("Veuillez saisir le nom : ");
			nom = entree.next();
			System.out.println("Veuillez saisir le prenom : ");
			prenom = entree.next();
			System.out.println("Veuillez saisir le nom de rue : ");
			noRue = entree.next();
			System.out.println("Veuillez saisir la voie : ");
			voie = entree.next();
			System.out.println("Veuillez saisir le code postal : ");
			codePostal = entree.next();
			System.out.println("Veuillez saisir la ville : ");
			ville = entree.next();
			System.out.println("Veuillez saisir le pays : ");
			pays = entree.next();
			
			Client c = new Client(nom, prenom, noRue, voie, codePostal, ville, pays);
			DAO.getClientDAO().create(c);
			
			break;
		case(2) :
			System.out.println("Veuillez saisir l'id du client : ");
			idClient = entree.nextInt();
			System.out.println("Veuillez saisir le nom : ");
			nom = entree.next();
			System.out.println("Veuillez saisir le prenom : ");
			prenom = entree.next();
			System.out.println("Veuillez saisir le nom de rue : ");
			noRue = entree.next();
			System.out.println("Veuillez saisir la voie : ");
			voie = entree.next();
			System.out.println("Veuillez saisir le code postal : ");
			codePostal = entree.next();
			System.out.println("Veuillez saisir la ville : ");
			ville = entree.next();
			System.out.println("Veuillez saisir le pays : ");
			pays = entree.next();
		
			Client u = new Client(idClient, nom, prenom, noRue, voie, codePostal, ville, pays);
			DAO.getClientDAO().update(u);
			break;
		case(3) :
			System.out.println("Veuillez saisir l'id du client : ");
			idClient = entree.nextInt();
			
			Client d = new Client(idClient);
		
			DAO.getClientDAO().delete(d);
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

	