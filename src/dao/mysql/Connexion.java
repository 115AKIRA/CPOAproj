package dao.mysql;

import java.io.*;
import java.sql.*;
import java.util.Properties;

public class Connexion {
	
	private static Connexion instance;
	
	private String url;
	private String login;
	private String pass;
	
	public static Connexion getInstance() {

        if (instance == null) {
            instance = new Connexion();
        }

        return instance;
    }

	public static void setInstance(Connexion instance) {
		Connexion.instance = instance;
	}
	
	private Connexion() {
		this.chargeFichier();
	}

	public Connection creeConnexion() {
		Connection maConnexion = null;
		try {	
			maConnexion = DriverManager.getConnection(this.url, this.login, this.pass);
		} catch (SQLException sqle) {
			System.out.println("Erreur connexion" + sqle.getMessage());
		}
		return maConnexion;
	}
	
	public void chargeFichier() {
		Properties accesBdd = new Properties(); 
		File fBdd = new File("./resources/config/bdd.properties");
		try { 
			FileInputStream source = new FileInputStream(fBdd); 
			accesBdd.loadFromXML(source); 
		} catch (IOException ioe) { 
			ioe.printStackTrace(); 
		} 
		this.login = accesBdd.getProperty("login");
		this.pass = accesBdd.getProperty("pass");
		this.url = accesBdd.getProperty("adresse_ip") + ":" + accesBdd.getProperty("port") + "/" + accesBdd.getProperty("bdd");
	}
	
}
