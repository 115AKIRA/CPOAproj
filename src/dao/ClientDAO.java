package dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import modele.Client;

public interface ClientDAO extends DAO<Client> {
	
	public abstract ArrayList<Client> getByNomPrenom(String nom, String prenom) throws Exception;
	public abstract String CSVtoSQL(String path) throws IOException, SQLException;

}