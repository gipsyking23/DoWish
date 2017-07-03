package fr.dowish.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import fr.dowish.domain.Admin;
import fr.dowish.domain.Boulangerie;
import fr.dowish.domain.Client;
import fr.dowish.repository.AdminRepository;
import fr.dowish.repository.BoulangerieRepository;
import fr.dowish.repository.ClientRepository;

@Configuration
public class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {

	@Autowired
	private BoulangerieRepository booulangerieRepository;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private AdminRepository adminRepository;

	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService());
	}

	@Bean
	UserDetailsService userDetailsService() {
		return new UserDetailsService() {

			@Override
			@Transactional
			public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
				Boulangerie boulangerie = booulangerieRepository.findByEmail(email);
				Client client = clientRepository.findByEmail(email);
				Admin admin = adminRepository.findByEmail(email);
				if (boulangerie != null) {

					return new User(boulangerie.getEmail(), boulangerie.getTel(), true, true, true, true,
							AuthorityUtils.createAuthorityList("BOULANGER"));
				} else if (client != null) {
 
					return new User(client.getEmail(), client.getTel(), true, true, true, true,
							AuthorityUtils.createAuthorityList("CLIENT"));

				} else if (admin != null) {

					return new User(admin.getEmail(), admin.getTel(), true, true, true, true,
							AuthorityUtils.createAuthorityList("ADMIN"));
				}

				else {

					throw new UsernameNotFoundException(email + " non trouvé.");
				}
			}
		};
	}

}
