package com.tekup.hotel.hotel.dto;


public class JwtResponseLogin {
	private String jwt;
    private ClientPrincipal user;
	public JwtResponseLogin(String jwttoken, ClientPrincipal user) {
		this.jwt = jwttoken;
		this.user = user;
	}

	public JwtResponseLogin(ClientPrincipal user) {
		this.user = user;
	}
	
	public ClientPrincipal getUser() {
		return user;
	}

	public void setUser(ClientPrincipal user) {
		this.user = user;
	}

	public String getJwttoken() {
		return jwt;
	}

	public JwtResponseLogin(String jwttoken) {
		this.jwt = jwttoken;
	}

	public String getToken() {
		return this.jwt;
	}
}
