package com.example.goodsdemo.user.dao;

import com.example.goodsdemo.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface UserRepository extends JpaRepository<User, Long> {
	User findByUserID(Long userID);

	User findByAccount(String account);
	boolean existsByAccount(String account);
	User findByPassword(String password);

	@Override
	@RestResource(exported = false)
	void delete(User user);
}
