<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
	//博客:https://blog.csdn.net/xuanjiewu/article/details/52448664
	String path = request.getContextPath(); //"/项目名"
	//"http://localhost:8080/项目名"
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path; 

	//放入到page容器中，可以在需要时用EL取出
	pageContext.setAttribute("path",path); //"/项目名"
	pageContext.setAttribute("basePath",basePath); //"http://localhost:8080/项目名"
%> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP页面</title>
</head>
<body>
	<%
		String url=basePath+"/main.jsp";
		response.sendRedirect(url);
	%> 
</body>
</html>
