package fr.dowish.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.dowish.domain.Ingredient;
import fr.dowish.service.IngredientService;

@RestController
public class IngredientController {

	@Autowired
	IngredientService ingredientService;
	
	
	//CLIENT
	@GetMapping(value = "client/sandwich/ingredient")//verifié
	public List<Ingredient> afficherLesIngredientsParSandiwch(@RequestParam String nom, @RequestParam String emailboulangerie) {
		return ingredientService.afficherLesIngredientsParSandiwch(nom, emailboulangerie );

	}

	@GetMapping(value = "client/dowish/ingredient") //verifié
	public List<Ingredient> afficherLesIngredientsParDowish(@RequestParam Long numero) {
		return ingredientService.afficherLesIngredientsParDowish(numero);
	}

	@GetMapping(value = "client/boulangerie/ingredient") //verifié
	public List<Ingredient> afficherLesIngredientsParBoulangerie(@RequestParam String email) {
		return ingredientService.afficherLesIngredientsParBoulangerie(email);
	}
	
	//BOULANGERIE
	@PostMapping(value="boulangerie/ingredient") //verifié
	public Ingredient AjouterUnIngredient(@RequestParam String nom, @RequestParam Float prix,@RequestParam String email) {
		return ingredientService.AjouterUnIngredient(nom, prix, email);
	}
	
	
	@PutMapping(value="boulangerie/ingredient/nom")//verifié
	public Ingredient  modifierNomIngredient(@RequestParam String nom, @RequestParam String email, @RequestParam String nouveaunom) {
		return ingredientService.modifierNomIngredient(nom, email, nouveaunom);
	
	}
	@PutMapping(value="boulangerie/ingredient/prix")//verifié
	public Ingredient  modifierPrixIngredient(@RequestParam String nom, @RequestParam Float nouveauprix, @RequestParam String emailboulangerie) {
		return ingredientService.modifierPrixIngredient(nom, nouveauprix, emailboulangerie);
	
}
	@DeleteMapping(value="boulangerie/ingredient")//verifié mais casacade
	public void supprimerIngredient (@RequestParam String nom, @RequestParam String emailboulangerie){
	ingredientService.effaceringredient(nom, emailboulangerie);
	}
	@GetMapping(value = "boulangerie/ingredient") //verifié
	public List<Ingredient> afficherLesIngredientsBoulangerie(@RequestParam String email) {
		return ingredientService.afficherLesIngredientsParBoulangerie(email);
	}
	
}