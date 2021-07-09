package com.tekup.hotel.hotel.dto;


public class JwtAuthenticationResponse {
    private String accessToken;
    private String tokenType = "Bearer";
    private ClientPrincipal client;
    /*public User convertToUser(UserPrincipal userPrincipal) {
    	User user = new User (userPrincipal.getId(),userPrincipal.getFirstName()
    			,userPrincipal.getUsername(),userPrincipal.getEmail(),userPrincipal.getAuthorities());
    	return user;
    }*/
    public JwtAuthenticationResponse(String accessToken,ClientPrincipal user) {
        this.accessToken = accessToken;
        //this.user= convertToUser(user);
        this.client = user;
    }

    public ClientPrincipal getUserPrincipal() {
		return client;
	}

	public void setUserPrincipal(ClientPrincipal userPrincipal) {
		this.client = userPrincipal;
	}

	public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
}
