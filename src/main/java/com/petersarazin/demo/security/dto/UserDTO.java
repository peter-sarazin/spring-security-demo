package com.petersarazin.demo.security.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class UserDTO extends User
{
	
	private static final long serialVersionUID = -8782851212134554984L;

	public UserDTO(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}

	private Integer userId;
	private String emailAddress;
	
	public UserDTO( String username, String password, Collection<? extends GrantedAuthority> authorities )
	{
		super(username, password, authorities);
	}

	public Integer getUserId() { return userId; }
	public void setUserId(Integer userId) { this.userId = userId; }

	public String getEmailAddress() { return emailAddress; }
	public void setEmailAddress(String emailAddress) { this.emailAddress = emailAddress; }
}
