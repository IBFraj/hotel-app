package com.tekup.hotel.hotel.dto;

import javax.validation.constraints.NotBlank;

public class LoginRequest {
    @NotBlank
    private String courriel;

    @NotBlank
    private String password;

    

    public String getCourriel() {
		return courriel;
	}

	public void setCourriel(String courriel) {
		this.courriel = courriel;
	}

	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}