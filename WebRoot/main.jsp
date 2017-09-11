<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<meta name="renderer" content="webkit" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<head>
<title>中国企业信用评价网-企业信用评级 企业信用报告 资信等级证书 企业信用等级权威评价机构</title>
<meta name="Keywords" content="中国企业信用评价网">
<meta name="Description" content="中国企业信用评价网由北京正信信用评价有限公司创办，国内专业、权威的第三方企业信用评价机构，招投标信用评级机构。主要提供企业信用报告、企业资信等级证明、企业资信等级证书、信用评估报告、企业信用等级证书、企业信用认证、企业信用证书、重合同守信用企业等评级和认证，证书全国通用、权威可靠。资信等级证明、资信等级证书、企业信用等级、资信等级首选中国企业信用评价网。网站提供证书样本、企业信用自评、在线申报、申报资料下载等服务">
<link rel="stylesheet" type="text/css" href="style.css" />
<link rel="stylesheet" type="text/css" href="simg.css" />
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="http://code.highcharts.com/highcharts.js"></script>
</head>
<body>
<%
  if(application.getAttribute("counter")==null)
  application.setAttribute("counter", "1");
  else{
  String strnum=null;
  strnum=application.getAttribute("counter").toString();
  int icount=0;
  icount=Integer.valueOf(strnum).intValue();
  icount++;
  application.setAttribute("counter", Integer.toString(icount));
  } %>
<div class="top">
<div class="w1000">
    <span class="left">
    <script language=JavaScript>
    var enabled = 0; today = new Date();
    var day; var date;
    if(today.getDay()==0) day = " 星期日"
    if(today.getDay()==1) day = " 星期一"
    if(today.getDay()==2) day = " 星期二"
    if(today.getDay()==3) day = " 星期三"
    if(today.getDay()==4) day = " 星期四"
    if(today.getDay()==5) day = " 星期五"
    if(today.getDay()==6) day = " 星期六"
    document.fgColor = "000000";
    date = "今天是：" + (today.getFullYear()) + "年" + (today.getMonth() + 1 ) + "月" + today.getDate() + "日 " + today.getHours() + "点" + today.getMinutes() + "分" + day +"";
    document.write(date);
    </script>
      &nbsp; &nbsp; &nbsp; &nbsp;浏览量：<%=application.getAttribute("counter")%>
   
    </span>
    <span class="right">| 
    <a href="/c/lxwm.html">前期咨询</a>
    </span>
</div>
</div>
<%
  if(application.getAttribute("counter")==null)
  application.setAttribute("counter", "1");
  else{
  String strnum=null;
  strnum=application.getAttribute("counter").toString();
  int icount=0;
  icount=Integer.valueOf(strnum).intValue();
  icount++;
  application.setAttribute("counter", Integer.toString(icount));
  } %>
<div >
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0"> 
  <tr>
    <td><div align="center" >
      <table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td width="100%" align="center">
            <div align="center" style="width:1000px;" >
              <img src="1.png" width="1000" border="0" />
              </div>
           </td>
        </tr>
      </table>
    </div></td>
  </tr>
</table>
</div>

<div class="nav_wrap">
	<div class="nav" >
		<ul>
			<li><a href="main.jsp">&nbsp;首 页&nbsp;</a></li>
			  <li><a  href="our.jsp" target="_blank">&nbsp;关于我们&nbsp;</a></li>  
			  <li><a  href="login.jsp" target="_blank">&nbsp;企业绿色评价&nbsp;</a></li>  
			  <li><a  href="news.jsp" target="_blank">&nbsp;相关资讯&nbsp;</a></li>  
			  <li><a  href="zcfg.jsp" target="_blank">&nbsp;政策文件&nbsp;</a></li>  
		</ul>
	</div>
</div>
  
<div class="w1007" >
<div style="float:left;width:127px;height:132px;"><img src="bg_hot1.gif" /></div> 
<div class="hot" style="float:right;width:880px;">
        <h1> 
<a href="attion.jsp">关于免费使用企业绿色评价系统的通知</a>
</h1>
	<div id="div1" class="scroll_div">
	<div id="scroll_end" class="scroll_div2"></div></div>
<script language="javascript" type="text/javascript">
	//热点聚焦的文字左滚动
	var speed = 20
	var scroll_begin = document.getElementById("scroll_begin");
	var scroll_div = document.getElementById("div1");
	var scroll_end = document.getElementById("scroll_end");
	scroll_end.innerHTML = scroll_begin.innerHTML
	var MyMar = setInterval(Marquee, speed)
	scroll_div.onmouseover = function () { clearInterval(MyMar) }
	scroll_div.onmouseout = function () { MyMar = setInterval(Marquee, speed) }
	function Marquee() {
	if (scroll_end.offsetWidth - scroll_div.scrollLeft <= 0)
	scroll_div.scrollLeft -= scroll_begin.offsetWidth+200
	else
		scroll_div.scrollLeft++
	}
</script>
</div></div>

<div class="w1007">
	<div id="left">
	<div id="accordion-1">
        <div class="part left">
          
	<style>
	#slt{ text-align:center; padding-top:8px; background:#eee;}
	#slt img{ height:40px; border:1px dotted #666;}
