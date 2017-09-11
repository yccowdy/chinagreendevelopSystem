package com.a.model;
import java.io.File;
import java.util.List;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class test {

    public static void main(String[] args) {
        try {
            WritableWorkbook wwb = null;
            Workbook wb=null;
               // 创建可写入的Excel工作簿
               String fileName = "b.xls";
               File file=new File(fileName);
               if (!file.exists()) {
                   file.createNewFile();
               }
               //以fileName为文件名来创建一个Workbook
               wb=Workbook.getWorkbook(file);
               wwb = Workbook.createWorkbook(file,wb);
               //以fileName为文件名来获取一个Workbook
               //wwb=(WritableWorkbook)Workbook.getWorkbook(file);

               // 创建工作表
              // WritableSheet ws = wwb.createSheet("Test Shee 1", 0);
               //获取工作表
               WritableSheet ws = wwb.getSheet("Sheet1");
               //查询数据库中所有的数据
              // List<StuEntity> list= StuService.getAllByDb();
               //要插入到的Excel表格的行号，默认从0开始
               Label labelId= new Label(1, 1, "中国大学");//表示第
               ws.mergeCells(1, 1, 3, 0);
               Label labelName= new Label(5,1, "2016.1.10");
               Label labelSex= new Label(1,3, "xxxxx");
               if(ws!=null){
               ws.addCell(labelId);
               ws.addCell(labelName);
               ws.addCell(labelSex);
               
               //ws.addCell(labelNum);
              /* for (int i = 0; i < 10; i++) {
                   
                   Label labelId_i= new Label(0, i+1, 1+"");
                   Label labelName_i= new Label(1, i+1, 2+"");
                   Label labelSex_i= new Label(2, i+1, 3+"");
                   Label labelNum_i= new Label(3, i+1, 4+"");
                   ws.addCell(labelId_i);
                   ws.addCell(labelName_i);
                   ws.addCell(labelSex_i);
                   ws.addCell(labelNum_i);
               }*/
             
              //写进文档
               wwb.write();
              // 关闭Excel工作簿对象
               wwb.close();
               }
             
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }
}

