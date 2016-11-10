package net.bingyan.xuyu.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.bingyan.xuyu.domain.User;
import net.bingyan.xuyu.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController
{

	@Autowired
	private UserService userService;

	@ResponseBody
	@RequestMapping(value = "/login")
	public Map<String, Object> login(@RequestBody Map<String, String> parameters) throws Exception
	{
		User user = userService.getUserByPhoneNumber(Long.valueOf(parameters.get("phoneNumber")));

		if (user == null)
		{
			throw new Exception("no such user!");
		}

		return pack(user);
	}

	@ResponseBody
	@RequestMapping(value = "/register")
	public Map<String, Object> register(@RequestBody User user) throws Exception
	{
		userService.createUser(user);
		return pack(user);
	}

	@ResponseBody
	@RequestMapping(value = "/{userID}")
	public Map<String, Object> profile(@PathVariable("userID") Integer userID) throws Exception
	{
		User profile = userService.getUser(userID);
		if (profile == null)
		{
			throw new Exception("no such user!");
		}
		return pack(profile);
	}
}
