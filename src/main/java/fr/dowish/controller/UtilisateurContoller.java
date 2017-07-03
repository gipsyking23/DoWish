package fr.dowish.controller;

import java.security.Principal;
import java.util.Collection;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class UtilisateurContoller {
	@GetMapping(value = "/nom")
	public String connecté(Principal principal) {
		return principal.getName();
	}

	@GetMapping(value = "/role")
	public int accès() {
		int résultat = 0;
		Collection<SimpleGrantedAuthority> autorities = (Collection<SimpleGrantedAuthority>) SecurityContextHolder
				.getContext().getAuthentication().getAuthorities();
		for (SimpleGrantedAuthority simpleGrantedAuthority : autorities) {
			if (simpleGrantedAuthority.getAuthority().equals("BOULANGER")) {
				résultat = 1;
			} else if (simpleGrantedAuthority.getAuthority().equals("CLIENT")) {
				résultat = 2;
			} else if (simpleGrantedAuthority.getAuthority().equals("ADMIN")) {
				résultat = 3;
			}

		}
		return résultat;

	}
}
