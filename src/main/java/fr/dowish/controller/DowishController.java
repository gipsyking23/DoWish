package fr.dowish.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.dowish.domain.Dowish;
import fr.dowish.service.DowishService;

@RestController
public class DowishController {

	@Autowired
	DowishService dowishService;

	// CLIENT
	@PostMapping(value = "client/dowish") // verifié
	public Dowish creer(@RequestParam String nom, @RequestParam(value = "ingredient") List<String> ingredients,
			@RequestParam String emailboulangerie) {
		return dowishService.enregistrer(nom, ingredients, emailboulangerie);

	}

	@DeleteMapping(value = "client/dowish") // TODO
	public void effacerUnDowish(@RequestParam Long numero) {
		dowishService.effacerUnDowish(numero);
	}

	 @GetMapping(value = "client/dowish") //vérifié
	 public Dowish TrouverUnDowishParNom(@RequestParam Long numero) {
	 return dowishService.TrouverUnDowish(numero);
	 }

}
