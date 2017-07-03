package fr.dowish.controller;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.dowish.domain.Panier;
import fr.dowish.service.PanierService;

@RestController
public class PanierController {
	

	@Autowired
	PanierService panierservice;
	
	//CLIENT

	@PostMapping(value = "client/panier")// verifié
	public Panier enregistrer(@RequestParam Date dateretrait, @RequestParam Time heureretrait,@RequestParam String emailclient, @RequestParam(value="sandwich")  List<String> sandwichs, @RequestParam(value="codedowish")  List<Long> codedowishs, @RequestParam String emailboulangerie){
		return panierservice.enregistrer(dateretrait, heureretrait, emailclient, sandwichs, codedowishs, emailboulangerie);

	}
	
	@PutMapping(value = "client/panier") //Todo
	public Panier enregistrer(@RequestParam Long référence, @RequestParam Date dateretrait, @RequestParam Time heureretrait, @RequestParam(value="sandwich")List<String> sandwichs, @RequestParam(value="codedowish")  List<Long> codedowishs, @RequestParam String emailboulangerie){
		return panierservice.modifier(référence, dateretrait, heureretrait, sandwichs, codedowishs, emailboulangerie);

	}

	@DeleteMapping(value = "client/panier")
	public void effacerUnPanier(@RequestParam Long référence) {
		panierservice.effacer(référence);

	}
	@GetMapping(value = "client/panier")
	public Panier TrouverUnPanier(@RequestParam Long référence) {
		return panierservice.TrouverUnPanier(référence);

	}
	
	
	@GetMapping(value = "client/total")
	public Float Totaldanspage (@RequestParam(value="sandiwch")  List<String> sandiwchs, @RequestParam(value="codedowish")  List<Long> codedowishs,@RequestParam String emailboulangerie){
		return panierservice.afficherTotal(sandiwchs, codedowishs, emailboulangerie);
	}
//	actualisation du prix en checkboxant
}



