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

public class TreeServlet extends HttpServlet {

	public TreeServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	//UserService userService = new UserServiceImpl();
		
		// 查找所有用户
		
	String choosetype1=request.getParameter("choosetype1");
	int chooseRole1=Integer.parseInt(choosetype1);
	UserServiceImpl userService = new UserServiceImpl();
	// 查找所有用户
	System.out.println("较色为："+chooseRole1);
	if(chooseRole1==6){
		List<User> users = userService.findAllUsers();
		HttpSession session = request.getSession();
		session.setAttribute("users", users);
		response.sendRedirect("tree.jsp");}
	else {
		List<User> users = userService.findUserByChooseType(chooseRole1);
			HttpSession session = request.getSession();
			session.setAttribute("users", users);
			response.sendRedirect("tree.jsp");}
		}

	

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
