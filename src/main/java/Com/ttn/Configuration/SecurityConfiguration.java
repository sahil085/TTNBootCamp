package Com.ttn.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("cutomeUserDetailsService")
	UserDetailsService userDetailsService;

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	  http.authorizeRequests()
	  	.antMatchers("/","resources/*").permitAll().
			  antMatchers("/contactpage").hasAuthority("USER").
			  and().formLogin().loginPage("/").loginProcessingUrl("/login").
			  usernameParameter("username").
			  passwordParameter("password").
			  defaultSuccessUrl("/contactpage")
			  .and().exceptionHandling().accessDeniedPage("/accessdeniedpage")
			  .and().
			  csrf().disable();

//		.antMatchers("/haarinaamAdminPage").access("hasRole('Harinaam Sankirtan')").
//		 antMatchers("/bookdistributionadminpage").access("hasRole('book distribution admin')").
//		 and().formLogin().loginPage("/loginProcess").defaultSuccessUrl("/contactpage")
//		.usernameParameter("email").passwordParameter("password")
//		.and().csrf().and().exceptionHandling().accessDeniedPage("/Access_Denied");


	}
}
