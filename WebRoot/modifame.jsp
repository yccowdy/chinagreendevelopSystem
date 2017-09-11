<%@page import="com.atoz.survey.po.User"%>
<%@page import="com.atoz.survey.dao.mysqlimpl.UserDaoImpl"%>
<%@page import="com.atoz.survey.service.UserService"%>
<%@page import="com.atoz.survey.service.impl.UserServiceImpl"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>欢迎使用</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/bootstrap-responsive.min.css">
	<style type="text/css">
		h3 {
			text-align: center;
		}
		.path {
			margin-left: 10px;
		}
		thead {
			font-weight: bold;
		}
		.input-prepend {
			margin-left: 20px;
		}
		.input-prepend input{
			height: 30px;
			line-height: 30px;
		}
		.form-horizontal input {
			height: 30px;
			line-height: 30px;
		}
	</style>
	<!--[if lt IE 9]>
      	<script src="js/html5shiv.js"></script>
    <![endif]-->
    <script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
  </head>
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
  <body>
  	<h3>欢迎使用企业行为评测系统</h3>
  	<%	
    	String addinfo= (String) session.getAttribute("addinfo");
		if(addinfo != null && addinfo.equals("addinfo"))
		{UserDaoImpl userDao= new UserDaoImpl();
List<User> user=userDao.findAllUsers();
//String userSummary=session.getAttribute("userSummary").toString();
String userid=session.getAttribute("userid").toString();
int id=Integer.parseInt(userid);
	//System.out.println(userSummary);
		for(User user1:user){
if(user1.getUserId()==id){ 
%>
  <span class="path"><i class="icon-home"></i>> 用户管理 > 完善公司信息</span>
    <hr>
 
 
    
			<form class="form-horizontal" action="AddServlet" method="post">
			  	<div class="control-group">
			    	<label class="control-label" for="inputUserZc">注册号</label>
				    <div class="controls">
				    	<input type="text" id="inputUserZc" name="inputUserZc" placeholder="注册号">
				    </div>
			  	</div>
			  	<div class="control-group">
			    	<label class="control-label" for="inputUserSummary">企业名称</label>
				    <div class="controls">
				    	<input type="text" id="inputUserSummary" name="inputUserSummary"  value="<%=user1.getUserSummary()%>" placeholder="usersummary" readonly>
				    </div>
			  	</div>
			  
			  	<div class="control-group">
			    	<label class="control-label" for="inputUserPerson">企业法人代表</label>
				    <div class="controls">
				    	<input type="text" id="inputUserPerson" name="inputUserPerson" placeholder="法人代表">
				    </div>
			  	</div>
			  	<div class="control-group">
			    	<label class="control-label" for="inputShangshi">是否属于上市公司</label>
				    <div class="controls">
				  <select id="inputShangshi" name="inputShangshi" >
				  <option value="上市公司">是</option>
                  <option value="不是上市公司">否</option>
				  </select>
				    </div>
			  	</div>
			  	<div class="control-group">
			    	<label class="control-label" for="inputShangshi">企业类型</label>
				    <div class="controls">
				  <select id="inputType" name="inputType" >
				  <option value="国企">国企</option>
                  <option value="私企">独资</option>
                  <option value="股份制">股份制</option>
                  <option value="有限责任">有限责任</option>
                  <option value="国企">国企</option>
				  </select>
				    </div>
			  	</div>
			  	<div class="control-group">
			    	<label class="control-label" for="inputIntro">公司介绍</label>
				    <div class="controls">
				    	<textarea rows="2" cols="2" name="inputIntro" id="inputIntro"></textarea> 
				    </div>
			  	</div><%}} %>
			  	<div class="control-group controls">
			  		<input type="hidden" name="from" value="fromAdmin">
			      	<button type="submit" class="btn btn-success">确定</button>
			      	<button type="reset" class="btn">重置</button>
			  	</div>
			</form>
			
    <%
    	session.removeAttribute("addinfo");
    	}
  
    	UserDaoImpl userDao= new UserDaoImpl();
List<User> user=userDao.findotherUsers();
String userid=session.getAttribute("userid").toString();
int id=Integer.parseInt(userid);

    	String modifyself= (String) session.getAttribute("modifyself");
		if(modifyself != null && modifyself.equals("modifyself"))
		{for(User user1:user){
if(user1.getUserId()==id){
   
    %>
   
    <span class="path"><i class="icon-home"></i>> 用户管理 > 修改密码</span>
    <hr>
    <!-- form start -->
			<form class="form-horizontal" action="CompServlet" method="post">
		
				
				
			 <div class="control-group">
			    	<label class="control-label" for="inputUserName">用户名</label>
				    <div class="controls">
				    
				    	<input type="text" id="inputUserName" name="modifygoverName" value="<%=user1.getUserName() %>" readonly>
				    </div>
			  	</div> 
			  	 
			   
			  	<div class="control-group">
			    	<label class="control-label" for="inputPassword">密码</label>
				    <div class="controls">
				      	<input type="password" id="inputPassword1" name="inputgoverPassword1" value="<%=user1.getUserPassword() %>" placeholder="password">
				    </div>
			  	</div>
			  	<div class="control-group">
			    	<label class="control-label" for="inputPassword">新密码</label>
				    <div class="controls">
				      	<input type="password" id="inputPassword2" name="inputPassword2" placeholder="password">
				    </div>
			  	</div>
			  	
			  	<div class="control-group">
			    	<label class="control-label" for="inputEmail1">我的邮箱</label>
				    <div class="controls">
				    	<input type="email" id="inputEmail1" name="inputEmail1" value="<%=user1.getUserMail() %>" placeholder="email" >
				    </div>
			  	</div><%}} %>
			  
			  		<div class="control-group controls">
			      	<button type="submit" class="btn btn-success">修改资料</button> 
			      <button type="reset" class="btn">重置</button>
			  	</div>
			</form>
    <%
    	session.removeAttribute("modifyself");
    	}
    	
    	String tips = (String) session.getAttribute("tips");
    	if(tips != null){
    		if(tips.equals("SUCCESS")){
    %>
     <span class="path"><i class="icon-home"></i>> 系统消息</span>
     <br><br><br><br>
     <p align="center"><i class="icon-info-sign"></i> 系统提示：操作成功！</p>
    <%	
    	
    		} else if(tips.equals("ERROR")){
    %>
     <span class="path"><i class="icon-home"></i>> 系统消息</span>
     <br><br><br><br>
     <p align="center"><i class="icon-info-sign"></i> 系统提示：操作失败！</p>
    <%
    		}
    		session.removeAttribute("tips");
    	}
    %>
  <!--   <center>
 <div class="span2">
	    			<div class="right-button">
	    				<div>
	    					<div class="span2"></div>
	    					<div class="span8 fabu">
	    				
	    					<a href="modify.jsp" class="btn btn-success">返回主页面</a></div>
	    					<div class="span2"></div>
	    				</div>
	    				
	    			</div>
    			</div></center> -->
  </body>
</html>