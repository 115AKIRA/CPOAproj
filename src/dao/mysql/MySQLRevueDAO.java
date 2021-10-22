package dao.mysql;

import java.util.ArrayList;


import java.sql.*;

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
	public boolean create(Revue objet) throws SQLException {
		
		int nbLigne = 0; 
		
		Connection laConnexion = Connexion.getInstance().creeConnexion();
		PreparedStatement requete = 
			
		laConnexion.prepareStatement("insert into Revue (id_revue,titre, description, tarif_numero, visuel, id_periodicite) values(?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
		requete.setString(1, objet.getTitre());
		requete.setString(2, objet.getTitre());
		requete.setString(3, objet.getDescription());
		requete.setFloat(4, objet.getTarifNumero());
		requete.setString(5, objet.getVisuel());
		requete.setInt(6, objet.getIdPeriodicite());
			
			
			
		nbLigne = requete.executeUpdate();
			
		ResultSet res = requete.getGeneratedKeys();
		if ( res.next() ) {
			objet.setIdRevue(res.getInt(1));
		}
		
		return nbLigne == 1;
	}

	@Override
	public boolean update(Revue objet) throws SQLException {
		
		int nbLigne = 0; 

		Connection laConnexion = Connexion.getInstance().creeConnexion();
		PreparedStatement requete = 
			
					
		laConnexion.prepareStatement("update Revue set id_revue=?, titre=?, description=?, tarif_numero=?, visuel=?, id_periodicite=?");
		requete.setString(1, objet.getTitre());
		requete.setString(2, objet.getTitre());
		requete.setString(3, objet.getDescription());
		requete.setFloat(4, objet.getTarifNumero());
		requete.setString(5, objet.getVisuel());
		requete.setInt(6, objet.getIdPeriodicite());
			
		nbLigne = requete.executeUpdate();
		
		return nbLigne == 1;
	}

	@Override
	public boolean delete(Revue objet) throws SQLException {
		
		int nbLigne = 0; 
		
		Connection laConnexion = Connexion.getInstance().creeConnexion();
		PreparedStatement requete = 
			
		laConnexion.prepareStatement("delete from Revue where id_revue=?");
		requete.setInt(1, objet.getIdRevue());
			
		nbLigne = requete.executeUpdate();
			
		return nbLigne == 1;
	}

	@Override
	public Revue getById(int id) throws SQLException {
		
		Revue r = null;
		
		Connection laConnexion = Connexion.getInstance().creeConnexion();
		PreparedStatement requete = 
			
		laConnexion.prepareStatement("select * from Revue where id_revue=?");
		requete.setInt(1, id);
			
		ResultSet resultSet = requete.executeQuery();

		if (resultSet.next()) {
			r = new Revue();
			r.setIdRevue(resultSet.getInt("id_revue"));
			r.setTitre(resultSet.getString("titre"));
			r.setDescription(resultSet.getString("description"));
			r.setTarifNumero(resultSet.getFloat("tarif_numero"));
			r.setVisuel(resultSet.getString("visuel"));
			r.setIdPeriodicite(resultSet.getInt("id_periodicite"));
		}
		
		return r;
	}

	@Override
	public ArrayList<Revue> findAll() throws SQLException {
		
		ArrayList<Revue> rList = new ArrayList<Revue>();

		Connection laConnexion = Connexion.getInstance().creeConnexion();
		PreparedStatement requete = 
			
		laConnexion.prepareStatement("select * from Revue");
			
		ResultSet resultSet = requete.executeQuery();

		while(resultSet.next()) {
			rList.add(new Revue(resultSet.getInt("id_revue"),resultSet.getString("titre"),
					resultSet.getString("description"),resultSet.getFloat("tarif_numero"),
					resultSet.getString("visuel"),resultSet.getInt("id_periodicite")));
		}
		
		return rList;
		
	}
}