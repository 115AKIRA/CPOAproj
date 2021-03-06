package dao.factory;

import dao.*;
import dao.Persistance;

public abstract class DAOFactory {
	
	public static DAOFactory getDAOFactory(Persistance cible) {
		
		DAOFactory daoF = null;
		
		switch (cible) {
			case MYSQL:
				daoF = new MySQLDAOFactory();
				break;
			case LISTE_MEMOIRE:
				daoF = new ListeMemoireDAOFactory();
				break;
		}
		
		return daoF;
	}
		public abstract PeriodiciteDAO getPeriodiciteDAO();
		public abstract RevueDAO getRevueDAO();
		public abstract ClientDAO getClientDAO();
		public abstract AbonnementDAO getAbonnementDAO();
		
}
