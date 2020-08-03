package com.ipnetinstitute.csc394.backend.security;

public class JWTRequest {
    private String username;
	private String userpwd;
	
	public JWTRequest(){}
	public JWTRequest(String username, String userpwd) {
		super();
		this.username = username;
		this.userpwd = userpwd;
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
}