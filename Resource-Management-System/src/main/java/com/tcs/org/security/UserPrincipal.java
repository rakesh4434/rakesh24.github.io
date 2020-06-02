package com.tcs.org.security;

import com.tcs.org.model.User;
import com.tcs.org.security.UserPrincipal;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Id;

public class UserPrincipal implements UserDetails {
@Id
	
	private int userId;
	@Column(unique=true)
	private String username;
	private String password;
	//@JsonIgnore
	private String textPassword;
	private String email;
	private String status;

    private Collection<? extends GrantedAuthority> authorities;

 
    public UserPrincipal(int userId, String username, String password, String textPassword, String email, String status,
			Collection<? extends GrantedAuthority> authorities) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.setTextPassword(textPassword);
		this.email = email;
		this.setStatus(status);
		this.authorities = authorities;
	}

	public static UserPrincipal create(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream().map(role ->
                new SimpleGrantedAuthority(role.getName())
        ).collect(Collectors.toList());

        return new UserPrincipal(
        		user.getUserId(),
        		user.getUsername(),
        		user.getPassword(),
        		user.getStatus(),
        		user.getTextPassword(),
        		user.getEmail(),

                authorities
        );
    }



    public String getEmail() {
        return email;
    }

    public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	
    public String getUsername() {
        return username;
    }

   
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPrincipal that = (UserPrincipal) o;
        return Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId);
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
}
