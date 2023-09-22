package com.example.goodsdemo.login;

import com.example.goodsdemo.user.entity.User;
import com.example.goodsdemo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class SpringUserService implements UserDetailsService {
	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {

		try {
			User user = userService.getUserByAccount(account);
			if (user == null) {
				throw new UsernameNotFoundException("password is wrong.");
			}
			return new SpringUser(user);
		} catch (Exception e) {
			throw new UsernameNotFoundException("Username is wrong.");
		}
	}
}