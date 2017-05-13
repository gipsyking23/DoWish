package fr.dowish.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Jour {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idjour; 
	private  String nom;
	
	
	
	public Jour() {
		super();
	}

	public Jour(String nom) {
		
		this.nom = nom;
	}
	
	@JsonIgnore
	public Long getIdjour() {
		return idjour;
	}
	public void setIdjour(Long idjour) {
		this.idjour = idjour;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	

}
