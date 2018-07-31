<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- springMvc的表单标签  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<script src="${basePath}/jquery/jquery-2.1.1.min.js"></script>
</head>
<body>
	<form action="${basePath}/T_cert/add" id="kk" >						
	证件名称:<input type="text" name="name" id="zj"><br>
	       <input type="button"  onclick="shuodong()" value="保存">
	</form>
	<script type="text/javascript">
	function shuodong(){
		if($("#zj").val()==null||$("#zj").val()==""){
			alert("证件名称不能为空!");
		}else{
			$("#kk").submit();
		}		
	}
	</script>
</body>
</html>
