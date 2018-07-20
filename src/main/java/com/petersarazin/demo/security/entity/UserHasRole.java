package com.petersarazin.demo.security.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class UserHasRole
{
	@EmbeddedId
	private UserHasRolePrimaryKey primaryKey;

	public UserHasRolePrimaryKey getPrimaryKey() { return primaryKey; }
	public void setPrimaryKey( UserHasRolePrimaryKey primaryKey ) { this.primaryKey = primaryKey; }
}
