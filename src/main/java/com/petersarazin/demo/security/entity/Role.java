package com.petersarazin.demo.security.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Role
{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer roleId;
	
	private String rolename;
	
	@OneToMany( fetch=FetchType.LAZY, mappedBy="primaryKey.role" )
	private List<UserHasRole> userHasRoleList;

	public Integer getRoleId() { return roleId; }
	public void setRoleId( Integer roleId ) {	this.roleId = roleId; }

	public String getRolename() { return rolename; }
	public void setRolename( String rolename ) { this.rolename = rolename; }
	
	public List<UserHasRole> getUserHasRoleList() { return userHasRoleList; }
	public void setUserHasRoleList( List<UserHasRole > userHasRoleList) { this.userHasRoleList = userHasRoleList; }
}
