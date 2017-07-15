package fr.dowish.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private RESTAuthenticationEntryPoint authenticationEntryPoint;
	@Autowired
	private RESTAuthenticationFailureHandler authenticationFailureHandler;
	@Autowired
	private RESTAuthenticationSuccessHandler authenticationSuccessHandler;
	@Autowired
	private RESTLogoutSuccessHandler logoutSuccessHandler;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin();
		http.csrf().disable().authorizeRequests()
				.antMatchers("/", "/new", "/index.html", "/about.html", "/formulaireClient.html").permitAll()
				.antMatchers("/admin/**").hasRole("ADMIN").antMatchers("client/**").hasRole("CLIENT")
				.antMatchers("/boulanger/**").hasRole("BOULANGER").anyRequest().authenticated();
		
		http.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint);
		http.formLogin().successHandler(authenticationSuccessHandler);
		http.formLogin().failureHandler(authenticationFailureHandler);
		http.logout().logoutSuccessHandler(logoutSuccessHandler);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/ressources/**", "static/**", "/javascript_boulangerie/**", "/javascript_client/**",
				"/image/**", "/css/**", "/fonts/**", "/js/**");
	}

}
