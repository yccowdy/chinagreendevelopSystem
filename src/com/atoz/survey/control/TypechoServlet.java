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

public class TypechoServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public TypechoServlet() {
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
	String choosetype=request.getParameter("choosetype");
	int chooseRole=Integer.parseInt(choosetype);
	String role7=request.getParameter("role7");
	System.out.println(role7);
	int role3=Integer.parseInt(role7);
	String userArea=request.getParameter("userarea");
	System.out.println(userArea);
	UserServiceImpl userService = new UserServiceImpl();

	System.out.println("较色为："+chooseRole);
//	if(chooseRole==6){
//		List<User> users = userService.findUserByChooseType(chooseRole);
//		HttpSession session = request.getSession();
//		session.setAttribute("role4", role3);
//		session.setAttribute("users", users);
//		session.setAttribute("userarea", userArea);
//		response.sendRedirect("company.jsp");}
//	else {
 if(role3==10){
	 if(chooseRole==6){
		 List<User> users = userService.findUserByProv(userArea.trim());
			HttpSession session = request.getSession();
			session.setAttribute("role4", role3);
			session.setAttribute("users", users);
			session.setAttribute("userarea", userArea);
		System.out.println(users);
			response.sendRedirect("company.jsp");}
	 else {
		List<User> users = userService.findUserByProvandRole(chooseRole,userArea);
			HttpSession session = request.getSession();
			session.setAttribute("users", users);
			session.setAttribute("role4", role3);
			System.out.println("fHHHH纷纷规划或");
			session.setAttribute("userarea", userArea);
			System.out.println(users);
			response.sendRedirect("company.jsp");}
	 
 }
	else if(role3==11){
		 if(chooseRole==6){
			 List<User> users = userService.findUserByCity(userArea.trim());
				HttpSession session = request.getSession();
				session.setAttribute("role4", role3);
				session.setAttribute("users", users);
				session.setAttribute("userarea", userArea);
				response.sendRedirect("company.jsp");}
		 else{
		List<User> users = userService.findUserByCityandRole(chooseRole,userArea);
			HttpSession session = request.getSession();
			session.setAttribute("users", users);
			session.setAttribute("role4", role3);
			session.setAttribute("userarea", userArea);
			response.sendRedirect("company.jsp");}}
	else if(role3==12){ 
		if(chooseRole==6){
		List<User> users = userService.findUserByArea(userArea);
		HttpSession session = request.getSession();
		session.setAttribute("role4", role3);
		session.setAttribute("users", users);
		session.setAttribute("userarea", userArea);
		response.sendRedirect("company.jsp");}
	else{
		List<User> users = userService.findUserByAreaandRole(chooseRole,userArea);
			HttpSession session = request.getSession();
			session.setAttribute("users", users);
			session.setAttribute("role4", role3);
			session.setAttribute("userarea", userArea);
			response.sendRedirect("company.jsp");}}
		}
	
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	@Override
	public void init() throws ServletException {
		// Put your code here
	}

}
