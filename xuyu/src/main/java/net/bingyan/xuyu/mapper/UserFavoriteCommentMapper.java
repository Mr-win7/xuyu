package net.bingyan.xuyu.mapper;

import java.util.List;
import net.bingyan.xuyu.domain.UserFavoriteComment;
import org.apache.ibatis.annotations.Param;

public interface UserFavoriteCommentMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table users_favorite_comments
	 * @mbg.generated  Mon Nov 07 21:36:37 CST 2016
	 */
	int deleteByPrimaryKey(@Param("userId") Integer userId, @Param("commentId") Integer commentId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table users_favorite_comments
	 * @mbg.generated  Mon Nov 07 21:36:37 CST 2016
	 */
	int insert(UserFavoriteComment record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table users_favorite_comments
	 * @mbg.generated  Mon Nov 07 21:36:37 CST 2016
	 */
	List<UserFavoriteComment> selectAll();
}