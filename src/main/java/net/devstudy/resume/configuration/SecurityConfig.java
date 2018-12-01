package net.devstudy.resume.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import net.devstudy.resume.Constants;
import net.devstudy.resume.repository.storage.MongoPersistentTokenRepositoryAdapter;
import net.devstudy.resume.repository.storage.RememberMeTokenRepository;
import net.devstudy.resume.service.impl.RememberMeService;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private RememberMeTokenRepository rememberMeTokenRepository;
	
	@Autowired
	private RememberMeService persistentTokenRememberMeService;
	
	@Autowired
	private AccessDeniedHandler accessDeniedHandler;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/my-profile", "/edit", "/edit/**", "/remove").hasAuthority(Constants.USER)
			.anyRequest().permitAll(); 
		http.formLogin()
			.loginPage("/sign-in")
			.loginProcessingUrl("/sign-in-handler")
			.usernameParameter("uid")
			.passwordParameter("password")
			.defaultSuccessUrl("/my-profile")
			.failureUrl("/sign-in-failed");
		http.logout()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/welcome")
			.invalidateHttpSession(true)
			.deleteCookies("JSESSIONID");
		http.rememberMe()
			.rememberMeParameter("remember-me")
			.rememberMeServices(persistentTokenRememberMeService);
		http.exceptionHandling().accessDeniedHandler(accessDeniedHandler);
	}
	
	@Bean
	public PersistentTokenRepository persistentTokenRepository(){
		return new MongoPersistentTokenRepositoryAdapter(rememberMeTokenRepository);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
}
