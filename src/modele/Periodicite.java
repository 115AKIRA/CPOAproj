package modele;

import java.sql.*;

public class Periodicite {
	
	int id_periodicite;
	String libelle;
	
	public Periodicite() {}
	
	public Periodicite(int id_periodicite, String libelle) {
		super();
		this.id_periodicite = id_periodicite;
		this.libelle = libelle;
	}

	public int getId() {
		return id_periodicite;
	}

	public void setId(int id_periodicite) {
		this.id_periodicite = id_periodicite;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_periodicite;
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Periodicite other = (Periodicite) obj;
		if (id_periodicite != other.id_periodicite)
			return false;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		return true;
	}
	
	//Supprimer Periodicite

	public void PeriodSuppr(int id_periodicite) {
		try {
			Connexion c = new Connexion();
			Connection laConnexion = c.creeConnexion();
			PreparedStatement requete = 
			
			laConnexion.prepareStatement("delete from Periodicite where id_periodicite=?");
			requete.setInt(1, id_periodicite);
			int nbLignes = requete.executeUpdate();
			System.out.println("Update:" + nbLignes);

		if (requete != null)
			requete.close();
			
		if (laConnexion != null)
			laConnexion.close();
			
	} catch (SQLException sqle) {
			System.out.println("Pb dans select " + sqle.getMessage());
			}
	}

	//Ajout Periodicite
	
	public void PeriodAjout(String libelle) {
		try {
			Connexion c = new Connexion();
			Connection laConnexion = c.creeConnexion();
			PreparedStatement requete = 
					
			laConnexion.prepareStatement("insert into Periodicite (libelle) values(?)", Statement.RETURN_GENERATED_KEYS);
			requete.setString(1, libelle);
			int nbLignes = requete.executeUpdate();
			System.out.println("Update:" + nbLignes);
			ResultSet res = requete.getGeneratedKeys();
			if (res.next()) {
			int cle = res.getInt(1); 
			System.out.println("Cle:" + cle);
				}
		
		if (res != null)
			res.close();
			
		if (requete != null)
			requete.close();
			
		if (laConnexion != null)
			laConnexion.close();
			
	} catch (SQLException sqle) {
			System.out.println("Pb dans select " + sqle.getMessage());
			}
	}	
	
	//Modifier Periodicite

	public void PeriodModif(int id_periodicite, String libelle) {
		try {
			Connexion c = new Connexion();
			Connection laConnexion = c.creeConnexion();
			PreparedStatement requete = 
					
			laConnexion.prepareStatement("update Periodicite set libelle =? where id_periodicite =?");
			requete.setString(1, libelle);
			requete.setInt(2, id_periodicite);
			int nbLignes = requete.executeUpdate();
			System.out.println("Update:" + nbLignes);
			
		if (requete != null)
			requete.close();
			
		if (laConnexion != null)
			laConnexion.close();
			
	} catch (SQLException sqle) {
			System.out.println("Pb dans select " + sqle.getMessage());
			}
	}

}
