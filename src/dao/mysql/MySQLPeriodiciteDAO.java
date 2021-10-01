package dao.mysql;

import java.util.ArrayList;
import java.util.List;

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

	private MySQLPeriodiciteDAO() {

		Periodicite p = new Periodicite();
		
		p.PeriodAjout("Mensuel");
		p.PeriodAjout("Quotidien");
	}


	@Override
	public boolean create(Periodicite objet) {
		objet.setId_periodicite(3);
		while (this.donnees.contains(objet)) {

			objet.setId_periodicite(objet.getId_periodicite() + 1);
		}
		boolean ok = this.donnees.add(objet);
		
		return ok;
	}

	@Override
	public boolean update(Periodicite objet) {
		
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
	public boolean delete(Periodicite objet) {
		
		objet.PeriodSuppr(objet.getId_periodicite());
		
		return true;
	}

	@Override
	public Periodicite getById(int id) {
		// Ne fonctionne que si l'objet m�tier est bien fait...
		int idx = this.donnees.indexOf(new Periodicite(id, "test"));
		if (idx == -1) {
			throw new IllegalArgumentException("Aucun objet ne poss�de cet identifiant");
		} else {
			return this.donnees.get(idx);
		}
	}

	@Override
	public ArrayList<Periodicite> findAll() {
		return (ArrayList<Periodicite>) this.donnees;
	}
}