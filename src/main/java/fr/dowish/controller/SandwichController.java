package fr.dowish.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.dowish.domain.Sandwich;
import fr.dowish.service.SandwichService;

@RestController
@RequestMapping(value = "sandwich")
public class SandwichController {

	@Autowired
	SandwichService sandwichService;

	@GetMapping(value = "boulangerie")//verifié
	public List<Sandwich> afficherLesSandwichParBoulangerie(@RequestParam String emailboulangerie) {
		return sandwichService.afficherLesSandwichParBoulangerie(emailboulangerie);
	}

	@GetMapping(value = "ingredient")//verifié
	public List<Sandwich> rechercheSandwichParIngredient(@RequestParam String nom ,@RequestParam String emailboulangerie) {
		return sandwichService.rechercheSandwichParIngredient(nom, emailboulangerie);
	}

	@GetMapping(value = "boulangerie/ajouter")//verifié
	public Sandwich ajouter(@RequestParam String nom, @RequestParam float prix,
			@RequestParam(value = "ingredient") List<String> ingredients, @RequestParam String emailboulangerie) {
		return sandwichService.enregistrer(nom, ingredients, prix, emailboulangerie);
	}

	@GetMapping(value = "boulangerie/effacer")//vérifié
	public void effacerApartirDuNom(@RequestParam String nom, @RequestParam String emailboulangerie) {
		sandwichService.effacerApartirDuNom(nom, emailboulangerie);

	}
	
	@GetMapping(value = "boulangerie/modifier/prix")//verifié
	public Sandwich modifierPrix(@RequestParam String nom, @RequestParam float nouveauprix,@RequestParam String emailBoulangerie) {
		return sandwichService.modifierPrix(nom, nouveauprix, emailBoulangerie);
	}
	
	@GetMapping(value = "boulangerie/modifier/nom")//verifié
	public Sandwich modifierNom(@RequestParam String nom, @RequestParam String nouveaunom, @RequestParam String emailBoulangerie) {
		return sandwichService.modifierNom(nom, nouveaunom, emailBoulangerie);
	}
	
	
	@GetMapping(value = "boulangerie/modifier/ingredient")//verifié
	public Sandwich enregistrer(@RequestParam String nom, @RequestParam List<String> nomingredients,@RequestParam String emailBoulangerie, @RequestParam Float nouveauprix) {
		return sandwichService.modifierIngredients(nom, nomingredients, emailBoulangerie, nouveauprix);
	}
	
	
	
	
	
}
