package fr.dowish.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.dowish.domain.Adresse;
import fr.dowish.service.AdresseService;

@RestController
@RequestMapping(value = "adresse")
public class AdresseController {

	@Autowired
	AdresseService adresseService;

	
//	CLIENT
	@GetMapping(value ="/boulangerie")//verifié
	public Adresse afficherAdresseBoulangerie(@RequestParam String emailboulangerie) {
		return adresseService.afficherAdresseBoulangerie(emailboulangerie);
	}

// BOULANGERIE
	@GetMapping(value ="/ajouter")//verifié
	 public Adresse AjouterAdresse(@RequestParam int numero, @RequestParam String rue, @RequestParam String ville, @RequestParam String codepostal, @RequestParam String emailboulangerie){
		return adresseService.AjouterAdresse(numero, rue, ville, codepostal, emailboulangerie);
	}
	
	@GetMapping(value ="/modifier")//verifié
	 public Adresse ModifierAdresse(@RequestParam int numero, @RequestParam String rue, @RequestParam String ville, @RequestParam String codepostal, @RequestParam String emailboulangerie){
		return adresseService.ModifierAdresse(numero, rue, ville, codepostal, emailboulangerie);
	}
	
}
