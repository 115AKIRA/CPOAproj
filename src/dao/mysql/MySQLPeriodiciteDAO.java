package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connexion.Connexion;
import dao.PeriodiciteDAO;
import modele.Periodicite;

public class MySQLPeriodiciteDAO implements PeriodiciteDAO {

	private static MySQLPeriodiciteDAO instance;

	private List<Periodicite> donnees;


	public static MySQLPeriodiciteDAO getInstance() {

		if (instance == null) {
			instance = new MySQLPeriodiciteDAO();
		}

		return instance;
	}

	private MySQLPeriodiciteDAO() {}


	@Override
	public boolean create(Periodicite objet) {
		
		int nbLigne = 0; 
		
		try {
			Connexion c = new Connexion();
			Connection laConnexion = c.creeConnexion();
			PreparedStatement requete = 
			
			laConnexion.prepareStatement("insert into Periodicite (libelle) values(?)", Statement.RETURN_GENERATED_KEYS);
			requete.setString(1, objet.getLibelle());
			
			nbLigne = requete.executeUpdate();
			
			ResultSet res = requete.getGeneratedKeys();
			if ( res.next() ) {
				objet.setId_periodicite(res.getInt(1));
			}
			
	} catch (SQLException sqle) {
			System.out.println("Pb dans select " + sqle.getMessage());
			}
		
		return nbLigne != 0;
	}

	@Override
	public boolean update(Periodicite objet) {
		
		int nbLigne = 0; 
		
		try {
			Connexion c = new Connexion();
			Connection laConnexion = c.creeConnexion();
			PreparedStatement requete = 
			
			laConnexion.prepareStatement("update Periodicite set libelle =? where id_periodicite =?");
			requete.setString(1, objet.getLibelle());
			requete.setInt(2, objet.getId_periodicite());
			
			nbLigne = requete.executeUpdate();
			
	} catch (SQLException sqle) {
			System.out.println("Pb dans select " + sqle.getMessage());
			}
		
		return nbLigne != 0;
	}

	@Override
	public boolean delete(Periodicite objet) {
		
		int nbLigne = 0; 
		
		try {
			Connexion c = new Connexion();
			Connection laConnexion = c.creeConnexion();
			PreparedStatement requete = 
			
			laConnexion.prepareStatement("delete from Periodicite where id_periodicite=?");
			requete.setInt(1, objet.getId_periodicite());
			
			nbLigne = requete.executeUpdate();
			
	} catch (SQLException sqle) {
			System.out.println("Pb dans select " + sqle.getMessage());
			}
		
		return nbLigne != 0;
	}

	@Override
	public Periodicite getById(int id) {
		
		Periodicite p = null;
		
		try {
			Connexion c = new Connexion();
			Connection laConnexion = c.creeConnexion();
			PreparedStatement requete = 
			
			laConnexion.prepareStatement("select * from Periodicite where id_periodicite=?");
			requete.setInt(1, id);
			
			ResultSet resultSet = requete.executeQuery();

		if (resultSet.next()) {
			p = new Periodicite();
			p.setId_periodicite(resultSet.getInt("id_periodicite"));
			p.setLibelle(resultSet.getString("libelle"));
		}
			
	} catch (SQLException sqle) {
			System.out.println("Pb dans select " + sqle.getMessage());
			}
		
		return p;
	}

	@Override
	public ArrayList<Periodicite> findAll() {
		
		ArrayList<Periodicite> pList = new ArrayList<Periodicite>();
		
		try {
			Connexion c = new Connexion();
			Connection laConnexion = c.creeConnexion();
			PreparedStatement requete = 
			
			laConnexion.prepareStatement("select * from Periodicite");
			
			ResultSet resultSet = requete.executeQuery();

		while(resultSet.next()) {
			pList.add(new Periodicite(resultSet.getInt("id_periodicite"),resultSet.getString("libelle")));
		}
			
	} catch (SQLException sqle) {
			System.out.println("Pb dans select " + sqle.getMessage());
			}
		
		return pList;
	}
}