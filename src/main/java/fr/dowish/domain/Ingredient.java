package fr.dowish.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Ingredient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idingredient;
	@NotNull
	private String nom;
	@NotNull
	private Float prix;

	@ManyToOne
	@JoinColumn(name = "boulangerie_idboulangerie")
	private Boulangerie boulangerie;

	@ManyToMany(mappedBy = "ingredients")
	private List<Sandwich> sandwichs;

	@ManyToMany(mappedBy = "ingredients")
	private List<Dowish> dowishs;

	public Ingredient() {
		super();
	}

	public Ingredient(String nom, Float prix, Boulangerie boulangerie) {
		super();
		this.nom = nom;
		this.prix = prix;
		this.boulangerie = boulangerie;
	}

	@JsonIgnore
	public Long getIdingredient() {
		return idingredient;
	}

	public void setIdingredient(Long idingredient) {
		this.idingredient = idingredient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Float getPrix() {
		return prix;
	}

	public void setPrix(Float prix) {
		this.prix = prix;
	}

	@JsonIgnore
	public Boulangerie getBoulangerie() {
		return boulangerie;
	}

	public void setBoulangerie(Boulangerie boulangerie) {
		this.boulangerie = boulangerie;
	}

	@JsonIgnore
	public List<Sandwich> getSandwichs() {
		return sandwichs;
	}

	public void setSandwichs(List<Sandwich> sandwichs) {
		this.sandwichs = sandwichs;
	}

}