package fr.dowish;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.dowish.domain.Boulangerie;
import fr.dowish.domain.Client;
import fr.dowish.domain.Commande;
import fr.dowish.repository.BoulangerieRepository;
import fr.dowish.repository.ClientRepository;
import fr.dowish.service.CommandeService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class DoWishApplicationTests {

	static Boulangerie boulangerie;
	static Client client;
	static Commande commande;

	@Autowired
	BoulangerieRepository boulangerieRepository;

	@Autowired
	ClientRepository clientRepository;

	@Autowired
	CommandeService commandeService;

	// Déclarations des objets et variable utilisés pour les tests
	@BeforeClass
	public static void initboulangerie() throws Exception {

		boulangerie = new Boulangerie();
	}

	@Test

	public void TrouverUneboulangerie() {
		boulangerie = boulangerieRepository.findByEmail("amiche@dowish.fr");
		assertEquals("06116127892", boulangerie.getTel());
	}

	@BeforeClass
	public static void initClient() throws Exception {

		client = new Client();
	}

	@Test
	@Rollback(true)
	public void testSaveOk() {

		client.setNom("pablo");
		client.setPrenom("picasso");
		client.setEmail("cubisme24@dowish.com");
		client.setTel("061234254");

		assertTrue(clientRepository.save(client) != null);
	}

	

}
