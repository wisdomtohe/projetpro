package com.ipnetinstitute.csc394.backend.security;

public class JWTResponse {
    private String token;
	public JWTResponse(String token) {
		this.token = token;
	}
	public String getToken() {
		return token;
	}
}