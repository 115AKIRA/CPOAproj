package modele;

import java.sql.*;

public class Revue {
	
	//Supprimer Revue

		public void RevueSuppr(int id_revue) {
			try {
				Connexion c = new Connexion();
				Connection laConnexion = c.creeConnexion();
				PreparedStatement requete = 
				
				laConnexion.prepareStatement("delete from Revue where id_revue=?");
				requete.setInt(1, id_revue);
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

		//Ajout Revue
		
		public void RevueAjout(String titre, String desc, float tarif_num, String visuel, int id_periodicite) {
			try {
				Connexion c = new Connexion();
				Connection laConnexion = c.creeConnexion();
				PreparedStatement requete = 
						
				laConnexion.prepareStatement("insert into Revue (titre, description, tarif_numero, visuel, id_periodicite) values(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
				requete.setString(1, titre);
				requete.setString(2, desc);
				requete.setFloat(3, tarif_num);
				requete.setString(4, visuel);
				requete.setInt(5, id_periodicite);
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

		public void RevueModif(int id_revue, String titre, String desc, float tarif_num, String visuel, int id_periodicite) {
			try {
				Connexion c = new Connexion();
				Connection laConnexion = c.creeConnexion();
				PreparedStatement requete = 
						
				laConnexion.prepareStatement("update Revue set titre =?, description =?, tarif_numero =?, visuel =?, id_periodicite =? where id_revue =?");
				requete.setString(1, titre);
				requete.setString(2, desc);
				requete.setFloat(3, tarif_num);
				requete.setString(4, visuel);
				requete.setInt(5, id_periodicite);
				requete.setInt(6, id_revue);
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
