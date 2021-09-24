package dao.factory;

import dao.*;
import dao.listememoire.*;

public class ListeMemoireDAOFactory extends DAOFactory {

	@Override
	public PeriodiciteDAO getPeriodiciteDAO() {
		return ListeMemoirePeriodiciteDAO.getInstance();
	}

}
