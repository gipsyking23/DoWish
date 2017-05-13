package fr.dowish.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.dowish.domain.Ingredient;
import fr.dowish.service.IngredientService;

@RestController
@RequestMapping(value = "ingredient")
public class IngredientController {

	@Autowired
	IngredientService ingredientService;

	@GetMapping(value = "sandwich")//verifié
	public List<Ingredient> afficherLesIngredientsParSandiwch(@RequestParam String nom, @RequestParam String emailboulangerie) {
		return ingredientService.afficherLesIngredientsParSandiwch(nom, emailboulangerie );

	}

	@GetMapping(value = "dowish") //verifié
	public List<Ingredient> afficherLesIngredientsParDowish(@RequestParam Long numero) {
		return ingredientService.afficherLesIngredientsParDowish(numero);
	}

	@GetMapping(value = "boulangerie") //verifié
	public List<Ingredient> afficherLesIngredientsParBoulangerie(@RequestParam String email) {
		return ingredientService.afficherLesIngredientsParBoulangerie(email);
	}
	
	@GetMapping(value="boulangerie/ajouter") //verifié
	public Ingredient AjouterUnIngredient(@RequestParam String nom, @RequestParam Float prix,@RequestParam String email) {
		return ingredientService.AjouterUnIngredient(nom, prix, email);
	}
	
	
	@GetMapping(value="boulangerie/modifier/nom")//verifié
	public Ingredient  modifierNomIngredient(@RequestParam String nom, @RequestParam String email, @RequestParam String nouveaunom) {
		return ingredientService.modifierNomIngredient(nom, email, nouveaunom);
	
	}
	@GetMapping(value="boulangerie/modifier/prix")//verifié
	public Ingredient  modifierPrixIngredient(@RequestParam String nom, @RequestParam Float nouveauprix, @RequestParam String emailboulangerie) {
		return ingredientService.modifierPrixIngredient(nom, nouveauprix, emailboulangerie);
	
}
	@GetMapping(value="boulangerie/supprimer")//verifié mais casacade
	public void supprimerIngredient (@RequestParam String nom, @RequestParam String emailboulangerie){
	ingredientService.effaceringredient(nom, emailboulangerie);
	}
	
	
}