package fr.dowish.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.dowish.domain.Client;
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

	public Client findByNom (String nom);
	public Client findByEmail(String email);
}
