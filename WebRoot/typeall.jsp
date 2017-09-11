<%@page import="com.atoz.survey.po.Login"%>
<%@page import="com.atoz.survey.po.Paper"%>
<%@page import="com.atoz.survey.po.User"%>
<%@page import="com.atoz.survey.service.impl.UserServiceImpl"%>
<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="java.util.Calendar"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'typeall.jsp' starting page</title>
    
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
 <%   // Calendar cal = Calendar.getInstance(); 
    	int month = 12;//cal.get(Calendar.MONTH) + 1;
    	System.out.println(month);
  		int showPage = 1;
  	//	String showPageInt = request.getParameter("showPage");
  	//	if(showPageInt != null){
  	//		showPage = Integer.parseInt(showPageInt);
  	//	}
  		//String area=(String)session.getAttribute("useradd");
  		
  		  String juese=request.getParameter("userthree");
  		
  		  int js=Integer.parseInt(juese);
  		  System.out.println(js);
  		
  		
  		  
  		  
UserServiceImpl userService = new UserServiceImpl();


List<User> users = userService.findUserByChooseType(js);



   
    
        System.out.println("你好吗"); 
      
  		
  	/*	int showcurrentPage = 0;
  		int remainCount = 0;
  		int endLineCount = 0;
  		int pageSize = 10;*/
  		if(users != null){
		/*	int pageAllCount = 0; //total counts
if(showPage == 0){showPage = 1;}
			pageAllCount = users.size();
			
			showcurrentPage = (showPage - 1) * pageSize;  //起始处下标
			remainCount = pageAllCount - showcurrentPage; //剩余的条数
			if(remainCount > 10){
				 endLineCount = showcurrentPage + 10; //截止下标
			}
			else{
				endLineCount = pageAllCount;
			}*/
   %>
  
	<div class="container1">
    	<div class="masthead">
    		<ul class="nav nav-pills pull-right">
    			
          
    			<li>&nbsp;</li>
    			
    			
    		</ul>    		
    		<h1><a href="typepicture.jsp?hid=<%=js %>">查看分布图</a></h1>
    	</div>
 
    	
    	
    	<div class="maincontent">
    		<div class="row-fluid">
    			<div class="span10">
    		<table class="table table-striped table-hover">

    			<thead> 
    				<tr>
    				
    					<th>企业名称</th>
    					 <th>自评分数</th>

    					
    					<th>委托分数</th>
    				</tr>
    			</thead>
    			<tbody>
    			<%	
    			
    				
    				
    				
    				for(int i =0; i < users.size(); i++){
    				User user = users.get(i);
    			
    					%>			
    			<tr> 
    				<td><%=user.getUserSummary() %></td>
    				 <% if(month==3||month==4||month==5){%>
	       <td><%=user.getUserSpring() %></td>
	          <td><%=user.getUserSspr() %></td><%} %>
	          <% if(month==6||month==8||month==7){%>
	       <td><%=user.getUserSummer() %></td>
	          <td><%=user.getUserSsm() %></td><%} %>
	          <% if(month==9||month==10||month==11){%>
	       <td><%=user.getUserAut() %></td>
	          <td><%=user.getUserSa() %></td><%} %>
	          <% if(month==12||month==1||month==2){%>
	       <td><%=user.getUserWin() %></td>
	          <td><%=user.getUserSw() %></td><%} %>
    				</tr>
    				<%}%>
    			</tbody>
    		</table>
    			</div>
    			
    		<%} %>
    	</div>

   </div><center>
 <div class="span2">
	    			<div class="right-button">
	    				<div>
	    					<div class="span2"></div>
	    					<div class="span8 fabu">	    				
	    					<a href="tree.jsp" class="btn btn-success">返回主页面</a></div>
	    					<div class="span2"></div>
	    				</div>
	    				
	    			</div>
    			</div></center>
  </body>
</html>
