package fr.dowish.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.dowish.domain.Boulangerie;
import fr.dowish.service.BoulangerieService;

@RestController
public class BoulangerieController {

	@Autowired
	BoulangerieService boulangerieService;

	//CLIENT
	@GetMapping(value="client/boulangeries")  //verifié
	public  List<Boulangerie> afficherListeBoulangerie(){
		return boulangerieService.afficherListeBoulangerie();
	}
	
	@GetMapping(value="client/boulangerie")  //verifié
	public  Boulangerie afficheBoulangerie(@RequestParam String email){
		return boulangerieService.afficher(email);
	}
	
	
	
	
	//ADIM
	@PostMapping(value="admin/boulangerie") //verifié
	public Boulangerie Ajouter(@RequestParam String nom,  @RequestParam String email, @RequestParam String tel){
		return boulangerieService.Ajouter(nom, email, tel);
	}
	
	@GetMapping(value="admin/boulangerie") //verifié
	public Boulangerie afficher(@RequestParam String email){
		return boulangerieService.afficher(email);
	}
	
	@PutMapping(value="admin/boulangerie/nom")  //verifié
	public Boulangerie modifierNom(@RequestParam String nom,@RequestParam String email,@RequestParam String nouveaunom){
		return boulangerieService.modifierNom(email,nouveaunom);
	}
	
	@PutMapping(value="admin/boulangerie/email")  //verifié
	public Boulangerie modifierMail(@RequestParam String email,@RequestParam String nouveauemail){
		return boulangerieService.modifierEmail(email,nouveauemail);		
	}
	
	@PutMapping(value="admin/boulangerie/tel")  //verifié
	public Boulangerie modifierTel(@RequestParam String email,@RequestParam String nouveautel){
		return boulangerieService.modifierTel(email,nouveautel); 
	}
	
	@GetMapping(value="admin/boulangerie/off") //???????
	public void effacer(@RequestParam String email){
		boulangerieService.effacer(email);
	
}
}