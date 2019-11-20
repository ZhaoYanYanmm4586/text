package com.yougex.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.yougex.common.ConnectionManage;
import com.yougex.dao.IUserDao;
import com.yougex.pojo.User;

public class UserDaoImpl implements IUserDao {

	@Override
	public User getUser(String userName, String userPwd) {
		// TODO Auto-generated method stub
		User user=null;
		//1.�õ����Ӷ���
		Connection conn = ConnectionManage.getConn();
		//2.��Ԥ������
		String sql="select userName,userPwd from userTbl where userName=? and userPwd=? ";
		try {
			PreparedStatement pre = conn.prepareStatement(sql);
			//3.��Ԥ������?����ֵ
			pre.setString(1, userName);
			pre.setString(2, userPwd);
			//4.ִ��,�õ������
			 ResultSet rs = pre.executeQuery();
			 if(rs.next()) //Ϊ�棬��ʾ�ҵ���
			 {
				 user=new User(userName, userPwd) ;
				 
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			ConnectionManage.closeConn(conn);
		}
		
		return user;
	}

}
