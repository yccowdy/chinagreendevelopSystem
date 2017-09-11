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

public class GlyServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public GlyServlet() {
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

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = null;
		UserService userService = new UserServiceImpl();
		// 查找所有用户
		String action = request.getParameter("action");
		if (action != null) {
			 if (action.equals("modifyUser1")) {// 修改密码
				//List<User> users1 = userService.findotherUsers();
				HttpSession session = request.getSession();
				//session.setAttribute("users1", users1);
				session.setAttribute("modifyUser1", "modifyUser1");
				response.sendRedirect("iframe.jsp");
			}
			
		}
		String Password1 = request.getParameter("inputPassword1");
		String modifydadminName = request.getParameter("modifydadminName");
		String Email = request.getParameter("inputEmail");
		///String modifyUserSex = request.getParameter("modifyUserSex");
	
		
		if (modifydadminName != null ) {
			user = userService.findUserByUserName(modifydadminName);
			///user.setUserPassword(modifyUserPassword);
			user.setUserMail(Email);
			user.setUserPassword(Password1);
			System.out.println(Email);
			///user.setUserSex(modifyUserSex);
			int result = userService.modifyadminUsers(user);
			if (result == 0) {
				HttpSession session = request.getSession();
				session.setAttribute("tips", "SUCCESS");
				response.sendRedirect("userfame.jsp");
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("tips", "ERROR");
				response.sendRedirect("iframe.jsp");
			}}
//		String UserRole=request.getParameter("inputUserRole");
//		String userName = request.getParameter("inputUserName");
//		String userPassword = request.getParameter("inputPassword");
//        String userSummary=request.getParameter("inputUserSummary");
//		String userEmail = request.getParameter("inputEmail");
//
//		Date now = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance();
//		String datetime = dateFormat.format(now);
//
//		UserServiceImpl userService = new UserServiceImpl();
//		if (userService.findUserByUserName(userName) == null) {
//			User user = new User();
//			user.setUserName(userName);
//			user.setUserPassword(userPassword);
//			user.setUserMail(userEmail);
//			user.setUserSummary(userSummary);
//			user.setUserReg(datetime);
//			//user.setUserIcon("0");
//			user.setUserRole(Integer.parseInt(UserRole));
//			userService.addUsers(user);
//			System.out.println("ghd哈哈哈哈哈哈");
//		}
//		if (from != null && from.equals("fromAdmin")) {
//			HttpSession session = request.getSession();
//			session.setAttribute("tips", "SUCCESS");
//			response.sendRedirect("iframe.jsp");
//		} else {
//			Login login = null;
//			LoginService loginService = new LoginServiceImpl();
//			//登录成功，带着登录信息跳转到个人中心：home.jsp
//			login = loginService.loginInfo(userName, userPassword);
//			HttpSession session = request.getSession();
//			session.setAttribute("loginInfo", login);
//			response.sendRedirect("home.jsp");
//		}
//		String modifyadminName = request.getParameter("modifydadminName");
//		String rtnMsg = "ERROR";
//		UserServiceImpl userService = new UserServiceImpl();
//		//UserDaoImpl userDao= new UserDaoImpl();
//		//User user1=userDao.findUserByUserName(modifyUserName.trim());
//		///String modifyUserPassword = request.getParameter("modifyPassword");
//		String modifyadminPassword = request.getParameter("inputadminPassword").trim();
//		String Password1 = request.getParameter("inputPassword1").trim();
//		String Password2 = request.getParameter("inputPassword2").trim();
//		String Email = request.getParameter("inputEmail").trim();
//		System.out.println(Password1);
//		if (userService.findUserByUserName(modifyadminName) != null) {
//			User user = new User();
//			//user.setUserName(modifyadminName);
//			user.setUserPassword(Password1);
//			user.setUserMail(Email);
//		
//			
//			userService.modifyadminUsers(user);
//			System.out.println("ghd哈哈哈哈哈哈");
//		}
//		if (from != null && from.equals("fromAdmin")) {
//			HttpSession session = request.getSession();
//			session.setAttribute("tips", "SUCCESS");
//			response.sendRedirect("iframe.jsp");
//		}
	}

	
	@Override
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
