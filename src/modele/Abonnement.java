package modele;

import java.sql.*;
import java.time.*;
import java.time.format.*;

import connexion.Connexion;

public class Abonnement {
	
	//Supprimer Abonnement

	public void AbonnemSuppr(int id_abonnement) {
		try {
			Connexion c = new Connexion();
			Connection laConnexion = c.creeConnexion();
			PreparedStatement requete = 
			
			laConnexion.prepareStatement("delete from Abonnement where id_abonnement=?");
			requete.setInt(1, id_abonnement);
			int nbLignes = requete.executeUpdate();
			System.out.println("Update:" + nbLignes);

		if (requete != null)
			requete.close();
			
		if (laConnexion != null)
			laConnexion.close();
			
	} catch (SQLException sqle) {
			System.out.println("Pb dans select " + sqle.getMessage());
			}
	}
	
	//Ajout Abonnement
	
			public void AbonnemAjout(CharSequence date_debut, CharSequence date_fin, int id_client, int id_revue) {
				try {
					Connexion c = new Connexion();
					Connection laConnexion = c.creeConnexion();
					PreparedStatement requete = 
							
					laConnexion.prepareStatement("insert into Abonnement (date_debut, date_fin, id_client, id_revue) values(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
					
					DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDate dateDebut = LocalDate.parse(date_debut, formatage);
					LocalDate dateFin = LocalDate.parse(date_fin, formatage);
					Date datedeb = Date.valueOf((dateDebut));
					Date datefin = Date.valueOf((dateFin));
					
					requete.setDate(1, datedeb);
					requete.setDate(2, datefin);
					requete.setInt(3, id_client);
					requete.setInt(4, id_revue);
					int nbLignes = requete.executeUpdate();
					System.out.println("Update:" + nbLignes);
					ResultSet res = requete.getGeneratedKeys();
					if (res.next()) {
					int cle = res.getInt(1); 
					System.out.println("Cle:" + cle);
						}
				
				if (res != null)
					res.close();
					
				if (requete != null)
					requete.close();
					
				if (laConnexion != null)
					laConnexion.close();
					
			} catch (SQLException sqle) {
					System.out.println("Pb dans select " + sqle.getMessage());
					}
			}
			
			//Modifier Revue

			public void AbonnemModif(int id_abonnement, CharSequence date_debut, CharSequence date_fin, int id_client, int id_revue) {
				try {
					Connexion c = new Connexion();
					Connection laConnexion = c.creeConnexion();
					PreparedStatement requete = 
							
					laConnexion.prepareStatement("update Abonnement set date_debut =?, date_fin =?, id_client =?, id_revue =? where id_abonnement =?");
					
					DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDate dateDebut = LocalDate.parse(date_debut, formatage);
					LocalDate dateFin = LocalDate.parse(date_fin, formatage);
					Date datedeb = Date.valueOf((dateDebut));
					Date datefin = Date.valueOf((dateFin));
					
					requete.setDate(1, datedeb);
					requete.setDate(2, datefin);
					requete.setInt(3, id_client);
					requete.setInt(4, id_revue);
					requete.setInt(5, id_abonnement);
					
					int nbLignes = requete.executeUpdate();
					System.out.println("Update:" + nbLignes);
					
				if (requete != null)
					requete.close();
					
				if (laConnexion != null)
					laConnexion.close();
					
			} catch (SQLException sqle) {
					System.out.println("Pb dans select " + sqle.getMessage());
					}
			}
			

}