</style>
<script>
	t1=1;
	a1=["水果","夜景","草地","荒山"];
	function on_(){
		s=31;
		if(t1==5){t1=1;}
		zm.innerHTML=a1[t1-1];
		tp.src="a"+t1+".jpg";
		t1++;
		tp.style.marginLeft="400px";
		g1=setInterval("yd_()",20);
	}
	function yd_(){
		if(s>0){
			tp.style.marginLeft=parseInt(tp.style.marginLeft)-s+"px";
			s--;
		}else{
			clearInterval(g1);
		}
	}
	function daduan_(x1){
		if(typeof(g1)!="undefined"){clearInterval(g1);}
		clearInterval(g);
		t1=x1;
		on_();
	}
</script>

    <div style="width:380px; height:200px; border:1px dotted #000; margin:0 auto; overflow:hidden; position:relative; background:#ccc;">
   <img id="tp" src="a1.jpg" style="margin-left:0px;" /></a>
  
        <div id="slt">
            <img id="i1" src="a1.jpg" />
         <img id="i2" src="a2.jpg" />
         <img id="i3" src="a3.jpg" />
            <img id="i4" src="a4.jpg" />
        </div>
        <div style="width:485px; height:40px; background:#fff; position:absolute; top:40px; left:0px; filter:alpha(opacity=30); -moz-opacity:0.3; -khtml-opacity:0.3; opacity:0.3;"></div>
        <div id="zm" style="width:485px; height:40px; text-align:center; line-height:40px; font-size:20px; font-weight:bold; position:absolute; top:200px; left:0px;">水果</div>
    </div>
    <script>
		i1.onmouseover=function(){daduan_(1);}
		i1.onmouseout=function(){g=setInterval("on_()",2000);}
		i2.onmouseover=function(){daduan_(2);}
		i2.onmouseout=function(){g=setInterval("on_()",2000);}
		i3.onmouseover=function(){daduan_(3);}
		i3.onmouseout=function(){g=setInterval("on_()",2000);}
		i4.onmouseover=function(){daduan_(4);}
		i4.onmouseout=function(){g=setInterval("on_()",2000);}
		g=setInterval("on_()",2000);
    </script>
        </div>
        <div class="part right">
            <h2 class="title"><a href="zcfg.jsp" class="right" target="_blank">更多>></a>政策法规</h2>
				<ul>
					<li><a class="left" href="http://huanbao.bjx.com.cn/news/20160922/774800.shtml" target="_blank">·《关于省以下环保机构监测监察执法垂直管理制度改革试点工作的指导意见》</li>
					<li><a class="left" href="http://huanbao.bjx.com.cn/news/20160930/777405.shtml" target="_blank">·《关于培养环境治理和生态保护市场主体的意见》</li>
					<li><a class="left" href="http://huanbao.bjx.com.cn/news/20161107/786539.shtml" target="_blank">·《关于省以下环保机构监测监察执法垂直管理制度改革试点工作的指导意见》</li>
				</ul>
		</div>

        <div class="info">
			<dd>
				<span><ul><li><a class="curr">诚信企业推荐</a></li><!--<a href="/c/cpyj/" class="moree">更多>></a>--></ul></span>
				<div class="iflist">    
				<style type="text/css"> 
                #demo {overflow:hidden; height:208px;} 
                </style> 
                <div id="demo"> 
                <div id="demo1"> 
               <!--  <div class="blist">·<a href="/c/cpyj/2943.html">北京燕山集联石油化工有限公司</a></div><div class="blist">·<a href="/c/cpyj/2942.html">河北乾烨金属制品有限公司</a></div><div class="blist">·<a href="/c/cpyj/2941.html">北京大明五洲科技有限公司</a></div><div class="blist">·<a href="/c/cpyj/2940.html">北京中实杰肯道失物业管理有限公司</a></div><div class="blist">·<a href="/c/cpyj/2933.html">河北世纪大饭店物业管理有限公司</a></div><div class="blist">·<a href="/c/cpyj/2932.html">中兴新能源汽车有限责任公司</a></div><div class="blist">·<a href="/c/cpyj/2927.html">重庆市恒海环卫设备有限公司</a></div><div class="blist">·<a href="/c/cpyj/2926.html">佳美物业服务有限公司</a></div><div class="blist">·<a href="/c/cpyj/2925.html">悦华新物业服务有限公司</a></div><div class="blist">·<a href="/c/cpyj/2924.html">江西赣电电气有限公司</a></div><div class="blist">·<a href="/c/cpyj/2923.html">北控环境投资（中国）有限公司</a></div><div class="blist">·<a href="/c/cpyj/2922.html">上海卫事康卫生管理服务有限公司</a></div><div class="blist">·<a href="/c/cpyj/2921.html">大禹节水集团股份有限公司</a></div><div class="blist">·<a href="/c/cpyj/2920.html">黑龙江省水利水电集团第二工程有限公司</a></div><div class="blist">·<a href="/c/cpyj/2919.html">北京科住物业管理有限公司</a></div><div class="blist">·<a href="/c/cpyj/2850.html">上海晨光科力普办公用品有限公司</a></div><div class="blist">·<a href="/c/cpyj/2849.html">浙江省第二测绘院</a></div><div class="blist">·<a href="/c/cpyj/2848.html">中国石化集团胜利石油管理局胜大油品厂</a></div><div class="blist">·<a href="/c/cpyj/2847.html">广东悦丰电力建设有限公司</a></div><div class="blist">·<a href="/c/cpyj/2846.html">承德江钻石油机械有限责任公司</a></div><div class="blist">·<a href="/c/cpyj/2845.html">北京住总正通市政工程有限公司</a></div><div class="blist">·<a href="/c/cpyj/2844.html">哈尔滨电力工程安装公司</a></div><div class="blist">·<a href="/c/cpyj/2843.html">广东瑞普信息科技有限公司</a></div><div class="blist">·<a href="/c/cpyj/2842.html">岳阳长岭炼化通达建筑安装工程有限公司</a></div><div class="blist">·<a href="/c/cpyj/2841.html">新疆新特顺电力设备有限责任公司</a></div><div class="blist">·<a href="/c/cpyj/2689.html">河北华北石油荣盛机械制造有限公司</a></div><div class="blist">·<a href="/c/cpyj/2688.html">中缆集团有限公司</a></div><div class="blist">·<a href="/c/cpyj/2687.html">胜利油田胜利化工有限责任公司</a></div><div class="blist">·<a href="/c/cpyj/2686.html">云南天悦家具制造有限公司</a></div><div class="blist">·<a href="/c/cpyj/2684.html">实华（天津）石油化工工程有限公司</a></div><div class="blist">·<a href="/c/cpyj/2600.html">中农集团控股股份有限公司</a></div><div class="blist">·<a href="/c/cpyj/2599.html">山东泰信幕墙工程有限公司</a></div><div class="blist">·<a href="/c/cpyj/2598.html">海航基础产业集团有限公司</a></div><div class="blist">·<a href="/c/cpyj/2554.html">江苏振光电力设备制造有限公司</a></div><div class="blist">·<a href="/c/cpyj/2553.html">广东华润涂料有限公司</a></div><div class="blist">·<a href="/c/cpyj/2541.html">北京易达新电气成套设备有限公司</a></div><div class="blist">·<a href="/c/cpyj/2540.html">湖南省水工环地质工程勘察院</a></div><div class="blist">·<a href="/c/cpyj/2539.html">青岛双瑞海洋环境工程股份有限公司</a></div><div class="blist">·<a href="/c/cpyj/2538.html">山东得顺源石油科技有限公司</a></div><div class="blist">·<a href="/c/cpyj/2537.html">山西晋缘电力化学清洗中心有限公司</a></div><div class="blist">·<a href="/c/cpyj/2487.html">广东肯富来泵业股份有限公司</a></div><div class="blist">·<a href="/c/cpyj/2486.html">北京昊创瑞通电气设备有限公司</a></div><div class="blist">·<a href="/c/cpyj/2485.html">中船重工环境工程有限公司</a></div><div class="blist">·<a href="/c/cpyj/2484.html">山东海岱园林集团有限公司</a></div><div class="blist">·<a href="/c/cpyj/2483.html">绥化远大电力建设集团有限责任公司</a></div><div class="blist">·<a href="/c/cpyj/2482.html">上海朗泰医院后勤管理有限公司</a></div><div class="blist">·<a href="/c/cpyj/2440.html">新华网股份有限公司</a></div><div class="blist">·<a href="/c/cpyj/2439.html">甘肃敬业农业科技有限公司</a></div><div class="blist">·<a href="/c/cpyj/2438.html">安徽华鑫电线电缆有限公司</a></div><div class="blist">·<a href="/c/cpyj/2436.html">新疆建投宝塑管业有限公司</a></div><div class="blist">·<a href="/c/cpyj/2435.html">北京嘉瑞环保股份有限公司</a></div><div class="blist">·<a href="/c/cpyj/2434.html">北京星际元会展有限公司</a></div><div class="blist">·<a href="/c/cpyj/2433.html">北京瑞泰安建设工程有限公司</a></div><div class="blist">·<a href="/c/cpyj/2432.html">北京华杰博通科技有限公司</a></div><div class="blist">·<a href="/c/cpyj/2431.html">山东华通玻璃钢有限公司</a></div><div class="blist">·<a href="/c/cpyj/2369.html">新疆城市建筑装饰工程有限公司</a></div><div class="blist">·<a href="/c/cpyj/2356.html">甘肃静宁建筑企业（集团）有限责任公司</a></div><div class="blist">·<a href="/c/cpyj/2332.html">良精集团有限公司</a></div><div class="blist">·<a href="/c/cpyj/2331.html">中国石化催化剂有限公司北京奥达分公司</a></div><div class="blist">·<a href="/c/cpyj/2330.html">天津骥腾科技有限公司</a></div><div class="blist">·<a href="/c/cpyj/2329.html">香河梅泰克诺门业有限公司</a></div><div class="blist">·<a href="/c/cpyj/2328.html">北京长吉加油设备有限公司</a></div><div class="blist">·<a href="/c/cpyj/2246.html">北京英昌通泰电力设备有限公司</a></div><div class="blist">·<a href="/c/cpyj/2245.html">甘肃华协农业生物科技股份有限公司</a></div><div class="blist">·<a href="/c/cpyj/2244.html">上海三零卫士信息安全有限公司</a></div><div class="blist">·<a href="/c/cpyj/2243.html">郴州市水电建设公司</a></div><div class="blist">·<a href="/c/cpyj/2242.html">浙江科润建设有限公司</a></div><div class="blist">·<a href="/c/cpyj/2241.html">北京鼎硕文豪图书有限公司</a></div><div class="blist">·<a href="/c/cpyj/2240.html">北京华创视讯科技发展有限公司</a></div><div class="blist">·<a href="/c/cpyj/2210.html">天合天国际会展服务（北京）有限公司</a></div><div class="blist">·<a href="/c/cpyj/2209.html">重庆市山城燃气设备有限公司</a></div><div class="blist">·<a href="/c/cpyj/2208.html">武汉江浙智能科技有限公司</a></div><div class="blist">·<a href="/c/cpyj/2207.html">浙江丽兹医用工程有限公司</a></div><div class="blist">·<a href="/c/cpyj/2206.html">山东海吉雅环保设备有限公司</a></div><div class="blist">·<a href="/c/cpyj/2193.html">上海澳翔鞋业有限公司</a></div><div class="blist">·<a href="/c/cpyj/2192.html">北京盛世宣合信息科技有限公司</a></div><div class="blist">·<a href="/c/cpyj/2191.html">南昌安特电缆有限公司</a></div><div class="blist">·<a href="/c/cpyj/2190.html">江苏德铭机械有限公司</a></div><div class="blist">·<a href="/c/cpyj/2189.html">厦门市海菱电子有限公司</a></div><div class="blist">·<a href="/c/cpyj/2188.html">东莞尊荣鞋业有限公司</a></div><div class="blist">·<a href="/c/cpyj/2187.html">北京奥特维科技有限公司</a></div><div class="blist">·<a href="/c/cpyj/2186.html">内蒙古正安恒泰电力科技有限公司</a></div><div class="blist">·<a href="/c/cpyj/2185.html">山西天辅区域规划咨询有限公司</a></div><div class="blist">·<a href="/c/cpyj/2163.html">咸宁市创益电子系统集成有限公司</a></div><div class="blist">·<a href="/c/cpyj/2943.html">北京燕山集联石油化工有限公司</a></div><div class="blist">·<a href="/c/cpyj/2942.html">河北乾烨金属制品有限公司</a></div><div class="blist">·<a href="/c/cpyj/2941.html">北京大明五洲科技有限公司</a></div><div class="blist">·<a href="/c/cpyj/2940.html">北京中实杰肯道失物业管理有限公司</a></div><div class="blist">·<a href="/c/cpyj/2933.html">河北世纪大饭店物业管理有限公司</a></div><div class="blist">·<a href="/c/cpyj/2932.html">中兴新能源汽车有限责任公司</a></div><div class="blist">·<a href="/c/cpyj/2927.html">重庆市恒海环卫设备有限公司</a></div><div class="blist">·<a href="/c/cpyj/2926.html">佳美物业服务有限公司</a></div><div class="blist">·<a href="/c/cpyj/2925.html">悦华新物业服务有限公司</a></div><div class="blist">·<a href="/c/cpyj/2924.html">江西赣电电气有限公司</a></div><div class="blist">·<a href="/c/cpyj/2923.html">北控环境投资（中国）有限公司</a></div><div class="blist">·<a href="/c/cpyj/2922.html">上海卫事康卫生管理服务有限公司</a></div><div class="blist">·<a href="/c/cpyj/2921.html">大禹节水集团股份有限公司</a></div><div class="blist">·<a href="/c/cpyj/2920.html">黑龙江省水利水电集团第二工程有限公司</a></div><div class="blist">·<a href="/c/cpyj/2919.html">北京科住物业管理有限公司</a></div><div class="blist">·<a href="/c/cpyj/2850.html">上海晨光科力普办公用品有限公司</a></div><div class="blist">·<a href="/c/cpyj/2849.html">浙江省第二测绘院</a></div><div class="blist">·<a href="/c/cpyj/2848.html">中国石化集团胜利石油管理局胜大油品厂</a></div><div class="blist">·<a href="/c/cpyj/2847.html">广东悦丰电力建设有限公司</a></div><div class="blist">·<a href="/c/cpyj/2846.html">承德江钻石油机械有限责任公司</a></div><div class="blist">·<a href="/c/cpyj/2845.html">北京住总正通市政工程有限公司</a></div><div class="blist">·<a href="/c/cpyj/2844.html">哈尔滨电力工程安装公司</a></div><div class="blist">·<a href="/c/cpyj/2843.html">广东瑞普信息科技有限公司</a></div><div class="blist">·<a href="/c/cpyj/2842.html">岳阳长岭炼化通达建筑安装工程有限公司</a></div><div class="blist">·<a href="/c/cpyj/2841.html">新疆新特顺电力设备有限责任公司</a></div><div class="blist">·<a href="/c/cpyj/2689.html">河北华北石油荣盛机械制造有限公司</a></div><div class="blist">·<a href="/c/cpyj/2688.html">中缆集团有限公司</a></div><div class="blist">·<a href="/c/cpyj/2687.html">胜利油田胜利化工有限责任公司</a></div><div class="blist">·<a href="/c/cpyj/2686.html">云南天悦家具制造有限公司</a></div><div class="blist">·<a href="/c/cpyj/2684.html">实华（天津）石油化工工程有限公司</a></div><div class="blist">·<a href="/c/cpyj/2600.html">中农集团控股股份有限公司</a></div><div class="blist">·<a href="/c/cpyj/2599.html">山东泰信幕墙工程有限公司</a></div><div class="blist">·<a href="/c/cpyj/2598.html">海航基础产业集团有限公司</a></div><div class="blist">·<a href="/c/cpyj/2554.html">江苏振光电力设备制造有限公司</a></div><div class="blist">·<a href="/c/cpyj/2553.html">广东华润涂料有限公司</a></div><div class="blist">·<a href="/c/cpyj/2541.html">北京易达新电气成套设备有限公司</a></div><div class="blist">·<a href="/c/cpyj/2540.html">湖南省水工环地质工程勘察院</a></div><div class="blist">·<a href="/c/cpyj/2539.html">青岛双瑞海洋环境工程股份有限公司</a></div><div class="blist">·<a href="/c/cpyj/2538.html">山东得顺源石油科技有限公司</a></div><div class="blist">·<a href="/c/cpyj/2537.html">山西晋缘电力化学清洗中心有限公司</a></div><div class="blist">·<a href="/c/cpyj/2487.html">广东肯富来泵业股份有限公司</a></div><div class="blist">·<a href="/c/cpyj/2486.html">北京昊创瑞通电气设备有限公司</a></div><div class="blist">·<a href="/c/cpyj/2485.html">中船重工环境工程有限公司</a></div><div class="blist">·<a href="/c/cpyj/2484.html">山东海岱园林集团有限公司</a></div><div class="blist">·<a href="/c/cpyj/2483.html">绥化远大电力建设集团有限责任公司</a></div><div class="blist">·<a href="/c/cpyj/2482.html">上海朗泰医院后勤管理有限公司</a></div><div class="blist">·<a href="/c/cpyj/2440.html">新华网股份有限公司</a></div><div class="blist">·<a href="/c/cpyj/2439.html">甘肃敬业农业科技有限公司</a></div><div class="blist">·<a href="/c/cpyj/2438.html">安徽华鑫电线电缆有限公司</a></div><div class="blist">·<a href="/c/cpyj/2436.html">新疆建投宝塑管业有限公司</a></div><div class="blist">·<a href="/c/cpyj/2435.html">北京嘉瑞环保股份有限公司</a></div><div class="blist">·<a href="/c/cpyj/2434.html">北京星际元会展有限公司</a></div><div class="blist">·<a href="/c/cpyj/2433.html">北京瑞泰安建设工程有限公司</a></div><div class="blist">·<a href="/c/cpyj/2432.html">北京华杰博通科技有限公司</a></div><div class="blist">·<a href="/c/cpyj/2431.html">山东华通玻璃钢有限公司</a></div><div class="blist">·<a href="/c/cpyj/2369.html">新疆城市建筑装饰工程有限公司</a></div><div class="blist">·<a href="/c/cpyj/2356.html">甘肃静宁建筑企业（集团）有限责任公司</a></div><div class="blist">·<a href="/c/cpyj/2332.html">良精集团有限公司</a></div><div class="blist">·<a href="/c/cpyj/2331.html">中国石化催化剂有限公司北京奥达分公司</a></div><div class="blist">·<a href="/c/cpyj/2330.html">天津骥腾科技有限公司</a></div><div class="blist">·<a href="/c/cpyj/2329.html">香河梅泰克诺门业有限公司</a></div><div class="blist">·<a href="/c/cpyj/2328.html">北京长吉加油设备有限公司</a></div><div class="blist">·<a href="/c/cpyj/2246.html">北京英昌通泰电力设备有限公司</a></div><div class="blist">·<a href="/c/cpyj/2245.html">甘肃华协农业生物科技股份有限公司</a></div><div class="blist">·<a href="/c/cpyj/2244.html">上海三零卫士信息安全有限公司</a></div><div class="blist">·<a href="/c/cpyj/2243.html">郴州市水电建设公司</a></div><div class="blist">·<a href="/c/cpyj/2242.html">浙江科润建设有限公司</a></div><div class="blist">·<a href="/c/cpyj/2241.html">北京鼎硕文豪图书有限公司</a></div><div class="blist">·<a href="/c/cpyj/2240.html">北京华创视讯科技发展有限公司</a></div><div class="blist">·<a href="/c/cpyj/2210.html">天合天国际会展服务（北京）有限公司</a></div><div class="blist">·<a href="/c/cpyj/2209.html">重庆市山城燃气设备有限公司</a></div><div class="blist">·<a href="/c/cpyj/2208.html">武汉江浙智能科技有限公司</a></div><div class="blist">·<a href="/c/cpyj/2207.html">浙江丽兹医用工程有限公司</a></div><div class="blist">·<a href="/c/cpyj/2206.html">山东海吉雅环保设备有限公司</a></div><div class="blist">·<a href="/c/cpyj/2193.html">上海澳翔鞋业有限公司</a></div><div class="blist">·<a href="/c/cpyj/2192.html">北京盛世宣合信息科技有限公司</a></div><div class="blist">·<a href="/c/cpyj/2191.html">南昌安特电缆有限公司</a></div><div class="blist">·<a href="/c/cpyj/2190.html">江苏德铭机械有限公司</a></div><div class="blist">·<a href="/c/cpyj/2189.html">厦门市海菱电子有限公司</a></div><div class="blist">·<a href="/c/cpyj/2188.html">东莞尊荣鞋业有限公司</a></div><div class="blist">·<a href="/c/cpyj/2187.html">北京奥特维科技有限公司</a></div><div class="blist">·<a href="/c/cpyj/2186.html">内蒙古正安恒泰电力科技有限公司</a></div><div class="blist">·<a href="/c/cpyj/2185.html">山西天辅区域规划咨询有限公司</a></div><div class="blist">·<a href="/c/cpyj/2163.html">咸宁市创益电子系统集成有限公司</a></div>
                 --></div> 
                <div id="demo2"></div> 
                </div> 
                <script> 
                var speed=36; //数字越大速度越慢 
                var tab=document.getElementById("demo"); 
                var tab1=document.getElementById("demo1"); 
                var tab2=document.getElementById("demo2"); 
                tab2.innerHTML=tab1.innerHTML; //克隆demo1为demo2 
                function Marquee(){ 
                if(tab2.offsetTop-tab.scrollTop<=0)//当滚动至demo1与demo2交界时 
                tab.scrollTop-=tab1.offsetHeight //demo跳到最顶端 
                else{ 
                tab.scrollTop++ 
                }	} 
                var MyMar=setInterval(Marquee,speed); 
                tab.onmouseover=function() {clearInterval(MyMar)};//鼠标移上时清除定时器达到滚动停止的目的 
                tab.onmouseout=function() {MyMar=setInterval(Marquee,speed)};//鼠标移开时重设定时器 
                </script>
				</div>
			</dd>
		</div>
	</div>
	<div class="clear"></div>
 
        <div class="part left" id="container" style="min-width: 310px; height: 400px; margin: 0 auto">
  
 			
 			<dd>
				<span><ul><li><h2><a class="curr">图表</a></h2></li></ul></span>
		<script >	   
			
        $(function () {
    // Create the chart
    Highcharts.chart('container', {
        chart: {
            type: 'column'
        },
        title: {
            text: '行业平均分'
        },

        xAxis: {
            type: 'category'
        },
        yAxis: {
            title: {
                text: ''
            }
        },
        legend: {
            enabled: false
        },
        plotOptions: {
            series: {
                borderWidth: 0,
                dataLabels: {
                    enabled: true,
                    format: '{point.y:.1f}'
                }
            }
        },
        tooltip: {
            headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
            pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f}</b> <br/>'
        },
        series: [{
            name: '平均分',
            colorByPoint: true,
            data: [{
                name: '行业A',
                y: 90,
                drilldown: 'null'
            }, {
                name: '行业B',
                y: 80,
                drilldown: 'null'
            }, {
                name: '行业C',
                y: 70,
                drilldown: 'null'
            }, {
                name: '行业D',
                y: 60,
                drilldown: 'null'
            }, {
                name: '行业E',
                y: 50,
                drilldown: 'null'
            }]
        }],
        drilldown: {
            series: [{
                name: 'Microsoft Internet Explorer',
                id: 'Microsoft Internet Explorer',
                data: [
                    [
                        'v11.0',
                        24.13
                    ],
                    [
                        'v8.0',
                        17.2
                    ],
                    [
                        'v9.0',
                        8.11
                    ],
                    [
                        'v10.0',
                        5.33
                    ],
                    [
                        'v6.0',
                        1.06
                    ],
                    [
                        'v7.0',
                        0.5
                    ]
                ]
            }, {
                name: 'Chrome',
                id: 'Chrome',
                data: [
                    [
                        'v40.0',
                        5
                    ],
                    [
                        'v41.0',
                        4.32
                    ],
                    [
                        'v42.0',
                        3.68
                    ],
                    [
                        'v39.0',
                        2.96
                    ],
                    [
                        'v36.0',
                        2.53
                    ],
                    [
                        'v43.0',
                        1.45
                    ],
                    [
                        'v31.0',
                        1.24
                    ],
                    [
                        'v35.0',
                        0.85
                    ],
                    [
                        'v38.0',
                        0.6
                    ],
                    [
                        'v32.0',
                        0.55
                    ],
                    [
                        'v37.0',
                        0.38
                    ],
                    [
                        'v33.0',
                        0.19
                    ],
                    [
                        'v34.0',
                        0.14
                    ],
                    [
                        'v30.0',
                        0.14
                    ]
                ]
            }, {
                name: 'Firefox',
                id: 'Firefox',
                data: [
                    [
                        'v35',
                        2.76
                    ],
                    [
                        'v36',
                        2.32
                    ],
                    [
                        'v37',
                        2.31
                    ],
                    [
                        'v34',
                        1.27
                    ],
                    [
                        'v38',
                        1.02
                    ],
                    [
                        'v31',
                        0.33
                    ],
                    [
                        'v33',
                        0.22
                    ],
                    [
                        'v32',
                        0.15
                    ]
                ]
            }, {
                name: 'Safari',
                id: 'Safari',
                data: [
                    [
                        'v8.0',
                        2.56
                    ],
                    [
                        'v7.1',
                        0.77
                    ],
                    [
                        'v5.1',
                        0.42
                    ],
                    [
                        'v5.0',
                        0.3
                    ],
                    [
                        'v6.1',
                        0.29
                    ],
                    [
                        'v7.0',
                        0.26
                    ],
                    [
                        'v6.2',
                        0.17
                    ]
                ]
            }, {
                name: 'Opera',
                id: 'Opera',
                data: [
                    [
                        'v12.x',
                        0.34
                    ],
                    [
                        'v28',
                        0.24
                    ],
                    [
                        'v27',
                        0.17
                    ],
                    [
                        'v29',
                        0.16
                    ]
                ]
            }]
        }
    });
});
 </script>	       
			
			</dd>
 			 
 	
        </div>
		
        <div class="part right" id="container1" style="min-width: 310px; height: 400px; margin: 0 auto">
         
				<span><ul><li><h2><a class="curr">图表</a></h2></li></ul></span>
