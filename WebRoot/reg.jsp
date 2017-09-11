<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <base href="<%=basePath%>">    
    <title>用户注册</title>
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
    <script type="text/javascript">
	$(document).ready(function(){
  		$("#tip").click(function(){
    		$(this).parent().hide();
  		});
  		$("#tip2").click(function(){
    		$(this).parent().hide();
  		});
	});
	
	function check() {
		var name = document.getElementById("inputUserName");
		var pass = document.getElementById("inputPassword");
		var pass2 = document.getElementById("inputPassword2");
		if (name.value == "") {
			$(".alert").show();
			name.focus();
			return false;
		} else if (pass.value == "") {
			$(".alert").show();
			pass.focus();
			return false;
		} else if (pass2.value == "") {
			$(".alert").show();
			pass2.focus();
			return false;
		} else if(pass.value != pass2.value) {
			$(".alert-password").show();
			pass.focus();
			return false;
		}
	}
</script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container-narrow">
    	<div class="masthead">
    		<ul class="nav nav-pills pull-right">
    			<li><a class="btn" href="login.jsp" role="button">用户登录</a></li>
    		</ul>
    		
    	</div>
    	<hr>
    	<div class="jumbotron">
			<!-- form start -->
			    <script language="javascript" src="js/1234.js"></script>
			<form class="form-horizontal" action="regServlet" method="post" onSubmit="return check()">
				<h2>账号注册</h2>
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
				<div id="alert" class="alert alert-warning fade in" style="display:none;">
					<a id="tip" class="close">x</a>
					<center>注册信息不完整，请重新输入！</center>
				</div>
				<div id="alert-password" class="alert alert-warning fade in" style="display:none;">
					<a id="tip2" class="close">x</a>
					<center>两次密码不一致，请重新输入！</center>
				</div>
				<input type="hidden" name="Daihao" value="1" />
			  	<div class="control-group">
			    	<label class="control-label" for="inputUserRole">所属行业</label>
				    <div class="controls">
				    <select id="inputUserRole" name="inputUserRole">
				
			<option value="1">非金属矿物制品业（平板玻璃）</option>
			<option value="2">非金属矿物制品—人造板</option>	    	
				    	<option value="3">非金属矿物制品—水泥工业</option>	    
				    	<option value="4">工业化学品制造业—氮肥制造业</option>	    
				    	<option value="5">煤炭开采及洗选业</option>	    
			    	  </select>
				    </div>
			  	</div>	
	
			  	<div class="control-group">
			    	<label class="control-label" for="inputUserAdd">所在地址</label>
				    <div class="controls">
				  
			    	  <Select id="province"  name="province"></Select>  
 <Select id="city"  name="city"></Select>  
<Select id="county"  name="town"></Select>
				    </div>
			  	</div>  
			  	<div class="control-group">
			    	<label class="control-label" for="inputUserArea">详细地址</label>
				    <div class="controls">
				    	*<input type="text" id="inputUserArea" name="inputUserArea" placeholder="输入详细地址">
				    </div>
			  	</div>
			  	<div class="control-group">
			    	<label class="control-label" for="inputUserSummary">用户名称</label>
				    <div class="controls">
				    	<input type="text" id="inputUserSummary" name="inputUserSummary" placeholder="输入企业名称或者政府名称">
				    </div>
			  	</div>
			  
			  	<div class="control-group">
			    	<label class="control-label" for="inputUserName">用户账号</label>
				    <div class="controls">
				    	<input type="text" id="inputUserName" name="inputUserName" placeholder="企业或者政府账号">
				    </div>
			  	</div>
			  	<div class="control-group">
			    	<label class="control-label" for="inputPassword">密码</label>
				    <div class="controls">
				      	<input type="password" id="inputPassword" name="inputPassword" placeholder="输入密码">
				    </div>
			  	</div>
			  	
			  	<div class="control-group">
			    	<label class="control-label" for="inputEmail">联系方式</label>
				    <div class="controls">
				    	<input type="text" id="inputEmail" name="inputEmail" placeholder="输入联系方式">
				    </div>
			  	</div>			  	
			  	<div class="control-group controls">
			      	<button type="submit" class="btn btn-success">注册</button>
			      	<button type="reset" class="btn">重置</button>
			  	</div>
			</form><!-- form end -->
    	</div>
    	<SCRIPT language="javascript">  
 setup();  
</SCRIPT>
    	<br><br><br><br>
    	<hr>
    	<div class="footer">
    		
    	</div>
    </div>
</body>
</html>
