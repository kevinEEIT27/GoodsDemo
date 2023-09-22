package com.example.goodsdemo.user.service;


import com.example.goodsdemo.user.entity.User;

import java.util.List;


public interface UserService {
	User getUserByUserID(Long userID);

	User getUserByPassword(String password);

	User getUserByAccount(String account);

	User save(User user);

	List<User> fineAll();

	void deleteUserByPrimaryKey(Long id);

	Boolean mobileExists(String mobile);
}
