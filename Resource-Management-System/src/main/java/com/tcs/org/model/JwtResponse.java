package com.tcs.org.model;

public class JwtResponse {

	 private String token;
	    private String type = "Bearer";
	    User userDtls;

		public User getUserDtls() {
			return userDtls;
		}

		public void setUserDtls(User userDtls) {
			this.userDtls = userDtls;
		}

		public JwtResponse(String accessToken,User userDtls) {
	        this.token = accessToken;
	        this.userDtls=userDtls;
	    }
	 
	    public String getAccessToken() {
	        return token;
	    }
	 
	    public void setAccessToken(String accessToken) {
	        this.token = accessToken;
	    }
	 
	    public String getTokenType() {
	        return type;
	    }
	 
	    public void setTokenType(String tokenType) {
	        this.type = tokenType;
	    }
}
