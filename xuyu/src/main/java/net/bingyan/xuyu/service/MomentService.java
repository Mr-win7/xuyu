package net.bingyan.xuyu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.bingyan.xuyu.domain.Moment;
import net.bingyan.xuyu.domain.User;
import net.bingyan.xuyu.domain.UserFavoriteMoment;
import net.bingyan.xuyu.mapper.MomentMapper;
import net.bingyan.xuyu.mapper.UserFavoriteMomentMapper;
import net.bingyan.xuyu.mapper.UtilMapper;

@Service
public class MomentService {

	@Autowired
	private MomentMapper momentMapper;

	@Autowired
	private UserFavoriteMomentMapper userFavoriteMomentMapper;

	@Autowired
	private UtilMapper utilMapper;

	public Moment getMoment(Integer momentId) {
		return momentMapper.selectByPrimaryKey(momentId);
	}

	public void addMoment(Moment moment) {
		momentMapper.insert(moment);
	}

	public void favoriteMoment(User user, Moment moment) {
		UserFavoriteMoment userFavoriteMoment = new UserFavoriteMoment();
		userFavoriteMoment.setUserId(user.getUserId());
		userFavoriteMoment.setMomentId(moment.getMomentId());
		userFavoriteMomentMapper.insert(userFavoriteMoment);
	}

	public void undoFavoriteMoment(User user, Moment moment) {
		userFavoriteMomentMapper.deleteByPrimaryKey(user.getUserId(), moment.getMomentId());
	}

	public List<Moment> searchMoment(String movie) {
		return utilMapper.selectMomentByMovie(movie);
	}

	public List<Moment> getFavoriteMoments(User user) {
		return utilMapper.selectUserFavoriteMoments(user.getUserId());
	}

	public List<Moment> getPublishedMoments(User user) {
		return utilMapper.selectUserPublishedMoments(user.getUserId());
	}

	public List<Moment> getHottestMoments() {
		return utilMapper.selectHottestMoments();
	}

	public List<Moment> getNewestMoments() {
		return utilMapper.selectNewestMoments();
	}

	public Integer getCommentSum(Moment moment) {
		return utilMapper.selectCountByMomentComment(moment.getMomentId());
	}

	public Integer getFavoriteSum(Moment moment) {
		return utilMapper.selectCountByMomentFavorite(moment.getMomentId());
	}
}
