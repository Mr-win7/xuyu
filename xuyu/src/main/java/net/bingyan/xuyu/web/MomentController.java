package net.bingyan.xuyu.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.bingyan.xuyu.domain.Moment;
import net.bingyan.xuyu.domain.MomentPhoto;
import net.bingyan.xuyu.domain.MomentWithPhotos;
import net.bingyan.xuyu.service.MomentService;
import net.bingyan.xuyu.service.UserService;
import net.bingyan.xuyu.service.UtilService;

@Controller
@RequestMapping(value = "/moment")
public class MomentController extends BaseController
{

	@Autowired
	private MomentService momentService;

	@Autowired
	private UtilService utilService;

	@Autowired
	private UserService userService;

	@ResponseBody
	@RequestMapping("/all/{mode}/{offset}")
	public Map<String, Object> getAll(@PathVariable("mode") String mode, @PathVariable("offset") Integer offset)
			throws Exception
	{
		List<Map<String, Object>> momentsWithPhotos = new ArrayList<>();
		Map<String, Object> momentWithPhotos;
		List<Moment> moments;
		if (mode.equals("hottest"))
		{
			moments = momentService.getHottestMoments();
		}
		else if (mode.equals("newest"))
		{
			moments = momentService.getNewestMoments();
		}
		else
		{
			throw new Exception("invalid mode!");
		}
		for (Moment moment : moments)
		{
			momentWithPhotos = new HashMap<>();
			momentWithPhotos.put("moment", moment);
			momentWithPhotos.put("photo", utilService.getMomentPhotos(moment).size() == 0 ? null
					: utilService.getMomentPhotos(moment).get(0));
			momentWithPhotos.put("commentSum", momentService.getCommentSum(moment));
			momentWithPhotos.put("favoriteSum", momentService.getFavoriteSum(moment));
			momentsWithPhotos.add(momentWithPhotos);
		}
		return pack(momentsWithPhotos);
	}

	@ResponseBody
	@RequestMapping("/{momentID}")
	public Map<String, Object> get(@PathVariable("momentID") Integer momentID)
	{
		Map<String, Object> momentWithPhotos = new HashMap<>();
		Moment moment = momentService.getMoment(momentID);
		List<MomentPhoto> photos = utilService.getMomentPhotos(moment);
		momentWithPhotos.put("moment", moment);
		momentWithPhotos.put("photos", photos);
		return pack(momentWithPhotos);
	}

	@ResponseBody
	@RequestMapping("/{userID}/favorite/{action}/{momentID}")
	public Map<String, Object> favorite(@PathVariable("userID") Integer userID, @PathVariable("action") String action,
			@PathVariable("momentID") Integer momentID) throws Exception
	{
		if (action.equals("add"))
		{
			momentService.favoriteMoment(userService.getUser(userID), momentService.getMoment(momentID));
		}
		else if (action.equals("remove"))
		{
			momentService.undoFavoriteMoment(userService.getUser(userID), momentService.getMoment(momentID));
		}
		else
		{
			throw new Exception("invalid action!");
		}
		return pack(null);
	}

	@ResponseBody
	@RequestMapping(value = "/{userId}/add")
	public Map<String, Object> add(@RequestBody MomentWithPhotos momentWithPhotos,
			@PathVariable(value = "userId") Integer userId)

	{
		Moment moment = momentWithPhotos.getMoment();
		moment.setUserId(userId);
		momentService.addMoment(moment);
		for (MomentPhoto momentPhoto : momentWithPhotos.getMomentPhotos())
		{
			momentPhoto.setMomentId(moment.getMomentId());
			utilService.addMomentPhotos(momentPhoto);
		}

		return pack(moment.getMomentId());
	}

	@ResponseBody
	@RequestMapping(value = "/published/{userId}")
	public Map<String, Object> published(@PathVariable("userId") Integer userId)
	{
		List<Map<String, Object>> momentsWithPhotos = new ArrayList<>();
		List<Moment> moments = momentService.getPublishedMoments(userService.getUser(userId));
		Map<String, Object> momentWithPhotos;
		for (Moment moment : moments)
		{
			momentWithPhotos = new HashMap<>();
			momentWithPhotos.put("moment", moment);
			momentWithPhotos.put("photo", utilService.getMomentPhotos(moment).size() == 0 ? null
					: utilService.getMomentPhotos(moment).get(0));
			momentWithPhotos.put("commentSum", momentService.getCommentSum(moment));
			momentWithPhotos.put("favoriteSum", momentService.getFavoriteSum(moment));
			momentsWithPhotos.add(momentWithPhotos);
		}
		return pack(momentsWithPhotos);
	}

	@ResponseBody
	@RequestMapping(value = "/favorite/{userId}")
	public Map<String, Object> getFavorite(@PathVariable("userId") Integer userId)
	{
		List<Moment> moments = momentService.getFavoriteMoments(userService.getUser(userId));
		return pack(moments);
	}
}
