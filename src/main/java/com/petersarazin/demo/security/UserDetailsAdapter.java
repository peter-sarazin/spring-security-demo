package com.petersarazin.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.petersarazin.demo.security.service.CustomUserDetailsService;

@Component
public class UserDetailsAdapter implements UserDetailsService
{

	@Autowired
	CustomUserDetailsService customUserDetailService;
	
	@Override
	public UserDetails loadUserByUsername( String username ) throws UsernameNotFoundException
	{
		return customUserDetailService.loadUserByUsername( username );
	}

}
