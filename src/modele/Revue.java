package modele;

import java.sql.*;

import connexion.Connexion;

public class Revue {
	
	private int id_revue;
	private String titre;
	private String description;
	private float tarif_numero;
	private String visuel;
	private int id_periodicite;

		public Revue(int id_revue, String titre, String description, float tarif_numero, String visuel,int id_periodicite) {
		super();
		this.id_revue = id_revue;
		this.titre = titre;
		this.description = description;
		this.tarif_numero = tarif_numero;
		this.visuel = visuel;
		this.id_periodicite = id_periodicite;
	}
		
		public Revue() {}

		public int getId() {
			return id_revue;
		}

		public void setId(int id_revue) {
			this.id_revue = id_revue;
		}

		public String getTitre() {
			return titre;
		}

		public void setTitre(String titre) {
			this.titre = titre;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public float getTarif_numero() {
			return tarif_numero;
		}

		public void setTarif_numero(float tarif_numero) {
			this.tarif_numero = tarif_numero;
		}

		public String getVisuel() {
			return visuel;
		}

		public void setVisuel(String visuel) {
			this.visuel = visuel;
		}

		public int getId_periodicite() {
			return id_periodicite;
		}

		public void setId_periodicite(int id_periodicite) {
			this.id_periodicite = id_periodicite;
		}
		

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((description == null) ? 0 : description.hashCode());
			result = prime * result + id_periodicite;
			result = prime * result + id_revue;
			result = prime * result + Float.floatToIntBits(tarif_numero);
			result = prime * result + ((titre == null) ? 0 : titre.hashCode());
			result = prime * result + ((visuel == null) ? 0 : visuel.hashCode());
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
			Revue other = (Revue) obj;
			if (description == null) {
				if (other.description != null)
					return false;
			} else if (!description.equals(other.description))
				return false;
			if (id_periodicite != other.id_periodicite)
				return false;
			if (id_revue != other.id_revue)
				return false;
			if (Float.floatToIntBits(tarif_numero) != Float.floatToIntBits(other.tarif_numero))
				return false;
			if (titre == null) {
				if (other.titre != null)
					return false;
			} else if (!titre.equals(other.titre))
				return false;
			if (visuel == null) {
				if (other.visuel != null)
					return false;
			} else if (!visuel.equals(other.visuel))
				return false;
			return true;
		}
		
		//Supprimer Revue

		public void RevueSuppr(int id_revue) {
			try {
				Connexion c = new Connexion();
				Connection laConnexion = c.creeConnexion();
				PreparedStatement requete = 
				
				laConnexion.prepareStatement("delete from Revue where id_revue=?");
				requete.setInt(1, id_revue);
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

		//Ajout Revue
		
		public void RevueAjout(String titre, String desc, float tarif_num, String visuel, int id_periodicite) {
			try {
				Connexion c = new Connexion();
				Connection laConnexion = c.creeConnexion();
				PreparedStatement requete = 
						
				laConnexion.prepareStatement("insert into Revue (titre, description, tarif_numero, visuel, id_periodicite) values(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
				requete.setString(1, titre);
				requete.setString(2, desc);
				requete.setFloat(3, tarif_num);
				requete.setString(4, visuel);
				requete.setInt(5, id_periodicite);
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

		public void RevueModif(int id_revue, String titre, String desc, float tarif_num, String visuel, int id_periodicite) {
			try {
				Connexion c = new Connexion();
				Connection laConnexion = c.creeConnexion();
				PreparedStatement requete = 
						
				laConnexion.prepareStatement("update Revue set titre =?, description =?, tarif_numero =?, visuel =?, id_periodicite =? where id_revue =?");
				requete.setString(1, titre);
				requete.setString(2, desc);
				requete.setFloat(3, tarif_num);
				requete.setString(4, visuel);
				requete.setInt(5, id_periodicite);
				requete.setInt(6, id_revue);
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
