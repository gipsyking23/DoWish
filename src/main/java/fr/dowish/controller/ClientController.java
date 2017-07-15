package fr.dowish.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.dowish.domain.Client;
import fr.dowish.service.ClientService;

@RestController
public class ClientController {

	@Autowired
	ClientService clientService;

	@PostMapping(value = "new") //verifié
	public  Client enregister(@RequestParam String nom, @RequestParam String prenom, @RequestParam String email, @RequestParam String tel ) {
		 return clientService.enregister(nom, prenom, email, tel);
	}

	@PutMapping(value = "client/email") //verifié
	public Client modifierEmail(@RequestParam String email,@RequestParam String nouveauemail) {
		return clientService.modifierEmail(email, nouveauemail);
	}

	@PutMapping(value = "client/tel") //verifié
	public Client modifierTel(@RequestParam String email, @RequestParam String nouveautel) {
		  return clientService.modifierTel(email, nouveautel);
	}
	@GetMapping(value = "client") //verifié
	public Client trouverUnClient(@RequestParam String email) {
		  return clientService.TrouverUnClient(email);
	}
	
	@DeleteMapping(value = "client") //verifié
	public Client effacer(@RequestParam String email) {
		  return clientService.effacer(email);
	}
}
 