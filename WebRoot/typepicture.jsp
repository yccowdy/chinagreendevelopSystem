<%@ page language="java" import="java.util.*,java.sql.*,javax.servlet.*,com.a.model.*,java.util.Calendar" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <title>Bar Chart</title>
        <script src="js/Chart.js"></script>
     	<script src="js/tubiao1.js"></script>
        <meta name = "viewport" content = "initial-scale = 1, user-scalable = no">
        <style>
            canvas{
            }
            canvas1{
            }
            #div{top:0px;position:absolute;}
            #div1{left:0px;top:500px;position:relative;}
        </style>
    </head>
    <body>
        
<%
    //String qiyeid=request.getParameter("qid");
   // String area=request.getParameter("Area");
    //System.out.println(area);
   int hayeid=Integer.parseInt(request.getParameter("hid"));
   System.out.println(hayeid);
    UserBeanCl usc=new UserBeanCl();
    //ArrayList al1=qij.show(1);ArrayList al=usc.show(area,hayeid);
     ArrayList al=usc.showtype(hayeid);
   // ArrayList al=usc.show(area,hayeid);
   // String jscore[]=new String[al.size()];
     System.out.println("***=="+al);
	String qiyename[]=new String[al.size()];
   int ziping[]=new int[al.size()];
   int zhuanping[]=new int[al.size()];
   //Calendar cal = Calendar.getInstance(); 
   int month =12; //cal.get(Calendar.MONTH) + 1;
   System.out.println("***"+month);
    for(int i=0;i<al.size();i++){
		UserBean ub=(UserBean)al.get(i);
		qiyename[i]=ub.getUserSummary();
		  if(month==3||month==4||month==5){
	  		ziping[i]=(int)ub.getUserSspr();
			zhuanping[i]=(int)ub.getUserSpring();
	          } 
	          if(month==6||month==8||month==7){
			ziping[i]=(int)ub.getUserSsm();
			zhuanping[i]=(int)ub.getUserSummer();
	          }
	          if(month==9||month==10||month==11){
	     		 zhuanping[i]=(int)ub.getUserAut();
	    		ziping[i]=(int)ub.getUserSa(); 
	    	 } 
	          if(month==12||month==1||month==2){
	      		 zhuanping[i]=(int)ub.getUserWin();
	       		 ziping[i]=(int)ub.getUserSw();
	       		 System.out.println(ziping[i]);
	          } 

    }  int t=hayeid;
   
    int a=220,b=220,c=220,w=5*al.size();
    double d=0.5;

 %>

 <div id="div" class="div">
  <p><b>企业自评分数柱状图</b></p>
  <p>企业自评分数柱状图</p>
   <canvas id="canvas" height="250" width="w1"></canvas>
    <script>

        var barChartData = {
         
            labels : [<%for(int i=0;i<al.size();i++){%>"<%=qiyename[i]%>",<%}%>],
            
            datasets : [
                {
                   
                   // strokeWidth: 20,
                    data : [<%for(int i=0;i<al.size();i++){%><%=ziping[i]%>,<%}%>],
   
                fillColor : "rgba(220,220, 220,0.5)",
                    strokeColor : "rgba(220,220,220,1)",
                }
                
            ]
  
            
        }

    var myLine = new Chart(document.getElementById("canvas").getContext("2d")).Bar(barChartData);
    
    </script>
 </div>

 <div id="div1">   
   <p>专家评分柱状图</p>
    <canvas id="canvas1" height="250" width="w"></canvas>
    <script>

        var barChartData1 = {
         
            labels : [<%for(int i=0;i<al.size();i++){%>"<%=qiyename[i]%>",<%}%>],
            datasets : [
                {
               
                    data : [<%for(int i=0;i<al.size();i++){%><%=zhuanping[i]%>,<%}%>],
  
         fillColor: "rgba(<%=a%>,<%=b%>,<%=c%>,<%=d%>)",
         strokeColor : "rgba(220,220,220,1)"

                <%//if(zhuanping[i]>=80){a=50;b=139;c=59;d=1;}else if(zhuanping[i]>=60&&zhuanping[i]<70){a=210;b=214;c=80;d=1;}else {a=200;b=0;c=0;d=1;}%>
                   
                    
                }
                
            ]
  
            
        }

    var myLine1 = new Chart(document.getElementById("canvas1").getContext("2d")).Bar(barChartData1);  
    </script>
    </div>
  
    </body>

</html>
