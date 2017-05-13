package fr.dowish.domain;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Panier {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idpanier;
	private Date dateretrait;
	private Time heureretrait;
	private Float total;
	
	@OneToOne
	@JoinColumn(name="numeropanier_référence")
	private Numeropanier numeropanier;

	@OneToOne
	@JoinColumn(name="client_idclient")
	private Client client;
	
	@ManyToMany(mappedBy = "paniers")
	private List<Dowish> dowishs;
	
	@ManyToMany(mappedBy = "paniers")
	private List<Sandwich> sandwichs;
	
	public Panier() {
	
	}
	
	public Panier(Date dateretrait, Time heureretrait, Client client, List<Dowish> dowishs, List<Sandwich> sandwichs, Numeropanier numeropanier) {
		super();
		this.dateretrait = dateretrait;
		this.heureretrait = heureretrait;
		this.client = client;
		this.dowishs = dowishs;
		this.sandwichs = sandwichs;
		this.numeropanier=numeropanier;
	}



	@JsonIgnore
	public Long getIdpanier() {
		return idpanier;
	}
	public void setIdpanier(Long idpanier) {
		this.idpanier = idpanier;
	}
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<Dowish> getDowishs() {
		return dowishs;
	}
	public void setDowishs(List<Dowish> dowishs) {
		this.dowishs = dowishs;
	}
	public List<Sandwich> getSandwichs() {
		return sandwichs;
	}
	public void setSandwich(List<Sandwich> sandwichs) {
		this.sandwichs= sandwichs;
	
	}
	public Time getHeureretrait() {
		return heureretrait;
	}
	public void setHeureretrait(Time heureretrait) {
		this.heureretrait = heureretrait;
	}

	public Date getDateretrait() {
		return dateretrait;
	}

	public void setDateretrait(Date dateretrait) {
		this.dateretrait = dateretrait;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}
	
	public Numeropanier getNumeropanier() {
		return numeropanier;
	}

	public void setNumeropanier(Numeropanier numeropanier) {
		this.numeropanier = numeropanier;
	}

}
