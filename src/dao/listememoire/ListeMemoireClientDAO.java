package dao.listememoire;

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
}
