package modele;

public class Revue {

	private int idRevue;
	private String titre;
	private String description;
	private float tarifNumero;
	private String visuel;
	private int idPeriodicite;

	public Revue(int idRevue, String titre, String description, float tarifNumero, String visuel, int idPeriodicite) {
		super();
		this.idRevue = idRevue;
		this.titre = titre;
		this.description = description;
		this.tarifNumero = tarifNumero;
		this.visuel = visuel;
		this.idPeriodicite = idPeriodicite;
	}
	
	public Revue(String titre, String description, float tarifNumero, String visuel, int idPeriodicite) {
		super();
		this.titre = titre;
		this.description = description;
		this.tarifNumero = tarifNumero;
		this.visuel = visuel;
		this.idPeriodicite = idPeriodicite;
	}

	public Revue() {}

	public Revue(int idRevue) {
		super();
		this.idRevue = idRevue;
	}

	public int getIdRevue() {
		return idRevue;
	}

	public void setIdRevue(int idRevue) {
		// pas de verification : obligatoirement un int, et en autoincrement
		this.idRevue = idRevue;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		// pas de verification : peut comporter des chiffres ( comme une date )
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		// pas de verification : peut comporter des chiffres ( comme une date )
		this.description = description;
	}

	public float getTarifNumero() {
		return tarifNumero;
	}

	public void setTarifNumero(float tarifNumero) {
		// pas de verification : obligatoirement un float
		this.tarifNumero = tarifNumero;
	}

	public String getVisuel() {
		return visuel;
	}

	public void setVisuel(String visuel) {
		// pas de verification : peut contenir des chiffres ( comme une date )
		this.visuel = visuel;
	}

	public int getIdPeriodicite() {
		return idPeriodicite;
	}

	public void setIdPeriodicite(int idPeriodicite) {
		// pas de verification : obligatoirement un int, et est une clé etrangère
		this.idPeriodicite = idPeriodicite;
	}

	@Override
	public String toString() {
		return "Revue [idRevue=" + idRevue + ", titre=" + titre + ", description=" + description + ", tarifNumero="
				+ tarifNumero + ", visuel=" + visuel + ", idPeriodicite=" + idPeriodicite + "]";
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
		if (idRevue != other.idRevue)
			return false;
		return true;
	}
	
	

}
