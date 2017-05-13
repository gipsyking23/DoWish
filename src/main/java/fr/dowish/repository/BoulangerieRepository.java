package fr.dowish.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.dowish.domain.Boulangerie;
@Repository
public interface BoulangerieRepository extends JpaRepository<Boulangerie, Long> {
	
	public  Boulangerie findByEmail(String email);


	
	
}
