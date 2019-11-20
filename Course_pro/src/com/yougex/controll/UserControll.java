package com.yougex.controll;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yougex.dao.ICourseDao;
import com.yougex.dao.IUserDao;
import com.yougex.dao.impl.CourseDaoImpl;
import com.yougex.dao.impl.UserDaoImpl;
import com.yougex.pojo.Course;
import com.yougex.pojo.User;

public class UserControll extends HttpServlet {
	
	
	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 //��������������3�仰
		request.setCharacterEncoding("gbk"); //�����������������ַ�������
		response.setCharacterEncoding("gbk");//����������Ӧ�������ַ�������
		response.setContentType("text/html;charset=gbk"); //�������������ѡ�����ֱ�����ʾ
	  // ȡ�û�����
		String userName=request.getParameter("username");
		String userPwd=request.getParameter("userpwd");
		System.out.println(userName);
	//����userDao;
		  IUserDao userDao=new UserDaoImpl();
		 User user= userDao.getUser(userName, userPwd);
		 if(user!=null)
		 {
			 //��¼�ɹ�
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			// �õ����е�ѧ����Ϣ�У�����д��request��Χ��
			ICourseDao courseDao=new CourseDaoImpl();
			ArrayList<Course> list = courseDao.getAllCourse();
			request.setAttribute("list", list);
			//��ת��ѧ������ҳ��
			request.getRequestDispatcher("main.jsp").forward(request, response);
		 }
		
		 else
		 {
			 //���ɹ�
			request.setAttribute("msg", "�û������벻��ȷ");
			request.getRequestDispatcher("login.jsp").forward(request, response); 
			 
		 }
	}

}
