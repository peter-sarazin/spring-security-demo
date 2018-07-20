package com.petersarazin.demo.security.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table( name="User" )
public class UserEntity implements Serializable
{
	private static final long serialVersionUID = 1134522155237755709L;

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer userId;
	
	private String username;
	
	private String password;

	@OneToMany( fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="primaryKey.user" )
	private List<UserHasRole> userHasRoleList;
	
	private short enabled;
	
	private String emailAddress;
	
	private boolean verified;

	public Integer getUserId() { return userId; }
	public void setUserId( Integer userId ) { this.userId = userId; }
	
	public String getUsername() { return username; }
	public void setUsername( String userName ) { this.username = userName; }

	public String getPassword() { return password; }
	public void setPassword( String password ) { this.password = password; }

	public short getEnabled() { return enabled; }
	public void setEnabled( short enabled ) { this.enabled = enabled; }
	
	public List<UserHasRole> getUserHasRoleList() { return userHasRoleList; }
	public void setUserHasRoleList( List<UserHasRole > userHasRoleList) { this.userHasRoleList = userHasRoleList; }
	
	public String getEmailAddress() { return emailAddress; }
	public void setEmailAddress( String emailAddress ) { this.emailAddress = emailAddress; }
	
	public boolean isVerified() { return verified; }
	public void setVerified( boolean verified ) { this.verified = verified; }
}
