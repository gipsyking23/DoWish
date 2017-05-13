package fr.dowish.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Adresse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private Long idadresse;
	 private int numero;
	 private String rue;
	 private String ville;
	 private String codepostal;
	 
	 @OneToOne
	 @JoinColumn(name="boulangerie_idboulangerie")
     private Boulangerie boulangerie;
	
	 
	 
	 

	public Adresse() {
		super();
	}
	
	public Adresse( int numero, String rue, String ville, String codepostal, Boulangerie boulangerie) {
		super();
		this.rue = rue;
		this.ville = ville;
		this.codepostal = codepostal;
		this.boulangerie = boulangerie;
		this.numero= numero;
	}
	@JsonIgnore
	public Long getIdadresse() {
		return idadresse;
	}
	public void setIdadresse(Long idadresse) {
		this.idadresse = idadresse;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getCodepostal() {
		return codepostal;
	}
	public void setCodepostal(String codepostal) {
		this.codepostal = codepostal;
	}
	
	@JsonIgnore
	public Boulangerie getBoulangerie() {
		return boulangerie;
	}
	public void setBoulangerie(Boulangerie boulangerie) {
		this.boulangerie = boulangerie;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	 
	 
	 
	 

}
