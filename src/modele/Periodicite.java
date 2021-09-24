package pojo;

import java.sql.*;

public class Periodicite {
	
	//Supprimer Periodicite

	public void PeriodSuppr(int id_periodicite) {
		try {
			Connexion c = new Connexion();
			Connection laConnexion = c.creeConnexion();
			PreparedStatement requete = 
			
			laConnexion.prepareStatement("delete from Periodicite where id_periodicite=?");
			requete.setInt(1, id_periodicite);
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

	//Ajout Periodicite
	
	public void PeriodAjout(String libelle) {
		try {
			Connexion c = new Connexion();
			Connection laConnexion = c.creeConnexion();
			PreparedStatement requete = 
					
			laConnexion.prepareStatement("insert into Periodicite (libelle) values(?)", Statement.RETURN_GENERATED_KEYS);
			requete.setString(1, libelle);
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
	
	//Modifier Periodicite

	public void PeriodModif(int id_periodicite, String libelle) {
		try {
			Connexion c = new Connexion();
			Connection laConnexion = c.creeConnexion();
			PreparedStatement requete = 
					
			laConnexion.prepareStatement("update Periodicite set libelle =? where id_periodicite =?");
			requete.setString(1, libelle);
			requete.setInt(2, id_periodicite);
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
