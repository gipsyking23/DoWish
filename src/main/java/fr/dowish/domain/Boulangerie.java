package fr.dowish.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Boulangerie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idboulangerie;
	private String nom;
	private String email;
	private String tel;

	
	@OneToMany(mappedBy = "boulangerie")
	private List<Sandwich> sandwichs;

	@OneToMany(mappedBy = "boulangerie")
	private List<Ingredient> ingredients;

	public Boulangerie() {
		super();
	}

	public Boulangerie(String nom, String email, String tel) {
		super();
		this.nom = nom;
		this.email = email;
		this.tel = tel;

	}
@JsonIgnore
	public Long getIdboulangerie() {
		return idboulangerie;
	}

	public void setIdboulangerie(Long idboulangerie) {
		this.idboulangerie = idboulangerie;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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

	@JsonIgnore
	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	@JsonIgnore
	public List<Sandwich> getSandwichs() {
		return sandwichs;
	}

	public void setSandwichs(List<Sandwich> sandwichs) {
		this.sandwichs = sandwichs;
	}

}
