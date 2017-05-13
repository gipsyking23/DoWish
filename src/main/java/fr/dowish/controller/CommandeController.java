package fr.dowish.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.dowish.domain.Commande;
import fr.dowish.service.CommandeService;

@RestController
@RequestMapping(value = "commande")
public class CommandeController {

	@Autowired
	CommandeService commandeService;

	@GetMapping(value = "client/enregistrer")
	@ResponseBody
	public Commande enregistrer(@RequestParam String commentaire, @RequestParam String email, @RequestParam Long id) {
		 return commandeService.enregistrerCommande(commentaire, email, id); 

	}

	@GetMapping(value ="client/afficher")
	public List<Commande> afficherSesCommandes(@RequestParam String email) {
		return commandeService.afficherSesCommandes(email);
	}

	@GetMapping(value ="client/recapituler")
	public Commande recapituler(@RequestParam Long numero) {
		return commandeService.recapituler(numero);
	}

}
