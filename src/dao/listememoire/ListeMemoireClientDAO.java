package dao.listememoire;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import dao.ClientDAO;
import modele.Client;


public class ListeMemoireClientDAO implements ClientDAO {
    
    private static ListeMemoireClientDAO instance;

    private List<Client> donnees;

    public static ListeMemoireClientDAO getInstance() {

        if (instance == null) {
            instance = new ListeMemoireClientDAO();
        }

        return instance;
    }
    private ListeMemoireClientDAO() {

        this.donnees = new ArrayList<Client>();
     
        this.donnees.add(new Client (6,"jean", "pierre", "ronce","voie1","57000","metz","France"));
        this.donnees.add(new Client (5,"jeanne", "pierre", "ronce","voie1","57000","metz","France"));
    }
    
    @Override
    public boolean create(Client objet) {

        objet.setIdClient(1);
        // Ne fonctionne que si l'objet m�tier est bien fait...
        while (this.donnees.contains(objet)) {

            objet.setIdClient(objet.getIdClient() + 1);
        }
        boolean ok = this.donnees.add(objet);
        
        return ok;
    }

    @Override
    public boolean update(Client objet) {
        
        // Ne fonctionne que si l'objet m�tier est bien fait...
        int idx = this.donnees.indexOf(objet);
        if (idx == -1) {
            throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
        } else {
            
            this.donnees.set(idx, objet);
        }
        
        return true;
    }

    @Override
    public boolean delete(Client objet) {

        Client supprime;
        
        // Ne fonctionne que si l'objet m�tier est bien fait...
        int idx = this.donnees.indexOf(objet);
        if (idx == -1) {
            throw new IllegalArgumentException("Tentative de suppression d'un objet inexistant");
        } else {
            supprime = this.donnees.remove(idx);
        }
        
        return objet.equals(supprime);
    }

    @Override
    public Client getById(int id ) {
        // Ne fonctionne que si l'objet m�tier est bien fait...
        int idx = this.donnees.indexOf(new Client(id, "test", "test", "test", "test", "test", "test", "test"));
        if (idx == -1) {
            throw new IllegalArgumentException("Aucun objet ne poss�de cet identifiant");
        } else {
            return this.donnees.get(idx);
        }
    }

    @Override
    public ArrayList<Client> findAll() {
        return (ArrayList<Client>) this.donnees;
    }
	@Override
	public ArrayList<Client> getByNomPrenom(String nom, String prenom) throws Exception {
		int nomx = this.donnees.indexOf(new Client(nom, "test", "test", "test", "test", "test", "test"));
		int prenomx = this.donnees.indexOf(new Client("test", prenom, "test", "test", "test", "test", "test"));
        if ( (nomx == -1) || (prenomx == -1) ){
            throw new IllegalArgumentException("Aucun objet ne poss�de ces identifiants");
        } else {
            return (ArrayList<Client>) this.donnees;
        }
    }
	
	public String CSVtoSQL(String path) throws IOException {

		try {
			Paths.get(path);
		} catch (InvalidPathException | NullPointerException ex) {
			return "Chemin n'existe pas ou est vide";
		}

		String line = "";


		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String[] client = null;
			while ((line = br.readLine()) != null)  {  
				client = line.split(",");
			}
			
			br.close();

			if ( client.length != 8 ) {
				return "Fichier incorrect";
			} else try {
				Integer.parseInt(client[0]);
				Client c = new Client();
				c.setNom(client[1]);
				c.setPrenom(client[2]);
				c.setNoRue(client[3]);
				c.setVoie(client[4]);
				c.setCodePostal(client[5]);
				c.setVille(client[6]);
				c.setPays(client[7]);
				
				create(c);

			} catch ( NumberFormatException e ) {
				return "Fichier de format incorrect";
			}

		} catch (IOException e) {
			return "Erreur lors de la lecture";
		}
		
		return "Fichier client crée";

	}
}
