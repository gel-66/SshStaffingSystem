<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>员工管理系统</title>
</head>
<frameset rows="80,*">
   <frame name="top" src="<%=basePath %>frame/top.jsp">
   <frameset cols="150,*" id="main">
      <frame src="<%=basePath %>frame/left.jsp"> 
     <frame name="right" src="<%=basePath %>frame/right.jsp">
   </frameset>
</frameset>
<body>

</body>
</html>