<dd>

    <script>
        $(function () {
    // Create the chart
    Highcharts.chart('container1', {
        chart: {
            type: 'column'
        },
        title: {
            text: '省'
        },

        xAxis: {
            type: 'category'
        },
        yAxis: {
            title: {
                text: ''
            }
        },
        legend: {
            enabled: false
        },
        plotOptions: {
            series: {
                borderWidth: 0,
                dataLabels: {
                    enabled: true,
                    format: '{point.y:.1f}'
                }
            }
        },
        tooltip: {
            headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
            pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f}</b> <br/>'
        },
        series: [{
            name: '平均分',
            colorByPoint: true,
            data: [{
                name: '湖北省',
                y: 90,
                drilldown: 'null'
            }, {
                name: '河南省',
                y: 90,
                drilldown: 'null'
            }, {
                name: '湖南省',
                y: 86,
                drilldown: 'null'
            }, {
                name: '安徽省',
                y: 87,
                drilldown: 'null'
            }, {
                name: '江西省',
                y: 90,
                drilldown: 'null'
            }]
        }],
        drilldown: {
            series: [{
                name: 'Microsoft Internet Explorer',
                id: 'Microsoft Internet Explorer',
                data: [
                    [
                        'v11.0',
                        24.13
                    ],
                    [
                        'v8.0',
                        17.2
                    ],
                    [
                        'v9.0',
                        8.11
                    ],
                    [
                        'v10.0',
                        5.33
                    ],
                    [
                        'v6.0',
                        1.06
                    ],
                    [
                        'v7.0',
                        0.5
                    ]
                ]
            }, {
                name: 'Chrome',
                id: 'Chrome',
                data: [
                    [
                        'v40.0',
                        5
                    ],
                    [
                        'v41.0',
                        4.32
                    ],
                    [
                        'v42.0',
                        3.68
                    ],
                    [
                        'v39.0',
                        2.96
                    ],
                    [
                        'v36.0',
                        2.53
                    ],
                    [
                        'v43.0',
                        1.45
                    ],
                    [
                        'v31.0',
                        1.24
                    ],
                    [
                        'v35.0',
                        0.85
                    ],
                    [
                        'v38.0',
                        0.6
                    ],
                    [
                        'v32.0',
                        0.55
                    ],
                    [
                        'v37.0',
                        0.38
                    ],
                    [
                        'v33.0',
                        0.19
                    ],
                    [
                        'v34.0',
                        0.14
                    ],
                    [
                        'v30.0',
                        0.14
                    ]
                ]
            }, {
                name: 'Firefox',
                id: 'Firefox',
                data: [
                    [
                        'v35',
                        2.76
                    ],
                    [
                        'v36',
                        2.32
                    ],
                    [
                        'v37',
                        2.31
                    ],
                    [
                        'v34',
                        1.27
                    ],
                    [
                        'v38',
                        1.02
                    ],
                    [
                        'v31',
                        0.33
                    ],
                    [
                        'v33',
                        0.22
                    ],
                    [
                        'v32',
                        0.15
                    ]
                ]
            }, {
                name: 'Safari',
                id: 'Safari',
                data: [
                    [
                        'v8.0',
                        2.56
                    ],
                    [
                        'v7.1',
                        0.77
                    ],
                    [
                        'v5.1',
                        0.42
                    ],
                    [
                        'v5.0',
                        0.3
                    ],
                    [
                        'v6.1',
                        0.29
                    ],
                    [
                        'v7.0',
                        0.26
                    ],
                    [
                        'v6.2',
                        0.17
                    ]
                ]
            }, {
                name: 'Opera',
                id: 'Opera',
                data: [
                    [
                        'v12.x',
                        0.34
                    ],
                    [
                        'v28',
                        0.24
                    ],
                    [
                        'v27',
                        0.17
                    ],
                    [
                        'v29',
                        0.16
                    ]
                ]
            }]
        }
    });
});
    </script>
		</dd>	
			
        </div><div class="clear"></div>
	</div>
	

    <div id="right" style="height:690px; display:table">
		<div class='title' style="height:200px" ><h3 class="title">通知公告</h3><!-- &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<a href="/c/wjtz/" style="color:#000; font-size:12px"></a></h3>
		 -->
		 <ul>
		<li>·<a href="attion.jsp">关于免费使用企业绿色评价系统的通知</a></li><!-- <li>·<a href="/c/wjtz/2939.html">关于推荐AA级以上信用企业</a></li><li>·<a href="/c/wjtz/2935.html">商务部等18部门开展2016年</a></li><li>·<a href="/c/wjtz/2612.html">2016年春节放假安排通知</a></li><li>·<a href="/c/wjtz/2488.html">2015年度医药企业信用评价</a></li>
		 -->
		</ul>
		</div>
		<hr style="border-bottom:1px solid #D8D8D8" size="1">
	<div class='title' style="height:250px">
		
		<h3 class="h3title" ><img src="pj.png" border="0" align="absmiddle" style="margin:0 0 0 -58px;" /><a href="login.jsp" target="_blank">企业信用评价</a></h3>
	  <h3 class="h3title" ><img src="lc.png" border="0" align="absmiddle" style="margin:0 0 0 -73px;" /><a href="绿色评价—企业绿色评价—流程（正在写）.docx" target="_blank">评价流程</a></h3>
		<h3 class="h3title" ><img src="yb.png" border="0" align="absmiddle" style="margin:0 0 0 -73px;" /><a href="/c/zsyb.html" target="_blank">证书样本</a></h3>
		
		</div>
		<hr style="border-bottom:1px solid #D8D8D8" size="1">
		<div style="height:400px"> 
		<h3 class="title">企业绿色实践</a></h3>
		<ul>
		<li>·<a href="1.docx">太原钢铁：绿色发展实践</a></li>
		
		<li>·<a href="2.docx">海尔绿帆&nbsp;：向环保航行</a></li>
		<br/>
		<li>·<a href="3.docx">兴发化工&nbsp;实现减排节能与环境保护的双赢</a></li>
		<br/>
		<li>·<a href="4.docx">湖北洋丰,“绿色洋丰”环保新招数</a></li><br/>
		<li>·<a href="5.docx">华新水泥,美好的世界，从我们开始</a></li>
		<br/>
		<li>·<a href="6.docx">神华集团,建设世界一流的清洁能源供应商</a></li>
		
		</ul>
		</div>
    </div>
