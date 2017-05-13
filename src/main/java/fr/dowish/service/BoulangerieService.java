package fr.dowish.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dowish.domain.Boulangerie;
import fr.dowish.repository.BoulangerieRepository;

@Service

public class BoulangerieService {
	
	@Autowired
	BoulangerieRepository boulangerieRepository; 
	
	public  List<Boulangerie> afficherListeBoulangerie(){
		return boulangerieRepository.findAll();
	}
	
	public Boulangerie Ajouter(String nom, String email, String tel){
		Boulangerie b = new Boulangerie();
		b.setEmail(email);
		b.setNom(nom);
		b.setTel(tel);
		return boulangerieRepository.save(b) ;
	}
	
	public Boulangerie modifierNom(String email, String nouveaunom){
		Boulangerie b = new Boulangerie();
		b.setIdboulangerie(boulangerieRepository.findByEmail(email).getIdboulangerie());
		b.setEmail(email);
		b.setNom(nouveaunom);
		b.setTel(boulangerieRepository.findByEmail(email).getTel());
		return boulangerieRepository.save(b);
	}
	
	public Boulangerie modifierEmail(String email, String nouveauemail){
		Boulangerie b = new Boulangerie();
		b.setIdboulangerie(boulangerieRepository.findByEmail(email).getIdboulangerie());
		b.setEmail(nouveauemail);
		b.setNom(boulangerieRepository.findByEmail(email).getNom());
		b.setTel(boulangerieRepository.findByEmail(email).getTel());
		return boulangerieRepository.save(b) ;
	}
	
	public Boulangerie modifierTel(String email, String nouveautel){
		Boulangerie b = new Boulangerie();
		b.setIdboulangerie(boulangerieRepository.findByEmail(email).getIdboulangerie());
		b.setEmail(email);
		b.setNom(boulangerieRepository.findByEmail(email).getNom());
		b.setTel(nouveautel);
		return boulangerieRepository.save(b);
	}
	
}
