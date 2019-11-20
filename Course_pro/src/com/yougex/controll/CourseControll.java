package com.yougex.controll;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.yougex.dao.ICourseDao;
import com.yougex.dao.impl.CourseDaoImpl;
import com.yougex.pojo.Course;

public class CourseControll extends HttpServlet {
          private ICourseDao courseDao=new CourseDaoImpl();
	
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
	    String path="main.jsp";
		String op=request.getParameter("op");
		if(op!=null&&op.equals("del"))
		{
			//这里完成删除的代码
			int couNo=Integer.parseInt(request.getParameter("couNo"));
			 
			delete(couNo);
			
			
			
		}else if(op!=null&&op.equals("update"))
		{
			System.out.println("udpate");
			//这里完成修改的代码
			int couNo=Integer.parseInt(request.getParameter("couNo"));
			//根据得到的couNo，获取学生对像
			Course course = this.courseDao.getCourseByCouNo(couNo);
			//将学生对像添加到请求中
			request.setAttribute("course", course);
			path="reg.jsp";
		}else if(op!=null&&op.equals("insert"))
		{
			
			Course course = new Course();
			String courseName = request.getParameter("courseName");
			String courseTeacher = request.getParameter("courseTeacher");
			String courseAddress = request.getParameter("courseAddress");
		
			course.setCouAddress(courseAddress);
			course.setCouName(courseName);
			course.setCouTeacher(courseTeacher);
			this.courseDao.insertCourse(course);
			path="main.jsp";
		}
		if(op!=null&&op.equals("save"))
		{
			System.out.println("save");
			//这里完成update之后保存的代码
			//取表单数据
			save(request,response);
			
		}
		
		// 得到所有的学生信息中，将它写在request范围中
					ICourseDao courseDao=new CourseDaoImpl();
					ArrayList<Course> list = courseDao.getAllCourse();
					request.setAttribute("list", list);
		request.getRequestDispatcher(path).forward(request, response);
	}

	
	public void delete(int couNo)
	{
		
		courseDao.deleteCourse(couNo);
		
	}
	public void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int couNo=Integer.parseInt(request.getParameter("couNo"));
		String couName=request.getParameter("couName");
		String couTeacher=request.getParameter("couTeacher");
		String couAddress=request.getParameter("couAddress");
		Course cou=new Course(couNo, couName, couTeacher, couAddress);
		this.courseDao.updateCourse(cou);
		
	}
}
