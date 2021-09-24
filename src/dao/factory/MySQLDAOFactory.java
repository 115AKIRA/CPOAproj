package dao.factory;

import dao.*;
import dao.mysql.*;

public class MySQLDAOFactory extends DAOFactory {

	@Override
	public PeriodiciteDAO getPeriodiciteDAO() {
		return MySQLPeriodiciteDAO.getInstance();
	}

}


