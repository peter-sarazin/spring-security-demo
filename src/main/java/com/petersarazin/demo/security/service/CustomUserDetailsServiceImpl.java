package com.petersarazin.demo.security.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.petersarazin.demo.security.entity.UserEntity;
import com.petersarazin.demo.security.entity.UserHasRole;
import com.petersarazin.demo.security.mapper.UserMapper;
import com.petersarazin.demo.security.repository.UserRepository;


@Service( "customUserDetailsService" )
@Transactional
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService
{

	@Autowired
	UserRepository userRepository;
	
	public UserDetails loadUserByUsername( String username ) throws UsernameNotFoundException
	{
		UserDetails userDetails = null;
		
		UserEntity userEntity = userRepository.findByUsername( username );
		
		if( userEntity == null )
		{
			throw new UsernameNotFoundException( username + " not found." );
		}
		
		List<UserHasRole> userHasRoleList = userEntity.getUserHasRoleList();
	
		List<GrantedAuthority> grantedAuthorityList = new ArrayList<GrantedAuthority>();
		
		for( UserHasRole userHasRole : userHasRoleList )
		{
			grantedAuthorityList.add( new SimpleGrantedAuthority( userHasRole.getPrimaryKey().getRole().getRolename() ) );
		}
		
		// map UserEntity to UserDetails implementation...
		userDetails = ( UserDetails ) UserMapper.map( userEntity, grantedAuthorityList );
		
		return userDetails;
	}
	
	public void persist( UserEntity userEntity )
	{
		userRepository.persist( userEntity );
	}

}
