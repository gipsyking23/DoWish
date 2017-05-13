package fr.dowish.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dowish.domain.Client;
import fr.dowish.repository.ClientRepository;

@Service

public class ClientService {

	@Autowired
	ClientRepository clientRepository;

	public Client enregister(String nom,  String prenom, String email, String tel) {
		Client c = new Client();
		c.setNom(nom);
		c.setPrenom(prenom);
		c.setEmail(email);
		c.setTel(tel);
		return clientRepository.save(c);
	}
	
	
	public Client modifierEmail(String email, String nouveauemail) {
		
		Client c = new Client();
		c.setIdclient(clientRepository.findByEmail(email).getIdclient());
		c.setNom(clientRepository.findByEmail(email).getNom());
		c.setPrenom(clientRepository.findByEmail(email).getPrenom());
		c.setEmail(nouveauemail);
		c.setTel(clientRepository.findByEmail(email).getTel());
		return clientRepository.save(c);
	}
	
public Client modifierTel(String email, String nouveautel) {
		
		Client c = new Client();
		c.setIdclient(clientRepository.findByEmail(email).getIdclient());
		c.setNom(clientRepository.findByEmail(email).getNom());
		c.setPrenom(clientRepository.findByEmail(email).getPrenom());
		c.setEmail(email);
		c.setTel(nouveautel);
		return clientRepository.save(c);
	}

	public Client TrouverUnClient(String email) {
		return clientRepository.findByEmail(email);
	}
	
	
}
