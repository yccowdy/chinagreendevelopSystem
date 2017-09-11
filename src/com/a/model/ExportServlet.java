package com.a.model;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.rmi.server.ExportException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ExportServlet extends HttpServlet {

	 static final long serialVersionUID = 1L;

	    protected void doGet(HttpServletRequest request,
	            HttpServletResponse response) throws ServletException, IOException {
	        /*File file = new File(getServletContext()
	                .getRealPath("WEB-INF/book.jpg"));*/
	        response.setContentType("application/x-xls;charset=utf-8");//"octets/stream"
	        /*response.addHeader("Content-Disposition",
	                "attachment;filename=test.xls");*/
	        response.addHeader("Content-Disposition",
	        		"attachment;filename="+"\""+ new String(("企业做题情况表.xls").getBytes("GB2312"),
	        				"iso8859-1")+ "\""); 
	        ExportExcel<UserBean> ex = new ExportExcel<UserBean>();
//	        String[] headers = { "企业名称","企业地点", "企业规模", "企业类型", "所属行业","1-2-1","1-3-1","1-4-1","2-1-1","2-2-1","3-1-1",
//	        		"3-1-2","3-2-1","4-1-1","4-2-1","4-3-1","4-4-1","4-5-1","4-6-1","4-7-1","4-8-1","4-9-1","4-9-2","4-10-1",
//	        		"4-11-1","5-1-1","5-1-2","5-1-3","5-1-4","5-2-1","5-2-2","5-2-3","5-2-4","5-2-5","5-3-1","5-3-2","5-3-3","6-1-1","6-2-1","6-2-2","6-2-3","6-2-4","6-2-5",
//	        		"6-2-6","6-3-1","6-3-2","6-3-3","6-3-4","6-3-5","6-3-6","6-3-7","6-3-8","6-4-1","6-4-2","6-4-3"};
	        String[] headers = {"企业名称","企业地点", "企业规模", "企业类型", "所属行业","题目答案"};
	        ArrayList<UserBean> alsb =new UserBeanCl().ExcelgetAllUser();
	        try {        	          
	            OutputStream out = response.getOutputStream();
	            ex.exportExcel(headers,alsb, out);
	            out.close();	           
	        } catch (FileNotFoundException e) {
	        	 System.out.println("excel导出成功！");
	            e.printStackTrace();
	        } catch (IOException e) {
	        	 System.out.println("excel");
	            e.printStackTrace();
	        }
	    }

	    protected void doPost(HttpServletRequest request,
	            HttpServletResponse response) throws ServletException, IOException {
	        doGet(request, response);
	    }

}