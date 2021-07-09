package com.tekup.hotel.hotel.dto;


public class JwtResponse {
	private static final long serialVersionUID = -8091879091924046844L;
	private String jwttoken;
    private ClientPrincipal user;
	public JwtResponse(String jwttoken, ClientPrincipal user) {
		this.jwttoken = jwttoken;
		this.user = user;
	}

	public JwtResponse(ClientPrincipal user) {
		this.user = user;
	}
	
	public ClientPrincipal getUser() {
		return user;
	}

	public void setUser(ClientPrincipal user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getJwttoken() {
		return jwttoken;
	}

	public JwtResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	public String getToken() {
		return this.jwttoken;
	}
}
