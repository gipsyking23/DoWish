package fr.dowish.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.dowish.domain.Ingredient;
import fr.dowish.domain.Sandwich;
import fr.dowish.repository.BoulangerieRepository;
import fr.dowish.repository.IngredientRepository;
import fr.dowish.repository.SandwichRepository;

@Service
public class SandwichService {

	@Autowired
	SandwichRepository sandwichRepository;

	@Autowired
	IngredientRepository ingredientRepository;
	
	@Autowired
	BoulangerieRepository boulangerieRepository;
	
	

	public List<Sandwich> afficherLesSandwichParBoulangerie(String emailboulangerie) {
		return sandwichRepository.findByBoulangerieEmail(emailboulangerie);

	}

	public List<Sandwich> rechercheSandwichParIngredient(String nom, String emailboulangerie) {
		return sandwichRepository.findByIngredientsNomAndBoulangerieEmail(nom, emailboulangerie);
	}

	public Sandwich enregistrer(String nom, List<String> nomIngredients, Float prix, String email ) {

		List<Ingredient> ingredients = new ArrayList<>();

		for (String ingredient : nomIngredients) {
			ingredients.add(ingredientRepository.findByNomAndBoulangerieEmail(ingredient, email));
		}

		Sandwich s = new Sandwich();
		s.setPrix(prix);
		s.setIngredients(ingredients);
		s.setBoulangerie(boulangerieRepository.findByEmail(email));
		s.setNom(nom);
		return sandwichRepository.save(s);
	}

	public void effacerUnsandwich(Long id) {
		sandwichRepository.delete(id);
	}
	@Transactional
	public void effacerApartirDuNom(String nom , String emailBoulangerie) {
		sandwichRepository.deleteByNomAndBoulangerieEmail(nom, emailBoulangerie);

	}

	public Sandwich modifierPrix(String nom, Float NouveauPrix, String emailBoulangerie) {

		Sandwich s = new Sandwich();
		s.setPrix(NouveauPrix);
		s.setIdsandwich(sandwichRepository.findByNomAndBoulangerieEmail(nom, emailBoulangerie).getIdsandwich());
		s.setNom(sandwichRepository.findByNomAndBoulangerieEmail(nom, emailBoulangerie).getNom());
		s.setBoulangerie(sandwichRepository.findByNomAndBoulangerieEmail(nom, emailBoulangerie).getBoulangerie());
		s.setIngredients(sandwichRepository.findByNomAndBoulangerieEmail(nom, emailBoulangerie).getIngredients());
		return sandwichRepository.save(s);

	}

	public Sandwich modifierNom(String nom, String nouveauNom, String emailBoulangerie ) {

		Sandwich s = new Sandwich();
		s.setNom(nouveauNom);
		s.setIdsandwich(sandwichRepository.findByNomAndBoulangerieEmail(nom, emailBoulangerie).getIdsandwich());
		s.setPrix(sandwichRepository.findByNomAndBoulangerieEmail(nom, emailBoulangerie).getPrix());
		s.setBoulangerie(sandwichRepository.findByNomAndBoulangerieEmail(nom, emailBoulangerie).getBoulangerie());
		s.setIngredients(sandwichRepository.findByNomAndBoulangerieEmail(nom, emailBoulangerie).getIngredients());
		return sandwichRepository.save(s);

	}

	public Sandwich modifierIngredients(String nom, List<String> nomIngredients, String emailboulangerie,  Float nouveauprix ) {

		Sandwich s = new Sandwich();
		List<Ingredient> ingredients = new ArrayList<>();

		for (String ingredient : nomIngredients) {
			ingredients.add(ingredientRepository.findByNomAndBoulangerieEmail(ingredient, emailboulangerie));
		}

		s.setIngredients(ingredients);
		s.setIdsandwich(sandwichRepository.findByNomAndBoulangerieEmail(nom, emailboulangerie).getIdsandwich());
		s.setPrix(nouveauprix);
		s.setNom(sandwichRepository.findByNomAndBoulangerieEmail(nom, emailboulangerie).getNom());
		s.setBoulangerie(sandwichRepository.findByNomAndBoulangerieEmail(nom, emailboulangerie).getBoulangerie());
		return sandwichRepository.save(s); 

	}

	public Sandwich TrouverParNom(String nom, String emailboulangerie) {
		return sandwichRepository.findByNomAndBoulangerieEmail(nom, emailboulangerie);
		
	}
}
