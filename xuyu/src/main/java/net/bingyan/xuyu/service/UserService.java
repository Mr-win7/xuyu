package net.bingyan.xuyu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.bingyan.xuyu.domain.User;
import net.bingyan.xuyu.mapper.UserMapper;
import net.bingyan.xuyu.mapper.UtilMapper;

@Service
public class UserService
{

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private UtilMapper utilMapper;

	public void createUser(User user)
	{
		userMapper.insert(user);
	}

	public User getUser(Integer userId)
	{
		return userMapper.selectByPrimaryKey(userId);
	}

	public User getUserByPhoneNumber(Long phoneNumber)
	{
		return utilMapper.selectUserByPhoneNumber(phoneNumber);
	}

}
