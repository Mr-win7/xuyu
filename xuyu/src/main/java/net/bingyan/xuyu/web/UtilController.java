package net.bingyan.xuyu.web;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UtilController extends BaseController
{

	@ResponseBody
	@RequestMapping(value = "/image")
	public Map<String, Object> uploadImage(@RequestParam("photo") MultipartFile file) throws Exception
	{
		if (!file.isEmpty())
		{
			String name = new SimpleDateFormat("yyyyMMddHHMMssSSS").format(new Date())
					+ (int) (Math.random() * 10000000);
			Path path = Paths.get(System.getProperty("user.home"), "server", "xuyu", "image", name);
			file.transferTo(new File(path.toUri()));
			return pack(name);
		}
		else
		{
			throw new Exception("empty file!");
		}

	}
}
