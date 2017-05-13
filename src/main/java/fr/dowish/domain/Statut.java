package fr.dowish.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Statut {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idstatut;
	private String nom;

	public Statut() {
		super();
	}

	public Statut(String nom) {
		super();
		this.nom = nom;
	}
	@JsonIgnore
	public long getIdstatut() {
		return idstatut;
	}

	public void setIdstatut(long idstatut) {
		this.idstatut = idstatut;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
