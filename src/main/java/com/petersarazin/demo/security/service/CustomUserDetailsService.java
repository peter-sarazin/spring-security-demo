package com.petersarazin.demo.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.petersarazin.demo.security.entity.UserEntity;

public interface CustomUserDetailsService
{
	UserDetails loadUserByUsername( String username ) throws UsernameNotFoundException;
	void persist( UserEntity userEntity );
}
