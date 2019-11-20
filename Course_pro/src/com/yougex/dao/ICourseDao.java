package com.yougex.dao;

import java.util.ArrayList;

import com.yougex.pojo.Course;

public interface ICourseDao {

	/**
	 *   完成学生的数据库添加功能
	 * @param stu  传入学生对像
	 * @return   true 添加成功  false失败
	 */
	public boolean insertCourse(Course cou);
	
	
	/**
	 *   完成学生的数据库修改功能
	 * @param stu  传入学生对像
	 * @return   true 修改成功  false失败
	 */
	public boolean updateCourse(Course cou);
	
	/**
	 * 
	 * @param stuNo 完成指定学员的学生删除
	 * @return
	 */
	public boolean deleteCourse(int couNo);
	
	/**
	 *   得到所有的学生信息
	 * @return  
	 */
	public ArrayList<Course> getAllCourse();
	
	/**
	 * 
	 * @param stuNo  传入学号，得到学生对像
	 * @return
	 */
	public Course getCourseByCouNo(int couNo);
	
	/**
	 * 
	 * @param sql  sql语句
	 * @return  返回学生集合
	 */
	public ArrayList<Course>  getCourseBySql(String sql);
	
}
