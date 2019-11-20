<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/reg.css">
	

  </head>
  
  <body>
    <div class="container">
      <form name="f1" id="f1" action="CourseControll?op=save" method="post">          
        <div class="input-area">
            <div class="username-area">
                <span class="username">课程编号</span>
            </div>
            <input type="text" name="couNo" value="${course.couNo }">
        </div>
        <div class="input-area">
            <div class="username-area">
                <span class="username">课程名称</span>
            </div>
            <input type="text" name="couName" value="${course.couName }">
        </div>
        <div class="input-area">
            <div class="username-area">
                <span class="username">授课教师</span>
            </div>
            <input type="text" name="couTeacher" value="${course.couTeacher }">
        </div>
        <div class="input-area">
            <div class="username-area">
                <span class="username">上课地点</span>
            </div>
            <input type="text" name="couAddress" value="${course.couAddress }">
        </div>
        <input type="submit" class="login-btn"  value="确认"/>  
    </form>
    </div>
  </body>
</html>