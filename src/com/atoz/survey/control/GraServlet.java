package com.atoz.survey.control;

import java.io.IOException;
import java.util.*;
import java.text.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.filters.SetCharacterEncodingFilter;

import com.atoz.survey.dao.mysqlimpl.UserDaoImpl;
import com.atoz.survey.po.Login;
import com.atoz.survey.po.User;
import com.atoz.survey.service.LoginService;
import com.atoz.survey.service.UserService;
import com.atoz.survey.service.impl.LoginServiceImpl;
import com.atoz.survey.service.impl.UserServiceImpl;

public class GraServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public GraServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	@Override
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	//UserService userService = new UserServiceImpl();
		
		// 查找所有用户
	request.setCharacterEncoding("utf-8");
	String gra1=request.getParameter("grade");
	int gra=Integer.parseInt(gra1);
	System.out.println(gra);
	String useradd=request.getParameter("userarea");
	System.out.println(useradd);
	String jiaose1=request.getParameter("role");
	int jiaose=Integer.parseInt(jiaose1);
	System.out.println(jiaose);
	String js1=request.getParameter("js");
	int js=Integer.parseInt(js1);
	System.out.println(js);
	HttpSession session = request.getSession();
	session.setAttribute("useradd", useradd);
	session.setAttribute("jiaose", jiaose);
	session.setAttribute("juese", js);
	if(gra==19){
	
		
		request.getRequestDispatcher("sort1.jsp").forward(request, response);
	}
	else if(gra==20){
	
	
//	session.setAttribute("users", users);
//	session.setAttribute("userarea", userArea);
		request.getRequestDispatcher("sort.jsp").forward(request, response);}
	
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}

	@Override
	public void init() throws ServletException {
		// Put your code here
	}

}
