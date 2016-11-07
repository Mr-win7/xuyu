package net.bingyan.xuyu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.bingyan.xuyu.domain.User;
import net.bingyan.xuyu.mapper.UserMapper;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	public void createUser(User user) {
		userMapper.insert(user);
	}

	public User getUser(Integer userId) {
		return userMapper.selectByPrimaryKey(userId);
	}

}
