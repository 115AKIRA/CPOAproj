package modele;

import java.time.*;

public class Abonnement {

	private int idClient;
	private LocalDate dateDebut;
	private LocalDate dateFin;
	private int idAbonnement;
	private int idRevue;

	public Abonnement(int idClient, LocalDate dateDebut, LocalDate dateFin, int idAbonnement, int idRevue) {
		super();
		this.idClient = idClient;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.idAbonnement = idAbonnement;
		this.idRevue = idRevue;
	}
	
	public Abonnement(LocalDate dateDebut, LocalDate dateFin, int idAbonnement, int idRevue) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.idAbonnement = idAbonnement;
		this.idRevue = idRevue;
	}

	public Abonnement() {}

	public Abonnement(int idAbonnement) {
		super();
		this.idAbonnement = idAbonnement;
	}

	public int getIdAbonnement() {
		return idAbonnement;
	}

	public void setIdAbonnement(int idAbonnement) {
		// pas de verification : obligatoirement un int, et tout inserts en autoincrements
		this.idAbonnement = idAbonnement;
	}
	
	public int getIdClient() {
		return idClient;
	}
	
	public void setIdClient(int idClient) {
		// pas de verification : obligatoirement un int, et tout est une clé étrangère
		this.idClient = idClient;
	}

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) throws DateTimeException {
		// pas de verification : on considère que l'on peut ajouter une date supérieure à la date courante
		this.dateDebut = dateDebut;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) throws DateTimeException {
		if ( dateFin.isBefore(this.dateDebut) || (this.dateDebut == null )) {
			System.out.println("Erreur ! Date de fin invalide !");
		}
		this.dateFin = dateFin;
	}

	public int getIdRevue() {
		return idRevue;
	}

	public void setIdRevue(int idRevue) {
		// pas de verification : obligatoirement un int, et est une clé étrangère
		this.idRevue = idRevue;
	}

	@Override
	public String toString() {
		return "Abonnement [idClient=" + idClient + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin
				+ ", idAbonnement=" + idAbonnement + ", idRevue=" + idRevue + "]";
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
		if (idAbonnement != other.idAbonnement)
			return false;
		return true;
	}
	

}
