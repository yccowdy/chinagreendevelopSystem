<%@page import="com.atoz.survey.dao.QuestionDao"%>
<%@page import="com.atoz.survey.po.Question"%>
<%@page import="com.atoz.survey.po.Login"%>
<%@page import="com.atoz.survey.po.Question"%>
<%@page import="com.atoz.survey.dao.mysqlimpl.QuestionDaoImpl"%>
<%@page import="com.atoz.survey.dao.mysqlimpl.PaperDaoImpl" %>
<%@page import="com.atoz.survey.po.Paper"%>
<%@page import="com.atoz.survey.dao.QuestionDao"%>
<%@page import="com.atoz.survey.po.User"%>
<%@page import="com.atoz.survey.dao.mysqlimpl.*"%>
<%@page import="com.atoz.survey.service.impl.UserServiceImpl"%>
<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
	


 
	
  
  <body>
    <span class="path"><i class="icon-home"></i> > 用户管理 > 查看所有用户</span>
	<div class="container">
		<div class="masthead">
			<h1>欢迎使用<注意所有题目只能做一遍，且一次性的做完，谢谢合作></h1>
		</div>
		<hr>
		<hr>
 <div class="survey">
			<form  method="post" action="submitSucess">
				<%
				
				QuestionDaoImpl questionDao = new QuestionDaoImpl();
				PaperDaoImpl paperDao=new PaperDaoImpl();	
				String ss = "";
				//String papetypestring=request.getParameter("papertype");
				String papetypestring=session.getAttribute("papertype").toString();
				int type = Integer.parseInt(papetypestring);
				System.out.println(type);
				//String paperjidustring=request.getParameter("paperjidu");
				String paperjidustring=session.getAttribute("paperjidu").toString();
				int paperjidu = Integer.parseInt(paperjidustring);
				System.out.println(paperjidu);
				//String Userid=request.getParameter("userid");
				String Userid=session.getAttribute("userid").toString();
				int id = Integer.parseInt(Userid);
								System.out.println("id是什么啊"+id);
				
				User user = null;
		UserServiceImpl userService = new UserServiceImpl();
		user = userService.findUserByUserId(id);
				
				List<Question> questions = questionDao.findQuestionsByqstandjidu(type,paperjidu);
				int totalNum = questions.size();
				int i = 1;
				%>
				<input type="hidden" id="totalNum" name="totalNum" value="<%=questions.size()%>">
				<input type="hidden" name="userid" value="<%=id%>">
				<input type="hidden" name="papertype" value=<%=type%>>
				<input type="hidden" name="paperjidu" value=<%=paperjidu%>>
				<div class="div_question">
				<%
					for (Question question : questions) {
						ss = "q" + i;
			
int qid=question.getPaperId();
System.out.println(qid);
	Paper paper=paperDao.findPaperByPaperId(qid);
	System.out.println("flhjjlghkjghj");
%>
一级标题：<%=paper.getPaperTitle() %>
二级标题：<%=paper.getPaperSummary() %>
				
					<label><h5><%=i %>、<%=question.getQstTitle()%></h5>
					</label>
					<%
							String content = question.getQstOption();
							if (content != null) {
								String[] options = content.split("#");
								int j = 0;//跟踪选择的值变化
						for (String option : options) {
					%>
					<label class="radio"> <input type="radio" name="<%=ss%>"
						id="<%=ss%>" value="<%=j %>"> <%=option %> </label>
						

					<%System.out.println("ss"+ss);
						j++;
						}System.out.println("j"+j);
							} 
							i++;
						}
					%><input type="hidden" id="sj" name="sj" vaule="<%=i %>">
					<br>
					<%
					System.out.println("ss===="+ss);
			            
				
					String role=session.getAttribute("role").toString();
					int r= Integer.parseInt(role);
					System.out.println(r);
					String icon=user.getUserIcon();
					System.out.println(icon);
					///float mark=Integer.parseInt(icon);
					if(r==0){
	
	%> 				
					<a href="home.jsp" class="btn btn-success">返回</a>
										
					<% }else{ 
					if(r==-1){
					if(user.getUserGrade()==0){
					%>
					<input class="btn btn-success" type="submit" value="提交"   > 
					<input type="reset" class="btn btn-danger" value="重置" >
					<%
					}else{%>
					<a href="tree.jsp" class="btn btn-success">返回</a>
					<% }
					}
					if(r!=-1){
					if(Double.parseDouble(icon)==0){%>
				<input class="btn btn-success" type="submit" value="提交" > 
					<input type="reset" class="btn btn-danger" value="重置"><%}
					else{	System.out.println("你号码活动");%>
					<a href="user.jsp" class="btn btn-success">返回</a>
					<% }
					}
					}%>
					
				</div>
	</form>
	  </div>
  	</div>
  	</body>
</html>