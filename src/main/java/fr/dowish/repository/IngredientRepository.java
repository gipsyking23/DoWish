package fr.dowish.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.dowish.domain.Ingredient;
@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

//	@Query( value=" SELECT * from ingredient INNER JOIN composant ON composant.ingredient_idingredient = ingredient.idingredient INNER JOIN sandwich ON composant.sandwich_idsandwich = sandwich.idsandwich WHERE sandwich.nom = :nom", nativeQuery= true)
//	 public List<Ingredient> afficherLesIngredientsParSandiwch(@Param("nom") String nom);
//	
//	@Query( value=" SELECT * FROM ingredient INNER JOIN composition ON composition.ingredient_idingredient = ingredient.idingredient INNER JOIN dowish ON composition.dowish_iddowish = dowish.iddowish WHERE dowish.nom = :nom", nativeQuery= true)
//	 public List<Ingredient> afficherLesIngredientsParDowish(@Param("nom") String nom);
//	
//	@Query(value="select * from ingredient  right join boulangerie on ingredient.boulangerie_idboulangerie = boulangerie.idboulangerie where boulangerie.nom = :nom", nativeQuery= true)
//	public List<Ingredient> afficherLesIngredientsParBoulangerie(@Param("nom") String nom);
	
	public List<Ingredient> findBySandwichsNomAndBoulangerieEmail(String nom, String email);
	public List<Ingredient> findByDowishsNumerodowishCodebarre(Long Numero);
	public List<Ingredient> findByBoulangerieEmail(String Email);
	
	public  Ingredient findByNomAndBoulangerieEmail (String nom, String email);
	public  Ingredient findByNom(String Nom); 
	public void deleteByNomAndBoulangerieEmail(String Nom, String email);
	

}

