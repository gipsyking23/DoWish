package fr.dowish.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dowish.domain.Adresse;
import fr.dowish.repository.AdresseRepository;
import fr.dowish.repository.BoulangerieRepository;

@Service
public class AdresseService {

	@Autowired
	AdresseRepository adresseRepository;

	@Autowired
	BoulangerieRepository boulangerieRepository;

	// CLIENT
	public Adresse afficherAdresseBoulangerie(String email) {
		return adresseRepository.findByBoulangerieEmail(email);
	}

	// BOULANGERIE
	public Adresse AjouterAdresse(int numero, String rue, String ville, String codepostal, String emailboulangerie) {
		Adresse a = new Adresse();
		a.setNumero(numero);
		a.setRue(rue);
		a.setVille(ville);
		a.setCodepostal(codepostal);
		a.setBoulangerie(boulangerieRepository.findByEmail(emailboulangerie));
		return adresseRepository.save(a);
	}

	public Adresse ModifierAdresse(int numero, String rue, String ville, String codepostal, String emailboulangerie) {
		Adresse a = new Adresse();
		a.setIdadresse(boulangerieRepository.findByEmail(emailboulangerie).getIdboulangerie());
		a.setNumero(numero);
		a.setRue(rue);
		a.setVille(ville);
		a.setCodepostal(codepostal);
		a.setBoulangerie(boulangerieRepository.findByEmail(emailboulangerie));
		return adresseRepository.save(a);

	}

}
