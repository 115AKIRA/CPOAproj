package dao;

import java.util.List;

import modele.Client;

public interface ClientDAO extends DAO<Client> {
	
	public abstract List<Client> getByNomPrenom(String nom, String prenom) throws Exception;

}