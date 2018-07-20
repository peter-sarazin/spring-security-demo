package com.petersarazin.demo.security.repository;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.petersarazin.demo.security.entity.UserEntity;

@Repository
public class UserRepositoryImpl extends GenericRepositoryImpl<UserEntity> implements UserRepository
{
	public UserEntity findByUsername( String username )
	{
		UserEntity userEntity = null;

		try
		{
			userEntity = ( UserEntity )em.createQuery( "select u from UserEntity u where u.username = :username" )
					.setParameter( "username", username )
					.getSingleResult();
		}
		catch( NoResultException nre )
		{
			System.out.println( "INFO: username " + username + " not found." );
		}
		catch( RuntimeException re )
		{
			String message = re.getClass().getSimpleName() + " caught in UserRepositoryImpl.findByUsername(): " + re.getMessage();
			System.err.println( message );
			throw re;
		}
		
		return userEntity;
	}
}
