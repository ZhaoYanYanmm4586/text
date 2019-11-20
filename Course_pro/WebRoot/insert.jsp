<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'insert.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="css/insert.css">

	</head>
	<body>
	<div class="lt-rt" id="showdiv">
    <form  action = "${pageContext.request.contextPath}/CourseControll?op=insert" method="post" >
        <!-- 课程名称 -->
        <div class="input-area">
            <div class="username-area">
                <span class="username">课程名称</span>
            </div>
            <input type="text" name="courseName">
        </div>
        
        <!-- 授课教师 -->
		<div class="input-area">
            <div class="username-area">
                <span class="username">授课教师</span>
            </div>
            <input type="text" name="courseTeacher">
        </div>
        
        <!-- 上课地点 -->
		<div class="input-area">
            <div class="username-area">
                <span class="username">上课地点</span>
            </div>
            <input type="text" name="courseAddress">
        </div>
        
        <!-- 确认修改按钮 -->
        <input type="submit" class="login-btn" value="提交"/>
    </form>
</div>
</body>
</html>