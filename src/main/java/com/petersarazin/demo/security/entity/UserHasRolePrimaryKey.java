package com.petersarazin.demo.security.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class UserHasRolePrimaryKey implements Serializable
{
	private static final long serialVersionUID = 3860131076176148930L;

	@ManyToOne( cascade=CascadeType.ALL )
	@JoinColumn( name="userId" )
	private UserEntity user;

	@ManyToOne( cascade=CascadeType.ALL )
	@JoinColumn( name="roleId" )
	private Role role;

	public UserEntity getUser() { return user; }
	public void setUser( UserEntity user ) { this.user = user; }

	public Role getRole() { return role; }
	public void setRole( Role role ) { this.role = role; 	}
}
