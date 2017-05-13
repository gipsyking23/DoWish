package fr.dowish.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.dowish.domain.Adresse;
@Repository
public interface AdresseRepository extends JpaRepository<Adresse, Long> {

	
//	@Query(value="select * from adresse a right join boulangerie b on a.boulangerie_idboulangerie = b.idboulangerie where b.nom = :nom", nativeQuery= true)
//	public Adresse afficherAdresseBoulangerie(@Param("nom") String nom);
	
	
	public Adresse findByBoulangerieEmail(String email); 
	
}
