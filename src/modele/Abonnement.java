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

	public int getIdAbonnement() {
		return idAbonnement;
	}

	public void setIdAbonnement(int idAbonnement) {
		this.idAbonnement = idAbonnement;
	}
	
	public Abonnement(int idRevue) {
		super();
		this.idRevue = idRevue;
	}

	public int getIdClient() {
		return idClient;
	}

	
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public int getIdRevue() {
		return idRevue;
	}

	public void setIdRevue(int idRevue) {
		this.idRevue = idRevue;
	}

	@Override
	public String toString() {
		return "Abonnement [idClient=" + idClient + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin
				+ ", idAbonnement=" + idAbonnement + ", idRevue=" + idRevue + "]";
	}

}
