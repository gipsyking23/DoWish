package fr.dowish.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.dowish.domain.Panier;
@Repository
public interface PanierRepository extends JpaRepository<Panier, Long> {
	
	public Panier findByIdpanier(Long id);
	public Panier findByNumeropanierRéférence(Long référence);
	public void deleteByNumeropanierRéférence(Long référence); 

	 
}
