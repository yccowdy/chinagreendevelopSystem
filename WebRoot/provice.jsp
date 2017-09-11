<%@ page language="java" import="java.util.*,java.sql.*,javax.servlet.*,com.a.model.*,java.util.Calendar" pageEncoding="utf-8"%>


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
  String str[] ={"北京市","天津市","上海市","重庆市","河北省","山西省","辽宁省","吉林省","黑龙江省","江苏省","浙江省","安徽省","福建省","江西省","山东省","河南省","湖北省","湖南省","广东省","海南省","四川省","贵州省","云南省","陕西省","甘肃省","青海省","台湾省","内蒙古","广西","西藏","宁夏","新疆","香港","澳门"};     
 String str1[] ={"上海市","河北省","湖北省","河南省"};
    UserBeanCl usc=new UserBeanCl();
    //ArrayList al1=qij.show(1);ArrayList al=usc.show(area,hayeid);
   
   
     ArrayList al1=usc.showpromark("上海市");
  
     ArrayList al2=usc.showpromark("河北省");
     
   ArrayList al3=usc.showpromark("湖北省");
  
     
    
   
    
     ArrayList al4=usc.showpromark("河南省");
    
    
    
     
    
   // ArrayList al=usc.show(area,hayeid);
   // String jscore[]=new String[al.size()];
    
	int t1=0,t2=0,t3=0,t4=0;
   int ziping1[]=new int[al1.size()];
     int ziping2[]=new int[al2.size()];
       int ziping3[]=new int[al3.size()];
         int ziping4[]=new int[al4.size()];

           
   //Calendar cal = Calendar.getInstance(); 
   int month =12; //cal.get(Calendar.MONTH) + 1;
   System.out.println("***"+month);
    for(int i=0;i<al1.size();i++){
		UserBean ub=(UserBean)al1.get(i);
		
	          if(month==12||month==1||month==2){
	      		
	       		 ziping1[i]=(int)ub.getUserSw();
	       		t1+=ziping1[i];
	          } 

    } 
     for(int i=0;i<al2.size();i++){
		UserBean ub=(UserBean)al2.get(i);
		
	          if(month==12||month==1||month==2){
	      		
	       		 ziping2[i]=(int)ub.getUserSw();
	       		t2+=ziping2[i];
	          } 

    } 
      for(int i=0;i<al3.size();i++){
		UserBean ub=(UserBean)al3.get(i);
		
	          if(month==12||month==1||month==2){
	      		
	       		 ziping3[i]=(int)ub.getUserSw();
	       		t3+=ziping3[i];
	          } 

    } 
      for(int i=0;i<al4.size();i++){
		UserBean ub=(UserBean)al4.get(i);
		
	          if(month==12||month==1||month==2){
	      		
	       		 ziping4[i]=(int)ub.getUserSw();
	       		t4+=ziping4[i];
	          } 

    } 
    
    int a=220,b=220,c=220;
    double d=0.5;

 %>

 
   <canvas id="canvas" height="250" width="w1"></canvas>
    <script>

        var barChartData = {
         
            labels : [<%=str1[0]%>,<%=str1[1]%>,<%=str1[2]%>，<%=str1[3]%>],
            
            datasets : [
                {
                   
                   // strokeWidth: 20,
                     data : [<%=t1/al1.size()%>,<%=t2/al2.size()%>,<%=t3/al3.size()%>,<%=t4/al4.size()%>],
   
                fillColor : "rgba(220,220,220,0.5)",
                    strokeColor : "rgba(220,220,220,1)",
                }
                
            ]
  
            
        }

    var myLine = new Chart(document.getElementById("canvas").getContext("2d")).Bar(barChartData);
    
    </script>



  
    </body>

</html>
