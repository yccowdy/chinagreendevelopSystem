<%@page import="com.atoz.survey.po.User"%>
<%@page import="com.atoz.survey.dao.mysqlimpl.UserDaoImpl"%>
<%@page import="com.atoz.survey.service.UserService"%>
<%@page import="com.atoz.survey.service.impl.UserServiceImpl"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
	<base href="<%=basePath%>user1.jsp">
	<title>后台管理中心</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="">
	<meta http-equiv="description" content="">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<script src="js/jquery.js"></script>
	<style type="text/css">
		body {
			padding-top: 60px;
			padding-bottom: 40px;
		}
		.sidebar-nav {
			padding: 9px 0;
		}
		#mysidebar {
			position: fixed;
		}
		#mycontent {
			float: right;
		}
		#userfame {
			width:960px;
			height:530px;
			border: 2px #E3E3E3 solid;
			border-radius: 5px;
		}
		@media (max-width: 980px) {
			.navbar-text.pull-right {
				float: none;
				padding-left: 5px;
				padding-right: 5px;
			}
		}
		.nav-header {
				font-size: 18px;
				padding: 3px 6px;
		}
		.nav-list > li > a {
    		padding: 3px 30px;
		}

	</style>
	<link rel="stylesheet" href="css/bootstrap-responsive.min.css">
	<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
      	<script src="js/html5shiv.js"></script>
    <![endif]-->
    <script type="text/javascript">
		$(document).ready(function () {
			var aLi = document.getElementById("tag").getElementsByTagName("li");
			for (var i = 0; i < aLi.length; i++) {
				aLi[i].onClick = function () {
					for (var j = 0; j < aLi.length; j++) {
							aLi[j].removeClass("active");
					}
					aLi[i].addClass("active");
				};
			}
		});
</script>
	<script src="js/bootstrap.min.js"></script>
</head>
<body>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container-fluid">
				<button type="button" class="btn btn-navbar" data-toggle="clooapse" data-target=".navbar-collapse">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>				
				</button>
			
			</div>
		</div>
	</div>
	<div class="container-fluid">
      	<div class="row-fluid">
        	<div id="mysidebar" class="span3">
          		<div id="tag" class="well sidebar-nav">
		            <ul class="nav nav-list">
		            	<li class="nav-header">功能面板</li>
						<br>
						<li class="nav-header">用户管理</li>
						
				
				    	<li><a href="UserServlet?action=modifyinfor" target="userfame">完善公司资料</a></li>
					<!-- 	<li><a href="UserServlet?action=findcomment" target="userfame">查看我的评价</a></li> -->
						<li><a href="UserServlet?action=modifyUser1" target="userfame">修改密码</a></li>
							<li><a href="user.jsp" >返回主页面</a></li>
					    
					
		            </ul>
          		</div><!--/.well -->
        	</div><!--/span-->
	        <div id="mycontent" class="span9">
	          	<iframe class="span9" id="userfame" src="userfame.jsp" name="userfame"></iframe>
	    	</div>
		</div>
    </div>
</body>
</html>
