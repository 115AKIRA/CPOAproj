package dao.factory;

import dao.*;
import dao.mysql.*;

public class MySQLDAOFactory extends DAOFactory {

	@Override
	public PeriodiciteDAO getPeriodiciteDAO() {
		return MySQLPeriodiciteDAO.getInstance();
	}

	@Override
	public RevueDAO getRevueDAO() {
		return MySQLRevueDAO.getInstance();
	}

	@Override
	public ClientDAO getClientDAO() {
		return MySQLClientDAO.getInstance();
	}

	@Override
	public AbonnementDAO getAbonnementDAO() {
		return MySQLAbonnementDAO.getInstance();
	}

}


