package modele;

import java.sql.*;
import java.util.StringTokenizer;

import connexion.Connexion;

public class Client {

	private int id_client;
	private String nom;
	private String prenom;
	private String no_rue ;
	private String voie ;
	private String code_postal ;
	private String ville ;
	private String pays ;

	
	public Client() {};
	
    public Client(int id_client, String nom, String prenom, String no_rue, String voie, String code_postal,
			String ville, String pays) {
		super();
		this.id_client = id_client;
		this.nom = nom;
		this.prenom = prenom;
		this.no_rue = no_rue;
		this.voie = voie;
		this.code_postal = code_postal;
		this.ville = ville;
		this.pays = pays;
	}

	
    
    public int getId_client() {
		return id_client;
	}

	public void setId_client(int id_client) {
		this.id_client = id_client;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNo_rue() {
		return no_rue;
	}

	public void setNo_rue(String no_rue) {
		this.no_rue = no_rue;
	}

	public String getVoie() {
		return voie;
	}

	public void setVoie(String voie) {
		this.voie = voie;
	}

	public String getCode_postal() {
		return code_postal;
	}

	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		
		if ( ville == null || ville.trim().length() == 0 || ville.matches("[0-9]+") ) {
			throw new IllegalArgumentException("Ville vide interdit !");
		}
		
		StringTokenizer st = new StringTokenizer((ville.trim().toLowerCase()).replace('-', ' '));
		ville = "";
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			switch(token) {
				case("les"):
					token = "-lès-";
					break;
				case("a"):
					token = "-à-";
					break;
				case("st"):
					token = "-Saint-";
					break;
				case("ste"):
					token = "-Sainte-";
					break;
				case("aux"):
					token = "-aux-";
					break;
				case("le"):
					token = "-le-";
					break;
				case("sous"):
					token = "-sous-";
					break;
				case("sur"):
					token = "-sur-";
					break;
				default:
					token = (token.substring(0,1).toUpperCase() + token.substring(1));
					
					// if ( token.replace(è,e)) = les || (token.replace(à,a)) = a ...
					// if token = st || token = saint
						// if token.contains(e)
							
			}
			
			ville = ville + token + ' ';
		
	     }
		
		
		if (ville.contains("-")) {
			ville = ville.replace(" ","");
			
			if ( ville.charAt(0) == '-') {
				ville = ville.substring(1);
			}
		
			if ( ville.charAt((ville.length()) - 1) == '-') {
				ville = ville.substring((ville.length() - 1), ville.length());
			
			}
		}
		
		this.ville = ((ville.substring(0,1).toUpperCase() + ville.substring(1)).trim());
		System.out.println(this.ville);
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		
		if ( pays == null || pays.trim().length()==0 ) {
			throw new IllegalArgumentException("Pays vide interdit !");
		}
		switch((pays.trim()).toLowerCase()) {
			case("luxembourg"):
			case("letzebuerg"):
				this.pays = ("Luxembourg");
				break;
			case("belgique"):
			case("belgium"):
				this.pays = ("Belgique");
				break;
			case("suisse"):
			case("switzerland"):
			case("schweiz"):
				this.pays = ("Suisse");
				break;
			default:
				throw new IllegalArgumentException("Pays non reconnu !");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code_postal == null) ? 0 : code_postal.hashCode());
		result = prime * result + id_client;
		result = prime * result + ((no_rue == null) ? 0 : no_rue.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((pays == null) ? 0 : pays.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		result = prime * result + ((ville == null) ? 0 : ville.hashCode());
		result = prime * result + ((voie == null) ? 0 : voie.hashCode());
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
		Client other = (Client) obj;
		if (code_postal == null) {
			if (other.code_postal != null)
				return false;
		} else if (!code_postal.equals(other.code_postal))
			return false;
		if (id_client != other.id_client)
			return false;
		if (no_rue == null) {
			if (other.no_rue != null)
				return false;
		} else if (!no_rue.equals(other.no_rue))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (pays == null) {
			if (other.pays != null)
				return false;
		} else if (!pays.equals(other.pays))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		if (ville == null) {
			if (other.ville != null)
				return false;
		} else if (!ville.equals(other.ville))
			return false;
		if (voie == null) {
			if (other.voie != null)
				return false;
		} else if (!voie.equals(other.voie))
			return false;
		return true;
	}

	 //A SupprimerClient
	
	public void ClientSuppr(int id_client) {
        try {
            Connexion c = new Connexion();
            Connection laConnexion = c.creeConnexion();
            PreparedStatement requete = 
            
            laConnexion.prepareStatement("delete from Client where id_client=?");
            requete.setInt(1, id_client);
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
    
    //Ajout Client
    
        public void ClientAjout(String nom, String prenom , String no_rue , String voie , String code_postal , String ville , String pays   ) {
            try {
                Connexion c = new Connexion();
                Connection laConnexion = c.creeConnexion();
                PreparedStatement requete = 
                        
                laConnexion.prepareStatement("insert into Client (nom, prenom, no_rue, voie, code_postal, ville, pays) values(?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
                requete.setString(1, nom);
                requete.setString(2, prenom);
                requete.setString(3, no_rue);
                requete.setString(4, voie);
                requete.setString(5, code_postal);
                requete.setString(6, ville);
                requete.setString(7, pays);
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
    
        
        //Modifier Client

        public void ClientModif(int id_client, String nom, String prenom , String no_rue , String voie , String code_postal , String ville , String pays) {
            try {
                Connexion c = new Connexion();
                Connection laConnexion = c.creeConnexion();
                PreparedStatement requete = 
                 
                	
                		
                laConnexion.prepareStatement("update Client set nom =?, prenom =?, no_rue =?, voie =?, code_postal=?, ville=?, pays=? where id_client =?");
                requete.setString(1, nom);
                requete.setString(2, prenom);
                requete.setString(3, no_rue);
                requete.setString(4, voie);
                requete.setString(5, code_postal);
                requete.setString(6, ville);
                requete.setString(7, pays);
                requete.setInt(8, id_client);
                
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
