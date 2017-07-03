package fr.dowish.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.dowish.domain.Admin;

public interface AdminRepository extends JpaRepository<Admin , Long> {
	
	public Admin findByEmail(String email); 

}
