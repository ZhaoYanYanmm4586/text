package com.yougex.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManage {

	/**
	 * 
	 * @return  �õ�һ�����ݿ�����Ӷ���
	 */
	public static java.sql.Connection getConn()
	{
		//1.׼�������ݿ�������ַ���
				String url="jdbc:oracle:thin:@192.168.1.108:1521:xe";
			
		        String driClass="oracle.jdbc.OracleDriver";
		        String userName="course";
		        String userPwd="course";
		   
		        //2.�ڴ�������Ŀ�����������
		Connection conn=null;
		try {
			//3.������������ص��ڴ���
			Class.forName(driClass);
			//4.wʹ������������������,����ͨ���������������õ����Ӷ���
   conn = DriverManager.getConnection(url, userName, userPwd);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return conn;
		
	}
	/**
	 * �ر����Ӷ���
	 * @param conn  ���� ���Ӷ���
	 */
	public static void closeConn(java.sql.Connection conn)
	{
		if(conn!=null)
		{
			try {
				if(!conn.isClosed())
				{
					
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
}
