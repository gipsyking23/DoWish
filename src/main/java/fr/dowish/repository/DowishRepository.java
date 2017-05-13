package fr.dowish.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.dowish.domain.Dowish;
@Repository
public interface DowishRepository extends JpaRepository<Dowish, Long> {

	  public Dowish findByNumerodowishCodebarre(Long numero);
	
	  public Dowish deleteByNumerodowishCodebarre(Long numero);
	
	

	
}
