package fr.dowish.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.dowish.domain.Commande;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {
	
	public List<Commande> findByPanierClientEmailOrderByPanierDateretraitDesc(String email);	
	public Commande findByNumeroNumero(Long numero);
	public List<Commande> findByBoulangerieEmailAndStatutNomOrderByPanierDateretraitAscPanierHeureretraitAsc(String email, String statut); 
	public Long countByStatutNomAndBoulangerieEmail(String statut, String Email); 
	public Long countByPanierDowishsIngredientsNomAndBoulangerieEmailAndStatutNom(String ingredient, String email, String statut); 
	public Long countByPanierSandwichsIngredientsNomAndBoulangerieEmailAndStatutNom(String ingredient, String email, String statut); 
	public Long countByPanierSandwichsNomAndBoulangerieEmailAndStatutNom(String sandwich, String email, String statut); 
	
} 



//@Query(value="SELECT * from commande INNER JOIN  panier ON panier.idpanier = commande.panier_idpanier inner join client on panier.client_idclient = client.idclient where client.email= :email", nativeQuery= true)
//public List<Commande> AfficherSesCommandes(@Param("email") String email);
//
//@Query(value="SELECT * from commande inner join numero on commande.numero_numero = numero.numero where numero= :numero", nativeQuery= true)
//public Commande recapitulerCommande(@Param("numero") Long numero);
//

