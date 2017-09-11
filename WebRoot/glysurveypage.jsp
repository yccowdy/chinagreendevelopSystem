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
  </head>
   <script language="javascript">  
    function sumbit_sure(){  
    var gnl=confirm("提交后不可修改，确定要提交吗?");  
    if (gnl==true){  
    return true;  
    }else{  
    return false;  
    }  
    }  
    </script>  
  <body>
	<div class="container">
		<div class="masthead">
			<h1>欢迎使用</h1>
		</div>
		<hr>
		<hr>
 <div class="survey">
 	<%        String paperfabu1=request.getParameter("paperfabu");
			int paperfabu=Integer.parseInt(paperfabu1);
			System.out.println("paperfabu=="+paperfabu);
 	            String paperjidustring=request.getParameter("paperJidu");
				int paperjidu = Integer.parseInt(paperjidustring);
				System.out.println(paperjidu);
				String papertypestring=request.getParameter("papertype");		
				int type = Integer.parseInt(papertypestring);
				System.out.println("type=="+type);
				
			String Nows=request.getParameter("paperNow");
		
				int paperNow = Integer.parseInt(Nows);
				System.out.println("paperNow=="+paperNow);
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
	          jijie=4;%>
   <form  method="post" action="Bytypeandyiji">
     <label for="yiji"></label>
     <select name="yiji" id="yiji">
      <option value="79">所有</option>
       <option value="80">绿色文化</option>
       <option value="81">组织体系</option>
       <option value="82">战略规划</option>
       <option value="83">管理制度</option>
       <option value="84">技术措施</option>
       <option value="85">环保绩效</option>
       <option value="86">已发布</option>
       <option value="87">未发布</option>
     </select>
     <input type="hidden" name="papertype" value="<%=type%>">
	  <input type="hidden" name="paperJidu" value="<%=paperjidu%>">
	   <input type="hidden" name="paperNow" value="<%=31%>">
	    
	 <input type="hidden" name="paperfabu" value="<%=paperfabu%>"> 
     <input type="submit" value="查询">
   </form>
   
						<% 
					
                  if(paperNow==30){
				QuestionDaoImpl questionDao = new QuestionDaoImpl();
				PaperDaoImpl paperDao=new PaperDaoImpl();	
				String ss = "";
				//String papetypestring=request.getParameter("papertype");					
				List<Question> questions = questionDao.findQuestionsByqstandjidu(type,paperjidu);
				int totalNum = questions.size();
				int i = 1;
				
				%>
				
				<div class="div_question">
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
						id="<%=ss%>" value="<%=j %>" disabled> <%=option %> </label>
						

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
	%> 				
					<a href="home.jsp" class="btn btn-success">返回</a>
				</div>
		<%} if(paperNow==31){
		
			if(paperfabu==87){
				PaperDaoImpl paperDao=new PaperDaoImpl();	
				String ss = "";
				//String papetypestring=request.getParameter("papertype");					
			 List<Question> questions=(List<Question>)session.getAttribute("questions");
				int totalNum = questions.size();
				int i = 1;
				
				%>
				
				<div class="div_question">
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
						id="<%=ss%>" value="<%=j %>" disabled> <%=option %> </label>
						

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
					%>
					<form action="FabuServlet" method="post" onsubmit="return sumbit_sure()">
					<input type="hidden" id="leixing" name="leixing" value="<%=type %>" >
					<input type="submit" value="一键发布" class="btn btn-danger">
						<a href="home.jsp" class="btn btn-success">返回</a>
					</form>	
					<%
					}else{PaperDaoImpl paperDao=new PaperDaoImpl();	
				String ss = "";
				//String papetypestring=request.getParameter("papertype");					
			 List<Question> questions=(List<Question>)session.getAttribute("questions");
				int totalNum = questions.size();
				int i = 1;
				
				%>
				
				<div class="div_question">
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
						id="<%=ss%>" value="<%=j %>" disabled> <%=option %> </label>
						

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
					%>
					<a href="home.jsp" class="btn btn-success">返回</a><% }%>
				</div>
		<%} %>
		</div>
  	</div>
</html>
