<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <base href="<%=basePath%>">
    
    <title>用户登录</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="">
	<meta http-equiv="description" content="">
	<link rel="stylesheet" href="css/bootstrap.css">
	<style type="text/css">
		body {
			padding-top: 20px;
			padding-bottom: 40px;
		}
		/*自定义容器*/
		.container-narrow {
			margin: 0 auto;
			max-width: 960px;
		}
		/*主体部分表单搜索框*/
		.jumbotron {
			max-width: 470px;
			margin: 0 auto;	
		}
		.jumbotron form {
			padding: 10px;
			border: 1px solid #e5e5e5;
			border-radius: 5px;
		}
		#paperId {
			height: 34px;
			line-height: 34px;
			font-size: 22px;
		}
		/*热门推荐等格式*/
		.marketing p + h4 {
			margin-top: 28px;
		}
	</style>
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/bootstrap-responsive.css">
	<link rel="stylesheet" href="css/bootstrap-responsive.min.css">
	<!--[if lt IE 9]>
      	<script src="js/html5shiv.js"></script>
    <![endif]-->
    <script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
	$(document).ready(function(){
  		$("#tip").click(function(){
    		$(this).parent().hide();
  		});
	});
	
	function check() {
		var name = document.getElementById("inputUserName");
		var pass = document.getElementById("inputPassword");
		if (name.value == "" || pass.value == "") {
			$(".alert").show();
			return false;
		}
	};
</script>
<style type="text/css">
<!--
.gradient{
  /*   width:1680px;
    height:1050px; */
    filter:alpha(opacity=60 finishopacity=100 style=1 startx=0,starty=0,finishx=0,finishy=150) progid:DXImageTransform.Microsoft.gradient(startcolorstr=#235E98,endcolorstr=#DEEBF3,gradientType=0);
    -ms-filter:alpha(opacity=60 finishopacity=100 style=1 startx=0,starty=0,finishx=0,finishy=150) progid:DXImageTransform.Microsoft.gradient(startcolorstr=#235E98,endcolorstr=#DEEBF3,gradientType=0);/*IE8*/
    background:#006600; /* 一些不支持背景渐变的浏览器 */
    background:-moz-linear-gradient(top,rgba(35,94,152, 1),rgba(222,235,243, 0.6));/*Firefox*/
    background:-webkit-gradient(linear, 0 0, 0 bottom, from(rgba(35,94,152, 1)), to(rgba(222,235,243, 0.6)));/*chrome Safari*/
    background:-o-linear-gradient(top, rgba(35,94,152, 1),rgba(222,235,243, 0.6));/*Opera11*/
}
//-->

</style>
</head>
<body class="gradient">
    <div class="container-narrow">
    	<div class="masthead">
    		<h1 style="color: White">欢迎使用</h1>
    		<a href="provice.jsp">nihao</a>
    	</div>
    	<hr>
    	<br>
    	<div class="jumbotron">
			<!-- form start -->
			<form class="form-horizontal" action="loginServlet" method="post" onSubmit="return check()">

				<h2 style="color: White">用户登录</h2>
				<%
				String rtnMsg = (String) session.getAttribute("rtnMsg");
				if("ERROR".equals(rtnMsg)){
				%>
				<div class="alert alert-warning fade in">
					<button class="close" data-dismiss="alert" type="button">x</button>
					<center>登录失败，用户名或密码错误！</center>
				</div>
				<%
					session.invalidate();
				}
				%>
				<div class="alert alert-warning fade in" style="display:none;">
					<a id="tip" class="close">x</a>
					<center>请输入完整用户名和密码！</center>
				</div>
			  	<div class="control-group">
			    	<label class="control-label" for="inputUserName">账号</label>
				    <div class="controls">
				    	<input type="text" id="inputUserName" name="inputUserName" placeholder="username">
				    </div>
			  	</div>
			  	<div class="control-group">
			    	<label class="control-label" for="inputPassword">密码</label>
				    <div class="controls">
				      	<input type="password" id="inputPassword" name="inputPassword" placeholder="password">
				    </div>
			  	</div>		
					<div class="controls">用户类型：
					<select name="u_type" id="u_type">
			 <option value="user">用户</option>
					<option value="company">政府</option>
					<option value="admin">管理员</option>
					<option value="tree">委托方</option>
				</select></div>
			  	<div class="control-group controls">
			      	<button type="submit" class="btn btn-primary">登录</button>
			      	<button type="reset" class="btn">重置</button>
			      	<a href="reg.jsp" style="color: White" class="btn btn-success">用户注册</a> 			      		
			  	</div>
			</form>
    	</div>
    	<br><br><br><br>
    	<hr>
    </div>
</body>
</html>
