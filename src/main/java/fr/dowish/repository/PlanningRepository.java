package fr.dowish.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.dowish.domain.Planning;
@Repository
public interface PlanningRepository extends JpaRepository<Planning, Long> {

//	@Query( value="select * from planning p inner join boulangerie b on p.boulangerie_idboulangerie = b.idboulangerie where b.nom = :nom order by p.date asc", nativeQuery= true)
//	 public List<Planning> afficherLePlanningParBoulangerie(@Param("nom") String nom);
	
	public List<Planning> findByBoulangerieEmailOrderByDateAsc(String emailBoulangerie); 
	
	public Planning findByDateAndBoulangerieEmail(Date date, String email);
	
}
	

