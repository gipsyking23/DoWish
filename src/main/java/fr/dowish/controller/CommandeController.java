package fr.dowish.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.dowish.domain.Commande;
import fr.dowish.service.CommandeService;

@RestController
public class CommandeController {

	@Autowired
	CommandeService commandeService;


	// CLIENT
	@PostMapping(value = "client/commande") // vérifié
	public Commande enregistrer(@RequestParam String commentaire, @RequestParam String email,
			@RequestParam Long référence) {
		return commandeService.enregistrerCommande(commentaire, email, référence);
	}

	@GetMapping(value = "client/commandes") // vérifié
	public List<Commande> afficherSesCommandes(@RequestParam String email) {
		return commandeService.afficherSesCommandes(email);
	}

	@GetMapping(value = "client/commande") // vérifié
	public Commande recapituler(@RequestParam Long numero) {
		return commandeService.recapituler(numero);
	}
	
	// BOULANGERIE
	@PutMapping(value = "boulangerie/commande/refusée") // vérifié
	public Commande refuser(@RequestParam String commentaire, @RequestParam Long numero) {
		return commandeService.refuserCommande(commentaire, numero);
	}

	@PutMapping(value = "boulangerie/commande/validée") // vérifié
	public Commande valider(@RequestParam Long numero) {
		return commandeService.modifierStatutValidée(numero);
	}

	@PutMapping(value = "boulangerie/commande/préparée") // vérifié
	public Commande préparer(@RequestParam Long numero) {
		return commandeService.modifierStatutPréparée(numero);
	}

	@PutMapping(value = "boulangerie/commande/soldée") // vérifié
	public Commande solder(@RequestParam Long numero) {
		return commandeService.modifierStatutSoldée(numero);
	}

	@PutMapping(value = "boulangerie/commande/archivée") // vérifié
	public Commande archiver(@RequestParam Long numero) {
		return commandeService.modifierStatutArchivée(numero);
	}

	@GetMapping(value = "boulangerie/commande/enattente") // vérifié
	public long CommandeEnAttente(@RequestParam String email) {
		return commandeService.CommpterCommandeEnAttente(email);
	}

	@GetMapping(value = "boulangerie/commande/validée") // vérifié
	public long CommandeValidée(@RequestParam String email) {
		return commandeService.CommpterCommandeValidé(email);
	}

	@GetMapping(value = "boulangerie/commande/préparée") // vérifié
	public long CommandePréparée(@RequestParam String email) {
		return commandeService.CommpterCommandePréparée(email);
	}

	@GetMapping(value = "boulangerie/commande/soldée") // vérifié
	public long CommandeSoldée(@RequestParam String email) {
		return commandeService.CommpterCommandeSoldée(email);
	}

	@GetMapping(value = "boulangerie/commandes") // vérifié
	public List<Commande> détailler(@RequestParam String email, @RequestParam String statut) {
		return commandeService.DetaillerCommandeParStatut(email, statut);
	}

	@GetMapping(value = "boulangerie/commande/dowish/ingredient") // vérifié
	public Long CompterCommandeParIngrédientEnAttenteDowish(@RequestParam String ingredient, @RequestParam String email, @RequestParam String statut) {
		return commandeService.CompterCommandeAvecIngrédientParSatutDowish(ingredient, email, statut);
	}
	@GetMapping(value = "boulangerie/commande/sandwich/ingredient") // vérifié
	public Long CompterCommandeParIngrédientEnAttenteSandwich(@RequestParam String ingredient, @RequestParam String email, @RequestParam String statut) {
		return commandeService. CompterCommandeAvecIngrédientParSatutSandwich(ingredient, email, statut);
	}
	@GetMapping(value = "boulangerie/commande/sandwich") // vérifié
	public Long CompterCommandeParSandwich(@RequestParam String sandwich, @RequestParam String email, @RequestParam String statut) {
		return commandeService. CompterCommandeAvecSandwichParSatut(sandwich, email, statut);
	}
}
