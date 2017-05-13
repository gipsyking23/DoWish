package fr.dowish.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Numerodowish {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  Long codebarre;
	
	public Numerodowish() {
		super();
		
	}

	public Numerodowish(Long codebarre) {
		super();
		this.codebarre = codebarre;
	}

	public Long getCodebarre() {
		return codebarre;
	}

	public void setCodebarre(Long codebarre) {
		this.codebarre = codebarre;
	}
	
	
	

}
