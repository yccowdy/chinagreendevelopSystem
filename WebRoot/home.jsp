<%@page import="com.atoz.survey.po.Login"%>
<%@page import="com.atoz.survey.po.Paper"%>
<%@page import="javax.swing.JOptionPane" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setCharacterEncoding("utf-8");
int count1=0,count2=0,count3=0,count4=0,count5=0,count6=0,count7=0,count8=0,count9=0,count10=0;int count11=0,count12=0,count13=0,count14=0,count15=0;int count16=0,count17=0,count18=0,count19=0,count20=0;
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
			padding-top: 4px;
		}
		.fabu a {
			color: #FFFFFF;
			text-decoration: none;
		}
	</style>
<style type="text/css">
<!--
.gradient{
  /*   width:1680px;
    height:1050px; */
    filter:alpha(opacity=60 finishopacity=100 style=1 startx=0,starty=0,finishx=0,finishy=150) progid:DXImageTransform.Microsoft.gradient(startcolorstr=#235E98,endcolorstr=#DEEBF3,gradientType=0);
    -ms-filter:alpha(opacity=60 finishopacity=100 style=1 startx=0,starty=0,finishx=0,finishy=150) progid:DXImageTransform.Microsoft.gradient(startcolorstr=#235E98,endcolorstr=#DEEBF3,gradientType=0);/*IE8*/
    background:#006600; /* 一些不支持背景渐变的浏览器 */
    background:-moz-linear-gradient(top,rgba(35,94,152, 1),rgba(222,235,243, 0.6));/*Firefox*/
    background:-webkit-gradient(linear, 0 0, 0 bottom, from(rgba(35,94,152, 1)), to(rgba(222,235,243, 0.6)));/*chrome Safari*/
    background:-o-linear-gradient(top, rgba(35,94,152, 1),rgba(222,235,243, 0.6));/*Opera11*/
}

</style>
	<!--[if lt IE 9]>
      	<script src="js/html5shiv.js"></script>
    <![endif]-->
    <script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>

  </head>
      <script language="javascript">  
    function sumbit_sure(){  
    var gnl=confirm("提交后本套卷不可修改，确定提交吗？");  
    if (gnl==true){  
    return true;  
    }else{  
    return false;  
    }  
    }  
    </script>  
 <body class="gradient">
  <%
String Userid=session.getAttribute("userid").toString();
		int id=Integer.parseInt(Userid);
  		int showPage = 1;
  		String tile="绿色文化";
  		String showPageInt = request.getParameter("showPage");
  		if(showPageInt != null){
  			showPage = Integer.parseInt(showPageInt);
  		}
  		List<Paper> papers = (List<Paper>) session.getAttribute("papers");
  		Login login = (Login) session.getAttribute("loginInfo");
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
				endLineCount = pageAllCount;
			}		
   %>
  
	<div class="container1">
    	<div>
<span style="center:300px;top: 30px; font-size: 24px; font-weight: bolder; color: White; font-family: 楷体,楷体_GB2312;">企业行业评测 </span>
    		<ul class="nav nav-pills pull-right">
    			<li style="color: White">当前登录：<%=login.getUserName() %></li>
    			<%
    				if(login.isAdmin()){
    			%>
    			<li>&nbsp;</li>
    			<li style="color: White"><a href="admin.jsp" style="color: White">后台管理</a></li>
    			<%
    				}
    			 %>
    			 <a href="login.jsp"
					  
						onClick="{if(confirm('确实要注销吗？')){return true;}return false;}">注销</a>
    		</ul>    		
    	</div>
    	<hr>
    	<div class="maincontent">
    		<div class="row-fluid">
    			<div class="span10">
    		<table class="table table-striped table-hover">
    			<thead>
    				<tr>
    					<th>行业</th>
    					 
    					<!--<th>二级指标</th>-->
    					<th>发布日期</th>
    					 <th>响应操作</th>
    					
    				</tr>
    			</thead>
    			<tbody>
    			<%
    				for(int i = 0; i <papers.size(); i++){
    				Paper paper = papers.get(i);
    				int t=paper.getPaperType();
    				//int a[]={0,0,0,0,0};
    				int jidu=paper.getPaperJidu();
    				String ty="";
    				String jd="";
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
    				if(jidu==1){
    					jd="第一季度";
    				}else if(jidu==2){
    					jd="第二季度";
    				}else if(jidu==3){
    					jd="第三季度";
    				}else if(jidu==4){
    					jd="第四季度";
    				}
    				String lk="";
	String b=String.valueOf(t);
	System.out.println(t);
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

    			
	   if(t==1&&count1==1&&jidu==1){%>			
		<tr>
			<td><a href="glysurveypage.jsp?papertype=<%=paper.getPaperType()%>&userid=<%=id%>&paperJidu=<%=jidu %>&paperTitle=<%=tile %>&paperNow=<%=30 %>&paperyijianfabu=<%=79 %>&paperyijianfabu=<%=79 %> " ><%=ty %></a></td>
			 <!-- <td><a href="surveypage.jsp?papertype=<%=paper.getPaperType()%>&userid=<%=id%>&paperJidu=<%=jidu %>&paperTitle=<%=tile %> " ><%=jd %></a></td> -->
			<td><%=paper.getPaperStartDate() %></td>
			<!-- <td><%=paper.getPaperCount() %></td> -->
			<td><a href="modifypaper.jsp?t=<%=t%>" class="btn btn-small btn-danger">修改</a>/<a href="deletePage?papertype=<%=paper.getPaperType()%>&qstjidu=<%=jidu %> " class="btn btn-small btn-danger">删除</a></td>
			</tr>
			<%}
			   if(t==1&&count2==1&&jidu==2){%>			
		<tr>
				<td><a href="glysurveypage.jsp?papertype=<%=paper.getPaperType()%>&userid=<%=id%>&paperJidu=<%=jidu %>&paperTitle=<%=tile %> " ><%=ty %></a></td>
			<!--  <td><%=paper.getPaperTitle() %></td>-->
			 <!-- <td><a href="surveypage.jsp?papertype=<%=paper.getPaperType()%>&userid=<%=id%>&paperJidu=<%=jidu %>" ><%=jd %></a></td> -->
			<td><%=paper.getPaperStartDate() %></td>
			<!-- <td><%=paper.getPaperCount() %></td> -->
		<td><a href="modifypaper.jsp?t=<%=t%>" class="btn btn-small btn-danger">修改</a>/<a href="deletePage?papertype=<%=paper.getPaperType()%>&qstjidu=<%=jidu %> " class="btn btn-small btn-danger">删除</a></td>
			</tr>
			<%}
			   if(t==1&&count3==1&&jidu==3){%>			
		<tr>
		 
			<td><a href="glysurveypage.jsp?papertype=<%=paper.getPaperType()%>&userid=<%=id%>&paperJidu=<%=jidu %>&paperTitle=<%=tile %> " ><%=ty %></a></td>
			
			<td><%=paper.getPaperStartDate() %></td>
			<!-- <td><%=paper.getPaperCount() %></td> -->
			<td><a href="modifypaper.jsp?t=<%=t%>" class="btn btn-small btn-danger">修改</a>/<a href="deletePage?papertype=<%=paper.getPaperType()%>&qstjidu=<%=jidu %> " class="btn btn-small btn-danger">删除</a></td>
			</tr>
			<%}
			   if(t==1&&count4==1&&jidu==4){
			   System.out.println("4");
			   %>			
		<tr>
			<td><a href="glysurveypage.jsp?papertype=<%=paper.getPaperType()%>&userid=<%=id%>&paperJidu=<%=jidu %>&paperTitle=<%=tile %>&paperNow=<%=30 %>&paperfabu=<%=79 %> " ><%=ty %></a></td>
			
			<td><%=paper.getPaperStartDate() %></td>
			<!-- <td><%=paper.getPaperCount() %></td> -->
			<td><a href="modifypaper.jsp?t=<%=t%>" class="btn btn-small btn-danger">修改</a>/<a href="deletePage?papertype=<%=paper.getPaperType()%>&qstjidu=<%=jidu %> " onClick="{if(confirm('确实要删除吗？')){return true;}return false;}" class="btn btn-small btn-danger">删除</a></td>
			 	<form  action="SucServlet" method="post" onsubmit="return sumbit_sure()">
			 	<input type="hidden" name="leixing" value="<%=t%>">
			 <td><input class="btn btn-success" type="submit" value="提交" ></td>
   				</form>
   				</tr>
   				
			<%}
			   if(t==2&&count5==1&&jidu==1){%>			
		<tr>
			<td><a href="glysurveypage.jsp?papertype=<%=paper.getPaperType()%>&userid=<%=id%>&paperJidu=<%=jidu %>&paperTitle=<%=tile %> " ><%=ty %></a></td>
			<td><%=paper.getPaperStartDate() %></td>
			<!-- <td><%=paper.getPaperCount() %></td> -->
			<td><a href="modifypaper.jsp?t=<%=t%>" class="btn btn-small btn-danger">修改</a>/<a href="deletePage?papertype=<%=paper.getPaperType()%>&qstjidu=<%=jidu %> " class="btn btn-small btn-danger">删除</a></td>
			</tr>
			<%}
			   if(t==2&&count6==1&&jidu==2){%>			
   			<tr>
   				<td><a href="glysurveypage.jsp?papertype=<%=paper.getPaperType()%>&userid=<%=id%>&paperJidu=<%=jidu %>&paperTitle=<%=tile %> " ><%=ty %></a></td>
   				
   				<td><%=paper.getPaperStartDate() %></td>
   				<!-- <td><%=paper.getPaperCount() %></td> -->
   				<td><a href="modifypaper.jsp?t=<%=t%>" class="btn btn-small btn-danger">修改</a>/<a href="deletePage?papertype=<%=paper.getPaperType()%>&qstjidu=<%=jidu %> " class="btn btn-small btn-danger">删除</a></td>
   				</tr>
   				<%}
   				   if(t==2&&count7==2&&jidu==3){%>			
   			<tr>
   			<td><a href="glysurveypage.jsp?papertype=<%=paper.getPaperType()%>&userid=<%=id%>&paperJidu=<%=jidu %>&paperTitle=<%=tile %> " ><%=ty %></a></td>
   				
   				<td><%=paper.getPaperStartDate() %></td>
   				<!-- <td><%=paper.getPaperCount() %></td> -->
   				<td><a href="modifypaper.jsp?t=<%=t%>" class="btn btn-small btn-danger">修改</a>/<a href="deletePage?papertype=<%=paper.getPaperType()%>&qstjidu=<%=jidu %> " class="btn btn-small btn-danger">删除</a></td>
   				</tr>
   				<%}
   				   if(t==2&&count8==1&&jidu==4){%>			
   			<tr>
   				<td><a href="glysurveypage.jsp?papertype=<%=paper.getPaperType()%>&userid=<%=id%>&paperJidu=<%=jidu %>&paperTitle=<%=tile %>&paperNow=<%=30 %>&paperfabu=<%=79 %> " ><%=ty %></a></td>
   				
   				<td><%=paper.getPaperStartDate() %></td>
   				<!-- <td><%=paper.getPaperCount() %></td> -->
   				<td><a href="modifypaper.jsp?t=<%=t%>" class="btn btn-small btn-danger">修改</a>/<a href="deletePage?papertype=<%=paper.getPaperType()%>&qstjidu=<%=jidu %>&paperfabu=<%=79 %> " onClick="{if(confirm('确实要删除吗？')){return true;}return false;}" class="btn btn-small btn-danger">删除</a></td>
   					<form  action="SucServlet" method="post" onsubmit="return sumbit_sure()">
			 	<input type="hidden" name="leixing" value="<%=t%>">
			 <td><input class="btn btn-success" type="submit" value="提交" ></td>
   				</form>
   				</tr>
   				<%}
   				   if(t==3&&count9==1&&jidu==1){
   				   System.out.println("4");
   				   %>			
   			<tr>
   				<td><a href="glysurveypage.jsp?papertype=<%=paper.getPaperType()%>&userid=<%=id%>&paperJidu=<%=jidu %>&paperTitle=<%=tile %> " ><%=ty %></a></td>
   				<td><%=paper.getPaperStartDate() %></td>
   				<!-- <td><%=paper.getPaperCount() %></td> -->
   				<td><a href="modifypaper.jsp?t=<%=t%>" class="btn btn-small btn-danger">修改</a>/<a href="deletePage?papertype=<%=paper.getPaperType()%>&qstjidu=<%=jidu %> " class="btn btn-small btn-danger">删除</a></td>
   				</tr>
   				<%}
   				   if(t==3&&count10==1&&jidu==2){
	    				   System.out.println("4");
	    				   %>			
	    			<tr>
	    				<td><a href="glysurveypage.jsp?papertype=<%=paper.getPaperType()%>&userid=<%=id%>&paperJidu=<%=jidu %>&paperTitle=<%=tile %> " ><%=ty %></a></td>
	    				
	    				<td><%=paper.getPaperStartDate() %></td>
	    				<!-- <td><%=paper.getPaperCount() %></td> -->
	    				<td><a href="modifypaper.jsp?t=<%=t%>" class="btn btn-small btn-danger">修改</a>/<a href="deletePage?papertype=<%=paper.getPaperType()%>&qstjidu=<%=jidu %> " class="btn btn-small btn-danger">删除</a></td>
	    				</tr>
	    				<%}
	    				   if(t==3&&count11==1&&jidu==3){%>			
	    			<tr>
	    				<td><a href="glysurveypage.jsp?papertype=<%=paper.getPaperType()%>&userid=<%=id%>&paperJidu=<%=jidu %>&paperTitle=<%=tile %> " ><%=ty %></a></td>
	    				
	    				<td><%=paper.getPaperStartDate() %></td>
	    				<!-- <td><%=paper.getPaperCount() %></td> -->
	    			<td><a href="modifypaper.jsp?t=<%=t%>" class="btn btn-small btn-danger">修改</a>/<a href="deletePage?papertype=<%=paper.getPaperType()%>&qstjidu=<%=jidu %> " class="btn btn-small btn-danger">删除</a></td>
	    				</tr>
	    				<%}
   				   if(t==3&&count12==1&&jidu==4){%>			
   			<tr>
   				<td><a href="glysurveypage.jsp?papertype=<%=paper.getPaperType()%>&userid=<%=id%>&paperJidu=<%=jidu %>&paperTitle=<%=tile %>&paperNow=<%=30 %>&paperfabu=<%=79 %> " ><%=ty %></a></td>
   				
   				<td><%=paper.getPaperStartDate() %></td>
   				<!-- <td><%=paper.getPaperCount() %></td> -->
   			<td><a href="modifypaper.jsp?t=<%=t%>" class="btn btn-small btn-danger">修改</a>/<a href="deletePage?papertype=<%=paper.getPaperType()%>&qstjidu=<%=jidu %> " onClick="{if(confirm('确实要删除吗？')){return true;}return false;}" class="btn btn-small btn-danger">删除</a></td>
   						<form  action="SucServlet" method="post" onsubmit="return sumbit_sure()">
			 	<input type="hidden" name="leixing" value="<%=t%>">
			 <td><input class="btn btn-success" type="submit" value="提交" ></td>
   				</form>
   				</tr>
   				<%}if(t==4&&count13==1&&jidu==1){%>			
       			<tr>
   			<td><a href="glysurveypage.jsp?papertype=<%=paper.getPaperType()%>&userid=<%=id%>&paperJidu=<%=jidu %>&paperTitle=<%=tile %> " ><%=ty %></a></td>
   				
   				<td><%=paper.getPaperStartDate() %></td>
   				<!-- <td><%=paper.getPaperCount() %></td> -->
   				<td><a href="modifypaper.jsp?t=<%=t%>" class="btn btn-small btn-danger">修改</a>/<a href="deletePage?papertype=<%=paper.getPaperType()%>&qstjidu=<%=jidu %> " class="btn btn-small btn-danger">删除</a></td>
   				</tr>
   				<%}
   				   if(t==4&&count14==1&&jidu==2){%>			
   			<tr>
   				<td><a href="glysurveypage.jsp?papertype=<%=paper.getPaperType()%>&userid=<%=id%>&paperJidu=<%=jidu %>&paperTitle=<%=tile %> " ><%=ty %></a></td>
   				
   				<td><%=paper.getPaperStartDate() %></td>
   				<!-- <td><%=paper.getPaperCount() %></td> -->
   			<td><a href="modifypaper.jsp?t=<%=t%>" class="btn btn-small btn-danger">修改</a>/<a href="deletePage?papertype=<%=paper.getPaperType()%>&qstjidu=<%=jidu %> " class="btn btn-small btn-danger">删除</a></td>
   				</tr>
   				<%}
   				   if(t==4&&count15==1&&jidu==3){%>			
   			<tr>
   				<td><a href="glysurveypage.jsp?papertype=<%=paper.getPaperType()%>&userid=<%=id%>&paperJidu=<%=jidu %>&paperTitle=<%=tile %>&paperNow=<%=30 %> " ><%=ty %></a></td>
   				
   				<td><%=paper.getPaperStartDate() %></td>
   				<!-- <td><%=paper.getPaperCount() %></td> -->
   				<td><a href="modifypaper.jsp?t=<%=t%>" class="btn btn-small btn-danger">修改</a>/<a href="deletePage?papertype=<%=paper.getPaperType()%>&qstjidu=<%=jidu %> " class="btn btn-small btn-danger">删除</a></td>
   				</tr>
   				<%}
   				   if(t==4&&count16==1&&jidu==4){
   				   System.out.println("4");
   				   %>			
   			<tr>
   			<td><a href="glysurveypage.jsp?papertype=<%=paper.getPaperType()%>&userid=<%=id%>&paperJidu=<%=jidu %>&paperTitle=<%=tile %>&paperNow=<%=30 %>&paperfabu=<%=79 %> " ><%=ty %></a></td>
   				
   				<td><%=paper.getPaperStartDate() %></td>
   				<!-- <td><%=paper.getPaperCount() %></td> -->
   				<td><a href="modifypaper.jsp?t=<%=t%>" class="btn btn-small btn-danger">修改</a>/<a href="deletePage?papertype=<%=paper.getPaperType()%>&qstjidu=<%=jidu %> " onClick="{if(confirm('确实要删除吗？')){return true;}return false;}" class="btn btn-small btn-danger">删除</a></td>
   					<form  action="SucServlet" method="post" onsubmit="return sumbit_sure()">
			 	<input type="hidden" name="leixing" value="<%=t%>">
			 <td><input class="btn btn-success" type="submit" value="提交" ></td>
   				</form>
   				</tr>
   				<%}
   				   if(t==5&&count17==1&&jidu==1){%>			
   			<tr>
   			<td><a href="glysurveypage.jsp?papertype=<%=paper.getPaperType()%>&userid=<%=id%>&paperJidu=<%=jidu %>&paperTitle=<%=tile %> " ><%=ty %></a></td>
   				
   				<td><%=paper.getPaperStartDate() %></td>
   				<!-- <td><%=paper.getPaperCount() %></td> -->
   				<td><a href="modifypaper.jsp?t=<%=t%>" class="btn btn-small btn-danger">修改</a>/<a href="deletePage?papertype=<%=paper.getPaperType()%>&qstjidu=<%=jidu %> " class="btn btn-small btn-danger">删除</a></td>
   				</tr>
   				<%}if(t==5&&count18==1&&jidu==2){%>			
       			<tr>
   				<td><a href="glysurveypage.jsp?papertype=<%=paper.getPaperType()%>&userid=<%=id %>&paperJidu=<%=jidu %>&paperTitle=<%=tile %> " ><%=ty %></a></td>
   				
   				<td><%=paper.getPaperStartDate() %></td>
   				<!-- <td><%=paper.getPaperCount() %></td> -->
   				<td><a href="modifypaper.jsp?t=<%=t%>" class="btn btn-small btn-danger">修改</a>/<a href="deletePage?papertype=<%=paper.getPaperType()%>&qstjidu=<%=jidu %> " class="btn btn-small btn-danger">删除</a></td>
   				</tr>
   				<%}
   				   if(t==5&&count19==1&&jidu==3){%>			
   			<tr>
   			<td><a href="glysurveypage.jsp?papertype=<%=paper.getPaperType()%>&userid=<%=id%>&paperJidu=<%=jidu %>&paperTitle=<%=tile %> " ><%=ty %></a></td>
   				<td><%=paper.getPaperStartDate() %></td>
   				<!-- <td><%=paper.getPaperCount() %></td> -->
   			<td><a href="modifypaper.jsp?t=<%=t%>" class="btn btn-small btn-danger">修改</a>/<a href="deletePage?papertype=<%=paper.getPaperType()%>&qstjidu=<%=jidu %> " class="btn btn-small btn-danger">删除</a></td>
   				</tr>
   				<%}
   				   if(t==5&&count20==1&&jidu==4){%>			
   			<tr>
   			<td><a href="glysurveypage.jsp?papertype=<%=paper.getPaperType()%>&userid=<%=id%>&paperJidu=<%=jidu %>&paperTitle=<%=tile %>&&paperNow=<%=30 %>&paperfabu=<%=79 %> " ><%=ty %></a></td>
   				
   				<td><%=paper.getPaperStartDate() %></td>
   				<!-- <td><%=paper.getPaperCount() %></td> -->
   			<td><a href="modifypaper.jsp?t=<%=t%>" class="btn btn-small btn-danger">修改</a>/<a href="deletePage?papertype=<%=paper.getPaperType()%>&qstjidu=<%=jidu %> " onClick="{if(confirm('确实要删除吗？')){return true;}return false;}" class="btn btn-small btn-danger">删除</a></td>
   			  		<form  action="SucServlet" method="post" onsubmit="return sumbit_sure()">
			 	<input type="hidden" name="leixing" value="<%=t%>">
			 <td><input class="btn btn-success" type="submit" value="提交" ></td>
   				</form>
   				</tr>
   				<%}    	    				 
    				} %>
    			</tbody>
    		</table>
    			</div>
	    		<div class="span8 fabu"><a href="addpaper.jsp" class="btn btn-success">创建问卷</a></div>
    			</div>
    		</div>
    		<div class="row">
    			<div class="span10">
    				<ul class="pager">
    				<%
    					if(showPage != 1){
    				%>
    						<li><a href="home.jsp?showPage=<%=(showPage-1) %>">前一页</a></li>
    				<%
    					}else{
    				%>
    					<li class="disabled"><a href="home.jsp?showPage=<%=(showPage-1) %>">前一页</a></li>
    				<%
    					}
    				 %>
					  <li><a href="home.jsp?showPage=<%=(showPage+1) %>">后一页</a></li>
					</ul>
		    	</div>
    		</div>
    	</div>
   <%		
   			}
   			
    %>
  </body>
</html>
