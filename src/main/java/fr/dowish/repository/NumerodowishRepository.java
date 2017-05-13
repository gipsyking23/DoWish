package fr.dowish.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.dowish.domain.Numerodowish;
@Repository
public interface NumerodowishRepository extends JpaRepository<Numerodowish, Long>{

}
