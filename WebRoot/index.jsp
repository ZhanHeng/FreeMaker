<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
response.sendRedirect(basePath+"/showEmpInfo.action");
%>
<html>
	<head>
		<title> this is freemarker page</title>
	</head>
	<body>
		
		this is index jsp page
		
	</body>
</html>