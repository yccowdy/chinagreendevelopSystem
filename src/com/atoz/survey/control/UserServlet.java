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

public class UserServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UserServlet() {
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
		User user = null;
		UserService userService = new UserServiceImpl();
		// 查找所有用户
		String action = request.getParameter("action");
		if (action != null) {
			if (action.equals("modifyinfor")) {// 查找用户，返回查找表单页面
				HttpSession session = request.getSession();
				session.setAttribute("modifyinfor", "modifyinfor");
				
				response.sendRedirect("userfame.jsp");
				
			}
			else if (action.equals("modifyUser1")) {// 修改密码
				//List<User> users1 = userService.findotherUsers();
				HttpSession session = request.getSession();
				//session.setAttribute("users1", users1);
				session.setAttribute("modifyUser1", "modifyUser1");
				response.sendRedirect("userfame.jsp");
			}
			else if (action.equals("findcomment")) {// 修改密码
				//List<User> users1 = userService.findotherUsers();
				HttpSession session = request.getSession();
				//session.setAttribute("users1", users1);
				session.setAttribute("findcomment", "findcomment");
				response.sendRedirect("userfame.jsp");
			}
		}
		String modifyPassword = request.getParameter("modifyPassword");
		String modifyUserName = request.getParameter("modifyUserName");
		String modifyUserEmail = request.getParameter("modifyEmail");
		///String modifyUserSex = request.getParameter("modifyUserSex");
	
		
		if (modifyUserName != null ) {
			user = userService.findUserByUserName(modifyUserName);
			///user.setUserPassword(modifyUserPassword);
			user.setUserMail(modifyUserEmail);
			user.setUserPassword(modifyPassword);
			System.out.println(modifyUserEmail);
			///user.setUserSex(modifyUserSex);
			int result = userService.modifyadminUsers(user);
			if (result == 0) {
				HttpSession session = request.getSession();
				session.setAttribute("tips", "SUCCESS");
				response.sendRedirect("userfame.jsp");
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("tips", "ERROR");
				response.sendRedirect("userfame.jsp");
			}}
	}

	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}

	@Override
	public void init() throws ServletException {
		// Put your code here
	}

}
