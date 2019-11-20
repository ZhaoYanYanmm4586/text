package com.yougex.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManage {

	/**
	 * 
	 * @return  得到一个数据库的连接对像
	 */
	public static java.sql.Connection getConn()
	{
		//1.准备好数据库的连接字符串
				String url="jdbc:oracle:thin:@192.168.1.108:1521:xe";
			
		        String driClass="oracle.jdbc.OracleDriver";
		        String userName="course";
		        String userPwd="course";
		   
		        //2.在创建的项目里添加驱动类
		Connection conn=null;
		try {
			//3.将加驱动类加载到内存中
			Class.forName(driClass);
			//4.w使用驱动管理类来管理,可以通过驱动管理类来得到连接对像
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
	 * 关闭连接对像
	 * @param conn  传入 连接对像
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
