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
  		int showPage = 1;
  		String showPageInt = request.getParameter("showPage");
  		if(showPageInt != null){
  			showPage = Integer.parseInt(showPageInt);
  		}
  		String roleuser=session.getAttribute("roleuser").toString();
  		System.out.println(roleuser);
  		String userarea=session.getAttribute("userarea").toString();
  		System.out.println(userarea);
  		String foundarea=session.getAttribute("foundarea").toString();
  			System.out.println(roleuser);
  		System.out.println(userarea);
        System.out.println(foundarea);
           int role7=Integer.parseInt(roleuser);
	
	 
if(role7==12){
     List<User> users = (List<User>)session.getAttribute("users");
  System.out.println("nihaoma1");
  		Login login = (Login) session.getAttribute("loginInfo");
  		int showcurrentPage = 0;
  		int remainCount = 0;
  		int endLineCount = 0;
  		int pageSize = 10;
  		if(users != null || login != null){
			int pageAllCount = 0; //total counts
if(showPage == 0){showPage = 1;}
			pageAllCount = users.size();
			
			showcurrentPage = (showPage - 1) * pageSize;  //起始处下标
			remainCount = pageAllCount - showcurrentPage; //剩余的条数
			if(remainCount > 10){
				 endLineCount = showcurrentPage + 10; //截止下标
			}
			else{
				endLineCount = pageAllCount;
			}
   
 
   %>
	<div class="container1">
    	<div class="masthead">
    		<ul class="nav nav-pills pull-right">
    	
    			<li>当前登录：<%=login.getUserName() %></li>
    			
    		<li>&nbsp;</li>
    		<%=userarea %>
    		<input type="hidden" name="role" value="<%=role7 %>">
    			
   
    			<li>&nbsp;</li>
    			<li><a href="modifame.jsp">后台管理</a></li>
    			<a href="login.jsp"
					  
						onClick="{if(confirm('确实要注销吗？')){return true;}return false;}">注销</a>
    		</ul> 
    		 		
    		
    	
 </div>
    	
    	
    	
    	<div class="maincontent">
    		<div class="row-fluid">
    			<div class="span10">
    		<table class="table table-striped table-hover">
    		<form action="TypechoServlet" method="post">
    搜索行业：<select id="choosetype" name="choosetype">
    
    	<option value="6">所有</option> 
    	<option value="1">非金属矿物制品业-平板玻璃</option>
    	<option value="2">非金属矿物制品-人造板</option>
    	<option value="3">非金属矿物制品-水泥工业</option>
    	<option value="4">业化学品制造业-氮肥制造业</option>
    	<option value="5">煤炭开采及洗选业</option>
    	</select>&nbsp;&nbsp;
    		<input type="hidden" name="userarea" value="<%=userarea %>">
    		<input type="hidden" name="role7" value="<%=role7 %>">
    		<input type="submit" value="查询">
    		</form>
    			<thead>
    				<tr> <th>所属行业<查看分数></th>
    				
    					<th>企业名称</th>
    				<!-- 	 <th>三方分数</th>
    				<th>自评分数</th>
    					 -->
    					<th>查看结果</th>
    				</tr>
    			</thead>
    			<tbody>
    			<%	
    			
    				
    				
    				
    				for(int i = showcurrentPage; i < endLineCount; i++){
    				User user = users.get(i);
    			
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
    			<tr>  <td><a href="sort.jsp?useradd=<%=userarea %>&jiaose=<%=t %>&juese=<%=12 %>&userid=<%=6 %>&ThreeMark=<%=9 %>" title="查看地区企业分数" alt="查看地区企业分数"><%=ty %></a></td>  
    
    			
    		<td><a href="companyinfo.jsp?userid=<%=user.getUserId() %>" ><%=user.getUserSummary()%></a></td>
    		<td><a href="showresult.jsp?papertype=<%=user.getUserRole()%>&userid=<%=user.getUserId() %>&ID=<%=19 %>" class="btn btn-small">查看结果</a></td>
    				</tr>
    				<%}}%>
    			</tbody>
    		</table>
    			</div>
    			
    		<div class="row">
    			<div class="span10">
    				<ul class="pager">
    				<%
    					if(showPage != 1){
    				%>
    						<li><a href="company.jsp?showPage=<%=(showPage-1) %>">前一页</a></li>
    				<%
    					}else{
    				%>
    					<li class="disabled"><a href="company.jsp?showPage=<%=(showPage-1) %>">前一页</a></li>
    				<%
    					}
    				 %>
					  <li><a href="company.jsp?showPage=<%=(showPage+1) %>">后一页</a></li>
					</ul>
		    	</div>
    		</div>
    	</div>
   </div>
   <%		}}
   			
   	
  
  if(role7==11){
    List<User> users = (List<User>)session.getAttribute("users");
  System.out.println("nihaoma1");
  		Login login = (Login) session.getAttribute("loginInfo");
  		int showcurrentPage = 0;
  		int remainCount = 0;
  		int endLineCount = 0;
  		int pageSize = 10;
  		if(users != null || login != null){
			int pageAllCount = 0; //total counts
if(showPage == 0){showPage = 1;}
			pageAllCount = users.size();
			
			showcurrentPage = (showPage - 1) * pageSize;  //起始处下标
			remainCount = pageAllCount - showcurrentPage; //剩余的条数
			if(remainCount > 10){
				 endLineCount = showcurrentPage + 10; //截止下标
			}
			else{
				endLineCount = pageAllCount;
			}
   
   %>
 
	<div class="container1">
    	<div class="masthead">
    		<ul class="nav nav-pills pull-right">
    			<li>当前登录：<%=login.getUserName() %></li>		<li>&nbsp;</li>
    		<%=foundarea %>
    		
    			<li>&nbsp;</li>
    			<li><a href="modify.jsp">后台管理</a></li>
    				<a href="login.jsp"
					  
						onClick="{if(confirm('确实要注销吗？')){return true;}return false;}">注销</a>
    		</ul>    
    				
    	
    	</div>

    	
    	
    	
    	<div class="maincontent">
    		<div class="row-fluid">
    			<div class="span10">
    		<table class="table table-striped table-hover">
    		  <form action="TypechoServlet" method="post">
    搜索行业：<select id="choosetype" name="choosetype">
    
    <option value="6">所有</option>
    	<option value="1">非金属矿物制品业-平板玻璃</option>
    	<option value="2">非金属矿物制品-人造板</option>
    	<option value="3">非金属矿物制品-水泥工业</option>
    	<option value="4">业化学品制造业-氮肥制造业</option>
    	<option value="5">煤炭开采及洗选业</option>
    	</select>&nbsp;&nbsp;
    		<input type="hidden" name="userarea" value="<%=userarea %>">
    		<input type="hidden" name="role7" value="<%=role7 %>">
    		<input type="submit" value="查询">
    	</form>
    			<thead>
    				<tr> <th>所属行业<查看分数></th>
    					<th>企业名称</th>
    		
    					<th>查看结果</th>
    				</tr>
    			</thead>
    			<tbody>
    			<%	
    			
    				
    				
    				
    				for(int i = showcurrentPage; i < endLineCount; i++){
    				User user = users.get(i);
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
    			<tr>
    			<td><a href="sort.jsp?useradd=<%=userarea %>&jiaose=<%=t %>&juese=<%=11 %>&userid=<%=6 %>&ThreeMark=<%=9 %>" title="查看地区企业分数" alt="查看地区企业分数"><%=ty %></a></td>
    			
    			<td><a href="companyinfo.jsp?userid=<%=user.getUserId() %>" ><%=user.getUserSummary()%></a></td>
    			<td><a href="showresult.jsp?papertype=<%=user.getUserRole()%>&userid=<%=user.getUserId() %>&ID=<%=19 %>" class="btn btn-small">查看结果</a></td>
    				</tr>
    				<%}}%>
    			</tbody>
    		</table>
    			</div>
    			
    		<div class="row">
    			<div class="span10">
    				<ul class="pager">
    				<%
    					if(showPage != 1){
    				%>
    						<li><a href="company.jsp?showPage=<%=(showPage-1) %>">前一页</a></li>
    				<%
    					}else{
    				%>
    					<li class="disabled"><a href="company.jsp?showPage=<%=(showPage-1) %>">前一页</a></li>
    				<%
    					}
    				 %>
					  <li><a href="company.jsp?showPage=<%=(showPage+1) %>">后一页</a></li>
					</ul>
		    	</div>
    		</div>
    	</div>
   </div>
 <%		}}
  if(role7==10){
    List<User> users = (List<User>)session.getAttribute("users");
  System.out.println(users);
  		Login login = (Login) session.getAttribute("loginInfo");
  		int showcurrentPage = 0;
  		int remainCount = 0;
  		int endLineCount = 0;
  		int pageSize = 10;
  		if(users != null || login != null){
			int pageAllCount = 0; //total counts
if(showPage == 0){showPage = 1;}
			pageAllCount = users.size();
			
			showcurrentPage = (showPage - 1) * pageSize;  //起始处下标
			remainCount = pageAllCount - showcurrentPage; //剩余的条数
			if(remainCount > 10){
				 endLineCount = showcurrentPage + 10; //截止下标
			}
			else{
				endLineCount = pageAllCount;
			}
   
  %>
 
	<div class="container1">
    	<div class="masthead">
    		<ul class="nav nav-pills pull-right">
    			<li>当前登录：<%=login.getUserName() %></li><li>&nbsp;</li>
    		<%=foundarea %>
    		
    			<li>&nbsp;</li>
    			<li><a href="modify.jsp">后台管理</a></li>
    				<a href="login.jsp"
          onClick="{if(confirm('确实要注销吗？')){return true;}return false;}">注销</a>
    		</ul>  
  	
    	
    	</div>

    	
    	
    	
    	<div class="maincontent">
    		<div class="row-fluid">
    			<div class="span10">
    		<table class="table table-striped table-hover">
    		 <form action="TypechoServlet" method="post">
    搜索行业：<select id="choosetype" name="choosetype">
    
    	<option value="6">所有</option>
    	<option value="1">非金属矿物制品业-平板玻璃</option>
    	<option value="2">非金属矿物制品-人造板</option>
    	<option value="3">非金属矿物制品-水泥工业</option>
    	<option value="4">业化学品制造业-氮肥制造业</option>
    	<option value="5">煤炭开采及洗选业</option>
    	</select>&nbsp;&nbsp;
    		<input type="hidden" name="userarea" value="<%=userarea %>">
    		<input type="hidden" name="role7" value="<%=role7 %>">
    		<input type="submit" value="查询">
    		</form>
    			<thead>
    				<tr> <th>所属行业<查看分数></th>
    					<th>企业名称</th>
    				
    					<th>查看结果</th>
    				</tr>
    			</thead>
    			<tbody>
    			<%	
    			
    				
    				
    				
    				for(int i = showcurrentPage; i < endLineCount; i++){
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
    			<tr><td><a href="sort.jsp?useradd=<%=userarea %>&jiaose=<%=t %>&juese=<%=10 %>&userid=<%=user.getUserId() %>&ThreeMark=<%=9 %>" title="查看该行业分数" alt="查看该行业分数"><%=ty %></a></td>
    			
    				<td><a href="companyinfo.jsp?userid=<%=user.getUserId() %>" title="查看企业信息" alt="查看企业信息"><%=user.getUserSummary()%></a></td>
    				
    				<td><a href="showresult.jsp?papertype=<%=user.getUserRole()%>&userid=<%=user.getUserId() %>&ID=<%=19 %>" class="btn btn-small">查看结果</a></td>
    				</tr>
    				<%}}%>
    			</tbody>
    		</table>
    			</div>
    			
    		<div class="row">
    			<div class="span10">
    				<ul class="pager">
    				<%
    					if(showPage != 1){
    				%>
    						<li><a href="company.jsp?showPage=<%=(showPage-1) %>">前一页</a></li>
    				<%
    					}else{
    				%>
    					<li class="disabled"><a href="company.jsp?showPage=<%=(showPage-1) %>">前一页</a></li>
    				<%
    					}
    				 %>
					  <li><a href="company.jsp?showPage=<%=(showPage+1) %>">后一页</a></li>
					</ul>
		    	</div>
    		</div>
    	</div>
   </div>
   </div>
   <%}}%>

  

  </body>
</html>
