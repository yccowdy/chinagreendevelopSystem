package com.atoz.survey.control;

import java.io.IOException;
import java.util.List;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atoz.survey.dao.mysqlimpl.UserDaoImpl;
import com.atoz.survey.po.User;
import com.atoz.survey.service.UserService;
import com.atoz.survey.service.impl.UserServiceImpl;

public class QuestionServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public QuestionServlet() {
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
		
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		
		if (action != null) {
			if (action.equals("findjidu1")) {
				///List<User> users = userService.findAllUsers();
				HttpSession session = request.getSession();
				String papertype = request.getParameter("papertype");
				String userid = request.getParameter("userid");
				session.setAttribute("findjidu1", "findjidu1");
				session.setAttribute("papertype", papertype);
				session.setAttribute("userid", userid);
				session.setAttribute("paperjidu", 1);
				System.out.println("papertype===="+papertype);
				response.sendRedirect("question.jsp");
			} else if (action.equals("findjidu2")) {// 查找用户，返回查找表单页面
				HttpSession session = request.getSession();
				session.setAttribute("findjidu2", "findjidu2");
				String papertype = request.getParameter("papertype");
				String userid = request.getParameter("userid");
				session.setAttribute("papertype", papertype);
				session.setAttribute("userid", userid);
				session.setAttribute("paperjidu", 2);
				response.sendRedirect("question.jsp");
			} else if (action.equals("findjidu3")) {// 查找用户，返回查找表单页面
				HttpSession session = request.getSession();
				session.setAttribute("findjidu3", "findjidu3");
				String papertype = request.getParameter("papertype");
				String userid = request.getParameter("userid");
				session.setAttribute("papertype", papertype);
				session.setAttribute("userid", userid);
				session.setAttribute("paperjidu", 3);
				response.sendRedirect("question.jsp");
			}else if (action.equals("findjidu4")) {// 添加用户账户
				HttpSession session = request.getSession();
				session.setAttribute("findjidu4", "findjidu4");
				String papertype = request.getParameter("papertype");
				String userid = request.getParameter("userid");
				session.setAttribute("papertype", papertype);
				session.setAttribute("userid", userid);
				session.setAttribute("paperjidu", 4);
				response.sendRedirect("question.jsp");
			}
		
		}

		// 根据用名称查找用户信息
		String userSummary = request.getParameter("findUserByUserSummary");
		/*String userSummary12=userSummary11;
				String userSummary=new String(userSummary12.getBytes("ISO-8859-1"),"utf-8"); //转码UTF8*/
		System.out.println("你麻痹");
		System.out.println(userSummary);
		if (userSummary != null) {
			
			user = userService.findUserByUserSummary(userSummary.trim());
			
			if (user != null) {
				HttpSession session = request.getSession();
				session.setAttribute("findUserResult", user);
				response.sendRedirect("iframe.jsp");
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("tips", "ERROR");
				response.sendRedirect("iframe.jsp");
			}
		}
		// 根据用户名查找用户信息
		String userName = request.getParameter("findUserByUserName");
		if (userName != null) {
			user = userService.findUserByUserName(userName.trim());
			if (user != null) {
				HttpSession session = request.getSession();
				session.setAttribute("findUserResult", user);
				response.sendRedirect("iframe.jsp");
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("tips", "ERROR");
				response.sendRedirect("iframe.jsp");
			}

		}
		
		
		String deleteIdString = request.getParameter("deleteId");
		if (deleteIdString != null) {
			int deleteId = Integer.parseInt(deleteIdString);
			int result = userService.deleteUsers(deleteId);
			if (result == 0) {
				HttpSession session = request.getSession();
				session.setAttribute("tips", "SUCCESS");
				response.sendRedirect("iframe.jsp");
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("tips", "ERROR");
				response.sendRedirect("iframe.jsp");
			}
		}
		// 查找到用户后修改资料
		String modifyUserName = request.getParameter("modifyUserName");
		///String modifyUserPassword = request.getParameter("modifyPassword");
		String modifyUserEmail = request.getParameter("modifyEmail");
		String modifyUserSex = request.getParameter("modifyUserSex");
	
		
		if (modifyUserName != null ) {
			user = userService.findUserByUserName(modifyUserName);
		//user.setUserPassword(modifyUserPassword);
			
			user.setUserMail(modifyUserEmail);
			user.setUserSex(modifyUserSex);
			int result = userService.modifyUsers(user);
			if (result == 0) {
				HttpSession session = request.getSession();
				session.setAttribute("tips", "SUCCESS");
				response.sendRedirect("iframe.jsp");
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("tips", "ERROR");
				response.sendRedirect("iframe.jsp");
			}

	          }
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
