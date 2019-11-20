<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    
    <title>My JSP 'main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
  </head>
  
  <body>
    <div class="container">
        <table border="1">
            <caption>选课信息</caption>
            <tr>
                <th>课程编号</th>
                <th>课程名称</th>
                <th>授课教师</th>
                <th>授课地点</th>     
                <th>操作</th>
            </tr>
	    <c:forEach items="${list }" var="cou" varStatus="no">
            <tr>
               	
                <td>${cou.couNo}</td>
                <td>${cou.couName}</td>
                <td>${cou.couTeacher}</td> 
                <td>${cou.couAddress}</td>   
                <td>
                    <a href="${pageContext.request.contextPath}/insert.jsp">添加</a>&nbsp;&nbsp;    
                    <a href="javascript:fun(${cou.couNo})">删除</a>&nbsp;&nbsp;               
                    <a href="CourseControll?couNo=${cou.couNo}&op=update">修改</a>&nbsp;&nbsp;
                </td>
            </tr>
	    </c:forEach>   

            
        </table>  
    </div>
        
  </body>
<script type="text/javascript">
 function fun(o)
 {
   var yes=window.confirm("要删除吗？");
   if(yes)
   {
      window.location.href="${pageContext.request.contextPath}/CourseControll?couNo="+o+"&op=del";
   }
 }
</script>
</html>
