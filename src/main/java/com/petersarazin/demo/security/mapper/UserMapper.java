package com.petersarazin.demo.security.mapper;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import com.petersarazin.demo.security.dto.UserDTO;
import com.petersarazin.demo.security.entity.UserEntity;

public class UserMapper
{
	public static UserDTO map( UserEntity userEntity, List<GrantedAuthority> grantedAuthorityList )
	{
		UserDTO userDto = null;
		
		if( userEntity == null )
		{
			throw new IllegalArgumentException( "userEntity cannot be null." );
		}
		
		userDto = new UserDTO( userEntity.getUsername(), userEntity.getPassword(), grantedAuthorityList );
		userDto.setUserId( userEntity.getUserId() );
		userDto.setEmailAddress( userEntity.getEmailAddress() );
		
		return userDto;
	}

	public static UserEntity map( UserDTO userDto )
	{
		UserEntity userEntity = null;
		
		if( userDto == null )
		{
			throw new IllegalArgumentException( "userDto cannot be null." );
		}
		
		userEntity = new UserEntity();
		userEntity.setUserId( userDto.getUserId() );
		userEntity.setUsername( userDto.getUsername() );
		userEntity.setEmailAddress( userDto.getEmailAddress() );
		
		return userEntity;
	}
	
}
