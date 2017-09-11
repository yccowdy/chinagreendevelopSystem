function Dsy()
{
 this.Items = {};
}
Dsy.prototype.add = function(id,iArray)
{
 this.Items[id] = iArray;
}
Dsy.prototype.Exists = function(id)
{
 if(typeof(this.Items[id]) == "undefined") return false;
 return true;
}
function change(v){
 var str="0";
 for(i=0;i<v;i++){ str+=("_"+(document.getElementById(s[i]).selectedIndex-1));};
 var ss=document.getElementById(s[v]);
 with(ss){
  length = 0;
  options[0]=new Option(opt0[v],opt0[v]);
  if(v && document.getElementById(s[v-1]).selectedIndex>0 || !v)
  {
   if(dsy.Exists(str)){
    ar = dsy.Items[str];
    for(i=0;i<ar.length;i++)options[length]=new Option(ar[i],ar[i]);
    if(v)options[1].selected = true;
   }
  }
  if(++v<s.length){change(v);}
 }
}
var dsy = new Dsy();
dsy.add("0",["绿色文化","组织体系","战略规划","管理制度","技术措施","环保绩效"]);
dsy.add("0_0",["理念","口号","宣传","培训"]);
dsy.add("0_1",["环保部门","专门人才"]);
dsy.add("0_2",["战略目标","战略措施"]);
dsy.add("0_3",["责任分工","风险管理","内部沟通","外部报告","奖惩制度","绿色采购制度","绿色生产制度","绿色营销制度","化学危险品管理制度","环境监测制度","环境管理体系认证"]);
dsy.add("0_4",["环保设备","环保技术","循环经济"]);
dsy.add("0_5",["环保投入","节约能源、资源","降污减排","企业形象"]);
var s=["inputTitle","inputPaperSummary"];
var opt0 = ["请选择一级标题","请选择二级标题"];
function setup()
{
 for(i=0;i<s.length-1;i++)
  document.getElementById(s[i]).onchange=new Function("change("+(i+1)+")");
 change(0);
}