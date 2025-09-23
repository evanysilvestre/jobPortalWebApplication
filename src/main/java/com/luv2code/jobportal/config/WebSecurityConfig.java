package com.luv2code.jobportal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.luv2code.jobportal.services.CustomUserDetailsService;

@Configuration
public class WebSecurityConfig {

    private final AuthenticationProvider authenticationProvider;
    
    private final CustomUserDetailsService customUserDetailsService;
    
    @Autowired
	public WebSecurityConfig(AuthenticationProvider authenticationProvider,
			CustomUserDetailsService customUserDetailsService) {
		this.authenticationProvider = authenticationProvider;
		this.customUserDetailsService = customUserDetailsService;
	}

	private final String[] publicUrl = {"/",
            "/global-search/**",
            "/register",
            "/register/**",
            "/webjars/**",
            "/resources/**",
            "/assets/**",
            "/css/**",
            "/summernote/**",
            "/js/**",
            "/*.css",
            "/*.js",
            "/*.js.map",
            "/fonts**", "/favicon.ico", "/resources/**", "/error"};

    
	
	protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http.authenticationProvider(authenticationProvider());
		
		/**/
		http.authorizeHttpRequests(auth->{
			auth.requestMatchers(publicUrl).permitAll();
			auth.anyRequest().authenticated();
		});
		return http.build();
	}
	
	/*We use this to tell spring security how to find our users and also how to authenticate the passwords for the users.*/
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		authenticationProvider.setUserDetailsService(customUserDetailsService);
		return authenticationProvider;
	}
	
	/*This tells spring Security how to authenticate the passwords.  In our scenario, we'll actually use encryption. And so in order to use encryption and we make use of the Bcrypt encoder.*/
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
