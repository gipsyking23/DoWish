package fr.dowish.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.dowish.domain.Dowish;
import fr.dowish.service.DowishService;

@RestController
@RequestMapping(value="dowish")
public class DowishController {
	
	@Autowired
	DowishService dowishService;
	
	
	@GetMapping(value = "ajouter") //verifié
	public Dowish creer(@RequestParam String nom, @RequestParam(value="ingredient")  List<String> ingredients, @RequestParam String emailboulangerie) {
		return dowishService.enregistrer(nom, ingredients, emailboulangerie);

	}
	@GetMapping(value = "effacer/numero") //TODO
	public void effacerUnDowish(@RequestParam Long numero) {
		dowishService.effacerUnDowish(numero);
	}
	
	@GetMapping(value = "trouver/numero") //vérifié
	public Dowish TrouverUnDowishParNom(@RequestParam Long numero) {
		return dowishService.TrouverUnDowish(numero); 
}

}
