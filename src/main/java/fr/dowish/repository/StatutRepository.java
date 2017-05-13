package fr.dowish.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.dowish.domain.Statut;
@Repository
public interface StatutRepository extends JpaRepository<Statut, Long> {

	
}
