package com.petersarazin.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration( "securityConfig" )
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{

	@Autowired
	UserDetailsAdapter customUserDetailsAdapter;
	
	protected void configure( HttpSecurity http ) throws Exception
	{
		http
			.formLogin()
				.loginPage( "/login" )
				.defaultSuccessUrl( "/userHome" )
				.permitAll()
				.and()
			.logout()
				.invalidateHttpSession(true)
				.logoutUrl("/logout")
				.logoutSuccessUrl( "/" )
				.logoutRequestMatcher( new AntPathRequestMatcher( "/logout" ) )
				.and()
			.httpBasic();

		http
			.authorizeRequests()
				.antMatchers( "/" ).permitAll()
				.antMatchers( "/error" ).permitAll()
				.antMatchers( "/login" ).permitAll()
				.antMatchers( "/registerNewUser" ).permitAll()
				.antMatchers( "/css/**" ).permitAll()
				.antMatchers( "/images/**" ).permitAll()					
				.anyRequest().authenticated();
	}

    @Autowired
	public void configureGlobal( AuthenticationManagerBuilder auth ) throws Exception
    {
    	try
    	{
 //       	auth.userDetailsService( customUserDetailsAdapter ).passwordEncoder( passwordEncoder() );
        	auth.userDetailsService( customUserDetailsAdapter );

    	}
    	catch( Exception e )
    	{
    		String message = e.getClass().getSimpleName() + "caught  and rethrown in configureGlobal(): " + e.getMessage();
    		System.err.println( message );
    		throw e;
    	}
	}
    
    @Bean
    public PasswordEncoder passwordEncoder() {
	        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	        return passwordEncoder;
    }
}
