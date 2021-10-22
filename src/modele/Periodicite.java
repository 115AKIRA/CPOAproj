package modele;

public class Periodicite {
	
	private int idPeriodicite;
	private String libelle;
	
	public Periodicite() {}
	
	public Periodicite(int idPeriodicite, String libelle) {
		super();
		this.idPeriodicite = idPeriodicite;
		this.libelle = libelle;
	}
	
	public Periodicite(String libelle) {
		super();
		this.libelle = libelle;
	}

	public Periodicite(int idPeriodicite) {
		super();
		this.idPeriodicite = idPeriodicite;
	}

	public int getIdPeriodicite() {
		return idPeriodicite;
	}

	public void setIdPeriodicite(int idPeriodicite) {
		this.idPeriodicite = idPeriodicite;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return "Periodicite [idPeriodicite=" + idPeriodicite + ", libelle=" + libelle + "]";
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
		if (idPeriodicite != other.idPeriodicite)
			return false;
		return true;
	}

}
