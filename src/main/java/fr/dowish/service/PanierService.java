package fr.dowish.service;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dowish.domain.Dowish;
import fr.dowish.domain.Panier;
import fr.dowish.domain.Sandwich;
import fr.dowish.repository.ClientRepository;
import fr.dowish.repository.DowishRepository;
import fr.dowish.repository.PanierRepository;
import fr.dowish.repository.SandwichRepository;

@Service
public class PanierService {
	@Autowired
	PanierRepository panierRepository;
	@Autowired
	SandwichRepository sandiwchRepository;
	@Autowired
	DowishRepository dowishRepository;
	@Autowired
	ClientRepository clientRepository;
	
	@Autowired 
	NumeropanierService numeropanierService;

	public Panier enregistrer(Date dateretrait, Time heureretrait, String emailclient, List<String> nomsandiwchs,
			List<Long> codeDowishs, String emailboulangerie) {

		float total = 0;

		float prixUnitaireDowish = 0;
		List<Dowish> dowishs = new ArrayList<>();

		for (Long codeBarre : codeDowishs) {
			dowishs.add(dowishRepository.findByNumerodowishCodebarre(codeBarre));
		}
		for (Dowish dowish : dowishs) {
			prixUnitaireDowish += dowish.getPrix();
		}

		float prixUnitaireSandwich = 0;
		List<Sandwich> sandiwchs = new ArrayList<>();

		for (String nom : nomsandiwchs) {
			sandiwchs.add(sandiwchRepository.findByNomAndBoulangerieEmail(nom, emailboulangerie ));
		}

		for (Sandwich sandwich : sandiwchs) {
			prixUnitaireSandwich += sandwich.getPrix();
		}

		total = prixUnitaireSandwich + prixUnitaireDowish;

		Panier p = new Panier();
		p.setNumeropanier(numeropanierService.CreerNumeropanier());
		p.setDateretrait(dateretrait);
		p.setHeureretrait(heureretrait);
		p.setTotal(total);
		p.setClient(clientRepository.findByEmail(emailclient));
		p.setDowishs(dowishs);
		p.setSandwich(sandiwchs);

		return panierRepository.save(p);
	}
	public Panier modifier(Long référence, Date dateretrait, Time heureretrait, List<String> nomsandiwchs,
			List<Long> codeDowishs, String emailboulangerie) {

		float total = 0;

		float prixUnitaireDowish = 0;
		List<Dowish> dowishs = new ArrayList<>();

		for (Long codeBarre : codeDowishs) {
			dowishs.add(dowishRepository.findByNumerodowishCodebarre(codeBarre));
		}
		for (Dowish dowish : dowishs) {
			prixUnitaireDowish += dowish.getPrix();
		}

		float prixUnitaireSandwich = 0;
		List<Sandwich> sandiwchs = new ArrayList<>();

		for (String nom : nomsandiwchs) {
			sandiwchs.add(sandiwchRepository.findByNomAndBoulangerieEmail(nom, emailboulangerie));
		}

		for (Sandwich sandwich : sandiwchs) {
			prixUnitaireSandwich += sandwich.getPrix();
		}

		total = prixUnitaireSandwich + prixUnitaireDowish;

		Panier p = new Panier();
		p.setIdpanier(panierRepository.findByNumeropanierRéférence(référence).getIdpanier());
		p.setNumeropanier(panierRepository.findByNumeropanierRéférence(référence).getNumeropanier());
		p.setDateretrait(dateretrait);
		p.setHeureretrait(heureretrait);
		p.setTotal(total);
		p.setClient(panierRepository.findByNumeropanierRéférence(référence).getClient());
		p.setDowishs(dowishs);
		p.setSandwich(sandiwchs);

		return panierRepository.save(p);
	}

	public Float afficherTotal(List<String> nomsandiwchs, List<Long> codedowishs, String emailboulangerie) {

		float total = 0;

		float prixUnitaireDowish = 0;
		List<Dowish> dowishs = new ArrayList<>();

		for (Long codeBarre : codedowishs) {
			dowishs.add(dowishRepository.findByNumerodowishCodebarre(codeBarre));
		}
		for (Dowish dowish : dowishs) {
			prixUnitaireDowish += dowish.getPrix();
		}

		float prixUnitaireSandwich = 0;
		List<Sandwich> sandiwchs = new ArrayList<>();

		for (String nom : nomsandiwchs) {
			sandiwchs.add(sandiwchRepository.findByNomAndBoulangerieEmail(nom, emailboulangerie));
		}

		for (Sandwich sandwich : sandiwchs) {
			prixUnitaireSandwich += sandwich.getPrix();
		}

		total = prixUnitaireSandwich + prixUnitaireDowish;
		return total;
	}

	public void effacer(Long id) {
		panierRepository.delete(id);

	}

	public Panier TrouverUnPanier(Long référence) {
		return panierRepository.findByNumeropanierRéférence(référence);

	}
}
