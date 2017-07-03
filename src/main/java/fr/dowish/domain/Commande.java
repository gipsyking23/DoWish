package fr.dowish.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Commande {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idcommande; 
	 
	@OneToOne
	@JoinColumn(name="numero_numero")
	private Numero numero;

	@CreationTimestamp
	private Timestamp date;
    
	private String commentaire;
	
	@OneToOne
	@JoinColumn(name="panier_idpanier")
	private Panier panier;

	@OneToOne
	@JoinColumn(name="boulangerie_idboulangerie")
	private Boulangerie boulangerie;
	
	@ManyToOne
	@JoinColumn(name="statut_idstatut")
	private Statut statut;
	
	
	
	
	
	public Commande() {
		
	}
	
	@JsonIgnore
	public Long getIdcommande() {
		return idcommande;
	}
	public void setIdcommande(Long idcommande) {
		this.idcommande = idcommande;
	}
	public String getDate() {
		return date.toString();
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public Panier getPanier() {
		return panier;
	}
	public void setPanier(Panier panier) {
		this.panier = panier;
	}


	public Boulangerie getBoulangerie() {
		return boulangerie;
	}


	public void setBoulangerie(Boulangerie boulangerie) {
		this.boulangerie = boulangerie;
	}

	public Numero getNumero() {
		return numero;
	}

	public void setNumero(Numero numero) {
		this.numero = numero;
	}


	public Statut getStatut() {
		return statut;
	}


	public void setStatut(Statut statut) {
		this.statut = statut;
	}
	
	
	
	
}
 