package com.ipnetinstitute.csc394.backend.security;

import java.util.Set;

public class UserLogin {
    private String username;
	private String userpwd;
	private Set<String> roles;
	
	public UserLogin() {}
	public UserLogin(String username, String userpwd, Set<String> roles) {
		super();
		this.username = username;
		this.userpwd = userpwd;
		this.roles = roles;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
}