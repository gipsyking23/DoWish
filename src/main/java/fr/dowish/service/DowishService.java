 package fr.dowish.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.dowish.domain.Dowish;
import fr.dowish.domain.Ingredient;
import fr.dowish.repository.DowishRepository;
import fr.dowish.repository.IngredientRepository;

@Service
public class DowishService {

	@Autowired
	DowishRepository dowishRepository;

	@Autowired
	IngredientRepository ingredientRepository;
	
	@Autowired
	NumerodowishService numerodowishService;
  
	public Dowish enregistrer(String nom, List<String> nomIngredients, String email) {
		float prixUnitaire = 0;
		List<Ingredient> ingredients = new ArrayList<>();

		for (String ingredient : nomIngredients) {
			ingredients.add(ingredientRepository.findByNomAndBoulangerieEmail(ingredient, email));
		}

		for (Ingredient ingredient : ingredients) {
			prixUnitaire += ingredient.getPrix();
		}

		float prix = prixUnitaire;
		Dowish d = new Dowish();
		d.setPrix(prix);
		d.setIngredients(ingredients);
		d.setNom(nom);
		d.setNumerodowish(numerodowishService.creerNumeroDowish());
		return dowishRepository.save(d);
	}

	@Transactional
	public void effacerUnDowish(Long numero) {
		dowishRepository.delete(dowishRepository.findByNumerodowishCodebarre(numero).getIdDowish());
	}


	
	public Dowish TrouverUnDowish(Long numero) {
		  return dowishRepository.findByNumerodowishCodebarre(numero);
		}
}
