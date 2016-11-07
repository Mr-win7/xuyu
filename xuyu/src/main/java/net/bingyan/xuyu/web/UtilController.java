package net.bingyan.xuyu.web;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value = "")
public class UtilController extends BaseController {

	@ResponseBody
	@RequestMapping(value = "/image")
	public String uploadImage(@RequestParam("photo") MultipartFile file) throws Exception {
		if (!file.isEmpty()) {
			String name = new SimpleDateFormat("yyyyMMddHHMMssSSS").format(new Date())
					+ (int) (Math.random() * 10000000);
			file.transferTo(new File("/home/wuwenqi/server/xuyu/image/" + name));
			return name;
		} else {
			// TODO
			throw new Exception();
		}

	}
}
