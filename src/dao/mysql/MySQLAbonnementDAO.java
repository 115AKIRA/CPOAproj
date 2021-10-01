package dao.mysql;

import java.util.ArrayList;

import java.sql.*;
import connexion.Connexion;
import dao.AbonnementDAO;
import modele.Abonnement;
import modele.Abonnement;


public class MySQLAbonnementDAO implements AbonnementDAO{

	 private static MySQLAbonnementDAO instance;

	  


	    public static MySQLAbonnementDAO getInstance() {

	        if (instance == null) {
	            instance = new MySQLAbonnementDAO();
	        }

	        return instance;
	    }
	    
	    private MySQLAbonnementDAO() {}

	    @Override
		public boolean create(Abonnement objet) {
			
			int nbLigne = 0; 
			
			try {
				Connexion c = new Connexion();
				Connection laConnexion = c.creeConnexion();
				PreparedStatement requete = 
				
				laConnexion.prepareStatement("insert into Abonnement (date_debut) values(?)", Statement.RETURN_GENERATED_KEYS);
				requete.setString(1, objet.get());
				
				nbLigne = requete.executeUpdate();
				
				ResultSet res = requete.getGeneratedKeys();
				if ( res.next() ) {
					objet.setId_revue(res.getInt(1));
				}
				
		} catch (SQLException sqle) {
				System.out.println("Pb dans select " + sqle.getMessage());
				}
			
			return nbLigne != 0;
		}

		@Override
		public boolean update(Abonnement objet) {
			
			int nbLigne = 0; 
			
			try {
				Connexion c = new Connexion();
				Connection laConnexion = c.creeConnexion();
				PreparedStatement requete = 
				
				laConnexion.prepareStatement("update Abonnement set Titre =? where id_revue =?");
				requete.setString(1, objet.getTitre());
				requete.setInt(2, objet.getId_revue());
				
				nbLigne = requete.executeUpdate();
				
		} catch (SQLException sqle) {
				System.out.println("Pb dans select " + sqle.getMessage());
				}
			
			return nbLigne != 0;
		}

		@Override
		public boolean delete(Abonnement objet) {
			
			int nbLigne = 0; 
			
			try {
				Connexion c = new Connexion();
				Connection laConnexion = c.creeConnexion();
				PreparedStatement requete = 
				
				laConnexion.prepareStatement("delete from Abonnement where id_revue=?");
				requete.setInt(1, objet.getId_periodicite());
				
				nbLigne = requete.executeUpdate();
				
		} catch (SQLException sqle) {
				System.out.println("Pb dans select " + sqle.getMessage());
				}
			
			return nbLigne != 0;
		}

		@Override
		public Abonnement getById(int id) {
			
			Abonnement r = null;
			
			try {
				Connexion c = new Connexion();
				Connection laConnexion = c.creeConnexion();
				PreparedStatement requete = 
				
				laConnexion.prepareStatement("select * from Abonnement where id_revue=?");
				requete.setInt(1, id);
				
				ResultSet resultSet = requete.executeQuery();

			if (resultSet.next()) {
				r = new Abonnement();
				r.setId_revue(resultSet.getInt("id_revue"));
				r.setTitre(resultSet.getString("titre"));
				r.setDescription(resultSet.getString("description"));
				r.setTarif_numero(resultSet.getFloat("tarif_numero"));
				r.setVisuel(resultSet.getString("visuel"));
				r.setId_periodicite(resultSet.getInt("id_periodicite"));
			}
				
		} catch (SQLException sqle) {
				System.out.println("Pb dans select " + sqle.getMessage());
				}
			
			return r;
		}

		@Override
		public ArrayList<Abonnement> findAll() {
			
			ArrayList<Abonnement> rList = new ArrayList<Abonnement>();
			
			try {
				Connexion c = new Connexion();
				Connection laConnexion = c.creeConnexion();
				PreparedStatement requete = 
				
				laConnexion.prepareStatement("select * from Abonnement");
				
				ResultSet resultSet = requete.executeQuery();

			while(resultSet.next()) {
				rList.add(new Abonnement(resultSet.getInt("id_revue")
						,resultSet.getString("titre"),resultSet.getString("description"),resultSet.getFloat("tarif_numero"),resultSet.getString("visuel"),resultSet.getInt("id_periodicite")));
			}
				
		} catch (SQLException sqle) {
				System.out.println("Pb dans select " + sqle.getMessage());
				}
			
			return rList;
			
		}
}
	   