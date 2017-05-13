package fr.dowish.service;

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

	public Commande enregistrerCommande(String commentaire, String email, Long idpanier ) {
		Commande commande = new Commande();
		commande.setCommentaire(commentaire);
		commande.setStatut(satutRepository.findOne(1L));
		commande.setNumero(numeroService.creerNumeroCommande());
		commande.setBoulangerie(boulangerieRepository.findByEmail(email));
		commande.setPanier(panierRepository.findByIdpanier(idpanier));
	 return commandeRepository.save(commande); 
		
	}

	public List<Commande> afficherSesCommandes(String email) {
		return commandeRepository.AfficherSesCommandes(email);
	}

	public Commande recapituler(Long numero) {
		return commandeRepository.recapitulerCommande(numero);
	}

	
}
