package com.example.goodsdemo.user.service.Impl;

import com.example.goodsdemo.user.dao.UserRepository;
import com.example.goodsdemo.user.entity.User;
import com.example.goodsdemo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User getUserByUserID(Long userID) {
		return userRepository.findByUserID(userID);
	}

	@Override
	public User getUserByPassword(String password) {
		return userRepository.findByPassword(password);
	}

	@Override
	public User getUserByAccount(String account) {
		return userRepository.findByAccount(account);
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> fineAll() {
		return userRepository.findAll();
	}

	@Override
	public void deleteUserByPrimaryKey(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public Boolean mobileExists(String mobile) {
		return userRepository.existsByAccount(mobile);
	}
}
