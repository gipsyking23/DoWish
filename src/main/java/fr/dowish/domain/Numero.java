package fr.dowish.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Numero {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  long numero;

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	
	public Numero(int numero) {
		super();
		this.numero = numero;
	}

	
	public Numero() {
		super();
	}
	
	

}
