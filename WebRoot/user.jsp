<%@page import="org.apache.tomcat.util.buf.UEncoder"%>
<%@page import="com.atoz.survey.po.Login"%>
<%@page import="com.atoz.survey.po.Paper"%>
<%@ page language="java" import="java.util.*" import="java.io.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
int count1=0,count2=0,count3=0,count4=0,count5=0,count6=0,count7=0,count8=0,count9=0,count10=0;int count11=0,count12=0,count13=0,count14=0,count15=0;int count16=0,count17=0,count18=0,count19=0,count20=0;
request.setCharacterEncoding("utf-8");
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
  
  <body>
  
	
  <%int z=0;
  	String Userid=session.getAttribute("userid").toString();
  	String ID = request.getParameter("userhaoma");
  	String userCompany=session.getAttribute("userCompany").toString();
  		int id=Integer.parseInt(Userid);
  		int showPage = 1;
  		String showPageInt = request.getParameter("showPage");
  		if(showPageInt != null){
  			showPage = Integer.parseInt(showPageInt);
  		}
  		
  		List<Paper> papers = (List<Paper>) session.getAttribute("papers");
  		Login login = (Login) session.getAttribute("loginInfo");
  		String role=session.getAttribute("role").toString();//11.29
  		String Area=(String)session.getAttribute("Area");
  		System.out.println("Area"+Area);
  		String userid=session.getAttribute("userid").toString();
  		int showcurrentPage = 0;
  		int remainCount = 0;
  		int endLineCount = 0;
  		int pageSize = 10;
  		if(papers != null || login != null){
			int pageAllCount = 0; //total counts
			if(showPage == 0){showPage = 1;}
			pageAllCount = papers.size();
			
			showcurrentPage = (showPage - 1) * pageSize;  //起始处下标
			remainCount = pageAllCount - showcurrentPage; //剩余的条数
			if(remainCount > 10){
				 endLineCount = showcurrentPage + 10; //截止下标
			}
			else{
				endLineCount=pageAllCount;
			}
  		
  		
		
   %>
	<div class="container1">
    	<div class="masthead">
    		<ul class="nav nav-pills pull-right">
    			<li>当前登录：<%=login.getUserName() %></li>
    			<a href="login.jsp"

            onClick="{if(confirm('确实要注销吗？')){return true;}return false;}">注销</a>
    			<li>&nbsp;</li>
    			<li><a href="user1.jsp">后台管理</a></li>
    			
    		</ul>    		
    		<!-- <h1><a href="zhuzhuangtu.jsp?hid=<%=role %>&Area=<%=Area %>">查看</a></h1> -->
    	</div>
    	<hr>
    	<div class="maincontent">
    		<div class="row-fluid">
    			<div class="span10">
    		<table class="table table-striped table-hover">
    			<thead>
    				<tr>
    					<th>行业</th>
    					<!--  <th>一级指标</th>-->
    					
    					  <th>发布日期</th>
    					<!--  <th>回答次数</th>-->
    					<th>查看结果</th>
    					<th>报告</th>
    				</tr>
    			</thead>
    			<tbody>
    			<%
    				int r= Integer.parseInt(role);
    				for(int i = showcurrentPage; i < endLineCount; i++){
    				Paper paper = papers.get(i);
    				int t=paper.getPaperType();
    				int jidu=paper.getPaperJidu();
    				String jd="";
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
    				String lk="";
                          if(jidu==1){
    					jd="第一季度";
    				}else if(jidu==2){
    					jd="第二季度";
    				}else if(jidu==3){
    					jd="第三季度";
    				}else if(jidu==4){
    					jd="第四季度";
    				}
	String b=String.valueOf(t);
	
	lk=lk+b;
	for(int j=0;j<lk.length();j++){
		if(lk.charAt(j)=='1'&&jidu==1){
				count1++;
			}
			if(lk.charAt(j)=='1'&&jidu==2){
				count2++;
			}
			if(lk.charAt(j)=='1'&&jidu==3){
				count3++;
			}
			if(lk.charAt(j)=='1'&&jidu==4){
				count4++;
			}
			if(lk.charAt(j)=='2'&&jidu==1){
				count5++;
			}
			if(lk.charAt(j)=='2'&&jidu==2){
				count6++;
			}
			if(lk.charAt(j)=='2'&&jidu==3){
				count7++;
			}
			if(lk.charAt(j)=='2'&&jidu==4){
				count8++;
			}if(lk.charAt(j)=='3'&&jidu==1){
				count9++;
			}
			if(lk.charAt(j)=='3'&&jidu==2){
				count10++;
			}
			if(lk.charAt(j)=='3'&&jidu==3){
				count11++;
			}
			if(lk.charAt(j)=='3'&&jidu==4){
				count12++;
			}if(lk.charAt(j)=='4'&&jidu==1){
				count13++;
			}
			if(lk.charAt(j)=='4'&&jidu==2){
				count14++;
			}
			if(lk.charAt(j)=='4'&&jidu==3){
				count15++;
			}
			if(lk.charAt(j)=='4'&&jidu==4){
				count16++;
			}if(lk.charAt(j)=='5'&&jidu==1){
				count17++;
			}
			if(lk.charAt(j)=='5'&&jidu==2){
				count18++;
			}
			if(lk.charAt(j)=='5'&&jidu==3){
				count19++;
			}
			if(lk.charAt(j)=='5'&&jidu==4){
				count20++;
			}
	}
    			// if(!(count1==2&& r==1)||(count2==2&& r==2)||(count3==2&& r==3)||(count4==2&& r==4)||(count5==2&& r==5))
    			 			 if(!(count1>=2||count2>=2||count3>=2||count4>=2||count5>=2||count6>=2||count7>=2||count8>=2||count9>=2||count10>=2||count11>=2||count12>=2||count13>=2||count14>=2||count15>=2||count16>=2||count17>=2||count18>=2||count19>=2||count20>=2)){ 
    			 %>
    			<tr>
    			<%if(t==r&&jidu==1){ 
    				System.out.println(paper.getPaperType());
    			%>
    				<td><%=ty %></td>
    		
    				<td><a href="surveypage.jsp?papertype=<%=paper.getPaperType()%>&userid=<%=id%>&paperJidu=<%=jidu %>&qstCount=<%=1%>" title="给自己评分" alt="给自己评分"><%=jd %></a></td>
    				
    				<td><%=paper.getPaperStartDate() %></td>
    			
    				<td><a href="showresult.jsp?papertype=<%=paper.getPaperType()%>&userid=<%=userid %>" class="btn btn-small">查看结果</a></td>
    				<td></td>
    				</tr>
    				
    				<%}%>
    					<tr>
    			<%if(t==r&&jidu==2){ 
    				System.out.println(paper.getPaperType());
    			%>
    				<td><%=ty %></td>
    				<!--  <td><%=paper.getPaperTitle() %></td>-->
    				<td><a href="surveypage.jsp?papertype=<%=paper.getPaperType()%>&userid=<%=id%>&paperJidu=<%=jidu %>&qstCount=<%=1%>" title="给自己评分" alt="给自己评分"><%=jd %></a></td>
    				<!--<th><a href="surveyPage?paperId=<%=paper.getPaperId() %>" ><%=paper.getPaperSummary() %></a></th>-->
    				<td><%=paper.getPaperStartDate() %></td>
    				<!--  <td><%=paper.getPaperCount() %></td>-->
    				<td><a href="showresult.jsp?papertype=<%=paper.getPaperType()%>&userid=<%=userid %>" class="btn btn-small">查看结果</a></td>
    				<!--  <td><a href="deletePage?paperId=<%=paper.getPaperId() %>" class="btn btn-small btn-danger">删除</a></td>-->
    				</tr>
    				
    				<%}	%><tr>
    			<%if(t==r&&jidu==3){ 
    				System.out.println(paper.getPaperType());
    			%>
    				
    				<!--  <td><%=paper.getPaperTitle() %></td>-->
    				<td><a href="surveypage.jsp?papertype=<%=paper.getPaperType()%>&userid=<%=id%>&paperJidu=<%=jidu %>" title="给自己评分" alt="给自己评分"><%=ty %></a></td>
    				<!--<th><a href="surveyPage?paperId=<%=paper.getPaperId() %>" ><%=paper.getPaperSummary() %></a></th>-->
    				<td><%=paper.getPaperStartDate() %></td>
    				<!--  <td><%=paper.getPaperCount() %></td>-->
    				<td><a href="showresult.jsp?papertype=<%=paper.getPaperType()%>&userid=<%=userid %>" class="btn btn-small">查看结果</a></td>
    				<!--  <td><a href="deletePage?paperId=<%=paper.getPaperId() %>" class="btn btn-small btn-danger">删除</a></td>-->
    				</tr>
    				
    				<%}%>
    					<tr>
    			<%if(t==r&&jidu==4){ 
    				System.out.println(paper.getPaperType());
    			%>
    				
    				<!--  <td><%=paper.getPaperTitle() %></td>-->
    				<td><a href="surveypage.jsp?papertype=<%=paper.getPaperType()%>&userid=<%=id%>&paperJidu=<%=jidu %>&qstCount=<%=1%>" title="给自己评分" alt="给自己评分"><%=ty %></a></td>
    				<!--<th><a href="surveyPage?paperId=<%=paper.getPaperId() %>" ><%=paper.getPaperSummary() %></a></th>-->
    				<td><%=paper.getPaperStartDate() %></td>
    				<!--  <td><%=paper.getPaperCount() %></td>-->
    				<td><a href="showresult.jsp?ID=<%=234%>&userid=<%=userid %>" class="btn btn-small">查看结果</a></td>
    				
    		<td><a href="<%=userCompany %>.pdf">导出</a></td>
    		
    				</tr>
    				
    				<%}
    				
    				
    				
    				}
    				} %>
    			</tbody>
    		</table>
    			</div>
    		
    		</div>
    		<div class="row">
    			<div class="span10">
    				<ul class="pager">
    				<%
    					if(showPage != 1){
    				%>
    						<li><a href="user.jsp?showPage=<%=(showPage-1) %>">前一页</a></li>
    				<%
    					}else{
    				%>
    					<li class="disabled"><a href="user.jsp?showPage=<%=(showPage-1) %>">前一页</a></li>
    				<%
    					}
    				 %>
					  <li><a href="user.jsp?showPage=<%=(showPage+1) %>">后一页</a></li>
					</ul>
		    	</div>
    		</div>
    	</div>
   </div>
   <%		
   			}
   			
    %>
  </body>
</html>