</div>


<div class="link" >

<strong>[相关链接]</strong>
    <a href="http://www.zhb.gov.cn/">国家环保局</a>|<a href="http://gsxt.saic.gov.cn/">国家企业信息公示系统</a>|<a href="http://www.creditchina.gov.cn/" >信用中国</a>|<a href="http://www.sdpc.gov.cn/" >国家发改委</a> | <a href="http://www.hbepb.gov.cn/" >湖北省环保厅</a> | <a href="http://www.sasac.gov.cn/" >国务院国资委</a> |<a href="http://www.stats.gov.cn/"> 国家统计局</a><a href="/c/tjqy/zfbm/245.html" ></a></p>
</div>

<div class="ddaoh">
	<a href="/" class="td_linkTatle">首 页</a> | 
	<a href="/c/gywm/" class="td_linkTatle">关于我们</a> | 
	<a href="/c/zxly.html" class="td_linkTatle">社会责任</a> | 
	<a href="/c/cxxy.html" class="td_linkTatle">诚信宣言</a> | 
	<a href="/c/dljgcx/" class="td_linkTatle">代理机构查询</a> | 
	<a href="/c/jmhz.html" class="td_linkTatle">合作申请</a> | 
	<a href="/c/cpyc.html" class="td_linkTatle">人才招聘</a> | 
	<a href="/c/mzsm.html" class="td_linkTatle">免责声明</a> | 
	<a href="/c/yjfk.html" class="td_linkTatle">意见反馈</a> | 
	<a href="/c/tjqy/" class="td_linkTatle">友情链接</a> | 
	<a href="/c/lxwm.html" class="td_linkTatle">联系我们</a> |
	<style type="text/css">#mobile	a img{display:none; border:none; width:120px;}	#mobile a:hover img{display:block; position:absolute;}	</style>
    <span id="mobile"><a href="http://zhan.sem123.com/index.php?g=Wap&m=Index&a=index&token=dagexr1429866944" target="_blank" class="td_linkTatle">手机版<img src="/UploadFiles/mobile.png" /></a></span>

