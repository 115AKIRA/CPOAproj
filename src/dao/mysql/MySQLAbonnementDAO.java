package dao.mysql;

import java.util.ArrayList;

import java.sql.*;
import java.time.format.DateTimeFormatter;

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
		public boolean create(Abonnement objet) throws SQLException {
			
	    	int nbLigne = 0; 
			
			Connection laConnexion = Connexion.getInstance().creeConnexion();
			PreparedStatement requete = 
				
			laConnexion.prepareStatement("insert into Abonnement (date_debut, date_fin, id_client, id_revue) values(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			requete.setDate(1, Date.valueOf(formatage.format(objet.getDateDebut())));
			requete.setDate(1, Date.valueOf(formatage.format(objet.getDateDebut())));
			requete.setInt(3, objet.getIdClient());
			requete.setInt(4, objet.getIdRevue());
				
			nbLigne = requete.executeUpdate();
				
			ResultSet res = requete.getGeneratedKeys();
			if ( res.next() ) {
				objet.setIdAbonnement(res.getInt(1));
			}
				
			
			return nbLigne == 1;
		}

		@Override
		public boolean update(Abonnement objet) throws SQLException {
			
			int nbLigne = 0; 
			
				Connection laConnexion = Connexion.getInstance().creeConnexion();
				PreparedStatement requete = 
				
				laConnexion.prepareStatement("update Abonnement set date_debut =?, date_fin =?, id_client =?, id_revue =? where id_abonnement =?");
				DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				requete.setDate(1, Date.valueOf(formatage.format(objet.getDateDebut())));
				requete.setDate(1, Date.valueOf(formatage.format(objet.getDateDebut())));
				requete.setInt(3, objet.getIdClient());
				requete.setInt(4, objet.getIdRevue());
				requete.setInt(5, objet.getIdAbonnement());
				
				nbLigne = requete.executeUpdate();
				

			return nbLigne == 1;
		}

		@Override
		public boolean delete(Abonnement objet) throws SQLException {
			
			int nbLigne = 0; 
			
			Connection laConnexion = Connexion.getInstance().creeConnexion();
			PreparedStatement requete = 
				
			laConnexion.prepareStatement("delete from Abonnement where id_abonnement=?");
			requete.setInt(1, objet.getIdAbonnement());
				
			nbLigne = requete.executeUpdate();
				
			return nbLigne == 1;
		}

		@Override
		public Abonnement getById(int id) throws SQLException {
			
			Abonnement a = null;
			
			Connection laConnexion = Connexion.getInstance().creeConnexion();
			PreparedStatement requete = 
					
			laConnexion.prepareStatement("select * from Abonnement where id_abonnement=?");
			requete.setInt(1, id);
				
			ResultSet resultSet = requete.executeQuery();

			if (resultSet.next()) {
				a = new Abonnement();
				a.setIdAbonnement(resultSet.getInt("id_abonnement"));
				a.setDateDebut((resultSet.getDate("date_debut")).toLocalDate());
				a.setDateFin((resultSet.getDate("date_fin")).toLocalDate());
				a.setIdClient(resultSet.getInt("id_client"));
				a.setIdRevue(resultSet.getInt("id_revue"));
			}
			
			return a;
		}

		@Override
		public ArrayList<Abonnement> findAll() throws SQLException {
			
			ArrayList<Abonnement> aList = new ArrayList<Abonnement>();
			
			Connection laConnexion = Connexion.getInstance().creeConnexion();
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
			
			return aList;
		}
}
	   