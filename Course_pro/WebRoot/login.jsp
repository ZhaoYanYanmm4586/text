<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
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
	<link rel="stylesheet" type="text/css" href="css/login.css">
  </head>
  
  <body>
    <div class="lt-rt">
	    <form  name="f1" id="f1" action="${pageContext.request.contextPath}/UserControll" method="post" >
	        <!--�û����� �û���������-->
	        <div class="input-area">
	            <div class="username-area">
	                <span class="username">�˺�</span>
	            </div>
	            <input type="text" id="login" name="username">
	        </div>
	
	        <div class="input-area">
	            <div class="username-area">
	                <span class="username">����</span>    
	            </div>
	            <!-- ���������-->
	            <input type="password" id="password" name="userpwd">
	        </div>
	        
	        <input type="submit" class="login-btn" value="��¼"/>
	    
			<p>${msg}</p>
	    </form>
	</div>
  </body>
</html>
