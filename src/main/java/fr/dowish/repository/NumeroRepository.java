package fr.dowish.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.dowish.domain.Numero;
@Repository
public interface NumeroRepository extends JpaRepository<Numero, Long> {
	
	
}
