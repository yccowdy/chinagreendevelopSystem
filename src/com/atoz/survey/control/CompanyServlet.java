package com.atoz.survey.control;

import java.io.IOException;
import java.util.*;
import java.text.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.apache.catalina.filters.SetCharacterEncodingFilter;

import com.atoz.survey.po.Login;
import com.atoz.survey.po.User;
import com.atoz.survey.service.LoginService;
import com.atoz.survey.service.UserService;
import com.atoz.survey.service.impl.LoginServiceImpl;
import com.atoz.survey.service.impl.UserServiceImpl;

public class CompanyServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CompanyServlet() {
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
		
		String UserSummary=request.getParameter("inputUserSummary");
		String UserZc = request.getParameter("inputUserZc");
		String UserPerson = request.getParameter("inputUserPerson");
		String Shangshi = request.getParameter("inputShangshi");
		String Type = request.getParameter("inputType");
		String Intro = request.getParameter("inputIntro");
		
        System.out.println(Intro);
		
        System.out.println(Type);
        
		UserServiceImpl userService = new UserServiceImpl();
	User user=null;
	
	if(UserZc.equals("")||UserZc==null||UserPerson.equals("")||UserPerson==null||Intro.equals("")||Intro==null){
		///JOptionPane.showMessageDialog(null, "填写区域不能为空");
		response.sendRedirect("userfame.jsp");
		return;
	}
	if(UserSummary!=null){
		user=userService.findUserByUserSummary(UserSummary);
		
		user.setUserZc(UserZc);
		user.setUserType(Type);
          user.setUserShangshi(Shangshi);      
			user.setUserPerson(UserPerson);
			user.setUserIntro(Intro);
		int result = userService.modifyComp(user);
		System.out.println(result);
		if (result == 0) {
			HttpSession session = request.getSession();
			session.setAttribute("tips", "SUCCESS");
			response.sendRedirect("userfame.jsp");
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("tips", "ERROR");
			response.sendRedirect("userfame.jsp");
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
