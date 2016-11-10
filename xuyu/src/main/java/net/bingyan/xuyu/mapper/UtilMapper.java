package net.bingyan.xuyu.mapper;

import java.util.List;

import net.bingyan.xuyu.domain.Comment;
import net.bingyan.xuyu.domain.Moment;
import net.bingyan.xuyu.domain.MomentPhoto;
import net.bingyan.xuyu.domain.User;

public interface UtilMapper
{

	Integer selectCountByCommentAgree(Integer commentId);

	Integer selectCountByCommentFavorite(Integer commentId);

	List<Moment> selectHottestMoments();

	List<Moment> selectNewestMoments();

	Integer selectCountByMomentComment(Integer momentId);

	Integer selectCountByMomentFavorite(Integer momentId);

	List<Moment> selectMomentByMovie(String movie);

	List<Comment> selectMomentComment(Integer momentId);

	List<Moment> selectUserFavoriteMoments(Integer userId);

	List<Comment> selectUserFavoriteComments(Integer userId);

	List<Moment> selectUserPublishedMoments(Integer userId);

	List<Comment> selectUserPublishedComments(Integer writer);

	List<MomentPhoto> selectMomentPhotos(Integer momentId);

	User selectUserByPhoneNumber(Long phoneNumber);
}
