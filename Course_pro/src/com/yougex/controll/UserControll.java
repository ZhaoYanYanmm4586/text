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

		 //解决乱码加下以下3句话
		request.setCharacterEncoding("gbk"); //用来设置请求对像的字符集编码
		response.setCharacterEncoding("gbk");//用来设置响应求对像的字符集编码
		response.setContentType("text/html;charset=gbk"); //用来设置浏览器选择哪种编码显示
	  // 取用户密码
		String userName=request.getParameter("username");
		String userPwd=request.getParameter("userpwd");
		System.out.println(userName);
	//调用userDao;
		  IUserDao userDao=new UserDaoImpl();
		 User user= userDao.getUser(userName, userPwd);
		 if(user!=null)
		 {
			 //登录成功
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			// 得到所有的学生信息中，将它写在request范围中
			ICourseDao courseDao=new CourseDaoImpl();
			ArrayList<Course> list = courseDao.getAllCourse();
			request.setAttribute("list", list);
			//跳转到学生管理页面
			request.getRequestDispatcher("main.jsp").forward(request, response);
		 }
		
		 else
		 {
			 //不成功
			request.setAttribute("msg", "用户名密码不正确");
			request.getRequestDispatcher("login.jsp").forward(request, response); 
			 
		 }
	}

}
