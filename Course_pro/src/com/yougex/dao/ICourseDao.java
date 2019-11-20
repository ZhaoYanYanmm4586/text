package com.yougex.dao;

import java.util.ArrayList;

import com.yougex.pojo.Course;

public interface ICourseDao {

	/**
	 *   ���ѧ�������ݿ���ӹ���
	 * @param stu  ����ѧ������
	 * @return   true ��ӳɹ�  falseʧ��
	 */
	public boolean insertCourse(Course cou);
	
	
	/**
	 *   ���ѧ�������ݿ��޸Ĺ���
	 * @param stu  ����ѧ������
	 * @return   true �޸ĳɹ�  falseʧ��
	 */
	public boolean updateCourse(Course cou);
	
	/**
	 * 
	 * @param stuNo ���ָ��ѧԱ��ѧ��ɾ��
	 * @return
	 */
	public boolean deleteCourse(int couNo);
	
	/**
	 *   �õ����е�ѧ����Ϣ
	 * @return  
	 */
	public ArrayList<Course> getAllCourse();
	
	/**
	 * 
	 * @param stuNo  ����ѧ�ţ��õ�ѧ������
	 * @return
	 */
	public Course getCourseByCouNo(int couNo);
	
	/**
	 * 
	 * @param sql  sql���
	 * @return  ����ѧ������
	 */
	public ArrayList<Course>  getCourseBySql(String sql);
	
}
