package fr.dowish.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Sandwich {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idsandwich;
	@NotNull
	private String nom;
	private Float prix;

	@ManyToOne
	@JoinColumn(name = "boulangerie_idboulangerie")
	private Boulangerie boulangerie;

	@ManyToMany
	@JoinTable(name = "composant", joinColumns = { @JoinColumn(name = "sandwich_idsandwich") }, inverseJoinColumns = {
			@JoinColumn(name = "ingredient_idingredient") })
	private List<Ingredient> ingredients;

//	@ManyToMany
//	@JoinTable(name = "panierdo", joinColumns = { @JoinColumn(name = "dowish_iddowish") }, inverseJoinColumns = {
//			@JoinColumn(name = "panier_idpanier") })
	@ManyToMany(mappedBy="dowishs")
	private List<Panier> paniers;

	public Sandwich() {

	}

	public Sandwich(String nom, Float prix, Boulangerie boulangerie, List<Ingredient> ingredients) {
		super();
		this.nom = nom;
		this.prix = prix;
		this.boulangerie = boulangerie;
		this.ingredients = ingredients;
	}
	@JsonIgnore
	public Long getIdsandwich() {
		return idsandwich;
	}

	public void setIdsandwich(Long idsandwich) {
		this.idsandwich = idsandwich;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public float getPrix() {
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

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	@JsonIgnore
	public List<Panier> getPaniers() {
		return paniers;
	}

	public void setPaniers(List<Panier> paniers) {
		this.paniers = paniers;
	}

}
