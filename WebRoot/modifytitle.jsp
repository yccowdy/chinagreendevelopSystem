<%@page import="com.atoz.survey.dao.mysqlimpl.QuestionDaoImpl"%>
<%@page import="com.atoz.survey.dao.QuestionDao"%>
<%@page import="com.atoz.survey.po.Question"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'scanservey.jsp' starting page</title>

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

.masthead {
	background-color: none;
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


.mastfoot {
	text-align: center;
	margin: 10px 0px 5px;
}
</style>
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
</head>

<body >
	<div class="container">
		<div class="masthead">
			<!-- <ul class="nav nav-pills pull-right">
				<li><a href="#myMadel" role="button" class="btn"
					data-toggle="modal"> 登陆</a>
				</li>
				<li><a href="#" class="btn" data-toggle="modal"> 注册</a>
				</li>
			</ul>
			 -->
			<h1>欢迎使用</h1>
		</div>
		<hr>
		<hr>
		<div class="survey">
		 <%
					//QuestionDaoImpl questionDao = new QuestionDaoImpl();
    List<Question> questions=(List<Question>)session.getAttribute("questions");
    		String title=session.getAttribute("paperTitle").toString();
    		System.out.println("title"+title);
    		String content=session.getAttribute("content").toString();
    		String QstTitle=session.getAttribute("QstTitle").toString();
    		String QstAnswer=session.getAttribute("QstAnswer").toString();
    		String QstId=session.getAttribute("QstId").toString();
    		String Summary=session.getAttribute("paperSummary").toString();
    		System.out.println(Summary);
    		System.out.println("QstId=="+QstId);
              System.out.println("QstAnswer=="+QstAnswer);
    if(questions!=null){int k=20;%>
    <form  method="post" action="Sectitle" >
    
		    <label for="Sectitle"></label>
		    <select name="Sectitle" id="Sectitle">
           <%  for(int i = 0; i< questions.size();i++){
		   
		   %>
            <option value="<%=k++%>"><%=questions.get(i).getQstTitle()%></option>
           <%} %>
	        </select>
	          <input type="hidden" id="paperTitle" name="paperTitle" value="<%=title%>">
	           <input type="hidden" id="paperSummary"   name="paperSummary" value="<%=Summary%>">
	        <input type="submit" vaule="查询">
	      </form>
  <% } if(questions!=null){
					String ss ="";
					if (content != null) {
								String[] options = content.split("#");
    	 %><form action="ModifyTitle" method="post" onsubmit="return sumbit_sure();">
				    <label><h5>题目：</h5><input type="text" id="qstTitle"   name="qstTitle" value="<%=QstTitle%>" style="height:25px; font-size:15px;" ></lable>
				    <h5>分数：</h5><input type="text" id="qstAnswer"   name="qstAnswer" value="<%=QstAnswer%>" style="width:50px; height:25px;"></label>
				    <input type="hidden" id="QstId"   name="QstId" value="<%=QstId%>">
				    <input type="hidden" id="paperTitle"   name="paperTitle" value="<%=title%>">
	           <input type="hidden" id="paperSummary"   name="paperSummary" value="<%=Summary%>">
				   
    			<%if(!Summary.equals("环境管理体系认证")){%>
				    
				    <div class="control-group">
					    <label class="control-label" for="inputOption">A、</label>
					    <div class="controls">
					      <input type="text" id="inputOption" value="<%=options[0]%>"  name="qstOption1" style="width:150px; height:25px;" >
					    </div>
				    </div>
				     
				    <div class="control-group">
					    <label class="control-label" for="inputOption">B、</label>
					    <div class="controls">
					      <input type="text" id="inputOption" value="<%=options[1]%>"  name="qstOption2" style="width:150px; height:25px;">
					    </div>
				    </div>
				    <div class="control-group">
					    <label class="control-label" for="inputOption">C、</label>
					    <div class="controls">
					      <input type="text" id="inputOption" value="<%=options[2]%>"  name="qstOption3" style="width:150px; height:25px;">
					    </div>
				    </div>
				    
				    <div class="control-group">
					    <label class="control-label" for="inputOption">D、</label>
					    <div class="controls">
					      <input type="text" id="inputOption" value="<%=options[3]%>"  name="qstOption4" style="width:150px; height:25px;">
					    </div>
				    </div>
				    <div class="control-group">
					    <label class="control-label" for="inputOption">E、</label>
					    <div class="controls">
					      <input type="text" id="inputOption" value="<%=options[4]%>"  name="qstOption5" style="width:150px; height:25px;">
					    </div>
				    </div>
				    <%} else{%>
				    				  
				    <div class="control-group">
					    <label class="control-label" for="inputOption">A、</label>
					    <div class="controls">
					      <input type="text" id="inputOption" value="<%=options[0]%>"  name="qstOption1" style="width:150px; height:25px;">
					    </div>
				    </div>
				    <div class="control-group">
					    <label class="control-label" for="inputOption">B、</label>
					    <div class="controls">
					      <input type="text" id="inputOption" value="<%=options[1]%>"   name="qstOption2" style="width:150px; height:25px;">
					    </div>
				    </div>
				    <div class="control-group">
					    <label class="control-label" for="inputOption">C、</label>
					    <div class="controls">
					      <input type="text" id="inputOption" value="<%=options[2]%>"   name="qstOption3" style="width:150px; height:25px;">
					    </div>
				    </div>
					    
					
				    <%} %>
				    <input type="submit" name="sumbit" class="btn btn-success" value="确认修改" >
    		<input type="reset" value="重置" class="btn btn-danger" >
    		<a href="home.jsp" class="btn btn-danger">返回</a>
    		</form>
    		<%}}%>
    		
    	</div>
</div>
    
 </body>
</html>
