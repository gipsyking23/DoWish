package fr.dowish.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;



/**
 * Classe de gestion de client
 * @author Tabouré cheick
 * @version 0.1
 */

@Entity

public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idclient;
	@NotNull
	private String nom;
	@NotNull
	private String prenom;
	@NotNull
	private String email;
	@NotNull
	private String tel;


	public Client() {
		super();
	}
	
	public Client(String nom, String prenom, String email, String tel) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.tel = tel;
	}
	@JsonIgnore
	public Long getIdclient() {
		return idclient;
	}
	public void setIdclient(Long idclient) {
		this.idclient = idclient;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	
	
	
}
	
	
	
	
