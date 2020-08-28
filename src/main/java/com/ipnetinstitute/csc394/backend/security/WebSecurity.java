package com.ipnetinstitute.csc394.backend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.ipnetinstitute.csc394.backend.dao.UserEntityRepository;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private UserEntityRepository userRepo;

	@Value("${jwtSecret}")
	private String jwtSecret;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// configure CORS, authorize any post request to a list of endpoints
		http.cors().and().csrf().disable().authorizeRequests().antMatchers(HttpMethod.POST, "/users/save", "/users/login", "/users/logout", "/users/getByEmail/{mail}", "/roles/save", "/roles/all").permitAll()
				// any other request should be authenticated
				.anyRequest().authenticated().and()
				// add the filters to be used
				.addFilter(new JWTAuthenticationFilter(authenticationManager(), userRepo, jwtSecret))
				.addFilter(new JWTAuthorizationFilter(authenticationManager(), jwtSecret))
				// we don't want sessions for our application
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		// Add a filter to validate the tokens with every request
//				 httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
//		 http .csrf().disable() .authorizeRequests() .anyRequest().permitAll();
				
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// set the password encoder to be used
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
		return source;
	}
	@Bean
	public WebMvcConfigurer corsConfig() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**");
			}
		};
	}
}
