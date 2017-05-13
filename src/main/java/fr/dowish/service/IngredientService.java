package fr.dowish.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.dowish.domain.Ingredient;
import fr.dowish.repository.BoulangerieRepository;
import fr.dowish.repository.IngredientRepository;

@Service
public class IngredientService {

	@Autowired
	IngredientRepository ingredientRepository;

	@Autowired
	BoulangerieRepository boulangerieRepository;

	public List<Ingredient> afficherLesIngredientsParSandiwch(String nom, String email) {
		return ingredientRepository.findBySandwichsNomAndBoulangerieEmail( nom, email);

	}

	public List<Ingredient> afficherLesIngredientsParDowish(Long numero) {
		return ingredientRepository.findByDowishsNumerodowishCodebarre(numero);
	}

	public List<Ingredient> afficherLesIngredientsParBoulangerie(String email) {
		return ingredientRepository.findByBoulangerieEmail(email);
	}

	public Ingredient AjouterUnIngredient(String nom, Float prix, String email) {
		Ingredient i = new Ingredient();
		i.setNom(nom);
		i.setPrix(prix);
		i.setBoulangerie(boulangerieRepository.findByEmail(email));
		return ingredientRepository.save(i);
	}

	public Ingredient modifierNomIngredient(String nom, String email, String nouveauNom) {
		Ingredient i = new Ingredient();
		
		i.setIdingredient(ingredientRepository.findByNomAndBoulangerieEmail(nom, email).getIdingredient());
		i.setNom(nouveauNom);
		i.setPrix(ingredientRepository.findByNomAndBoulangerieEmail(nom, email).getPrix());
		i.setBoulangerie(boulangerieRepository.findByEmail(email));
		return ingredientRepository.save(i);
	}
	
	public Ingredient modifierPrixIngredient(String nom, Float nouveauPrix, String email) {
		Ingredient i = new Ingredient();
		
		i.setIdingredient(ingredientRepository.findByNomAndBoulangerieEmail(nom, email).getIdingredient());
		i.setNom(nom);
		i.setPrix(nouveauPrix);
		i.setBoulangerie(boulangerieRepository.findByEmail(email));
		return ingredientRepository.save(i);
	}
	@Transactional
	public void effaceringredient (String nom, String email){
		ingredientRepository.deleteByNomAndBoulangerieEmail(nom, email);
	}
	
	
	
}