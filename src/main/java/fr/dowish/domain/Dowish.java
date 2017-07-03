package fr.dowish.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Dowish {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long iddowish; 
	
	private String nom;
	@NotNull               //étoile dans le nom pour le distinguer
	private Float prix;
	
	@OneToOne
	@JoinColumn(name="numerodowish_codebarre")
	private Numerodowish numerodowish;
	
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name = "composition", 
	    joinColumns = { @JoinColumn(name = "dowish_iddowish") }, 
	    inverseJoinColumns = { @JoinColumn(name = "ingredient_idingredient")} 
	           )
	private List<Ingredient> ingredients;
	
//	
//	@ManyToMany
//	@JoinTable(name = "panierdo", joinColumns = { @JoinColumn(name = "dowish_iddowish") }, inverseJoinColumns = {
//			@JoinColumn(name = "panier_idpanier")} )
	@ManyToMany(mappedBy="dowishs")
	private  List<Panier> paniers;
	
	public Dowish() {
		super();
	}
	
	public Dowish(String nom, Float prix, List<Ingredient> ingredients) {
		super();
		this.nom = nom;
		this.prix = prix;
		this.ingredients = ingredients;
	}
	@JsonIgnore
	public Long getIdDowish() {
		return iddowish;
	}
	public void setIdDowish(Long idDowish) {
		this.iddowish = idDowish;
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
	
	public Numerodowish getNumerodowish() {
		return numerodowish;
	}

	public void setNumerodowish(Numerodowish numerodowish) {
		this.numerodowish = numerodowish;
	}
	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
	

}
