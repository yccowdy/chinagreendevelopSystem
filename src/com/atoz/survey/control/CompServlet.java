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

public class CompServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CompServlet() {
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
			if (action.equals("addinfo")) {
				HttpSession session = request.getSession();
				session.setAttribute("addinfo", "addinfo");
				response.sendRedirect("modifame.jsp");
			} else if (action.equals("modifyself")) {// 添加用户账户
				HttpSession session = request.getSession();
				session.setAttribute("modifyself", "modifyself");
				response.sendRedirect("modifame.jsp");
			}
		
		}

	
		// 查找到用户后修改资料
		String modifygoverName = request.getParameter("modifygoverName");
		///String modifyUserPassword = request.getParameter("modifyPassword");
		String Password2 = request.getParameter("inputPassword2");
		String Email1 = request.getParameter("inputEmail1");
		//String goverSex = request.getParameter("modifygoverSex");
	
	   System.out.println(modifygoverName);
	   System.out.println(Email1);
	   System.out.println("NIHAOMA1");
		
		if (modifygoverName != null ) {
			user = userService.findUserByUserName(modifygoverName);
			
			
			user.setUserMail(Email1);
			user.setUserPassword(Password2);
			
			int result = userService.modifygover(user);
			if(result == 0) {
				HttpSession session = request.getSession();
				session.setAttribute("tips", "SUCCESS");
				response.sendRedirect("modifame.jsp");
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("tips", "ERROR");
				response.sendRedirect("modifame.jsp");
			}
//			
	          }
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
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
