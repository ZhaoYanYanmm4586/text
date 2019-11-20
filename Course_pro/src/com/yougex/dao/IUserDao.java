package com.yougex.dao;

import com.yougex.pojo.User;

public interface IUserDao {

	/**
	 * 
	 * @param userName  登录名
	 * @param userPwd   密码
	 * @return user为null表示没有查到，查以返回user对像
	 */
	public User getUser(String userName,String userPwd);
	
}
