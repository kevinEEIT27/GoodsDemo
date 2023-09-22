package com.example.goodsdemo.login;

import com.example.goodsdemo.user.entity.User;
import com.example.goodsdemo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class UserIdentity {

	private final SpringUser EMPTY_USER = new SpringUser(new User());
	@Autowired
	private UserService userService;

	public SpringUser getSpringUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Object principal = authentication.getPrincipal();
		return principal.equals("anonymousUser")
			? EMPTY_USER
			: (SpringUser) principal;
	}

	public boolean isAnonymous() {
		return EMPTY_USER.equals(getSpringUser());
	}

	public Long getId() {
		return getSpringUser().getId();
	}

	public String getName() {
		return getSpringUser().getName();
	}

	public String getEmail() {
		return getSpringUser().getUsername();
	}
}
