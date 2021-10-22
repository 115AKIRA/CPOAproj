package dao.mysql;

import java.sql.*;
import java.util.ArrayList;

import dao.PeriodiciteDAO;
import modele.Periodicite;

public class MySQLPeriodiciteDAO implements PeriodiciteDAO {

	private static MySQLPeriodiciteDAO instance;

	public static MySQLPeriodiciteDAO getInstance() {

		if (instance == null) {
			instance = new MySQLPeriodiciteDAO();
		}

		return instance;
	}

	private MySQLPeriodiciteDAO() {}


	@Override
	public boolean create(Periodicite objet) throws SQLException {
		
		int nbLigne = 0; 

		Connection laConnexion = Connexion.getInstance().creeConnexion();
		PreparedStatement requete = 
			
		laConnexion.prepareStatement("insert into Periodicite (libelle) values(?)", Statement.RETURN_GENERATED_KEYS);
		requete.setString(1, objet.getLibelle());
			
		nbLigne = requete.executeUpdate();
			
		ResultSet res = requete.getGeneratedKeys();
		if ( res.next() ) {
			objet.setIdPeriodicite(res.getInt(1));
		}
		
		return nbLigne == 1;
	}

	@Override
	public boolean update(Periodicite objet) throws SQLException {
		
		int nbLigne = 0; 

		Connection laConnexion = Connexion.getInstance().creeConnexion();
		PreparedStatement requete = 
			
		laConnexion.prepareStatement("update Periodicite set libelle =? where id_periodicite =?");
		requete.setString(1, objet.getLibelle());
		requete.setInt(2, objet.getIdPeriodicite());
			
		nbLigne = requete.executeUpdate();
		
		return nbLigne == 1;
	}

	@Override
	public boolean delete(Periodicite objet) throws SQLException {
		
		int nbLigne = 0; 

			Connection laConnexion = Connexion.getInstance().creeConnexion();
			PreparedStatement requete = 
			
			laConnexion.prepareStatement("delete from Periodicite where id_periodicite=?");
			requete.setInt(1, objet.getIdPeriodicite());
			
			nbLigne = requete.executeUpdate();
		
		return nbLigne == 1;
	}

	@Override
	public Periodicite getById(int id) throws SQLException {
		
		Periodicite p = null;

		Connection laConnexion = Connexion.getInstance().creeConnexion();
		PreparedStatement requete = 
			
		laConnexion.prepareStatement("select * from Periodicite where id_periodicite=?");
		requete.setInt(1, id);
			
		ResultSet resultSet = requete.executeQuery();

		if (resultSet.next()) {
			p = new Periodicite();
			p.setIdPeriodicite(resultSet.getInt("id_periodicite"));
			p.setLibelle(resultSet.getString("libelle"));
		}
		
		return p;
	}

	@Override
	public ArrayList<Periodicite> findAll() throws SQLException{
		
		ArrayList<Periodicite> pList = new ArrayList<Periodicite>();

		Connection laConnexion = Connexion.getInstance().creeConnexion();
		PreparedStatement requete = 
			
		laConnexion.prepareStatement("select * from Periodicite");
			
		ResultSet resultSet = requete.executeQuery();

		while(resultSet.next()) {
			pList.add(new Periodicite(resultSet.getInt("id_periodicite"),
					resultSet.getString("libelle")));
		}
		
		return pList;
	}
}