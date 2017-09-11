package com.atoz.survey.control;


import java.io.*;
import java.util.*;
import java.text.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.apache.catalina.filters.SetCharacterEncodingFilter;

import com.a.model.UserBean;
import com.a.model.UserBeanCl;
import com.atoz.survey.dao.mysqlimpl.UserDaoImpl;
import com.atoz.survey.po.Login;
import com.atoz.survey.po.User;
import com.atoz.survey.service.LoginService;
import com.atoz.survey.service.UserService;
import com.atoz.survey.service.impl.LoginServiceImpl;
import com.atoz.survey.service.impl.UserServiceImpl;

public class RegServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public RegServlet() {
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
		
		request.setCharacterEncoding("UTF-8");
		String from= request.getParameter("from");
		UserDaoImpl userDao= new UserDaoImpl();
		List<User> userAll=userDao.findotherUsers();
		String UserRole=request.getParameter("inputUserRole");
		String userName = request.getParameter("inputUserName").trim();
		String city = request.getParameter("city").trim();
		String province = request.getParameter("province").trim();
		String town = request.getParameter("town").trim();
		String Area = request.getParameter("inputUserArea").trim();;		
		String userPassword = request.getParameter("inputPassword").trim();;
        String userSummary=request.getParameter("inputUserSummary").trim();;
		String userEmail = request.getParameter("inputEmail").trim();;
		String daihao1 = request.getParameter("Daihao");
		int daihao=Integer.parseInt(daihao1);
		int userRole=Integer.parseInt(UserRole);
//		Date now = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance();
//		String datetime = dateFormat.format(now);
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String paperStartDate = simpleDateFormat.format(date);
		UserServiceImpl userService = new UserServiceImpl();
		User user = new User();
		if(city.equals("请选择市")||province.equals("请选择省")||town.equals("请选择区县")){
		//	JOptionPane.showMessageDialog(null, "地区没有选择");
			if(daihao==0){
			response.sendRedirect("iframe.jsp");}
			else response.sendRedirect("reg.jsp");
			return;
		}
		for(int i=0;i<userAll.size();i++){
			if(userAll.get(i).getUserName().equals(userName)){
				if(daihao==0){
					response.sendRedirect("iframe.jsp");}
					else response.sendRedirect("reg.jsp");
				return;
			}
		}
		if(userName.equals("")||userName==null||Area.equals("")||Area==null||userPassword.equals("")||userPassword==null||
				userSummary.equals("")||userSummary==null||userEmail.equals("")||userEmail==null){
			if(daihao==0){
				response.sendRedirect("iframe.jsp");}
				else response.sendRedirect("reg.jsp");
			return;
		}
		
		
//			if(userRole==12){
//			
//			user.setUserName(userName);
//			user.setUserPassword(userPassword);
//			user.setUserMail(userEmail);
//			user.setUserSummary(userSummary);
//			user.setUserReg(datetime);
//			user.setUserArea(town);
//			user.setUserCity(city);
//			user.setUserProv(province);
//			user.setUserAdd(Area);
//			user.setUserIcon("0");
//			user.setUserSw(0);
//			user.setUserWin(0);
//			user.setUserRole(userRole);
//			
//			}
//			else if(userRole==11){
//				user.setUserName(userName);
//				user.setUserPassword(userPassword);
//				user.setUserMail(userEmail);
//				user.setUserSummary(userSummary);
//				user.setUserReg(datetime);
//				user.setUserArea(town);
//				user.setUserCity(city);
//				user.setUserProv(province);
//			    user.setUserIcon("0");
//			    user.setUserSw(0);
//				user.setUserWin(0);
//				user.setUserSex("无");
//				user.setUserAdd(Area);
//				user.setUserRole(userRole);
//				}
//			else if(userRole==10){
//				
//				user.setUserName(userName);
//				user.setUserPassword(userPassword);
//				user.setUserMail(userEmail);
//				user.setUserSummary(userSummary);
//				user.setUserReg(datetime);
//				user.setUserArea(town);
//				user.setUserCity(city);
//				user.setUserProv(province);
//			    user.setUserIcon("0");
//			    user.setUserSw(0);
//				user.setUserWin(0);
//				user.setUserSex("无");
//				user.setUserAdd(Area);
//				user.setUserRole(userRole);
//			
//				
//				}
//			else {
//				
//				user.setUserName(userName);
//				user.setUserPassword(userPassword);
//				user.setUserMail(userEmail);
//				user.setUserSummary(userSummary);
//				user.setUserReg(datetime);
//				user.setUserArea(town);
//				user.setUserCity(city);
//				user.setUserProv(province);
//			    user.setUserIcon("0");
//			    user.setUserSw(0);
//				user.setUserWin(0);
//				user.setUserSex("请添加公告");
//				user.setUserAdd(Area);
//				user.setUserRole(userRole);
//				
//				}
			UserBean userub=new UserBean(userName,userPassword,userEmail,paperStartDate,"无",userRole,userSummary,town,province,city,Area,0,0);
			int result=new UserBeanCl().addQiye(userub);
			System.out.println("添加结果=="+result);
			HttpSession session = request.getSession();
		if(daihao==0){
	    if (from != null && from.equals("fromAdmin")&&result==1) {
			session.setAttribute("tips", "SUCCESS");
		response.sendRedirect("login.jsp");
		}
		else {
			Login login = null;
			LoginService loginService = new LoginServiceImpl();
			//登录成功，带着登录信息跳转到个人中心：home.jsp
		session.setAttribute("tips", "ERROR");
			login = loginService.loginInfo(userName, userPassword);			
			session.setAttribute("loginInfo", login);
			response.sendRedirect("login.jsp");
		}		
	 }
		else {
			if(result==1){
				response.sendRedirect("login.jsp");	
			}
			else response.sendRedirect("reg.jsp");
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
