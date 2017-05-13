package fr.dowish.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dowish.domain.Numero;
import fr.dowish.repository.NumeroRepository;

@Service
public class NumeroService {
	
	@Autowired
	NumeroRepository numeroRepository;
	
	public Numero creerNumeroCommande(){
		Numero n = new Numero();
		 return numeroRepository.save(n);
		
	}
	
	
	}
	
	


