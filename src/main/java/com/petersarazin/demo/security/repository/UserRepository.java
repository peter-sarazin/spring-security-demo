package com.petersarazin.demo.security.repository;

import com.petersarazin.demo.security.entity.UserEntity;

public interface UserRepository extends GenericRepository<UserEntity>
{
	UserEntity findByUsername( String username );
}
