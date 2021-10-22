package modele;

import java.util.StringTokenizer;


public class Client {

	private int idClient;
	private String nom;
	private String prenom;
	private String noRue ;
	private String voie ;
	private String codePostal ;
	private String ville ;
	private String pays ;

	
	public Client() {};
	
    public Client(int idClient, String nom, String prenom, String noRue, String voie, String codePostal,
			String ville, String pays) {
		super();
		this.idClient = idClient;
		this.nom = nom;
		this.prenom = prenom;
		this.noRue = noRue;
		this.voie = voie;
		this.codePostal = codePostal;
		this.ville = ville;
		this.pays = pays;
	}
    
    public Client(String nom, String prenom, String noRue, String voie, String codePostal,
			String ville, String pays) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.noRue = noRue;
		this.voie = voie;
		this.codePostal = codePostal;
		this.ville = ville;
		this.pays = pays;
	}

	 
    public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		// pas de verification : obligatoirement un int, et en autoincrement
		this.idClient = idClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		if (nom.matches("[0-9]+")) {
			System.out.println("Le nom doit comporter uniquement des lettres !");
		} else {
		this.nom = nom;
		}
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNoRue() {
		return noRue;
	}

	public void setNoRue(String noRue) {
		this.noRue = noRue;
	}

	public String getVoie() {
		return voie;
	}

	public void setVoie(String voie) {
		
		if ( voie == null || voie.trim().length() == 0 || voie.trim().substring(0,1).matches("[a-zA-Z]")) {
			throw new IllegalArgumentException("Voie illégale !");
		}
		
		StringTokenizer st = new StringTokenizer((voie.trim().replaceFirst(" ", ", ")));
		voie = "";
		while (st.hasMoreTokens()) {
			String token = st.nextToken().toLowerCase();
			
			switch(token) {
	        case("boul"):
	        case("boul."):
	        case("bd"):
	            token = ("boulevard");
	            break;
	            case("av."):
	            case("av"):
	            	token = ("avenue");
	                break;
	            case("faub"):
	            case("fg"):
	            case("faub."):
	            	token = ("faubourg");
	                break;
	            case("pl."):
	            case("pl"):
	            	token = ("place");
			}
			
			voie = voie + token + ' ';
		
		}
		
		this.voie = voie;
		
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		
		if ( codePostal == null || codePostal.trim().length() == 0 || codePostal.matches("[a-zA-Z]+") ) {
			throw new IllegalArgumentException("Code postal illegal !");
		}
        
	    codePostal = codePostal.replaceAll("[a-zA-Z]", "").replaceAll("-", "");
	    
	    while (codePostal.length() < 5 ) {
	        codePostal =( "0"+ codePostal); 
	    }
		this.codePostal = codePostal;
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
					
					if ( token.matches("(?i)aux|le|sous|sur")) {
						token = ( '-' + token + '-' );
					} else if ( token.matches("(?i)les|lès|a|à")) {
						token = ( '-' + (token.replace("a", "à").replace("e", "é")) + '-' );
					} else if ( token.matches("(?i)st|ste|saint|sainte")) {
						if ( token.contains("e")) {
							token = ("-Sainte-");
						} else {
							token = ( "-Saint-");
						}
					} else {
						token = (token.substring(0,1).toUpperCase() + token.substring(1));
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
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {

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
	public String toString() {
		return "Client [idClient=" + idClient + ", nom=" + nom + ", prenom=" + prenom + ", noRue=" + noRue + ", voie="
				+ voie + ", codePostal=" + codePostal + ", ville=" + ville + ", pays=" + pays + "]";
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
		if (idClient != other.idClient)
			return false;
		return true;
	}
        
}
