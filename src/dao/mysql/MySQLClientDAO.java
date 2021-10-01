package dao.mysql;

import java.sql.*;
import java.util.ArrayList;

import connexion.Connexion;
import dao.ClientDAO;

import modele.Client;


public class MySQLClientDAO implements ClientDAO {
 
    private static MySQLClientDAO instance;


    public static MySQLClientDAO getInstance() {

        if (instance == null) {
            instance = new MySQLClientDAO();
        }

        return instance;
    }

    private MySQLClientDAO() {}

    @Override
	public boolean create(Client objet) {
		
		int nbLigne = 0; 
		
		try {
			Connexion c = new Connexion();
			Connection laConnexion = c.creeConnexion();
			PreparedStatement requete = 
			
	        laConnexion.prepareStatement("insert into Client (nom, prenom, no_rue, voie, code_postal, ville, pays) values(?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
	        requete.setString(1, objet.getNom());
	        requete.setString(2, objet.getPrenom());
	        requete.setString(3, objet.getNo_rue());
	        requete.setString(4, objet.getVoie());
	        requete.setString(5, objet.getCode_postal());
	        requete.setString(6, objet.getVille());
	        requete.setString(7, objet.getPays());
			
			nbLigne = requete.executeUpdate();
			
			ResultSet res = requete.getGeneratedKeys();
			if ( res.next() ) {
				objet.setId_client(res.getInt(1));
			}
			
	} catch (SQLException sqle) {
			System.out.println("Pb dans select " + sqle.getMessage());
			}
		
		return nbLigne != 0;
	}

	@Override
	public boolean update(Client objet) {
		
		int nbLigne = 0; 
		
		try {
			Connexion c = new Connexion();
			Connection laConnexion = c.creeConnexion();
			PreparedStatement requete = 
			
			laConnexion.prepareStatement("update Client set nom =?, prenom =?, no_rue =?, voie =?, code_postal=?, ville=?, pays=? where id_client =?");
			requete.setString(1, objet.getNom());
            requete.setString(2, objet.getPrenom());
            requete.setString(3, objet.getNo_rue());
            requete.setString(4, objet.getVoie());
            requete.setString(5, objet.getCode_postal());
            requete.setString(6, objet.getVille());
            requete.setString(7, objet.getPays());
            requete.setInt(8, objet.getId_client());
			
			nbLigne = requete.executeUpdate();
			
	} catch (SQLException sqle) {
			System.out.println("Pb dans select " + sqle.getMessage());
			}
		
		return nbLigne != 0;
	}

	@Override
	public boolean delete(Client objet) {
		
		int nbLigne = 0; 
		
		try {
			Connexion c = new Connexion();
			Connection laConnexion = c.creeConnexion();
			PreparedStatement requete = 
			
			laConnexion.prepareStatement("delete from Client where id_client=?");
			requete.setInt(1, objet.getId_client());
			
			nbLigne = requete.executeUpdate();
			
	} catch (SQLException sqle) {
			System.out.println("Pb dans select " + sqle.getMessage());
			}
		
		return nbLigne != 0;
	}

	
	@Override
	public ArrayList<Client> findAll() {
		
		ArrayList<Client> cList = new ArrayList<Client>();
		
		try {
			Connexion c = new Connexion();
			Connection laConnexion = c.creeConnexion();
			PreparedStatement requete = 
			
			laConnexion.prepareStatement("select * from Periodicite");
			
			ResultSet resultSet = requete.executeQuery();

		while(resultSet.next()) {
			cList.add(new Client(resultSet.getInt("id_client"),
					resultSet.getString("nom"),
					resultSet.getString("prenom"),
					resultSet.getString("no_rue"),
					resultSet.getString("voie"),
					resultSet.getString("code_postal"),
					resultSet.getString("ville"),
					resultSet.getString("pays")));
		}
			
	} catch (SQLException sqle) {
			System.out.println("Pb dans select " + sqle.getMessage());
			}
		
		return cList;
	}

	@Override
	public ArrayList<Client> getByNomPrenom(String nom, String prenom) throws Exception {
		
		ArrayList<Client> cList = new ArrayList<Client>();
		
		try {
			Connexion c = new Connexion();
			Connection laConnexion = c.creeConnexion();
			PreparedStatement requete = 
			
			laConnexion.prepareStatement("select * from Client where nom=?, prenom=?");
			requete.setString(1, nom);
			requete.setString(2, prenom);
			
			ResultSet resultSet = requete.executeQuery();

		while (resultSet.next()) {
			cList.add(new Client(resultSet.getInt("id_client"),
					resultSet.getString("nom"),
					resultSet.getString("prenom"),
					resultSet.getString("no_rue"),
					resultSet.getString("voie"),
					resultSet.getString("code_postal"),
					resultSet.getString("ville"),
					resultSet.getString("pays")));
		}
			
	} catch (SQLException sqle) {
			System.out.println("Pb dans select " + sqle.getMessage());
			}
		
		return cList;
	}

	@Override
	public Client getById(int id) throws Exception {

		Client cl = null;
		
		try {
			Connexion c = new Connexion();
			Connection laConnexion = c.creeConnexion();
			PreparedStatement requete = 
			
			laConnexion.prepareStatement("select * from Client where id_client=?");
			requete.setInt(1, id);
			
			ResultSet resultSet = requete.executeQuery();

		if (resultSet.next()) {
			cl = new Client();
			cl.setId_client(resultSet.getInt("id_periodicite"));
			cl.setNom(resultSet.getString("nom"));
			cl.setPrenom(resultSet.getString("nom"));
			cl.setNo_rue(resultSet.getString("no_rue"));
			cl.setVoie(resultSet.getString("voie"));
			cl.setCode_postal(resultSet.getString("code_postal"));
			cl.setVille(resultSet.getString("ville"));
			cl.setPays(resultSet.getString("pays"));
		}
			
	} catch (SQLException sqle) {
			System.out.println("Pb dans select " + sqle.getMessage());
			}
		
		return cl;
	}
}