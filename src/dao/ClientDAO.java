package dao;

import java.util.ArrayList;

import modele.Client;

public interface ClientDAO extends DAO<Client> {
	
	public abstract ArrayList<Client> getByNomPrenom(String nom, String prenom) throws Exception;

}