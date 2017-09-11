<%@page import="com.atoz.survey.dao.mysqlimpl.QuestionDaoImpl"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.atoz.survey.dao.mysqlimpl.PaperDaoImpl" %>
<%@page import="com.atoz.survey.po.Paper"%>
<%@page import="com.atoz.survey.po.Question"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE>
<html lang="en">
  <head>
    <base href="<%=basePath%>">
    
    <title>添加问卷问题</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/bootstrap-responsive.css">
	<link rel="stylesheet" href="css/bootstrap-responsive.min.css">
	<!--[if lt IE 9]>
      	<script src="js/html5shiv.js"></script>
    <![endif]-->
    <script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<style type="text/css">
		body {
			padding-top: 20px;
			padding-bottom: 40px;
		}
		.container1{
			margin:auto;
			width:960px;
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
			margin-left:20px;
			padding:20px 0px 0px 3px; 
		}
		/*热门推荐等格式*/
		.marketing p + h4 {
			margin-top: 28px;
		}
		.controls input{
		 	height:30px;
		 	line-height:30px;
		}
	</style>
	
  </head>
  
  <body>
    <div class="container1">
    	<div class="masthead">
    	
    	
    	</div>
    	<hr>
    	<div class="maincontent">
    		<ul class="nav nav-pills">
    			<li class="active">
    				单选题
    			</li>
    			
    		</ul>
    		
    	<%
    		String papertype=session.getAttribute("papertype").toString();
    		int type= Integer.parseInt(papertype);
    		System.out.println(type);
    		String paperJidu0=session.getAttribute("paperJidu").toString();
    		int paperJidu= Integer.parseInt(paperJidu0);
    		System.out.println(paperJidu);
    		String title=session.getAttribute("paperTitle").toString();
    		System.out.print(title);
    		String Summary=session.getAttribute("paperSummary").toString();
    		System.out.println(Summary);
    	%>
    	一级指标：<%=title%>
    	<br>
    	<%
    	PaperDaoImpl paperDao=new PaperDaoImpl();
    	List<Question> questions = new ArrayList<Question>();
    	QuestionDaoImpl qusetionDao=new QuestionDaoImpl();
    	List<Paper> papers=paperDao.findPapersBytitleandtypeandjidu(title, type, paperJidu);
    	System.out.println("papers=="+papers);
    	int sum=0;
    	for(Paper paper : papers){
    		questions=qusetionDao.findQuestionsByPaperId(paper.getPaperId());
    		System.out.println(paper.getPaperId());
    		for (Question question : questions){
    		String score=question.getQstAnswer();
    		int s=Integer.parseInt(score);
    		sum=sum+s;
    		}
    		System.out.println(sum);
    	}
    	String nu="";
    	 %>
    	该一级指标还能出<%=100-sum %>分
    		<form action="addQuestions" method="post" class="form-horizontal">
    			<input type="hidden" value=<%=type %> name="qstType">
    			<input type="hidden" value=<%=sum %> name="jc">
				    <label>添加问题</label>
    			<%if(!Summary.equals("环境管理体系认证")){%>
				    <div class="control-group">
					    <label class="control-label" for="inputTitle">问题题目</label>
					    <div class="controls">
					    <textarea rows="3" cols="50" name="qstTitle" placeholder="输入问题题目 " value="<%=nu%>"></textarea>
					    </div>
				    </div>
				    <div class="control-group">
					    <label class="control-label" for="inputgrade">分数</label>
					    <div class="controls">
					    <input type="text" name="qstAnswer" placeholder="输入问题分数 " style="width:50px; height:25px;">
					    </div>
				    </div>
				    <div class="control-group">
					    <label class="control-label" for="inputOption">A、</label>
					    <div class="controls">
					      <input type="text" id="inputOption" placeholder="输入选项内容" name="qstOption1" value="<%=nu%>">
					    </div>
				    </div>
				      <input type="hidden" id="inputJidu"  name="paperJidu" value="<%=paperJidu%>">
				    <div class="control-group">
					    <label class="control-label" for="inputOption">B、</label>
					    <div class="controls">
					      <input type="text" id="inputOption" placeholder="输入选项内容" name="qstOption2" value="<%=nu%>">
					    </div>
				    </div>
				    <div class="control-group">
					    <label class="control-label" for="inputOption">C、</label>
					    <div class="controls">
					      <input type="text" id="inputOption" placeholder="输入选项内容" name="qstOption3" value="<%=nu%>">
					    </div>
				    </div>
				    
				    <div class="control-group">
					    <label class="control-label" for="inputOption">D、</label>
					    <div class="controls">
					      <input type="text" id="inputOption" placeholder="输入选项内容" name="qstOption4" value="<%=nu%>">
					    </div>
				    </div>
				    <div class="control-group">
					    <label class="control-label" for="inputOption">E、</label>
					    <div class="controls">
					      <input type="text" id="inputOption" placeholder="输入选项内容" name="qstOption5" value="<%=nu%>">
					    </div>
				    </div>
				    <%} else{%>
				    				    <div class="control-group">
					    <label class="control-label" for="inputTitle">问题题目</label>
					    <div class="controls">
					    <textarea rows="3" cols="50" name="qstTitle" placeholder="输入问题题目 " value="<%=nu%>"></textarea>
					    </div>
				    </div>
				    <div class="control-group">
					    <label class="control-label" for="inputgrade">分数</label>
					    <div class="controls">
					  <input type="text" name="qstAnswer" placeholder="输入问题分数 " style="width:50px; height:25px;" >
					    </div>
				    </div>
				    <div class="control-group">
					    <label class="control-label" for="inputOption">A、</label>
					    <div class="controls">
					      <input type="text" id="inputOption" placeholder="输入选项内容" name="qstOption1"  value="<%=nu%>">
					    </div>
				    </div>
				    <div class="control-group">
					    <label class="control-label" for="inputOption">B、</label>
					    <div class="controls">
					      <input type="text" id="inputOption" placeholder="输入选项内容" name="qstOption2" value="<%=nu%>">
					    </div>
				    </div>
				    <div class="control-group">
					    <label class="control-label" for="inputOption">C、</label>
					    <div class="controls">
					      <input type="text" id="inputOption" placeholder="输入选项内容" name="qstOption3" value="<%=nu%>">
					    </div>
				    </div>
					      <input type="hidden" value="0" id="inputOption" placeholder="输入选项内容" name="qstOption4">
					      <input type="hidden" value="0" id="inputOption" placeholder="输入选项内容" name="qstOption5">
					      <input type="hidden" id="inputJidu"  name="paperJidu" value="<%=paperJidu%>">
				    <%} %>
				    <input type="submit" name="sumbit" class="btn btn-success" value="继续添加">
    		</form>
    		
    	</div>
    </div>
    
  </body>
</html>
