<%@page import="com.atoz.survey.po.User"%>
<%@page import="com.atoz.survey.dao.mysqlimpl.UserDaoImpl"%>
<%@page import="com.atoz.survey.service.UserService"%>
<%@page import="com.atoz.survey.service.impl.UserServiceImpl"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
  <SCRIPT language=javascript>
        
    document.onkeydown = function()//禁止刷新
     {
          if(event.keyCode==116) {
              event.keyCode=0;
              event.returnValue = false;
          }
    }
    
    document.oncontextmenu = function() {
        event.returnValue = false;
    }
        
</SCRIPT> 
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
  	<h3>欢迎使用企业行为评测系统</h3>
  	 <%  String userid=session.getAttribute("userid").toString();
  	 System.out.println(userid);
String modifyinfor= (String) session.getAttribute("modifyinfor");
		if(modifyinfor != null && modifyinfor.equals("modifyinfor")){
		UserDaoImpl userDao= new UserDaoImpl();
List<User> user=userDao.findotherUsers();
int id=Integer.parseInt(userid);
System.out.println(userid);
for(User user1:user){
if(user1.getUserId()==id){%>
<span class="path"><i class="icon-home"></i> > 用户管理 > 公司信息</span>
    <hr>
    <%String ty="";int t=user1.getUserRole();
    		        if(t==0){
    		        ty="管理员";
    		        }
    		         if(t==10){
    		        ty="省政府";}
    		           if(t==11){
    		        ty="市政府";}
    		           if(t==12){
    		        ty="县政府";}
    		         if(t==-1){
    		        ty="委托方";
    		        }
    		        
    				if(t==1){
    					ty="非金属矿物制品业（平板玻璃）";
    				} if(t==2){
    					ty="非金属矿物制品—人造板";
    				} if(t==3){
    					ty="非金属矿物制品—水泥工业";
    				} if(t==4){
    					ty="工业化学品制造业—氮肥制造业";
    				} if(t==5){
    					ty="煤炭开采及洗选业";
    				}
    %> 
	<!-- form start -->
			<form class="form-horizontal" action="CompanyServlet" method="post">
			<div class="control-group">
			    	<label class="control-label" >所属行业</label>
				    <div class="controls">
				    
				    	<%=ty %>
				    </div>
			  	</div>
			  	<div class="control-group">
			    	<label class="control-label" for="inputUserSummary">公司名称</label>
				    <div class="controls">
				   	<input type="text" id="inputUserSummary" name="inputUserSummary"  value="<%=user1.getUserSummary()%>" placeholder="usersummary" readonly>
				    </div>
			  	</div>
			  	<div class="control-group">
			    	<label class="control-label" for="inputUserZc">企业注册号</label>
				    <div class="controls">
				    
				    	<input type="text" id="inputUserZc" name="inputUserZc" >
				    </div>
			  	</div>
			  	
			  <div class="control-group">
			    	<label class="control-label" for="inputUserPerson">企业类型</label>
				    <div class="controls">
				      	<!-- <input type="text" id="inputUserPerson" name="inputUserPerson" > -->
				      	 <select id="inputUserPerson" name="inputUserPerson" >
				  <option value="煤炭开采和洗选业">煤炭开采和洗选业</option>
                  <option value="石油和天然气开采业">石油加工及炼焦业</option>
                   <option value="金属矿采选业">金属矿采选业</option>
                   <option value="石油和天然气开采业">石油和天然气开采业</option>
                  <option value="金属冶炼及压延加工业">金属冶炼及压延加工业</option>
                   <option value="其他采矿业">其他采矿业</option>
                   <option value="非金属采选业">非金属采选业</option>
                  <option value="化学原料及化学制品制造业">化学原料及化学制品制造业</option>
                   <option value="燃气生产和供应业">燃气生产和供应业</option>
                   <option value="水的生产和供应业">水的生产和供应业</option>
                  <option value="电力、热力的生产和供应业">电力、热力的生产和供应业</option>
				  </select>
				    </div>
			  	</div>
			  	<div class="control-group">
			    	<label class="control-label" for="inputShangshi">企业规模</label>
				    <div class="controls">
				  <select id="inputShangshi" name="inputShangshi" >
				  <option value="大型">大型</option>
                  <option value="中型">中型</option>
                   <option value="小型">小型</option>
				  </select>
				    </div>
			  	</div>
			  	<div class="control-group">
			    	<label class="control-label" for="inputType">企业类型</label>
				    <div class="controls">
				  <select id="inputType" name="inputType" >
				  <option value="国有独资">国有独资</option>
                  <option value="民营">民营</option>
                  <option value="集体全资">集体全资</option>
                  <option value="股份制上市公司">股份制上市公司</option>
                  <option value="港澳台企业">港澳台企业</option>
                  <option value="外资企业">外资企业</option>
				  </select>
				    </div>
			  	</div>
			  	<div class="control-group">
			    	<label class="control-label" for="inputIntro">公司介绍</label>
				    <div class="controls">
				    	<textarea rows="2" cols="2" name="inputIntro" id="inputIntro"></textarea> 
				    </div>
			  	</div><%}} %>
			  	<div class="control-group controls">
			      	<button type="submit" class="btn btn-success">修改资料</button> 
			       <button type="reset" class="btn">重置</button>
			  	</div>
			</form>
<%session.removeAttribute("modifyinfor");}

    	String modifyUser1= (String) session.getAttribute("modifyUser1");
		if(modifyUser1 != null && modifyUser1.equals("modifyUser1")){UserDaoImpl userDao= new UserDaoImpl();
List<User> user=userDao.findotherUsers();
//String userid=session.getAttribute("userid").toString();
int id=Integer.parseInt(userid);
System.out.println(userid);
		for(User user1:user){
if(user1.getUserId()==id){%>
 <span class="path"><i class="icon-home"></i> > 用户管理 > 用户综合管理 > 查找结果</span>
    <hr>
    <%String ty="";int t=user1.getUserRole();
    		        if(t==0){
    		        ty="管理员";
    		        }
    		         if(t==10){
    		        ty="政府";
    		         if(t==-1){
    		        ty="委托方";
    		        }
    		        }
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
    %> 
	<!-- form start -->
			<form class="form-horizontal" action="UserServlet" method="post">
			<div class="control-group">
			    	<label class="control-label" >所属行业</label>
				    <div class="controls">
				    
				    	<%=ty %>
				    </div>
			  	</div>
			  	<div class="control-group">
			    	<label class="control-label" >公司名称</label>
				    <div class="controls">
				    
				    	<%=user1.getUserSummary() %>
				    </div>
			  	</div>
			  	<div class="control-group">
			    	<label class="control-label" for="inputUserName">用户名</label>
				    <div class="controls">
				    
				    	<input type="text" id="inputUserName" name="modifyUserName" value="<%=user1.getUserName() %>">
				    </div>
			  	</div>
			  	
			  <div class="control-group">
			    	<label class="control-label" for="inputPassword">密码</label>
				    <div class="controls">
				      	<input type="password" id="inputPassword" name="modifyPassword" value="<%=user1.getUserPassword() %>">
				    </div>
			  	</div>
			  	<div class="control-group">
			    	<label class="control-label" for="inputPassword">新密码</label>
				    <div class="controls">
				      	<input type="password" id="inputPassword2" name="modifyPassword2" value="">
				    </div>
			  	</div>	
			  	<div class="control-group">
			    	<label class="control-label" for="inputEmail">安全邮箱</label>
				    <div class="controls">
				    	<input type="email" id="inputEmail" name="modifyEmail" value="<%=user1.getUserMail() %>">
				    </div>
			  	</div><%}} %>
			  	<div class="control-group controls">
			      	<button type="submit" class="btn btn-success">修改资料</button> 
			       <button type="reset" class="btn">重置</button>
			  	</div>
			</form>
	<%session.removeAttribute("modifyUser1");}
	String tips = (String) session.getAttribute("tips");
    	if(tips != null){
    		if(tips.equals("SUCCESS")){
    %>
	 <span class="path"><i class="icon-home"></i>> 系统消息</span>
     <br><br><br><br>
     <p align="center"><i class="icon-info-sign"></i> 系统提示：操作成功！</p>
    <%	
    	
    		} else if(tips.equals("ERROR")){
    %>
     <span class="path"><i class="icon-home"></i>> 系统消息</span>
     <br><br><br><br>
     <p align="center"><i class="icon-info-sign"></i> 系统提示：操作失败！</p>
    <%
    		}
    		session.removeAttribute("tips");
    	}
    %>

  </body>
</html>