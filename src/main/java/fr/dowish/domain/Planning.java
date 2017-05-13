package fr.dowish.domain;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Planning {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idplanning;
	private Date date;
	private Time ouverture;
	private Time fermeture;
	private Boolean fermée;

	@ManyToOne
	@JoinColumn(name = "jour_idjour")
	private Jour jour;
	
	@OneToOne
	@JoinColumn(name = "boulangerie_idboulangerie")
	private Boulangerie boulangerie;

	public Planning() {

	}

	public Planning(Date date, Time ouverture, Time fermeture, Boolean fermée, Jour jour, Boulangerie boulangerie) {
		super();
		this.date = date;
		this.ouverture = ouverture;
		this.fermeture = fermeture;
		this.fermée = fermée;
		this.jour = jour;
		this.setBoulangerie(boulangerie);
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getOuverture() {
		return ouverture;
	}

	public void setOuverture(Time ouverture) {
		this.ouverture = ouverture;
	}

	public Time getFermeture() {
		return fermeture;
	}

	public void setFermeture(Time fermeture) {
		this.fermeture = fermeture;
	}

	public Boolean getFermée() {
		return fermée;
	}

	public void setFermée(Boolean fermée) {
		this.fermée = fermée;
	}
	@JsonIgnore
	public Long getIdplanning() {
		return idplanning;
	}

	public void setIdplanning(Long idplanning) {
		this.idplanning = idplanning;
	}

	public Jour getJour() {
		return jour;
	}

	public void setJour(Jour jour) {
		this.jour = jour;
	}
	@JsonIgnore
	public Boulangerie getBoulangerie() {
		return boulangerie;
	}

	public void setBoulangerie(Boulangerie boulangerie) {
		this.boulangerie = boulangerie;
	}

}
