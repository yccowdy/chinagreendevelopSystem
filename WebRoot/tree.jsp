<%@page import="com.atoz.survey.po.Login"%>
<%@page import="com.atoz.survey.po.Paper"%>
<%@page import="com.atoz.survey.po.User"%>
<%@page import="com.atoz.survey.service.impl.*"%>
<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="java.util.Calendar"%>
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
  
  <body link="red">
  <% //Calendar cal = Calendar.getInstance(); 
    		int month = 12;//cal.get(Calendar.MONTH) + 1;
    		System.out.println(month);
  		int showPage = 1;
  		String showPageInt = request.getParameter("showPage");
  		if(showPageInt != null){
  			showPage = Integer.parseInt(showPageInt);
  		}
    	List<User> users = (List<User>)session.getAttribute("users");
    		String ID = request.getParameter("userhaoma");
    		System.out.println("ID======"+ID);
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
    			<a href="login.jsp"
     onClick="{if(confirm('确实要注销吗？')){return true;}return false;}">注销</a><br>	</ul> <br><br>
      	<ul class="nav nav-pills pull-center">
    
      <li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
    	</ul><br><br>
    				  		
    		
    		
    		<div class="row-fluid">
    			<div class="span10">
    			
    			  <form action="TreeServlet" method="post">
    	 搜索行业：<select id="choosetype1" name="choosetype1">
    	<option value="6">所有</option>
    	<option value="1">非金属矿物制品业-平板玻璃</option>
    	<option value="2">非金属矿物制品-人造板</option>
    	<option value="3">非金属矿物制品-水泥工业</option>
    	<option value="4">业化学品制造业-氮肥制造业</option>
    	<option value="5">煤炭开采及洗选业</option>
    	</select>
    	&nbsp;&nbsp;
    	<input type="submit" value="查询">
    	
    		
  
    	 </form>
    	
    </div></div>
    	
    		<table class="table table-striped table-hover">
    			<thead>
    				<tr> 
    				<th>所在省(分数排行)</th>
    				<th>所在市(分数排行)</th>
    				<th>所在县(分数排行)</th>
    				<th>所属行业</th>
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
    					int paperjidu=0;
    			System.out.println(month);
    					if(month==3||month==4||month==5)
	       paperjidu=1;
	          if(month==6||month==8||month==7)
	       paperjidu=2;
	        if(month==9||month==10||month==11)
	       paperjidu=3;
	          if(month==12||month==1||month==2)
	          paperjidu=4;
	       %>
    			<tr>
    			<td><a href="sort.jsp?useradd=<%=user.getUserProv() %>&jiaose=<%=t %>&juese=<%=10 %>&userid=<%=6 %>&ThreeMark=<%=9 %>" title="查看地区企业分数" alt="查看地区企业分数"><%=user.getUserProv() %></a></td>
    			<td><a href="sort.jsp?useradd=<%=user.getUserCity() %>&jiaose=<%=t %>&juese=<%=11 %>&userid=<%=6 %>&ThreeMark=<%=9 %>" title="查看地区企业分数" alt="查看地区企业分数"><%=user.getUserCity() %></a></td>
    			<td><a href="sort.jsp?useradd=<%=user.getUserArea() %>&jiaose=<%=t %>&juese=<%=12 %>&userid=<%=6 %>&ThreeMark=<%=9 %>" title="查看地区企业分数" alt="查看地区企业分数"><%=user.getUserArea() %></a></td>
    			<td><a href="typeall.jsp?userthree=<%=t %>" title="查看该行业企业" alt="查看该行业企业"><%=ty %></a></td>
    				 <%System.out.println("t=="+t); %>
    				 <td><a href="surveypage.jsp?papertype=<%=user.getUserRole()%>&userid=<%=user.getUserId() %>&paperJidu=<%=paperjidu%>" title="对企业打分" alt="对企业打分"><%=user.getUserSummary() %></a></td>
    				 <td><a href="showresult.jsp?userid=<%=user.getUserId() %>&ID=<%=6 %>" class="btn btn-small" title="查看企业分数" alt="查看企业分数">查看结果</a></td>
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
    						<li><a href="tree.jsp?showPage=<%=(showPage-1) %>">前一页</a></li>
    				<%
    					}else{
    				%>
    					<li class="disabled"><a href="tree.jsp?showPage=<%=(showPage-1) %>">前一页</a></li>
    				<%
    					}
    				 %>
					  <li><a href="tree.jsp?showPage=<%=(showPage+1) %>">后一页</a></li>
					</ul>
		    	</div>
    		</div>
    	</div>

   <%} %>
  
 

  </body>
</html>
