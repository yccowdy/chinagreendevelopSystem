<%@page import="javax.swing.JOptionPane"%>
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
<%@page import="java.util.Calendar"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE>
<html lang="en">
  <head>
    <base href="<%=basePath%>">
    
    <title>问卷</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="css/bookstrap-responsive.min.css" rel="stylesheet" type="text/css">
	<!--[if lt IE 9]>
      	<script src="js/html5shiv.js"></script>
    <![endif]-->
	<script src="js/jquery-1.9.1.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/bootstrap.js"></script>
  <script src="js/html5shiv.js"></script>
  <style type="text/css">
  body{

  	background-repeat:repeat-x;
  	background-attachment:fixed;
  }
  .container{
  margin-top:15px;
  
  }
  .masthead{
  background-color:none;
  }
  .radio.inline.q2 + .radio.inline.q2{
  margin-right:30px;
  }

  .survey{
  	border:1px;
  	background-color:white;
  	height:auto;
  	margin:0px;
  	padding:15px 0px 0px 30px;
  	
  }
  .div_question{
  	width:96%;
  	height:auto;
  	border:2px solid white;
  	padding :4px 4px;
  	margin:2px auto;
  	border-bottom:1px solid #EFEEEE;
  }
 
  .mastfoot{
  text-align:center;
  margin:10px 0px 5px;
  }
  
  </style>
  <script type="text/javascript">  
  
    function check(form) {  
        if (form.totalNum.value ==0) {  
            alert("请输入用户帐号!");  
            form.totalNum.focus();  
            return false;  
        }  
     
    }  
    </script>
  </head>
  
  <body>
	<div class="container">
		<div class="masthead">
			<h1>欢迎使用<注意所有题目只能做一遍，且一次性的做完，谢谢合作></h1>
		</div>
		<hr>
		<hr>
 <div class="survey">
				
				<% 
    		int month = 12;
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
				String role=session.getAttribute("role").toString();
				int r= Integer.parseInt(role);
				QuestionDaoImpl questionDao = new QuestionDaoImpl();
				PaperDaoImpl paperDao=new PaperDaoImpl();	
				String ss = "";
				
				String papetypestring=request.getParameter("papertype");
				int type = Integer.parseInt(papetypestring);
				System.out.println(type);
				
				int qstCount = 1;
				System.out.println(qstCount);
				String paperjidustring=request.getParameter("paperJidu");
				int paperjidu = Integer.parseInt(paperjidustring);
				System.out.println(paperjidu);
				String Userid=request.getParameter("userid");
				
				int id = Integer.parseInt(Userid);
								System.out.println("id是什么啊"+id);
				User user = null;
				UserServiceImpl userService = new UserServiceImpl();
				user = userService.findUserByUserId(id);
				
				List<Question> questions = questionDao.findQuestionsByqstandjiduandfabu(type,paperjidu,qstCount);
				int totalNum = questions.size();
				int i = 1;
		if(totalNum==0&&r==-1){
 					//JOptionPane.showMessageDialog(null, "当前没有题目");
 					response.sendRedirect("tree.jsp");
 				}else if(r!=0&&r!=-1&&totalNum==0){
					//JOptionPane.showMessageDialog(null, "当前没有题目");
		response.sendRedirect("tree.jsp");}
				%>				
				<div class="div_question">
				<form  method="post" action="submitSucess">
				<input type="hidden" id="totalNum" name="totalNum" value="<%=questions.size()%>">
				<input type="hidden" name="userid" value="<%=id%>">
				<input type="hidden" name="papertype" value="<%=type%>">
				<input type="hidden" name="paperjidu" value="<%=paperjidu%>">
				<input type="hidden" name="treeid3" value="<%=6%>">
				<%
					for (Question question : questions) {
						ss = "q" + i;
			
				int qid=question.getPaperId();
				System.out.println(qid);
				Paper paper=paperDao.findPaperByPaperId(qid);
				System.out.println("flhjjlghkjghj");
%>
<b>一级标题：<%=paper.getPaperTitle() %></b>
<b>二级标题：<%=paper.getPaperSummary() %></b>
				
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
					System.out.println("r=="+r);%>
					<%	int win1=(int)user.getUserGrade();
					System.out.println("win1=="+win1);
				if(win1==1){
		         if(r==-1){
	%>
					<input class="btn btn-success" type="submit" value="提交" onclick="return check(this.form)"> 
					<input type="reset" class="btn btn-danger" value="重置" >
					
					
					<% }
					else {
					
				
					%>
					
				<input class="btn btn-success" type="submit" value="提交"> 
					<input type="reset" class="btn btn-danger" value="重置">
					
				
					<%
					}
					}
					else
					{if(r==-1){%>
						<a href="tree.jsp" class="btn btn-success">返回</a>
					<%}else {%>
					
					<a href="user.jsp" class="btn btn-success">返回</a>
					
					
					<%
					} }%>
					
					
			</form>
					</div>
		</div>		
				</div>
</body>
</html>
