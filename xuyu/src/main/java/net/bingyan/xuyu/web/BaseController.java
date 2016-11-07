package net.bingyan.xuyu.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BaseController
{

	protected Map<String, Object> pack(Object object)
	{
		Map<String, Object> WebPackage = new HashMap<String, Object>();
		WebPackage.put("code", new Integer(0));
		WebPackage.put("msg", "成功");
		WebPackage.put("data", object);
		return WebPackage;

	}

	@ResponseBody
	@ExceptionHandler
	public Map<String, Object> exp(Exception exception)
	{
		Map<String, Object> map = new HashMap<>();
		map.put("code", new Integer(1));
		map.put("msg", exception.getMessage());
		exception.printStackTrace();
		return map;
	}

}
