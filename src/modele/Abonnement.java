package modele;

import java.sql.*;
import java.time.*;
import java.time.format.*;

import connexion.Connexion;

public class Abonnement {
	
	
	
	
	private int id_client;
	private CharSequence date_debut;
	private CharSequence date_fin;
	private int id_abonnement;
	private int id_revue;
	
	
	
	
	
	
	public Abonnement(int id_client, CharSequence date_debut, CharSequence date_fin, int id_abonnement, int id_revue) {
		super();
		this.id_client = id_client;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.id_abonnement = id_abonnement;
		this.id_revue = id_revue;
	}





	public int getId_abonnement() {
		return id_abonnement;
	}





	public void setId_abonnement(int id_abonnement) {
		this.id_abonnement = id_abonnement;
	}

	

	
	
	
	
	public Abonnement(int id_revue) {
		super();
		this.id_revue = id_revue;
	}





	//Supprimer Abonnement

	public int getId_client() {
		return id_client;
	}





	public void setId_client(int id_client) {
		this.id_client = id_client;
	}





	public CharSequence getDate_debut() {
		return date_debut;
	}





	public void setDate_debut(CharSequence date_debut) {
		this.date_debut = date_debut;
	}





	public CharSequence getDate_fin() {
		return date_fin;
	}





	public void setDate_fin(CharSequence date_fin) {
		this.date_fin = date_fin;
	}





	public int getId_revue() {
		return id_revue;
	}





	public void setId_revue(int id_revue) {
		this.id_revue = id_revue;
	}





	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date_debut == null) ? 0 : date_debut.hashCode());
		result = prime * result + ((date_fin == null) ? 0 : date_fin.hashCode());
		result = prime * result + id_client;
		result = prime * result + id_revue;
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
		Abonnement other = (Abonnement) obj;
		if (date_debut == null) {
			if (other.date_debut != null)
				return false;
		} else if (!date_debut.equals(other.date_debut))
			return false;
		if (date_fin == null) {
			if (other.date_fin != null)
				return false;
		} else if (!date_fin.equals(other.date_fin))
			return false;
		if (id_client != other.id_client)
			return false;
		if (id_revue != other.id_revue)
			return false;
		return true;
	}





	public void AbonnemSuppr(int id_abonnement) {
		try {
			Connexion c = new Connexion();
			Connection laConnexion = c.creeConnexion();
			PreparedStatement requete = 
			
			laConnexion.prepareStatement("delete from Abonnement where id_abonnement=?");
			requete.setInt(1, id_abonnement);
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
	
	//Ajout Abonnement
	
			public void AbonnemAjout(CharSequence date_debut, CharSequence date_fin, int id_client, int id_revue) {
				try {
					Connexion c = new Connexion();
					Connection laConnexion = c.creeConnexion();
					PreparedStatement requete = 
							
					laConnexion.prepareStatement("insert into Abonnement (date_debut, date_fin, id_client, id_revue) values(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
					
					DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDate dateDebut = LocalDate.parse(date_debut, formatage);
					LocalDate dateFin = LocalDate.parse(date_fin, formatage);
					Date datedeb = Date.valueOf((dateDebut));
					Date datefin = Date.valueOf((dateFin));
					
					requete.setDate(1, datedeb);
					requete.setDate(2, datefin);
					requete.setInt(3, id_client);
					requete.setInt(4, id_revue);
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
			
			//Modifier Revue

			public void AbonnemModif(int id_abonnement, CharSequence date_debut, CharSequence date_fin, int id_client, int id_revue) {
				try {
					Connexion c = new Connexion();
					Connection laConnexion = c.creeConnexion();
					PreparedStatement requete = 
							
					laConnexion.prepareStatement("update Abonnement set date_debut =?, date_fin =?, id_client =?, id_revue =? where id_abonnement =?");
					
					DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDate dateDebut = LocalDate.parse(date_debut, formatage);
					LocalDate dateFin = LocalDate.parse(date_fin, formatage);
					Date datedeb = Date.valueOf((dateDebut));
					Date datefin = Date.valueOf((dateFin));
					
					requete.setDate(1, datedeb);
					requete.setDate(2, datefin);
					requete.setInt(3, id_client);
					requete.setInt(4, id_revue);
					requete.setInt(5, id_abonnement);
					
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
