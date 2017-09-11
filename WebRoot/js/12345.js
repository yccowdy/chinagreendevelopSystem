/**
 * 
 */
var city=[

     ["理念","口号","宣传","培训"],

     ["环保部门","专门人才"],

     ["战略目标","战略措施"],

     ["责任分工","风险管理","内部沟通","外部报告","奖惩制度","绿色采购制度","绿色生产制度","绿色营销制度","化学危险品管理制度"],

     ["环保设备","环保技术","循环经济"],
     
     ["环保设备","环保技术","循环经济"],

     ];


     function getCity(){

         //获得省份下拉框的对象

         var sltProvince=document.form1.province;

         //获得城市下拉框的对象

         var sltCity=document.form1.city;         

         //得到对应省份的城市数组

         var provinceCity=city[sltProvince.selectedIndex - 1];

 

         //清空城市下拉框，仅留提示选项

         sltCity.length=1;

 

         //将城市数组中的值填充到城市下拉框中

         for(var i=0;i<provinceCity.length;i++){

             sltCity[i+1]=new Option(provinceCity[i],provinceCity[i]);

         }

     }

