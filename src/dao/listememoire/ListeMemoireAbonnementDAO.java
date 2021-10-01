package dao.listememoire;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import dao.AbonnementDAO;
import modele.Abonnement;

public class ListeMemoireAbonnementDAO implements AbonnementDAO {
	
	private static ListeMemoireAbonnementDAO instance;
	
	 private List<Abonnement> donnees;

	    public static ListeMemoireAbonnementDAO getInstance() {

	        if (instance == null) {
	            instance = new ListeMemoireAbonnementDAO();
	        }

	        return instance;
	    }
	    private ListeMemoireAbonnementDAO() {

	        this.donnees = new ArrayList<Abonnement>();

	        LocalDate d1 = LocalDate.parse("04/04/2020");
	        LocalDate d2 = LocalDate.parse("04/04/2021");
	        LocalDate d3 = LocalDate.parse("25/07/2019");
	        LocalDate d4 = LocalDate.parse("25/07/2020");
	        this.donnees.add(new Abonnement (8,d1,d2,9,5));
	        this.donnees.add(new Abonnement (7,d3,d4,15,27));
	    }
	    

	    @Override
	    public boolean create(Abonnement objet) {

	        objet.setId_abonnement(1);
	        // Ne fonctionne que si l'objet m�tier est bien fait...
	        while (this.donnees.contains(objet)) {

	            objet.setId_abonnement(objet.getId_abonnement() + 1);
	        }
	        boolean ok = this.donnees.add(objet);
	        
	        return ok;
	    }

	    @Override
	    public boolean update(Abonnement objet) {
	        
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
	    public boolean delete(Abonnement objet) {

	        Abonnement supprime;
	        
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
	    public Abonnement getById(int id) {
	        
	    	LocalDate d1 = LocalDate.parse("04/04/2020");
	    	LocalDate d2 = LocalDate.parse("04/04/2021");
	        int idx = this.donnees.indexOf(new Abonnement(id,d1,d2,0,0));
	        if (idx == -1) {
	            throw new IllegalArgumentException("Aucun objet ne poss�de cet identifiant");
	        } else {
	            return this.donnees.get(idx);
	        }
	    }

	    @Override
	    public ArrayList<Abonnement> findAll() {
	        return (ArrayList<Abonnement>) this.donnees;
	    }
	}



