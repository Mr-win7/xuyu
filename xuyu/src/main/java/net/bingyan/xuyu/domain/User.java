package net.bingyan.xuyu.domain;

public class User {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column users.user_id
	 * @mbg.generated  Sun Nov 06 19:20:42 CST 2016
	 */
	private Integer userId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column users.username
	 * @mbg.generated  Sun Nov 06 19:20:42 CST 2016
	 */
	private String username;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column users.sex
	 * @mbg.generated  Sun Nov 06 19:20:42 CST 2016
	 */
	private String sex;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column users.avatar
	 * @mbg.generated  Sun Nov 06 19:20:42 CST 2016
	 */
	private String avatar;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column users.phone_number
	 * @mbg.generated  Sun Nov 06 19:20:42 CST 2016
	 */
	private Long phoneNumber;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column users.user_id
	 * @return  the value of users.user_id
	 * @mbg.generated  Sun Nov 06 19:20:42 CST 2016
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column users.user_id
	 * @param userId  the value for users.user_id
	 * @mbg.generated  Sun Nov 06 19:20:42 CST 2016
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column users.username
	 * @return  the value of users.username
	 * @mbg.generated  Sun Nov 06 19:20:42 CST 2016
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column users.username
	 * @param username  the value for users.username
	 * @mbg.generated  Sun Nov 06 19:20:42 CST 2016
	 */
	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column users.sex
	 * @return  the value of users.sex
	 * @mbg.generated  Sun Nov 06 19:20:42 CST 2016
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column users.sex
	 * @param sex  the value for users.sex
	 * @mbg.generated  Sun Nov 06 19:20:42 CST 2016
	 */
	public void setSex(String sex) {
		this.sex = sex == null ? null : sex.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column users.avatar
	 * @return  the value of users.avatar
	 * @mbg.generated  Sun Nov 06 19:20:42 CST 2016
	 */
	public String getAvatar() {
		return avatar;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column users.avatar
	 * @param avatar  the value for users.avatar
	 * @mbg.generated  Sun Nov 06 19:20:42 CST 2016
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar == null ? null : avatar.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column users.phone_number
	 * @return  the value of users.phone_number
	 * @mbg.generated  Sun Nov 06 19:20:42 CST 2016
	 */
	public Long getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column users.phone_number
	 * @param phoneNumber  the value for users.phone_number
	 * @mbg.generated  Sun Nov 06 19:20:42 CST 2016
	 */
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}