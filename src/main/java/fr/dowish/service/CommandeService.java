package fr.dowish.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dowish.domain.Commande;
import fr.dowish.repository.BoulangerieRepository;
import fr.dowish.repository.CommandeRepository;
import fr.dowish.repository.PanierRepository;
import fr.dowish.repository.StatutRepository;

@Service
public class CommandeService {

	@Autowired
	CommandeRepository commandeRepository;

	@Autowired
	StatutRepository satutRepository;

	@Autowired
	NumeroService numeroService;

	@Autowired
	BoulangerieRepository boulangerieRepository;

	@Autowired
	PanierRepository panierRepository;

	public Commande enregistrerCommande(String commentaire, String email, Long référence) {
		Commande commande = new Commande();
		commande.setCommentaire(commentaire);
		commande.setStatut(satutRepository.findOne(1L));
		commande.setNumero(numeroService.creerNumeroCommande());
		commande.setBoulangerie(boulangerieRepository.findByEmail(email));
		commande.setPanier(panierRepository.findByNumeropanierRéférence(référence));
		return commandeRepository.save(commande);

	}

	public List<Commande> afficherSesCommandes(String email) {
		return commandeRepository.findByPanierClientEmail(email);
	}

	public Commande recapituler(Long numero) {
		return commandeRepository.findByNumeroNumero(numero);
	}

	public Commande refuserCommande(String commentaire, Long numero) {
		Commande commande = new Commande();
		commande.setIdcommande(commandeRepository.findByNumeroNumero(numero).getIdcommande());
		commande.setCommentaire(commentaire);
		commande.setDate(Timestamp.valueOf(commandeRepository.findByNumeroNumero(numero).getDate()));
		commande.setStatut(satutRepository.findOne(3L));
		commande.setNumero(commandeRepository.findByNumeroNumero(numero).getNumero());
		commande.setBoulangerie(commandeRepository.findByNumeroNumero(numero).getBoulangerie());
		commande.setPanier(commandeRepository.findByNumeroNumero(numero).getPanier());
		return commandeRepository.save(commande);
	}

	public Commande modifierStatutValidée(Long numero) {
		Commande commande = new Commande();
		Commande c = new Commande();
		c = commandeRepository.findByNumeroNumero(numero);
		commande.setDate(Timestamp.valueOf(c.getDate()));
		commande.setIdcommande(c.getIdcommande());
		commande.setCommentaire(c.getCommentaire());
		commande.setStatut(satutRepository.findOne(2L));
		commande.setNumero(c.getNumero());
		commande.setBoulangerie(c.getBoulangerie());
		commande.setPanier(c.getPanier());
		return commandeRepository.save(commande);
	}

	public Commande modifierStatutPréparée(Long numero) {
		Commande commande = new Commande();
		Commande c = new Commande();
		c = commandeRepository.findByNumeroNumero(numero);
		commande.setDate(Timestamp.valueOf(c.getDate()));
		commande.setIdcommande(c.getIdcommande());
		commande.setCommentaire(c.getCommentaire());
		commande.setStatut(satutRepository.findOne(4L));
		commande.setNumero(c.getNumero());
		commande.setBoulangerie(c.getBoulangerie());
		commande.setPanier(c.getPanier());
		return commandeRepository.save(commande);
	}

	public Commande modifierStatutSoldée(Long numero) {
		Commande commande = new Commande();
		Commande c = new Commande();
		c = commandeRepository.findByNumeroNumero(numero);
		commande.setDate(Timestamp.valueOf(c.getDate()));
		commande.setIdcommande(c.getIdcommande());
		commande.setCommentaire(c.getCommentaire());
		commande.setStatut(satutRepository.findOne(5L));
		commande.setNumero(c.getNumero());
		commande.setBoulangerie(c.getBoulangerie());
		commande.setPanier(c.getPanier());
		return commandeRepository.save(commande);
	}

	public Commande modifierStatutArchivée(Long numero) {
		Commande commande = new Commande();
		Commande c = new Commande();
		c = commandeRepository.findByNumeroNumero(numero);
		commande.setDate(Timestamp.valueOf(c.getDate()));
		commande.setIdcommande(c.getIdcommande());
		commande.setCommentaire(c.getCommentaire());
		commande.setStatut(satutRepository.findOne(6L));
		commande.setNumero(c.getNumero());
		commande.setBoulangerie(c.getBoulangerie());
		commande.setPanier(c.getPanier());
		return commandeRepository.save(commande);
	}

	public Long CommpterCommandeRefusée(String emailboulangerie) {
		return commandeRepository.countByStatutNomAndBoulangerieEmail("refusée", emailboulangerie);

	}

	public Long CommpterCommandeEnAttente(String emailboulangerie) {
		return commandeRepository.countByStatutNomAndBoulangerieEmail("en attente", emailboulangerie);

	}

	public Long CommpterCommandeValidé(String emailboulangerie) {
		return commandeRepository.countByStatutNomAndBoulangerieEmail("validée", emailboulangerie);

	}

	public Long CommpterCommandePréparée(String emailboulangerie) {
		return commandeRepository.countByStatutNomAndBoulangerieEmail("préparée", emailboulangerie);

	}

	public Long CommpterCommandeSoldée(String emailboulangerie) {
		return commandeRepository.countByStatutNomAndBoulangerieEmail("soldée", emailboulangerie);

	}

	public List<Commande> DetaillerCommandeParStatut(String email, String statut) {
		return commandeRepository
				.findByBoulangerieEmailAndStatutNomOrderByPanierDateretraitAscPanierHeureretraitAsc(email, statut);
	}

	public Commande DetaillerCommande(Long numéro) {
		return commandeRepository.findByNumeroNumero(numéro);
	}

	public Long CompterCommandeAvecIngrédientParSatutDowish(String ingredient, String email, String statut) {
		return commandeRepository.countByPanierDowishsIngredientsNomAndBoulangerieEmailAndStatutNom(ingredient, email, statut);
	}
	
	public Long CompterCommandeAvecIngrédientParSatutSandwich(String sandwich, String email, String statut) {
		return commandeRepository.countByPanierSandwichsIngredientsNomAndBoulangerieEmailAndStatutNom(sandwich, email, statut);
	}
	
	
	public Long CompterCommandeAvecSandwichParSatut(String sandwich, String email, String statut) {
		return commandeRepository.countByPanierSandwichsNomAndBoulangerieEmailAndStatutNom(sandwich, email, statut);
	}
}
