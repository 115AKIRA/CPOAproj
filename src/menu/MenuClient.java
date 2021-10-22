package menu;

import java.util.Scanner;

import dao.Persistance;
import dao.factory.DAOFactory;
import modele.Client;

public class MenuClient {
	
	public static DAOFactory DAO = null;
	
	private int idClient;
	private String nom;
	private String prenom;
	private String noRue ;
	private String voie ;
	private String codePostal ;
	private String ville ;
	private String pays ; 
	
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
		choixPersistance();
		
		}
	}

	public static void main(String[] args) {
		
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
			String nom = entree.next();
			System.out.println("Veuillez saisir le prenom : ");
			String prenom = entree.next();
			System.out.println("Veuillez saisir le nom de rue : ");
			String rue = entree.next();
			System.out.println("Veuillez saisir la voie : ");
			String voie = entree.next();
			System.out.println("Veuillez saisir le code postal : ");
			String code = entree.next();
			System.out.println("Veuillez saisir la ville : ");
			String ville = entree.next();
			System.out.println("Veuillez saisir le pays : ");
			String pays = entree.next();
			
			Client c = new Client(nom, prenom, rue, voie, code, ville, pays);
			DAO.getClientDAO().create(c);
			
			break;
		case(2) :
			DAO = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE);
			break;
		case(3) :
			break;
		case(4) :
			break;
	}
		} catch(NumberFormatException iae) {
			System.out.println("Veuillez faire un choix valide.");
			main(args);
		}
		
	
	}
	
}

	