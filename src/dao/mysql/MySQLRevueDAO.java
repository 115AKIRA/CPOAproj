package dao.mysql;


import java.util.ArrayList;


import java.sql.*;

import connexion.Connexion;
import dao.RevueDAO;

import modele.Revue ;


public class MySQLRevueDAO implements RevueDAO {

	private static MySQLRevueDAO instance;

	


	public static MySQLRevueDAO getInstance() {

		if (instance == null) {
			instance = new MySQLRevueDAO();
		}

		return instance;
	}

	private MySQLRevueDAO() {}
	
	
	

	@Override
	public boolean create(Revue objet) {
		
		int nbLigne = 0; 
		
		try {
			Connexion c = new Connexion();
			Connection laConnexion = c.creeConnexion();
			PreparedStatement requete = 
			
			laConnexion.prepareStatement("insert into Revue (id_revue,titre, description, tarif_numero, visuel, id_periodicite) values(?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			requete.setString(1, objet.getTitre());
			requete.setString(2, objet.getTitre());
			requete.setString(3, objet.getDescription());
			requete.setFloat(4, objet.getTarif_numero());
			requete.setString(5, objet.getVisuel());
			requete.setInt(6, objet.getId_periodicite());
			
			
			
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
	public boolean update(Revue objet) {
		
		int nbLigne = 0; 
		
		try {
			Connexion c = new Connexion();
			Connection laConnexion = c.creeConnexion();
			PreparedStatement requete = 
			
					
			laConnexion.prepareStatement("insert into Revue (id_revue,titre, description, tarif_numero, visuel, id_periodicite) values(?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			requete.setString(1, objet.getTitre());
			requete.setString(2, objet.getTitre());
			requete.setString(3, objet.getDescription());
			requete.setFloat(4, objet.getTarif_numero());
			requete.setString(5, objet.getVisuel());
			requete.setInt(6, objet.getId_periodicite());
			
			nbLigne = requete.executeUpdate();
			
	} catch (SQLException sqle) {
			System.out.println("Pb dans select " + sqle.getMessage());
			}
		
		return nbLigne != 0;
	}

	@Override
	public boolean delete(Revue objet) {
		
		int nbLigne = 0; 
		
		try {
			Connexion c = new Connexion();
			Connection laConnexion = c.creeConnexion();
			PreparedStatement requete = 
			
			laConnexion.prepareStatement("delete from Revue where id_revue=?");
			requete.setInt(1, objet.getId_revue());
			
			nbLigne = requete.executeUpdate();
			
	} catch (SQLException sqle) {
			System.out.println("Pb dans select " + sqle.getMessage());
			}
		
		return nbLigne != 0;
	}

	@Override
	public Revue getById(int id) {
		
		Revue r = null;
		
		try {
			Connexion c = new Connexion();
			Connection laConnexion = c.creeConnexion();
			PreparedStatement requete = 
			
			laConnexion.prepareStatement("select * from Revue where id_revue=?");
			requete.setInt(1, id);
			
			ResultSet resultSet = requete.executeQuery();

		if (resultSet.next()) {
			r = new Revue();
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
	public ArrayList<Revue> findAll() {
		
		ArrayList<Revue> rList = new ArrayList<Revue>();
		
		try {
			Connexion c = new Connexion();
			Connection laConnexion = c.creeConnexion();
			PreparedStatement requete = 
			
			laConnexion.prepareStatement("select * from Revue");
			
			ResultSet resultSet = requete.executeQuery();

		while(resultSet.next()) {
			rList.add(new Revue(resultSet.getInt("id_revue")
					,resultSet.getString("titre"),resultSet.getString("description"),resultSet.getFloat("tarif_numero"),resultSet.getString("visuel"),resultSet.getInt("id_periodicite")));
		}
			
	} catch (SQLException sqle) {
			System.out.println("Pb dans select " + sqle.getMessage());
			}
		
		return rList;
		
	}
	}