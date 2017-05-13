package fr.dowish.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.dowish.domain.Boulangerie;
import fr.dowish.service.BoulangerieService;

@RestController
@RequestMapping(value ="boulangerie")
public class BoulangerieController {

	@Autowired
	BoulangerieService boulangerieService;

	//CLIENT
	@GetMapping(value="client")  //verifié
	public  List<Boulangerie> afficherListeBoulangerie(){
		return boulangerieService.afficherListeBoulangerie();
	}
	
	//BOULANGERIE
	@GetMapping(value="ajouter") //verifié
	public Boulangerie Ajouter(@RequestParam String nom,  @RequestParam String email, @RequestParam String tel){
		return boulangerieService.Ajouter(nom, email, tel);
	}
	
	
	@GetMapping(value="modifier/nom")  //verifié
	public Boulangerie modifierNom(@RequestParam String nom,@RequestParam String email,@RequestParam String nouveaunom){
		return boulangerieService.modifierNom(email,nouveaunom);
	}
	
	@GetMapping(value="modifier/email")  //verifié
	public Boulangerie modifierMail(@RequestParam String email,@RequestParam String nouveauemail){
		return boulangerieService.modifierEmail(email,nouveauemail);		
	}
	
	@GetMapping(value="modifier/tel")  //verifié
	public Boulangerie modifierTel(@RequestParam String email,@RequestParam String nouveautel){
		return boulangerieService.modifierTel(email,nouveautel); 
	}
	
	
	
}
