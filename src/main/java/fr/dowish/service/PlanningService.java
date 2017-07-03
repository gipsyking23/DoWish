package fr.dowish.service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dowish.domain.Planning;
import fr.dowish.repository.BoulangerieRepository;
import fr.dowish.repository.JourRepository;
import fr.dowish.repository.PlanningRepository;

@Service
public class PlanningService {

	@Autowired
	PlanningRepository planningRepository;

	@Autowired
	BoulangerieRepository boulangerieRepository;

	@Autowired
	JourRepository JourRepository;

	public List<Planning> calendrier(String emailBoulangerie) {
		return planningRepository.findByBoulangerieEmail(emailBoulangerie);
	}

	public void faireAgenda(Date date, Time heureOuverture,
			Time heurefermeture, boolean fermée, String email,
			String jour) {

		Planning p = new Planning();
		p.setDate(date);
		p.setFermée(fermée);
		p.setBoulangerie(boulangerieRepository.findByEmail(email));
		p.setJour(JourRepository.findByNom(jour));

		if (fermée) {
			p.setFermeture(null);
			p.setOuverture(null);
		} else {
			p.setFermeture(heurefermeture);
			p.setOuverture(heureOuverture);

		}
		planningRepository.save(p);
	}

	public void modifierHorraire(Date date, Time heureOuverture, Time heurefermeture, boolean fermée, String email) {
		Planning p = new Planning();
		p.setIdplanning(planningRepository.findByDateAndBoulangerieEmail(date, email).getIdplanning());
		p.setFermée(fermée);
		p.setDate(date);
		p.setJour(planningRepository.findByDateAndBoulangerieEmail(date, email).getJour());
		p.setBoulangerie(boulangerieRepository.findByEmail(email));
		if (fermée) {
			p.setFermeture(null);
			p.setOuverture(null);
		} else {
			p.setFermeture(heurefermeture);
			p.setOuverture(heureOuverture);
		}
		planningRepository.save(p);
	}

}