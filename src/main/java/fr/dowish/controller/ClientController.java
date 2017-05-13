package fr.dowish.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.dowish.domain.Client;
import fr.dowish.service.ClientService;

@RestController
@RequestMapping(value = "client")
public class ClientController {

	@Autowired
	ClientService clientService;

	@GetMapping(value = "enregistrer") //verifié
	public  Client enregister(@RequestParam String nom, @RequestParam String prenom, @RequestParam String email, @RequestParam String tel ) {
		 return clientService.enregister(nom, prenom, email, tel);
	}

	@GetMapping(value = "modifier/email") //verifié
	public Client modifierEmail(@RequestParam String email,@RequestParam String nouveauemail) {
		return clientService.modifierEmail(email, nouveauemail);
	}

	@GetMapping(value = "modifier/tel") //verifié
	public Client modifierTel(@RequestParam String email, @RequestParam String nouveautel) {
		  return clientService.modifierTel(email, nouveautel);
	}
	@GetMapping(value = "trouver") //verifié
	public Client trouverUnClient(@RequestParam String email) {
		  return clientService.TrouverUnClient(email);
	}
	
	
}
 