package menu;

import java.time.*;
import java.util.Scanner;

import com.sun.tools.javac.Main;

import dao.Persistance;
import dao.factory.DAOFactory;
import modele.Abonnement;

public class MenuAbonnement {
	
private static DAOFactory DAO = null;
	
	private static int idClient;
	private static LocalDate dateDebut;
	private static LocalDate dateFin;
	private static int idAbonnement;
	private static int idRevue;
	
	
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
	
	public static LocalDate creerDate() throws Exception {
		
		LocalDate d = null;
		
		Scanner entree = new Scanner(System.in);
		
		System.out.println("jour :");
		int jour = entree.nextInt();
		System.out.println("mois :");
		int mois = entree.nextInt();
		System.out.println("annee :");
		int annee = entree.nextInt();
		
		entree.close();
		
		try {
			d = LocalDate.of(jour, mois, annee);
		} catch ( DateTimeException iae ) {
			System.out.println("Date incorrecte");
			System.out.println("Retour au menu :");
			main(null);
		}
		
		return d;
		
	}

	public static void main(String[] args) throws Exception {


		Scanner entree = new Scanner(System.in);
		
		choixPersistance();
		
		System.out.println("Que voulez vous faire ? :");
		System.out.println("1) Créer un abonnement");
		System.out.println("2) Modifier un abonnement");
		System.out.println("3) Supprimer un abonnement");
		System.out.println("4) Retour au menu");
		
		int choix = entree.nextInt();
		
		try {
		
		switch (choix) {
		
		case(1) :
			System.out.println("Veuillez saisir la date de debut: ");
			dateDebut = creerDate();
			System.out.println("Veuillez saisir la date de fin : ");
			dateFin = creerDate();
			System.out.println("Veuillez saisir l'id de periodicite : ");
			idRevue = entree.nextInt();
			System.out.println("Veuillez saisir l'id du client : ");
			idClient = entree.nextInt();
			
			try {
				Abonnement c = new Abonnement(dateDebut, dateFin, idRevue, idClient);
				DAO.getAbonnementDAO().create(c);
			} catch( Exception iae) {
				System.out.println("Erreur lors de la création - retour au menu !");
				main(args);
			}
			break;
		case(2) :
			System.out.println("Veuillez saisir l'id d'abonnement : ");
			idAbonnement = entree.nextInt();
			System.out.println("Veuillez saisir la date de debut: ");
			dateDebut = creerDate();
			System.out.println("Veuillez saisir la date de fin : ");
			dateFin = creerDate();
			System.out.println("Veuillez saisir l'id de periodicite : ");
			idRevue = entree.nextInt();
			System.out.println("Veuillez saisir l'id du client : ");
			idClient = entree.nextInt();
		
			try {
				Abonnement u = new Abonnement(idAbonnement, dateDebut, dateFin, idRevue, idClient);
				DAO.getAbonnementDAO().update(u);
			} catch( Exception iae) {
				System.out.println("Erreur lors de la modification - retour au menu !");
				main(args);
			}
			break;
		case(3) :
			System.out.println("Veuillez saisir l'id d'abonnement : ");
			idRevue = entree.nextInt();
			
			Abonnement d = new Abonnement(idAbonnement);
			DAO.getAbonnementDAO().delete(d);
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
