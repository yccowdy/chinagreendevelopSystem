<%@page import="com.atoz.survey.po.Login"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE>
<html lang="en">
<head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'modifypaper.jsp' starting page</title>
    
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
		.nav-pills > li > a {
			padding-top: 2px;
		}
		.fabu a {
			color: #FFFFFF;
			text-decoration: none;
		}
		#inputTitle {
			height: 30px;
			line-height: 30px;
		}
	.rrr {
	font-size: 9pt;
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
 request.setCharacterEncoding("utf-8");
String t0=request.getParameter("t");
int t=Integer.parseInt(t0);
System.out.println(t);
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
  	Login login = (Login) session.getAttribute("loginInfo");
   %>
    <div class="container1">
    	<div class="masthead">
    		<ul class="nav nav-pills pull-right">
    			<li>当前登录：<%=login.getUserName() %></li>
    			<%
    				if(login.isAdmin()){
    			%>
    			<li>&nbsp;</li>
    			<li><a href="admin.jsp">后台管理</a></li>
    			<%
    				}
    			 %>
    		</ul>
    		
    	</div>
    	<hr>
    	<div class="maincontent">
    		<form action="ModifyPaper" method="post" class="form-horizontal">
    			<script language="javascript" src="js/title.js"></script>  
				    <h3>修改问卷</h3>
				    <input type="hidden" name="paperJidu" value="4">
				     <input type="hidden" name="paperType" value="<%=t %>">
			   <!--  <div class="control-group">
					    <label class="control-label" for="inputJidu" >问卷编号</label>
					    <div class="controls">
					      <select name="paperJidu">
					      	<option value="4"></option>
					      <!-- 	<option value="2">第二季度</option>
					      	<option value="3">第三季度</option>
					      	<option value="4">第四季度</option> -->
					   <!--    	
					      </select>
					    </div>
				    </div> -->
				    <div class="control-group">
					    <label class="control-label" for="inputType" >问卷类别</label>
					    <div class="controls">
					    <!--   <select name="paperType">
					      	<option value="1">非金属矿物制品业（平板玻璃）</option>
					      	<option value="2">非金属矿物制品—人造板</option>
					      	<option value="3">非金属矿物制品—水泥工业</option>
					      	<option value="4">工业化学品制造业—氮肥制造业</option>
					      	<option value="5">煤炭开采及洗选业</option>
					      </select> -->
					      <%=ty %>
					    </div>
				    </div>
				   <!-- <div class="control-group">
					    <label class="control-label" for="inputWeight">一级指标权重</label>
					    <div class="controls">
					      <!--  <input type="text" id="inputWeight" placeholder="输入问卷权重" name="paperWeight" size="100" >-->
					<!-- > <select id="inputWeight" name="paperWeight">
					      <option>0.1</option>
					      <option>0.2</option>
					      <option>0.3</option>
					      <option>0.4</option>
					      <option>0.5</option>
					      <option>0.6</option>
					      <option>0.7</option>
					      <option>0.8</option>
					      <option>0.9</option>
					      <option>1.0</option>
					      </select> 
					    </div>
					</div> --> 
				    <div class="control-group">
					    <label class="control-label" for="inputTitle">请选择您要修改的指标</label>
					    <div class="controls">
					      <!-- <input type="text" id="inputTitle" placeholder="输入问卷标题" name="paperTitle"> 
					       <select id="inputTitle" name="paperTitle">
					      <option>1.绿色文化</option>
					      <option>2.组织体系</option>
					      <option>3.战略规划</option>
					      <option>4.管理制度</option>
					      <option>5.技术措施</option>
					      <option>6.环保绩效</option>
					      </select> -->
					      <select id="inputTitle" name="paperTitle" ></select>
					      <select id="inputPaperSummary" name="paperSummary"></select>
					 
				    </div>
				    </div>
				    <div class="control-group">
					    <label class="control-label" for="inputWeight">一级指标权重</label>
				      <div class="controls">
					      <!--  <input type="text" id="inputWeight" placeholder="输入问卷权重" name="paperWeight" size="100" >-->
					 <select id="inputWeight" name="paperWeight">
					      <option>0.1</option>
					      <option>0.2</option>
					      <option>0.3</option>
					      <option>0.4</option>
					      <option>0.5</option>
					      <option>0.6</option>
					      <option>0.7</option>
					      <option>0.8</option>
					      <option>0.9</option>
					      <option>1.0</option>
				        </select> 
					    &lt;<span class="rrr">如果修改权重，请选择。否则就按照权重值就不变&gt;</span></div>
					</div>
	    
				
				    
					<br>
					<SCRIPT language="javascript">  
 setup();  
</SCRIPT>


 
					<div class="control-group">
						<input type="reset" value="重置" class="btn btn-success" >
						<input type="submit" class="btn btn-success" value="下一步">
					</div>				    
    		</form>
    	</div>
</div>

</body>
</html>
