package fr.dowish.controller;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.dowish.domain.Planning;
import fr.dowish.service.PlanningService;

@RestController
public class PlanningController {

	@Autowired
	PlanningService planningService;

	// CLIENT
	@GetMapping(value = "Client/horaire") // vérifié
	public List<Planning> calendrier(@RequestParam String emailBoulangerie) {
		return planningService.calendrier(emailBoulangerie);
	}

	// BOUALANGERIE
	@PostMapping(value = "Boulangerie/horaire") // vérifié 
	public void faireAgenda(@RequestParam Date date, @RequestParam Time heureOuverture,
			@RequestParam Time heurefermeture, @RequestParam boolean fermée, @RequestParam String emailboulangerie,
			@RequestParam String jour) {
		planningService.faireAgenda(date, heureOuverture, heurefermeture, fermée, emailboulangerie, jour);
	}

	@PutMapping(value = "Boulangerie/horaire") // vérifié
	public void modification(@RequestParam Date date, @RequestParam Time heureOuverture,
			@RequestParam Time heurefermeture, @RequestParam boolean fermée, @RequestParam String emailboulangerie) {
		planningService.modifierHorraire(date, heureOuverture, heurefermeture, fermée, emailboulangerie);
	}
}
