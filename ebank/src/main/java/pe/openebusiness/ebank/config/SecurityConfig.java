package pe.openebusiness.ebank.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.session.SessionManagementFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	@Qualifier("customUserDetailsService")
	UserDetailsService userDetailsService;

	@Autowired
	@Qualifier("customAuthSuccessHandler")
	AuthenticationSuccessHandler authenticationSuccessHandler;
	
	@Autowired
	@Qualifier("customAuthFailureHandler")
	AuthenticationFailureHandler authenticationFailureHandler;

	@Autowired
	@Qualifier("customLogoutSuccessHandler")
	LogoutSuccessHandler logoutSuccessHandler;
	
	@Autowired
	private CustomAuthenticationEntryPoint authenticationEntryPoint;
	
	@Bean
	AppCorsFilter corsFilter() {
		AppCorsFilter filter = new AppCorsFilter();
		return filter;
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.addFilterBefore(corsFilter(), SessionManagementFilter.class)
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/*").authenticated()
			.antMatchers("/test/user/get").hasRole("TEST")
			.antMatchers("/user/getProfile").hasRole("TEST")
			.antMatchers("/user/getUsers").hasRole("TEST")
			.antMatchers("/user/resetPassword").hasRole("TEST")
			.antMatchers("/user/getUserById").hasRole("TEST")
			.antMatchers("/navigation/getMenu").hasRole("TEST")
			.antMatchers("/user/saveImage").permitAll()
			.antMatchers("/user/saveImage").permitAll()
			.antMatchers("/user/changePassword").permitAll()
			.antMatchers("/client/findById/*").hasRole("TEST")
			.antMatchers("/client/getClientAddress/*").hasRole("TEST")
			.antMatchers("/client/getAllAddressType/*").hasRole("TEST")
			.antMatchers("/client/getClientContactInfo/*").hasRole("TEST")
			.antMatchers("/client/getAllHousingTypes/*").hasRole("TEST")
			.antMatchers("/client/getAllZoneTypes/*").hasRole("TEST")
			.antMatchers("/client/getAllRoadTypes/*").hasRole("TEST")
			.antMatchers("/client/getAllGroupTypes/*").hasRole("TEST")
			.antMatchers("/client/getAllSectorTypes/*").hasRole("TEST")
			.antMatchers("/client/getAllUbigeos/*").hasRole("TEST")
			.antMatchers("/client/searchUbigeos/*").hasRole("TEST")
			.antMatchers("/client/getAllPersonTypes/*").hasRole("TEST")
			.antMatchers("/client/getAllDocumentTypes/*").hasRole("TEST")
			.antMatchers("/client/getAllMagnitudes/*").hasRole("TEST")
			.antMatchers("/client/getAllActivities/*").hasRole("TEST")
			.antMatchers("/client/getAllGenders/*").hasRole("TEST")
			.antMatchers("/client/getAllCountries/*").hasRole("TEST")
			.antMatchers("/client/searchCountries/*").hasRole("TEST")
			.antMatchers("/client/getAllCivilStatus/*").hasRole("TEST")
			.antMatchers("/client/getAllSituations/*").hasRole("TEST")
			.antMatchers(HttpMethod.POST, "/client/editClient/*").hasRole("TEST")
			.antMatchers(HttpMethod.POST, "/client/editContactInfo/*").hasRole("TEST")
			.antMatchers(HttpMethod.OPTIONS).permitAll()
			.and()
			.formLogin().usernameParameter("username").passwordParameter("password").permitAll()
			.successHandler(authenticationSuccessHandler)
			.failureHandler(authenticationFailureHandler)
			.and()
			.logout().permitAll()
			.logoutSuccessHandler(logoutSuccessHandler)
			.and()
			.exceptionHandling()
			.authenticationEntryPoint(authenticationEntryPoint);
	}
	
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
		auth.authenticationProvider(authenticationProvider());
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(passwordEncoder());
		
		return provider;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationTrustResolver geAuthenticationTrustResolver() {
		return new AuthenticationTrustResolverImpl();
	}

}
