package dao.mysql;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;

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
	public boolean create(Client objet) throws SQLException {

		int nbLigne = 0; 

		Connection laConnexion = Connexion.getInstance().creeConnexion();
		PreparedStatement requete = 

				laConnexion.prepareStatement("insert into Client (nom, prenom, no_rue, voie, code_postal, ville, pays) values(?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
		requete.setString(1, objet.getNom());
		requete.setString(2, objet.getPrenom());
		requete.setString(3, objet.getNoRue());
		requete.setString(4, objet.getVoie());
		requete.setString(5, objet.getCodePostal());
		requete.setString(6, objet.getVille());
		requete.setString(7, objet.getPays());

		nbLigne = requete.executeUpdate();

		ResultSet res = requete.getGeneratedKeys();
		if ( res.next() ) {
			objet.setIdClient(res.getInt(1));
		}

		return nbLigne == 1;
	}

	@Override
	public boolean update(Client objet) throws SQLException  {

		int nbLigne = 0; 

		Connection laConnexion = Connexion.getInstance().creeConnexion();
		PreparedStatement requete = 

				laConnexion.prepareStatement("update Client set nom =?, prenom =?, no_rue =?, voie =?, code_postal=?, ville=?, pays=? where id_client =?");
		requete.setString(1, objet.getNom());
		requete.setString(2, objet.getPrenom());
		requete.setString(3, objet.getNoRue());
		requete.setString(4, objet.getVoie());
		requete.setString(5, objet.getCodePostal());
		requete.setString(6, objet.getVille());
		requete.setString(7, objet.getPays());
		requete.setInt(8, objet.getIdClient());

		nbLigne = requete.executeUpdate();

		return nbLigne == 1;
	}

	@Override
	public boolean delete(Client objet) throws SQLException {

		int nbLigne = 0; 

		Connection laConnexion = Connexion.getInstance().creeConnexion();
		PreparedStatement requete = 

				laConnexion.prepareStatement("delete from Client where id_client=?");
		requete.setInt(1, objet.getIdClient());

		nbLigne = requete.executeUpdate();

		return nbLigne == 1;
	}


	@Override
	public ArrayList<Client> findAll() throws SQLException {

		ArrayList<Client> cList = new ArrayList<Client>();

		Connection laConnexion = Connexion.getInstance().creeConnexion();
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

		return cList;
	}

	@Override
	public ArrayList<Client> getByNomPrenom(String nom, String prenom) throws Exception {

		ArrayList<Client> cList = new ArrayList<Client>();

		Connection laConnexion = Connexion.getInstance().creeConnexion();
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

		return cList;
	}

	@Override
	public Client getById(int id) throws Exception {

		Client cl = null;

		Connection laConnexion = Connexion.getInstance().creeConnexion();
		PreparedStatement requete = 

				laConnexion.prepareStatement("select * from Client where id_client=?");
		requete.setInt(1, id);

		ResultSet resultSet = requete.executeQuery();

		if (resultSet.next()) {
			cl = new Client();
			cl.setIdClient(resultSet.getInt("id_periodicite"));
			cl.setNom(resultSet.getString("nom"));
			cl.setPrenom(resultSet.getString("nom"));
			cl.setNoRue(resultSet.getString("no_rue"));
			cl.setVoie(resultSet.getString("voie"));
			cl.setCodePostal(resultSet.getString("code_postal"));
			cl.setVille(resultSet.getString("ville"));
			cl.setPays(resultSet.getString("pays"));

			create(cl);
		}

		return cl;
	}

	public String CSVtoSQL(String path) throws IOException, SQLException {

		try {
			Paths.get(path);
		} catch (InvalidPathException | NullPointerException ex) {
			System.out.println("erreur chemin vide");
			return "Chemin n'existe pas ou est vide";
		}

		String line = "";


		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String[] client = null;
			while ((line = br.readLine()) != null)  {  
				client = line.split(",");
				System.out.println(client);
			}
			
			System.out.println("sortis de la boucle");

			br.close();

			int i;
			
			if ( (client.length)/8 != 1*((client.length)/8) ) {
				System.out.println("fichier incorrect");
				System.out.println(client.length);
				return "Fichier incorrect";
			} else try {
				for ( i = 0 ; i <= client.length ; i = i + 8) {
					Integer.parseInt(client[0 + i]);
					System.out.println("etape 1");
					System.out.println(client[0 + i]);
					Client c = new Client();
					c.setNom(client[(1 + i)]);
					System.out.println("etape 2");
					System.out.println(client[1 + i]);
					c.setPrenom(client[(2 + i)]);
					System.out.println("etape 3");
					System.out.println(client[2 + i]);
					c.setNoRue(client[(3 + i)]);
					System.out.println("etape 4");
					System.out.println(client[3 + i]);
					c.setVoie(client[(4 + i)]);
					System.out.println("etape 5");
					System.out.println(client[4 + i]);
					c.setCodePostal(client[(5 + i)]);
					System.out.println("etape 6");
					System.out.println(client[5 + i]);
					c.setVille(client[(6 + i)]);
					System.out.println("etape 7");
					System.out.println(client[6 + i]);
					c.setPays(client[(7 + i)]);
					System.out.println("etape 8");
					System.out.println(client[7 + i]);

					create(c);
					System.out.println("etape 9");
				}

			} catch ( NumberFormatException e ) {
				return "Fichier de format incorrect";
			}

		} catch (IOException e) {
			return "Erreur lors de la lecture";
		}

		return "Fichier client crée";

	}
}