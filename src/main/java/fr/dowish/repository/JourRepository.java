package fr.dowish.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.dowish.domain.Jour;
@Repository
public interface JourRepository extends JpaRepository<Jour, Long> {

	public Jour findByNom(String nom); 

}
