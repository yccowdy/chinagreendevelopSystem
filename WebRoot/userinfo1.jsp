<%@page import="com.atoz.survey.po.User"%>
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
	


<center>
  <body> 
  	<h3>欢迎使用企业行为评测系统</h3>
  	 <%String id1=request.getParameter("userid");
  int id=Integer.parseInt(id1);
  User user=null;
   Calendar cal = Calendar.getInstance(); 
    		int month = cal.get(Calendar.MONTH) + 1;
    		System.out.println(month);
    		int jijie=0;
					if(month==3||month==4||month==5)
	       jijie=1;
	          if(month==6||month==8||month==7)
	       jijie=2;
	        if(month==9||month==10||month==11)
	       jijie=3;
	          if(month==12||month==1||month==2)
	          jijie=4;
  UserServiceImpl userService = new UserServiceImpl();
   user = userService.findUserByUserId(id);
  
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
 %>  <table width="43%" border="1">
  <tr>
    <td width="21%">公司名称</td>
    <td width="79%"><%=user.getUserSummary() %></td>
  </tr>
  <tr>
    <td>所在省</td>
    <td><%=user.getUserProv() %></td>
  </tr>
  <tr>
    <td>所在市</td>
    <td><%=user.getUserCity() %></td>
  </tr>
  <tr>
    <td>所在县</td>
    <td><%=user.getUserArea() %></td>
  </tr>
   <%if(jijie==1){ %>
   <tr>
    <td>委托分数</td>
    <td><%=user.getUserSpring() %></td>
  </tr>
  <tr>
    <td>自评分数</td>
    <td><%=user.getUserSspr()%></td>
  </tr><%}
  if(jijie==2){ %>
  <tr>
    <td>委托分数</td>
    <td><%=user.getUserSummer() %></td>
  </tr>
  <tr>
    <td>自评分数</td>
    <td><%=user.getUserSsm() %></td>
  </tr><%}
  if(jijie==3){ %>
  <tr>
    <td>委托分数</td>
    <td><%=user.getUserAut() %></td>
  </tr>
  <tr>
    <td>自评分数</td>
    <td><%=user.getUserSa() %></td>
  </tr><%}
  if(jijie==4){ %>
  <tr>
    <td>委托分数</td>
    <td><%=user.getUserWin() %></td>
  </tr>
  <tr>
    <td>自评分数</td>
    <td><%=user.getUserSw()%></td>
  </tr><%}
   %>
  
  <tr>
    <td>公告</td>
    <td><%=user.getUserSex() %></td>
  </tr>
  <tr>
    <td>联系方式</td>
    <td><%=user.getUserMail() %></td>
  </tr>
  <tr>
    <td>注册时间</td>
    <td><%=user.getUserReg() %></td>
  </tr>
  <tr>
    <td>所属行业</td>
    <td><%=ty %></td>
  </tr>
  <tr>
    <td>详细地址</td>
    <td><%=user.getUserAdd() %></td>
  </tr>
  <tr>
    <td>法人代表</td>
    <td><%=user.getUserPerson() %></td>
  </tr>
  <tr>
    <td>是否上市</td>
    <td><%=user.getUserShangshi() %></td>
  </tr>
  <tr>
    <td>公司类型</td>
    <td><%=user.getUserType() %></td>
  </tr>
   <tr>
    <td>注册号</td>
    <td><%=user.getUserZc() %></td>
  </tr>
</table>
<center>
<p><a href="iframe.jsp">关闭</a></p></center>
  </body></center>
</html>