<%@page import="com.atoz.survey.po.User"%>
<%@page import="java.util.*"%>
<%@page import="java.text.*"%>
<%@page import="com.a.model.UserBean"%>
<%@page import="com.a.model.UserBeanCl"%>
<%@page import="com.atoz.survey.dao.mysqlimpl.UserDaoImpl"%>
<%@page import="com.atoz.survey.service.UserService"%>
<%@page import="com.atoz.survey.service.impl.UserServiceImpl"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setCharacterEncoding("utf-8");
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
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
	.form-horizontal .control-group .controls {
}
    .form-horizontal .control-group .controls {
	font-size: 14px;
}
    .form-horizontal .control-group {
}
    </style>
	<!--[if lt IE 9]>
      	<script src="js/html5shiv.js"></script>
    <![endif]-->
    <script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script type="text/javascript">  
  function exportExcel(){
	    document.form1.action="ExportServlet";
	    document.form1.submit();
		/* alert('待完善！'); */
	}
    function check(form) {  
        if (form.inputUserArea.value =="") {  
            alert("请输入用户帐号!");  
            form.inputUserArea.focus();  
            return false;  
        }  
     
    }  
    </script>
	
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
    	//查看所有用户
    	//List<User> findAllUsers = (List<User>) session.getAttribute("users");
    String findAllUsers= (String) session.getAttribute("findAllUsers");
    	if(findAllUsers != null&& findAllUsers.equals("findAllUsers") ){
    	UserDaoImpl userDao= new UserDaoImpl();
List<User> users=userDao.findotherUsers();
    %>
    <span class="path"><i class="icon-home"></i> > 用户管理 > 查看所有用户</span>
    <form  name="form1" action="">
    <td colspan="7"><input type="button" value='导出Excel表' onclick="exportExcel();"></td>
    </form>
    <hr>
    <table class="table table-hover">
    	<thead>
      <td>所在地区</td>
    		
    		<td>所属行业</td>
    		<td>企业名称</td>
    		<td>邮箱</td>
    		<td>注册时间</td>
    		
    		<td>公告</td>
    		<td>详情</td>
    	</thead>
    <%
    		for(User user : users){
    		String ty="";int t=user.getUserRole();
    		System.out.println(user.getUserArea());
    		      
    		      
    				if(t==1){
    					ty="非金属矿物制品业（平板玻璃）";
    				}else if(t==2){
    					ty="非金属矿物制品—人造板";
    				}else if(t==3){
    					ty="非金属矿物制品—水泥工业";
    				}else if(t==4){
    					ty="工业化学品制造业—氮肥制造业";
    				}else if(t==5){
    					ty="煤炭开采及洗选业";
    				}
    				if(!(t==0||t==-1||t==10||t==11||t==12)){
    %>
	    <tr>
	    <%//if(Integer.parseInt(user.getUserRole())!=10||) %>
	    <td><%=user.getUserProv() %><%=user.getUserCity() %><%=user.getUserArea() %></td>
	    <td><%=ty %></td>
	    	<td><a href="userinfo.jsp?userid=<%=user.getUserId() %>" title="查看企业信息" alt="查看企业信息"><%=user.getUserSummary() %></a></td>
	    	
	    	
	    	<td><%=user.getUserMail() %></td>
	    	<td><%=user.getUserReg() %></td>
	    	<td><%=user.getUserSex() %></td>
	    	<td><a href="<%=user.getUserSummary() %>.pdf" target="_blank">导出</a></td>
	    	
	    </tr>
    <%
    		}}
    %>
    </table>
    <%
    	session.removeAttribute("findAllUsers");
    	}
    String findAllgover= (String) session.getAttribute("findAllgover");
    	if(findAllgover != null&& findAllgover.equals("findAllgover") ){

    	UserDaoImpl userDao= new UserDaoImpl();
List<User> users=userDao.findotherUsers();
    %>
    <span class="path"><i class="icon-home"></i> > 用户管理 > 查看所有用户</span>
    <table class="table table-hover">
    	<thead>
      <td>所在地区</td>
    		
    		
    		<td>政府类型</td>
    		<td>详细地址</td>
    		<td>邮箱</td>
    		<td>注册时间</td>
    		
    		
    	</thead>
    <%
    		for(User user : users){
    		String ty="";int t=user.getUserRole();
    		System.out.println(user.getUserArea());
    		      if(t==10){
    		      ty="省政府";
    		      }
    		       if(t==11){
    		      ty="市政府";
    		      }
    		       if(t==12){
    		      ty="县政府";
    		      }
    				if(t==1){
    					ty="非金属矿物制品业（平板玻璃）";
    				}else if(t==2){
    					ty="非金属矿物制品—人造板";
    				}else if(t==3){
    					ty="非金属矿物制品—水泥工业";
    				}else if(t==4){
    					ty="工业化学品制造业—氮肥制造业";
    				}else if(t==5){
    					ty="煤炭开采及洗选业";
    				}
    				if(t==10||t==11||t==12){
    %>
	    <tr>
	
	     <% if(t==10){ %>
	    <td><%=user.getUserProv() %></td>
	  
	    <td><a href="glycomp.jsp?roleuser=<%=t %>&userarea=<%=user.getUserProv() %>&foundarea=<%=user.getUserProv() %>" title="查看地区企业" alt="查看地区企业"><%=user.getUserProv()%></a><a href="userinfo.jsp?userid=<%=user.getUserId() %>" title="查看详细信息" alt="查看详细信息"><%=ty %></a></td><%} %>
	     <% if(t==11){ %>
	     <td><%=user.getUserProv() %><%=user.getUserCity() %></td>
	    <td><a href="glycomp.jsp?roleuser=<%=t %>&userarea=<%=user.getUserCity() %>&foundarea=<%=user.getUserProv() %><%=user.getUserCity() %>" title="查看地区企业" alt="查看地区企业"><%=user.getUserCity() %></a><a href="userinfo.jsp?userid=<%=user.getUserId() %>"  title="查看详细信息" alt="查看详细信息"><%=ty %></a></td><%} %>
	     <% if(t==12){ %>
	     <td><%=user.getUserProv() %><%=user.getUserCity() %><%=user.getUserArea() %></td>
	    <td><a href="glycomp.jsp?roleuser=<%=t %>&userarea=<%=user.getUserArea() %>&foundarea=<%=user.getUserProv() %><%=user.getUserCity() %><%=user.getUserArea() %>" title="查看地区企业" alt="查看地区企业"><%=user.getUserArea() %></a><a href="userinfo.jsp?userid=<%=user.getUserId() %>" title="查看详细信息" alt="查看详细信息"><%=ty %></a></td><%} %>
	    	
	    	
	    	<td><%=user.getUserAdd() %></td>
	    	<td><%=user.getUserMail() %></td>
	    	<td><%=user.getUserReg() %></td>
	    	
	    	
	    	
	    	
	    </tr>
    <%
    		}}
    %>
</table>
    <%
    	session.removeAttribute("findAllgover");
    	}
    	
    	//查找用户
    	String findUser= (String) session.getAttribute("findUser");
		if(findUser != null && findUser.equals("findUser")){
    %>
    <span class="path"><i class="icon-home"></i> > 用户管理 > 用户综合管理 > 查找用户</span>
    <hr>
    <hr>
    <form action="adminServlet" method="post">
    	<div class="input-prepend input-append">
    		<span class="add-on">企业名称</span>
			<% UserDaoImpl userDao= new UserDaoImpl();
List<User> list=userDao.findotherUsers(); 
%><select id="findUserByUserSummary" name="findUserByUserSummary">
<option value="">请选择</option>
   <%
            if(list != null && list.size() != 0){
                   for(int i = 0; i< list.size();i++){
                   if(!(list.get(i).getUserRole()==10||list.get(i).getUserRole()==11||list.get(i).getUserRole()==12||list.get(i).getUserRole()==0||list.get(i).getUserRole()==-1))
                     { %>
                             <option value="<%=list.get(i).getUserSummary()%>"><%=list.get(i).getUserSummary()%></option>
                            
                       <%
                   }}
            }
  %>
</select>
<% %>
			<button class="btn" type="submit" >Go!</button>
    	</div>
    </form>
    <form action="adminServlet" method="post">
    	<div class="input-prepend input-append">
    		<span class="add-on">根据企业账号查找</span>
					<select  id="findUserByUserName" name="findUserByUserName" placeholder="请输入用户名"> 
		<option value="">请选择</option>
   <%
            if(list != null && list.size() != 0){
                   for(int i = 0; i< list.size();i++){
                   if(!(list.get(i).getUserRole()==10||list.get(i).getUserRole()==11||list.get(i).getUserRole()==12||list.get(i).getUserRole()==0||list.get(i).getUserRole()==-1))
                     { %>
                             <option value="<%=list.get(i).getUserName()%>"><%=list.get(i).getUserName()%></option>
                             <%System.out.print(list.get(i).getUserName());%>
                       <%
                   }}
            }
  %>
</select>
<% %>
			<button class="btn" type="submit" >Go!</button>
    	</div>
    </form>
    <%
    	session.removeAttribute("findUser");
    	}
    	//根据用户ID或用户名查找结果,修改资料
    	User findUserResult = (User) session.getAttribute("findUserResult");
    	if( findUserResult != null ){
    %>
    
    <span class="path"><i class="icon-home"></i> > 用户管理 > 用户综合管理 > 查找结果</span>
    <hr>
    <%
     String ty="";int t=findUserResult.getUserRole();
    		        if(t==0){
    		        ty="管理员";
    		        }
    		         if(t==10){
    		        ty="省政府";}
    		         if(t==11){
    		        ty="市政府";}
    		         if(t==12){
    		        ty="县政府";}
    		         if(t==-1){
    		        ty="第三方";
    		        }
    		       
    				if(t==1){
    					ty="非金属矿物制品业（平板玻璃）";
    				}else if(t==2){
    					ty="非金属矿物制品—人造板";
    				}else if(t==3){
    					ty="非金属矿物制品—水泥工业";
    				}else if(t==4){
    					ty="工业化学品制造业—氮肥制造业";
    				}else if(t==5){
    					ty="煤炭开采及洗选业";
    				}
    %> 
			<form class="form-horizontal" action="adminServlet" method="post" onclick="return check(this)">
		<div class="control-group">
			<label class="control-label" for="inputUserType">所属行业</label>
			  <div class="controls">
				    
				    	<%=ty %>
	      </div>
		  	  </div>
			  	
			  	<div class="control-group">
			    	<label class="control-label" for="inputUserSummary">用户名称</label>
				    <div class="controls">
				    
				    	<%=findUserResult.getUserSummary() %>
				    </div>
			  	</div>
			  	<div class="control-group">
			    	<label class="control-label" for="inputUserName">用户名</label>
				    <div class="controls">
				    
				    	<input type="text" id="inputUserName" name="modifyUserName" value="<%=findUserResult.getUserName() %>" readonly>
				    </div>
			  	</div>
			  	<div class="control-group">
			    	<label class="control-label" for="inputUserSex">公告</label>
				    <div class="controls">
			  <textarea rows="7" cols="7"  id="inputUserSex" name="modifyUserSex" value="<%=findUserResult.getUserSex()%>"></textarea>
			   </div>
			  	</div>
		
			  	<div class="control-group">
			    	<label class="control-label" for="inputEmail">联系邮箱</label>
				    <div class="controls">
				    	<input type="email" id="inputEmail" name="modifyEmail" value="<%=findUserResult.getUserMail() %>">
				    </div>
			  	</div>
			  	<div class="control-group controls">
			      	<button type="submit" class="btn btn-success">修改资料</button> 
			      	<a class="btn btn-danger" href="adminServlet?deleteId=<%=findUserResult.getUserId() %>">删除此账号</a>
			  	</div>
			</form>
    <%	
        
    	session.removeAttribute("findUserResult");
    	} 
    	
    String modifyUser1= (String) session.getAttribute("modifyUser1");
		if(modifyUser1 != null && modifyUser1.equals("modifyUser1"))
		{UserDaoImpl userDao= new UserDaoImpl();
List<User> user=userDao.findotherUsers();
int userid=(Integer)session.getAttribute("userid");
//int id=Integer.parseInt(userid);
System.out.println(userid);
		for(User user1:user){
if(user1.getUserId()==userid){
   
    %>
   
    <span class="path"><i class="icon-home"></i>> 用户管理 > 修改密码</span>
    <hr>
  
			<form class="form-horizontal" action="GlyServlet" method="post">
		
            <input type="hidden" name="Daihao" value="0" />
				<div class="control-group">
			    	<label class="control-label" >所属行业</label>
				    <div class="controls">
				管理员
				    </div>
			  	</div>
			 <div class="control-group">
			    	<label class="control-label" for="inputUserName">用户名</label>
				    <div class="controls">
				    
				    	<input type="text" id="inputUserName" name="modifydadminName" value="<%=user1.getUserName() %>" readonly>
				    </div>
		  	  </div> 
			  	
			  	<div class="control-group">
			    	<label class="control-label" for="inputPassword1">密码</label>
				    <div class="controls">
				      	<input type="password" id="inputPassword1" name="inputPassword1" value="<%=user1.getUserPassword() %>" placeholder="原密码">
				    </div>
			  	</div>
			  	<div class="control-group">
			    	<label class="control-label" for="inputPassword2">确认密码</label>
				    <div class="controls">
				      	<input type="password" id="inputPassword2" name="inputPassword2" placeholder="password">
				    </div>
			  	</div>
			  	
			  	<div class="control-group">
			    	<label class="control-label" for="inputEmail">我的邮箱</label>
				    <div class="controls">
				    	<input type="email" id="inputEmail" name="inputEmail" value="<%=user1.getUserMail() %>" placeholder="email" >
				    </div>
			  	</div><%}} %>
			  	
			  		<div class="control-group controls">
			     <input type="submit" class="btn btn-success" value="确认修改">
			    <input type="reset" value="重置" class="btn btn-danger" >
			  	</div>
			<!-- form end -->		</form>
    <%
    
    	session.removeAttribute("modifyUser1");
    	}
    	String addUser = (String) session.getAttribute("addUser");
    	if(addUser != null && addUser.equals("addUser")){
    %>
    <span class="path"><i class="icon-home"></i>> 用户管理 > 添加用户账号</span>
    <hr>
 
 
    <script language="javascript" src="js/1234.js"></script>
    <form class="form-horizontal" action="regServlet" method="post">
				<div class="control-group">
			    	<label class="control-label" for="inputUserRole">所属行业</label>
				    <div class="controls">
				    <select id="inputUserRole" name="inputUserRole">
				 <option value="10">省政府</option> 
				 <option value="11">市政府</option> 
				 <option value="12">县政府</option> 
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
			  		<input type="hidden" name="from" value="fromAdmin">
			      	<button type="submit" class="btn btn-success" >添加账号</button>
			      	<button type="reset" class="btn btn-danger">重置</button>
			  	</div>
</form>
			
  <%session.removeAttribute("addUser");
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
    %><SCRIPT language="javascript">  
 setup();  
</SCRIPT>
</body>
 
</html>