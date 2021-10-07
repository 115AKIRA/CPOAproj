package dao.mysql;

import java.util.ArrayList;

import java.sql.*;
import java.time.format.DateTimeFormatter;

import connexion.Connexion;
import dao.AbonnementDAO;
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
				
				laConnexion.prepareStatement("insert into Abonnement (date_debut, date_fin, id_client, id_revue) values(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
				DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				requete.setDate(1, Date.valueOf(formatage.format(objet.getDate_debut())));
				requete.setDate(1, Date.valueOf(formatage.format(objet.getDate_fin())));
				requete.setInt(3, objet.getId_client());
				requete.setInt(4, objet.getId_revue());
				
				nbLigne = requete.executeUpdate();
				
				ResultSet res = requete.getGeneratedKeys();
				if ( res.next() ) {
					objet.setId_abonnement(res.getInt(1));
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
				
				laConnexion.prepareStatement("update Abonnement set date_debut =?, date_fin =?, id_client =?, id_revue =? where id_abonnement =?");
				DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				requete.setDate(1, Date.valueOf(formatage.format(objet.getDate_debut())));
				requete.setDate(1, Date.valueOf(formatage.format(objet.getDate_fin())));
				requete.setInt(3, objet.getId_client());
				requete.setInt(4, objet.getId_revue());
				requete.setInt(5, objet.getId_abonnement());
				
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
				
				laConnexion.prepareStatement("delete from Abonnement where id_abonnement=?");
				requete.setInt(1, objet.getId_abonnement());
				
				nbLigne = requete.executeUpdate();
				
		} catch (SQLException sqle) {
				System.out.println("Pb dans select " + sqle.getMessage());
				}
			
			return nbLigne != 0;
		}

		@Override
		public Abonnement getById(int id) {
			
			Abonnement a = null;
			
			try {
				Connexion c = new Connexion();
				Connection laConnexion = c.creeConnexion();
				PreparedStatement requete = 
				
				laConnexion.prepareStatement("select * from Abonnement where id_abonnement=?");
				requete.setInt(1, id);
				
				ResultSet resultSet = requete.executeQuery();

			if (resultSet.next()) {
				a = new Abonnement();
				a.setId_abonnement(resultSet.getInt("id_abonnement"));
				a.setDate_debut((resultSet.getDate("date_debut")).toLocalDate());
				a.setDate_fin((resultSet.getDate("date_fin")).toLocalDate());
				a.setId_client(resultSet.getInt("id_client"));
				a.setId_revue(resultSet.getInt("id_revue"));
			}
				
		} catch (SQLException sqle) {
				System.out.println("Pb dans select " + sqle.getMessage());
				}
			
			return a;
		}

		@Override
		public ArrayList<Abonnement> findAll() {
			
			ArrayList<Abonnement> aList = new ArrayList<Abonnement>();
			
			try {
				Connexion c = new Connexion();
				Connection laConnexion = c.creeConnexion();
				PreparedStatement requete = 
				
				laConnexion.prepareStatement("select * from Abonnement");
				
				ResultSet resultSet = requete.executeQuery();

			while(resultSet.next()) {
				aList.add(new Abonnement(resultSet.getInt("id_abonnement"),
						(resultSet.getDate("date_debut").toLocalDate()),
						(resultSet.getDate("date_fin").toLocalDate()),
						resultSet.getInt("id_client"),
						resultSet.getInt("id_revue")));
			}
				
		} catch (SQLException sqle) {
				System.out.println("Pb dans select " + sqle.getMessage());
				}
			
			return aList;
		}
}
	   