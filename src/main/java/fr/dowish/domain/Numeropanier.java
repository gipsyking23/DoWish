package fr.dowish.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Numeropanier {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long référence;
	
	public Numeropanier() {
		super();
	}

	public Numeropanier(Long référence) {
		super();
		this.référence = référence;
	}

	public Long getRéférence() {
		return référence;
	}

	public void setRéférence(Long référence) {
		this.référence = référence;
	}

	
	
	
	
	
}
	
	