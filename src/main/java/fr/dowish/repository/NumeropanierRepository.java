package fr.dowish.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.dowish.domain.Numeropanier;
@Repository
public interface NumeropanierRepository extends JpaRepository<Numeropanier, Long> {
	
	

}
