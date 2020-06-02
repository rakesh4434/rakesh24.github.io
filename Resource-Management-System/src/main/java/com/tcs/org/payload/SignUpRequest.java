package com.tcs.org.payload;

import java.util.List;

import javax.validation.constraints.*;

import com.tcs.org.model.RoleName;

public class SignUpRequest {
   /* @NotBlank
    @Size(min = 4, max = 40)*/
    //private String name;
    private int userId;

  /*  @NotBlank
    @Size(min = 3, max = 15)*/
    private String username;
    private String textPassword;
   /* @NotBlank
    @Size(max = 40)*/
    @Email
    private String email;
    private String status;

   /* @NotBlank
    @Size(min = 6, max = 20)*/
    private String password;

    private List<RoleName> roleNames;
    
    
/*    public String getName() {
        return name;
    }*/
/*
    public void setName(String name) {
        this.name = name;
    }
*/
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getTextPassword() {
		return textPassword;
	}

	public void setTextPassword(String textPassword) {
		this.textPassword = textPassword;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<RoleName> getRoleNames() {
		return roleNames;
	}

	public void setRoleNames(List<RoleName> roleNames) {
		this.roleNames = roleNames;
	}
}