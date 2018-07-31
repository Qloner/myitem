<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

	<link rel="stylesheet" href="${basePath}/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="${basePath}/css/font-awesome.min.css">
	<link rel="stylesheet" href="${basePath}/css/main.css">
	<style>
	.tree li {
        list-style-type: none;
		cursor:pointer;
	}
	table tbody tr:nth-child(odd){background:#F4F4F4;}
	table tbody td:nth-child(even){color:#C00;}
	</style>

</head>
<body>
	  <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container-fluid">
        <div class="navbar-header">
          <div><a class="navbar-brand" style="font-size:32px;" href="#">众筹平台 - 资质管理</a></div>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li style="padding-top:8px;">
				<div class="btn-group">
				  <button type="button" class="btn btn-default btn-success dropdown-toggle" data-toggle="dropdown">
					<i class="glyphicon glyphicon-user"></i> 张三 <span class="caret"></span>
				  </button>
					  <ul class="dropdown-menu" role="menu">
						<li><a href="#"><i class="glyphicon glyphicon-cog"></i> 个人设置</a></li>
						<li><a href="#"><i class="glyphicon glyphicon-comment"></i> 消息</a></li>
						<li class="divider"></li>
						<li><a href="index.html"><i class="glyphicon glyphicon-off"></i> 退出系统</a></li>
					  </ul>
			    </div>
			</li>
            <li style="margin-left:10px;padding-top:8px;">
				<button type="button" class="btn btn-default btn-danger">
				  <span class="glyphicon glyphicon-question-sign"></span> 帮助
				</button>
			</li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
			<div class="tree">
				<ul style="padding-left:0px;" class="list-group">
					<li class="list-group-item tree-closed" >
						<a href="main.html"><i class="glyphicon glyphicon-dashboard"></i> 控制面板</a> 
					</li>
					<li class="list-group-item tree-closed">
						<span><i class="glyphicon glyphicon glyphicon-tasks"></i> 权限管理 <span class="badge" style="float:right">3</span></span> 
						<ul style="margin-top:10px;display:none;">
							<li style="height:30px;">
								<a href="user.html"><i class="glyphicon glyphicon-user"></i> 用户维护</a> 
							</li>
							<li style="height:30px;">
								<a href="role.html"><i class="glyphicon glyphicon-king"></i> 角色维护</a> 
							</li>
							<li style="height:30px;">
								<a href="permission.html"><i class="glyphicon glyphicon-lock"></i> 许可维护</a> 
							</li>
						</ul>
					</li>
					<li class="list-group-item tree-closed">
						<span><i class="glyphicon glyphicon-ok"></i> 业务审核 <span class="badge" style="float:right">3</span></span> 
						<ul style="margin-top:10px;display:none;">
							<li style="height:30px;">
								<a href="auth_cert.html"><i class="glyphicon glyphicon-check"></i> 实名认证审核</a> 
							</li>
							<li style="height:30px;">
								<a href="auth_adv.html"><i class="glyphicon glyphicon-check"></i> 广告审核</a> 
							</li>
							<li style="height:30px;">
								<a href="auth_project.html"><i class="glyphicon glyphicon-check"></i> 项目审核</a> 
							</li>
						</ul>
					</li>
					<li class="list-group-item">
						<span><i class="glyphicon glyphicon-th-large"></i> 业务管理 <span class="badge" style="float:right">7</span></span> 
						<ul style="margin-top:10px;">
							<li style="height:30px;">
								<a href="cert.html" style="color:red;"><i class="glyphicon glyphicon-picture"></i> 资质维护</a> 
							</li>
							<li style="height:30px;">
								<a href="type.html"><i class="glyphicon glyphicon-equalizer"></i> 分类管理</a> 
							</li>
							<li style="height:30px;">
								<a href="process.html"><i class="glyphicon glyphicon-random"></i> 流程管理</a> 
							</li>
							<li style="height:30px;">
								<a href="advertisement.html"><i class="glyphicon glyphicon-hdd"></i> 广告管理</a> 
							</li>
							<li style="height:30px;">
								<a href="message.html"><i class="glyphicon glyphicon-comment"></i> 消息模板</a> 
							</li>
							<li style="height:30px;">
								<a href="project_type.html"><i class="glyphicon glyphicon-list"></i> 项目分类</a> 
							</li>
							<li style="height:30px;">
								<a href="tag.html"><i class="glyphicon glyphicon-tags"></i> 项目标签</a> 
							</li>
						</ul>
					</li>
					<li class="list-group-item tree-closed" >
						<a href="param.html"><i class="glyphicon glyphicon-list-alt"></i> 参数管理</a> 
					</li>
				</ul>
			</div>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<div class="panel panel-default">
			  <div class="panel-heading">
				<h3 class="panel-title"><i class="glyphicon glyphicon-th"></i> 数据列表</h3>
			  </div>
			  <div class="panel-body">
<form action="${basePath}/T_cert/list" class="form-inline" role="form" style="float:left;">
  <div class="form-group has-feedback">
    <div class="input-group">
      <div class="input-group-addon">查询条件</div>
      <input class="form-control has-success" name="queryName"  type="text" placeholder="请输入查询条件">
    </div>
  </div>
  <button type="submit" class="btn btn-warning"><i class="glyphicon glyphicon-search"></i> 查询</button>
</form>

<button type="button" onclick="dels()" class="btn btn-danger" style="float:right;margin-left:10px;"><i class=" glyphicon glyphicon-remove"></i> 删除</button>


<form action="${basePath}/T_cert/toadd" class="form-inline" role="form" style="float:right;">
<button type="submit" class="btn btn-primary" style="float:right;" onclick="window.location.href='form.html'"><i class="glyphicon glyphicon-plus"></i> 新增</button>
</form>
<br>
 <hr style="clear:both;">
          <div class="table-responsive">
            <table class="table  table-bordered">
              <thead>
                <tr >
                  <th width="30">#</th>
				  <th width="30"><input type="checkbox"></th>
                  <th>名称</th>
                  <th width="100">操作</th>
                </tr>
              </thead>
              
              <tbody>
	              <c:forEach var="i" items="${list}">
	              	<tr>
	              	  <td>${i.id}</td>
					  <td><input type="checkbox" name="id" value="${i.id}" ></td>
	                  <td>${i.name}</td>
	                  <td>
	                  	<form action="${basePath}/T_cert/toupdate/${i.id}" class="form-inline" role="form" style="float:left;">
	              			<button type="submit" class="btn btn-primary btn-xs"><i class=" glyphicon glyphicon-pencil"></i></button>	                  		
	                  	</form>		
	                  	
	                 		<button type="button" onclick="del(${i.id})" class="btn btn-danger btn-xs"><i class=" glyphicon glyphicon-remove"></i></button>                  	
	                  	      				  	 
				  	  </td>
	              	</tr>
	              </c:forEach>  
	              	<tr>
	              		<td colspan="100">${mygroup}</td>
	              	</tr>           	
              </tbody>            
            </table>
          </div>
			  </div>
			</div>
        </div>
      </div>
    </div>

    <script src="${basePath}/jquery/jquery-2.1.1.min.js"></script>
    <script src="${basePath}/bootstrap/js/bootstrap.min.js"></script>
	<script src="${basePath}/script/docs.min.js"></script>
        <script type="text/javascript">
            $(function () {
			    $(".list-group-item").click(function(){
				    if ( $(this).find("ul") ) {
						$(this).toggleClass("tree-closed");
						if ( $(this).hasClass("tree-closed") ) {
							$("ul", this).hide("fast");
						} else {
							$("ul", this).show("fast");
						}
					}
				});
            });
            
            function del(id){
            	var arrays=$("input[name=id]");
            	for(var i=0;i<arrays.length;i++){
            		if(arrays[i].type=="checkbox"&&arrays[i].checked==true){
            			if(confirm("确认删除id="+id+"的记录?")){
            				location="${basePath}/T_cert/del/"+id;
                    		alert("删除成功!");
                    	}
            		}
            	}            	
            }           
            
             function dels(){
            	var arrs=$("input[name=id]");  
                var idss="";  
                for (var i=0; i<arrs.length; i++){  
                    if(arrs[i].type=="checkbox"&&arrs[i].checked==true){  
                        idss+=arrs[i].value + ",";  
                    }  
                }
             	var ids=idss.substring(0, idss.length-1);            
               // console.log(ids);
            	
        		if(ids==""){                     
                    alert("请选择要删除的信息!");  
                    return;  
                }else if(confirm("确定要删除多条数据吗？")){ 
                	location="${basePath}/T_cert/dels/"+ids;
        			alert("删除成功!");
        		}                 
        	}            
        </script>
	
</body>
</html>
