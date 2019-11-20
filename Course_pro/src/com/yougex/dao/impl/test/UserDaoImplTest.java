package com.yougex.dao.impl.test;

import com.yougex.dao.IUserDao;
import com.yougex.dao.impl.UserDaoImpl;
import com.yougex.pojo.User;

public class UserDaoImplTest {

	public static void main(String[] args) {
		
		IUserDao dao=new UserDaoImpl();
		User u = dao.getUser("wang", "111");
		System.out.println(u);
	}
}
