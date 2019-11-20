package com.yougex.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.yougex.common.ConnectionManage;
import com.yougex.dao.ICourseDao;
import com.yougex.pojo.Course;


public class CourseDaoImpl implements ICourseDao {
        
	@Override
	public boolean insertCourse(Course cou) {
		boolean b=false;
		//得到连接对像
         Connection conn=ConnectionManage.getConn();
          String sql="insert into course(courseName,courseTeacher,courseAddress) values(?,?,?)"; 
        try {
			PreparedStatement pre = conn.prepareStatement(sql);
//        	couName,
			pre.setString(1, cou.getCouName());
//	        couTeacher
		    pre.setString(2, cou.getCouTeacher()); 
//        	couAddress,
			pre.setString(3, cou.getCouAddress());

      b= pre.executeUpdate()>0?true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			   ////关闭连接对像
	         ConnectionManage.closeConn(conn);
		}
      
		return b;
	}
	//course
	// Course
	@Override
	public boolean updateCourse(Course cou) {
		boolean b=false;
		//得到连接对像
         Connection conn=ConnectionManage.getConn();
          String sql=" update course  set courseAddress=?,courseName=?,courseTeacher=?,courseNo=? WHERE courseno=?"; 
        try {
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, cou.getCouAddress());
			pre.setString(2, cou.getCouName());
			pre.setString(3, cou.getCouTeacher());
			pre.setInt(4, cou.getCouNo());
			pre.setInt(5, cou.getCouNo());
      b= pre.executeUpdate()>0?true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			   ////关闭连接对像
	         ConnectionManage.closeConn(conn);
		}
      
		return b;
	}

	@Override
	public boolean deleteCourse(int couNo) {
		boolean b=false;
		//得到连接对像
         Connection conn=ConnectionManage.getConn();
          String sql="delete course where courseno=?"; 
        try {
			PreparedStatement pre = conn.prepareStatement(sql);
pre.setInt(1, couNo);
      b= pre.executeUpdate()>0?true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			   ////关闭连接对像
	         ConnectionManage.closeConn(conn);
		}
      
		return b;
	}

	@Override
	public ArrayList<Course> getAllCourse() {
 
		 ArrayList<Course> list=new ArrayList<Course>();
		 
		//得到连接对像
         Connection conn=ConnectionManage.getConn();
          String sql="select * from course"; 
      
			try {
				PreparedStatement pre = conn.prepareStatement(sql);
				ResultSet rs = pre.executeQuery();
				while(rs.next())
				{
					Course cou=new Course();
					
					  //couNo number primary key,
					  int couNo= rs.getInt("courseNo"); 
					  cou.setCouNo(couNo);
					  System.out.println(couNo);
//	        	    couName nvarchar2(10) not null,
					  String couName= rs.getString("courseName"); 
					  cou.setCouName(couName);
					  System.out.println(couName);
//					  couTeacher nvarchar2(10) not null, 
				
					  String couTeacher= rs.getString("courseTeacher"); 
					  cou.setCouTeacher(couTeacher); 
					  
//	        	    couAddress nvarchar2(50)
					String  couAddress=rs.getString("courseAddress"); 
				cou.setCouAddress(couAddress);
					
					list.add(cou);
				}
//    
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally
			{
				
				ConnectionManage.closeConn(conn);
			}
		 
		return list;
	}

	@Override
	public Course getCourseByCouNo(int couNo) {
		Course cou=null;
		
		//得到连接对像
         Connection conn=ConnectionManage.getConn();
          String sql="select * from course where courseNo=?"; 
      
			try {
				PreparedStatement pre = conn.prepareStatement(sql);
				pre.setInt(1, couNo);
				ResultSet rs = pre.executeQuery();
				if(rs.next())
				{
					 cou=new Course();
					
					  //couNo number primary key,
					  int couNo1= rs.getInt("courseNo"); 
					  cou.setCouNo(couNo1);
//	        	    stuName nvarchar2(10) not null,
					 String couName= rs.getString("courseName"); 
					cou.setCouName(couName);
//		        	couTeacher nvarchar2(50)
					  String  couTeacher=rs.getString("courseTeacher"); 
					cou.setCouTeacher(couTeacher);	        	   
//	        	    stuAddress nvarchar2(50)
					String  couAddress=rs.getString("courseAddress"); 
					cou.setCouAddress(couAddress);
					
				
				}
//    
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally
			{
				
				ConnectionManage.closeConn(conn);
			}
		 
		return cou;
	}

	@Override
	public ArrayList<Course> getCourseBySql(String sql) {

		 ArrayList<Course> list=new ArrayList<Course>();
		 
		//得到连接对像
        Connection conn=ConnectionManage.getConn();
       
     
			try {
				PreparedStatement pre = conn.prepareStatement(sql);
				ResultSet rs = pre.executeQuery();
				while(rs.next())
				{
					Course cou=new Course();
		
				
				//couNo number primary key,
				  int couNo1= rs.getInt("couNo"); 
				  cou.setCouNo(couNo1);
//      	    stuName nvarchar2(10) not null,
				 String couName= rs.getString("couName"); 
				cou.setCouName(couName);
//	        	couTeacher nvarchar2(50)
				  String  couTeacher=rs.getString("couTeacher"); 
				cou.setCouTeacher(couTeacher);	        	   
//      	    stuAddress nvarchar2(50)
				String  couAddress=rs.getString("couAddress"); 
				cou.setCouAddress(couAddress);
					
					list.add(cou);
					
					
				}
//   
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally
			{
				
				ConnectionManage.closeConn(conn);
			}
		 
		return list;
	}

}