</div>	 
<style>
.rides-cs {  font-size: 12px; background:#29a7e2; position: fixed; top:193px; right: 0px; _position: absolute; z-index: 1500; border-radius:6px 0px 0 6px;}
.rides-cs a { color: #00A0E9;}
.rides-cs a:hover { color: #ff8100; text-decoration: none;}
.rides-cs .floatL { width: 36px; float:left; position: relative; z-index:1;margin-top: 21px;height: 181px;}
.rides-cs .floatL a { font-size:0; text-indent: -999em; display: block;}
.rides-cs .floatR { width: 130px; float: left; padding: 5px; overflow:hidden;}
.rides-cs .floatR .cn {background:#F7F7F7; border-radius:6px;margin-top:4px;}
.rides-cs .cn .titZx{ font-size: 14px; color: #333;font-weight:600; line-height:24px;padding:5px;text-align:center;}
.rides-cs .cn ul {padding:0px;}
.rides-cs .cn ul li { line-height: 38px; height:38px;border-bottom: solid 1px #E6E4E4;overflow: hidden;text-align:center;}
.rides-cs .cn ul li span { color: #777;}
.rides-cs .cn ul li a{color: #777;}
.rides-cs .cn ul li img { vertical-align: middle;}
.rides-cs .btnOpen, .rides-cs .btnCtn {  position: relative; z-index:9; top:25px; left: 0;  background-image: url(/images/lanrenzhijia.png); background-repeat: no-repeat; display:block;  height: 146px; padding: 8px;}
.rides-cs .btnOpen { background-position: 0 0;}
.rides-cs .btnCtn { background-position: -37px 0;}
.rides-cs ul li.top { border-bottom: solid #ACE5F9 1px;}
.rides-cs ul li.bot { border-bottom: none;}
</style>

<script>
	$(function(){
		$("#aFloatTools_Show").click(function(){
			$('#divFloatToolsView').animate({width:'show',opacity:'show'},100,function());
			$('#aFloatTools_Show').hide();
			$('#aFloatTools_Hide').show();				
		});
		$("#aFloatTools_Hide").click(function(){
			$('#divFloatToolsView').animate({width:'hide', opacity:'hide'},100,function());
			$('#aFloatTools_Show').show();
			$('#aFloatTools_Hide').hide();	
		});
	});
</script>

</body>
</html>
