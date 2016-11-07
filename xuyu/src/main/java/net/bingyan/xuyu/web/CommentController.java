package net.bingyan.xuyu.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.bingyan.xuyu.domain.Comment;
import net.bingyan.xuyu.service.CommentService;
import net.bingyan.xuyu.service.MomentService;
import net.bingyan.xuyu.service.UserService;

@Controller
@RequestMapping(value = "/comment")
public class CommentController extends BaseController
{

	@Autowired
	private CommentService commentService;

	@Autowired
	private MomentService momentService;

	@Autowired
	private UserService userService;

	@ResponseBody
	@RequestMapping(value = "/{momentID}")
	public Map<String, Object> getAll(@PathVariable("momentID") Integer momentID)
	{
		List<Map<String, Object>> fullComments = new ArrayList<>();
		List<Comment> comments = commentService.getMomentComment(momentService.getMoment(momentID));
		Map<String, Object> fullComment;
		for (Comment comment : comments)
		{
			fullComment = new HashMap<>();
			fullComment.put("comment", comment);
			fullComment.put("agreeSum", commentService.getAgreeSum(comment));
			fullComment.put("favoriteSum", commentService.getFavoriteSum(comment));
			fullComments.add(fullComment);

		}
		return pack(fullComments);
	}

	@ResponseBody
	@RequestMapping(value = "/{userID}/{momentID}/add")
	public Map<String, Object> add(@PathVariable("momentID") Integer momentID, @PathVariable("userID") Integer userID,
			@RequestBody Comment comment)
	{
		comment.setWriter(userID);
		comment.setMomentId(momentID);
		comment.setTime(new Date());
		commentService.addComment(comment);
		return pack(null);
	}

	@ResponseBody
	@RequestMapping(value = "/{userID}/agree/{action}/{commentID}")
	public Map<String, Object> agree(@PathVariable("userID") Integer userID,
			@PathVariable("commentID") Integer commentID, @PathVariable("action") String action) throws Exception
	{
		if (action.equals("add"))
		{
			commentService.agreeComment(userService.getUser(userID), commentService.getComment(commentID));
		}
		else if (action.equals("remove"))
		{
			commentService.undoAgreeComment(userService.getUser(userID), commentService.getComment(commentID));
		}
		else
		{
			// TODO
			throw new Exception();
		}
		return pack(null);
	}

	@ResponseBody
	@RequestMapping(value = "/{userID}/favorite")
	public Map<String, Object> getFavorite(@PathVariable("userID") Integer userID)
	{
		List<Comment> comments = commentService.getFavoriteComments(userService.getUser(userID));
		return pack(comments);
	}

	@ResponseBody
	@RequestMapping(value = "/{userID}/favorite/{action}/{commentID}")
	public Map<String, Object> favorite(@PathVariable("userID") Integer userID, @PathVariable("action") String action,
			@PathVariable("commentID") Integer commentID) throws Exception
	{
		if (action.equals("add"))
		{
			commentService.favoriteComment(userService.getUser(userID), commentService.getComment(commentID));
		}
		else if (action.equals("remove"))
		{
			commentService.undoFavoriteComment(userService.getUser(userID), commentService.getComment(commentID));
		}
		else
		{
			// TODO
			throw new Exception();
		}
		return pack(null);
	}

}
