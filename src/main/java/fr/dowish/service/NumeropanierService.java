package fr.dowish.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dowish.domain.Numeropanier;
import fr.dowish.repository.NumeropanierRepository;

@Service
public class NumeropanierService {
	
	@Autowired
	NumeropanierRepository numeropanierRepository; 
	
	public Numeropanier CreerNumeropanier(){
	   Numeropanier n = new Numeropanier();
	  return numeropanierRepository.save(n); 
		
	}
	
	

}
