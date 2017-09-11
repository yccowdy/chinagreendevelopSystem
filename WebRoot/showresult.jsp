<%@page import="com.atoz.survey.po.Login"%>
<%@page import="com.atoz.survey.po.Question"%>
<%@page import="com.atoz.survey.dao.mysqlimpl.QuestionDaoImpl"%>
<%@page import="com.atoz.survey.dao.mysqlimpl.PaperDaoImpl" %>
<%@page import="com.atoz.survey.dao.mysqlimpl.UserDaoImpl" %>
<%@page import="com.atoz.survey.po.Paper"%>
<%@page import="com.atoz.survey.dao.QuestionDao"%>
<%@page import="com.atoz.survey.po.User"%>
<%@page import="com.atoz.survey.dao.mysqlimpl.*"%>
<%@page import="com.atoz.survey.service.impl.UserServiceImpl"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'showresult.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="css/bookstrap-responsive.min.css" rel="stylesheet"
	type="text/css">
<!--[if lt IE 9]>
      	<script src="js/html5shiv.js"></script>
    <![endif]-->
<script src="js/jquery-1.9.1.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/html5shiv.js"></script>
<style type="text/css">
body {
	background-repeat: repeat-x;
	background-attachment: fixed;
}

.container {
	margin-top: 15px;
}

.radio.inline.q2+.radio.inline.q2 {
	margin-right: 30px;
}

.survey {
	border: 1px;
	background-color: white;
	height: auto;
	margin: 0px;
	padding: 15px 0px 0px 30px;
}

.div_question {
	width: 96%;
	height: auto;
	border: 2px solid white;
	padding: 4px 4px;
	margin: 2px auto;
	border-bottom: 1px solid #EFEEEE;
}

.plength {
	width: 60%;
	text-align: center;
}

.mastfoot {
	text-align: center;
	margin: 10px 0px 5px;
}
</style>

</head>

<body>
<%//List<Paper> papers = (List<Paper>) session.getAttribute("papers");

	//Login login = (Login) session.getAttribute("loginInfo");
 %>
	<div class="container">
		<div class="masthead">
	
				</li>
			</ul> -->
			<h1>欢迎使用</h1>
		</div>
		<hr>
		<hr>
		
			
		<%
					
		String useridstring = request.getParameter("userid");
		String ID0 = request.getParameter("ID");
		int ID=Integer.parseInt(ID0);
		int id = Integer.parseInt(useridstring);
		System.out.println("id=="+id);
		User user = null;
		UserServiceImpl userService = new UserServiceImpl();
		user=userService.findUserByUserId(id);
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
			%>
			 <table class="table table-hover">
    	<thead>
    	     <td>企业名称</td>
    		<td>政府类型</td>
    		<td>详细地址</td>
    		<td>邮箱</td>
    		<td>注册时间</td>
    		<td>委托分数</td>
    		<td>自评分数</td>
    		<% //Calendar cal = Calendar.getInstance(); 
    		int month = 12;//cal.get(Calendar.MONTH) + 1;
    		%>
    	</thead>
    	<tr>
    	<TD><%=user.getUserSummary()%> </TD>
			<td><%=ty %></td>
	    <td><%=user.getUserAdd() %></td>
	    <td><%=user.getUserMail() %></td>
	    <td><%=user.getUserReg() %></td>
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
			<%if(ID==6){%>
		  <a href="tree.jsp">返回</a><%} %>
		  <%if(ID!=6&&ID!=19){%>
		  <a href="user.jsp">返回</a><%} %>
		  <%if(ID==19){%>
		  <a href="company.jsp">返回</a><%} %>

	
	
</body>

</html>
