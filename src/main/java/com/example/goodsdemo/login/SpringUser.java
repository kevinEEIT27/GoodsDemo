package com.example.goodsdemo.login;


import com.example.goodsdemo.user.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class SpringUser implements UserDetails {
	private User user;

	public SpringUser(User user) {
		this.user = user;
	}

	public Long getId() {
		return user.getUserID();
	}

	public String getName() {
		return user.getName();
	}

	public String getAccount() {
		return user.getAccount();
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getAccount();
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
}
