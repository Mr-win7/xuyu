package net.bingyan.xuyu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.bingyan.xuyu.domain.Comment;
import net.bingyan.xuyu.domain.Moment;
import net.bingyan.xuyu.domain.User;
import net.bingyan.xuyu.domain.UserAgreeComment;
import net.bingyan.xuyu.domain.UserFavoriteComment;
import net.bingyan.xuyu.mapper.CommentMapper;
import net.bingyan.xuyu.mapper.UserAgreeCommentMapper;
import net.bingyan.xuyu.mapper.UserFavoriteCommentMapper;
import net.bingyan.xuyu.mapper.UtilMapper;

@Service
public class CommentService {

	@Autowired
	private CommentMapper commentMapper;

	@Autowired
	private UserFavoriteCommentMapper userFavoriteCommentMapper;

	@Autowired
	private UserAgreeCommentMapper userAgreeCommentMapper;

	@Autowired
	private UtilMapper utilMapper;

	public Comment getComment(Integer commentId) {
		return commentMapper.selectByPrimaryKey(commentId);
	}

	public void addComment(Comment comment) {
		commentMapper.insert(comment);
	}

	public void favoriteComment(User user, Comment comment) {
		UserFavoriteComment userFavoriteComment = new UserFavoriteComment();
		userFavoriteComment.setUserId(user.getUserId());
		userFavoriteComment.setCommentId(comment.getCommentId());
		userFavoriteCommentMapper.insert(userFavoriteComment);
	}

	public void undoFavoriteComment(User user, Comment comment) {
		userFavoriteCommentMapper.deleteByPrimaryKey(user.getUserId(), comment.getCommentId());
	}

	public void agreeComment(User user, Comment comment) {
		UserAgreeComment userAgreeComment = new UserAgreeComment();
		userAgreeComment.setUserId(user.getUserId());
		userAgreeComment.setCommentId(comment.getCommentId());
		userAgreeCommentMapper.insert(userAgreeComment);
	}

	public void undoAgreeComment(User user, Comment comment) {
		userAgreeCommentMapper.deleteByPrimaryKey(user.getUserId(), comment.getCommentId());
	}

	public List<Comment> getMomentComment(Moment moment) {
		return utilMapper.selectMomentComment(moment.getMomentId());
	}

	public List<Comment> getFavoriteComments(User user) {
		return utilMapper.selectUserFavoriteComments(user.getUserId());
	}

	public List<Comment> getPublishedComments(User user) {
		return utilMapper.selectUserPublishedComments(user.getUserId());
	}

	public Integer getAgreeSum(Comment comment) {
		return utilMapper.selectCountByCommentAgree(comment.getCommentId());
	}

	public Integer getFavoriteSum(Comment comment) {
		return utilMapper.selectCountByCommentFavorite(comment.getCommentId());
	}
}
