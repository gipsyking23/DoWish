package fr.dowish.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.dowish.domain.Sandwich;

@Repository
public interface SandwichRepository extends JpaRepository<Sandwich, Long> {

	

	public List<Sandwich> findByIngredientsNomAndBoulangerieEmail(String nom, String email);

	public List<Sandwich> findByBoulangerieEmail(String email);

	public void deleteByNomAndBoulangerieNom(String nom, String NomBoulangerie);

	public Sandwich findByNomAndBoulangerieEmail(String Nom, String emailboulangerie);

	public void deleteByNomAndBoulangerieEmail(String nom, String emailBoulangerie);
	
	
}

//@Query( value="select * from sandwich s right join boulangerie b on
	// s.boulangerie_idboulangerie = b.idboulangerie where b.nom = :nom",
	// nativeQuery= true)
	// public List<Sandwich> afficherLesSandwichParBoulangerie(@Param("nom")
	// String nom);

	// @Query (value="SELECT * from sandwich INNER JOIN composant ON
	// composant.sandwich_idsandwich = sandwich.idsandwich INNER JOIN ingredient
	// ON composant.ingredient_idingredient = ingredient.idingredient WHERE
	// ingredient.nom = :nom", nativeQuery= true)
	// public List<Sandwich> rechercheSandwichParIngredient(@Param("nom") String
	// nom);