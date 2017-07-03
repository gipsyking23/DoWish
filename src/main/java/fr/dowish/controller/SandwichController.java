package fr.dowish.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.dowish.domain.Sandwich;
import fr.dowish.service.SandwichService;

@RestController
public class SandwichController {

	@Autowired
	SandwichService sandwichService;

	// CLIENT
	@GetMapping(value = "client/sandwichs") // verifié
	public List<Sandwich> afficherLesSandwichParBoulangerie(@RequestParam String emailboulangerie) {
		return sandwichService.afficherLesSandwichParBoulangerie(emailboulangerie);
	}

	@GetMapping(value = "client/ingredient/sandwich") // verifié
	public List<Sandwich> rechercheSandwichParIngredient(@RequestParam String nom,
			@RequestParam String emailboulangerie) {
		return sandwichService.rechercheSandwichParIngredient(nom, emailboulangerie);
	}

	@GetMapping(value = "client/sandwich") // vérifié
	public Sandwich trouverUnSandwich(@RequestParam String nom, @RequestParam String emailboulangerie) {
		return sandwichService.TrouverParNom(nom, emailboulangerie);

	}

	// BOULANGERIE
	@PostMapping(value = "boulangerie/sandwich") // verifié
	public Sandwich ajouter(@RequestParam String nom, @RequestParam float prix,
			@RequestParam(value = "ingredient") List<String> ingredients, @RequestParam String emailboulangerie) {
		return sandwichService.enregistrer(nom, ingredients, prix, emailboulangerie);
	}

	@DeleteMapping(value = "boulangerie/sandwich") // vérifié
	public void effacerApartirDuNom(@RequestParam String nom, @RequestParam String emailboulangerie) {
		sandwichService.effacerApartirDuNom(nom, emailboulangerie);

	}

	@PutMapping(value = "boulangerie/sandwich/prix") // verifié
	public Sandwich modifierPrix(@RequestParam String nom, @RequestParam float nouveauprix,
			@RequestParam String emailBoulangerie) {
		return sandwichService.modifierPrix(nom, nouveauprix, emailBoulangerie);
	}

	@PutMapping(value = "boulangerie/sandwich/nom") // verifié
	public Sandwich modifierNom(@RequestParam String nom, @RequestParam String nouveaunom,
			@RequestParam String emailBoulangerie) {
		return sandwichService.modifierNom(nom, nouveaunom, emailBoulangerie);
	}

	@PutMapping(value = "boulangerie/sandwich/ingredient") // verifié
	public Sandwich enregistrer(@RequestParam String nom, @RequestParam List<String> nomingredients,
			@RequestParam String emailBoulangerie, @RequestParam Float nouveauprix) {
		return sandwichService.modifierIngredients(nom, nomingredients, emailBoulangerie, nouveauprix);
	}

	@GetMapping(value = "boulangerie/sandwichs") // verifié
	public List<Sandwich> afficherLesSandwichBoulangerie(@RequestParam String emailboulangerie) {
		return sandwichService.afficherLesSandwichParBoulangerie(emailboulangerie);
	}
}
