<%@page import="com.atoz.survey.po.Login"%>
<%@page import="com.atoz.survey.po.Paper"%>
<%@page import="com.atoz.survey.po.User"%>
<%@page import="com.atoz.survey.service.impl.UserServiceImpl"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
int count1=0,count2=0,count3=0,count4=0,count5=0;
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>个人中心</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/bootstrap-responsive.min.css">
	<style type="text/css">
		body {
			padding-top: 20px;
			padding-bottom: 40px;
		}
		.container1{
		width:960px;
		margin:auto;
		}
		/*内容部分*/
		.maincontent{
			margin-top:40px;
			height:auto;
		}
		.right-button{
			border-width:3px;
			border-color:red;
			margin:0;
			padding:30px 0px 0px 3px;
		}
		.buttonspace{
			margin-top:15px;
			padding:20px 0px 0px 3px; 
		}
		
		/*热门推荐等格式*/
		.marketing p + h4 {
			margin-top: 28px;
		}
		.nav-pills > li > a {
			padding-top: 2px;
		}
		.fabu a {
			color: #FFFFFF;
			text-decoration: none;
		}
	</style>
	
	<!--[if lt IE 9]>
      	<script src="js/html5shiv.js"></script>
    <![endif]-->
    <script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>

  </head>
  
  <body>
  <%    
  		
  		String roleuser=request.getParameter("roleuser");
  		System.out.println(roleuser);
  		String userarea=request.getParameter("userarea");
  		System.out.println(userarea);
  	
  			System.out.println(roleuser);
  		System.out.println(userarea);
       
           int role7=Integer.parseInt(roleuser);
	UserServiceImpl userService = new UserServiceImpl();
if(role7==12){
    List<User> users = userService.findUserByArea(userarea);
  System.out.println("nihaoma1");
  		Login login = (Login) session.getAttribute("loginInfo");
  	
  		if(users != null || login != null){
			
		
		
   %>
	<div class="container1">
    	<div class="masthead">
    		<ul class="nav nav-pills pull-right">
    			
    	
    		
    		</ul>    		
    	
    	</div>
 
    	
    
    	
    	<div class="maincontent">
    		<div class="row-fluid">
    			<div class="span10">
    		<table class="table table-striped table-hover">
		<thead>
    				<tr> <th>所属行业</th>
    				
    					<th>企业名称</th>
    				
    					<th>查看结果</th>
    				</tr>
    			</thead>
    			<tbody>
    			<%	
    			
    				
    				
    				
    				for(int i = 0; i < users.size(); i++){
    				User user = users.get(i);
    				// session.setAttribute("userarea", user.getUserArea());
    				int t=user.getUserRole();
    				String ty="";
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
    				if(t==0||t==-1||t==10||t==11||t==12){
    					continue;	
    				}else{
    					System.out.println(t);
    					
    				%>			
    			<tr>  <td><%=ty %></td>  
    
    				<td><a href="userinfo1.jsp?userid=<%=user.getUserId() %>" ><%=user.getUserSummary()%></a></td>
    		
    		<td><a href="showresult.jsp?papertype=<%=user.getUserRole()%>&userid=<%=user.getUserId() %>" class="btn btn-small">查看结果</a></td>
    				</tr>
    				<%}}}}%>
    			</tbody>
    		</table>
    			</div>
    			
    		
    		
    	</div>
   </div>
  
<%
  if(role7==11){
    List<User> users = userService.findUserByCity(userarea.trim());
  System.out.println("nihaoma1");
  		Login login = (Login) session.getAttribute("loginInfo");
  		
  		if(users != null || login != null){
		
   %>
 
	<div class="container1">
    	<div class="masthead">
    		<ul class="nav nav-pills pull-right">-->
    		
    
    		
    			
    		  	</ul>	
    	
    	</div>
 
    	
    	
    	
    	<div class="maincontent">
    		<div class="row-fluid">
    			<div class="span10">
    		<table class="table table-striped table-hover">
 
    			<thead>
    				<tr> <th>所属行业</th>
    					<th>企业名称</th>
    	
    					<th>联系方式</th>
    				</tr>
    			</thead>
    			<tbody>
    			<%	
    			
    				
    				
    				
    				for(int i = 0; i < users.size(); i++){
    				User user = users.get(i);
    				 session.setAttribute("userarea", user.getUserArea());
    				int t=user.getUserRole();
    				String ty="";
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
    				if(t==0||t==-1||t==10||t==11||t==12){
    					continue;	
    				}else{
    					System.out.println(t);
    					
    				%>			
    			<tr><td><%=ty %></td> 
    			
    			
    				<td><a href="userinfo1.jsp?userid=<%=user.getUserId() %>" ><%=user.getUserSummary()%></a></td>
    	<td><%=user.getUserMail() %></td>
    				</tr>
    				<%}}%>
    			</tbody>
    		</table>
    			</div>
    			
    		
    	</div>
   </div>
 <%		}
   			
   	}

 if(role7==10){
    List<User> users = userService.findUserByProv(userarea.trim());
  System.out.println("nihaoma1");
  		Login login = (Login) session.getAttribute("loginInfo");
  	
  		if(users != null || login != null){
		
   %>
 
	<div class="container1">
    	<div class="masthead">
    		<ul class="nav nav-pills pull-right">
    		
    	
    		
    			
    			
    		</ul>    		
    		
    	</div>
 
    	
    	
    	
    	<div class="maincontent">
    		<div class="row-fluid">
    			<div class="span10">
    		<table class="table table-striped table-hover">
  
    			<thead>
    				<tr> <th>所属行业</th>
    					<th>企业名称</th>
    			
    					<th>联系方式</th>
    				</tr>
    			</thead>
    			<tbody>
    			<%	
    			
    				
    				
    				
    				for(int i = 0 ;i <users.size(); i++){
    				User user = users.get(i);
    				 ///session.setAttribute("userarea", user.getUserArea());
    				int t=user.getUserRole();
    				String ty="";
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
    				if(t==0||t==-1||t==10||t==11||t==12){
    					continue;	
    				}else{
    					System.out.println(t);
    					
    				%>			
    			<tr><td><%=ty %></td> 
    				<td><a href="userinfo1.jsp?userid=<%=user.getUserId() %>" title="查看详细信息" alt="查看详细信息" ><%=user.getUserSummary()%></a></td>
    				<td><%=user.getUserMail() %></td>
    				 </tr>
    				<%}}%>
    			</tbody>
    		</table>
    			</div>
    			
  
    	</div>
   </div>
   
</div>
<%}} %>
  

  </body>
</html>
