package net.bingyan.xuyu.domain;

public class UserFavoriteMoment {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column users_favorite_moment.user_id
	 * @mbg.generated  Sun Nov 06 19:20:42 CST 2016
	 */
	private Integer userId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column users_favorite_moment.moment_id
	 * @mbg.generated  Sun Nov 06 19:20:42 CST 2016
	 */
	private Integer momentId;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column users_favorite_moment.user_id
	 * @return  the value of users_favorite_moment.user_id
	 * @mbg.generated  Sun Nov 06 19:20:42 CST 2016
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column users_favorite_moment.user_id
	 * @param userId  the value for users_favorite_moment.user_id
	 * @mbg.generated  Sun Nov 06 19:20:42 CST 2016
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column users_favorite_moment.moment_id
	 * @return  the value of users_favorite_moment.moment_id
	 * @mbg.generated  Sun Nov 06 19:20:42 CST 2016
	 */
	public Integer getMomentId() {
		return momentId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column users_favorite_moment.moment_id
	 * @param momentId  the value for users_favorite_moment.moment_id
	 * @mbg.generated  Sun Nov 06 19:20:42 CST 2016
	 */
	public void setMomentId(Integer momentId) {
		this.momentId = momentId;
	}
}