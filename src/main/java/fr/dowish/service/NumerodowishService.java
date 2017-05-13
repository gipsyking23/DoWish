package fr.dowish.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dowish.domain.Numerodowish;
import fr.dowish.repository.NumerodowishRepository;
@Service
public class NumerodowishService {

	@Autowired
	NumerodowishRepository numerodowishRepository;
	
	public Numerodowish creerNumeroDowish(){
		Numerodowish n = new Numerodowish();
		 return numerodowishRepository.save(n);
		
	}
	
	
	}
	