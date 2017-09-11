package com.atoz.survey.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atoz.survey.po.Login;
import com.atoz.survey.po.Paper;
import com.atoz.survey.po.User;
import com.atoz.survey.service.LoginService;
import com.atoz.survey.service.PaperService;
import com.atoz.survey.service.UserService;
import com.atoz.survey.service.impl.LoginServiceImpl;
import com.atoz.survey.service.impl.PaperServiceImpl;
import com.atoz.survey.service.impl.UserServiceImpl;

public class LoginServlet extends HttpServlet {

	
	public LoginServlet() {
		super();
	}

	
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("inputUserName").trim();
		String userPassword = request.getParameter("inputPassword").trim();
		String userRole = request.getParameter("u_type").trim();
	 ///  int role=Integer.parseInt(userRole);
		System.out.println(userRole);
		String rtnMsg = "ERROR";
		Login login = null;
		User user = null;
		LoginServiceImpl loginService = new LoginServiceImpl();
		UserServiceImpl userService = new UserServiceImpl();
		PaperServiceImpl paperService = new PaperServiceImpl();

		if (userName != null && userPassword != null
				&& userRole.equals("admin")) {
			// 登录成功，带着登录信息跳转到个人中心：home.jsp
			login = loginService.loginInfo(userName, userPassword);//11.29 role,role
		} else if (userName != null && userPassword != null
				&& userRole.equals("user")) {
			login = loginService.loginInfo(userName, userPassword);
		} else if (userName != null && userPassword != null
				&& userRole.equals("company")) {
			login = loginService.loginInfo(userName, userPassword);
		}else if (userName != null && userPassword != null//12.4
				&& userRole.equals("tree")) {
			login = loginService.loginInfo(userName, userPassword);
		}//12.4
		if (login == null || login.isLogin() == false) {
			login = new Login();
			login.setUserName(userName);
			login.setUserPassword(userPassword);
			login.setAdmin(false);
			login.setLogin(false);
			HttpSession session = request.getSession();
			session.setAttribute("rtnMsg", rtnMsg);
			response.sendRedirect("login.jsp");
		} else {
			user = new User();
			user = userService.findUserByUserName(userName);
			System.out.println("3");
			List<Paper> papers = paperService.findAllPapers();//findPaperByUserId(user.getUserId())
			HttpSession session = request.getSession();
			session.setAttribute("loginInfo", login);
			session.setAttribute("papers", papers);
			session.setAttribute("users", user);
			session.setAttribute("role", user.getUserRole());// 11.29s
			session.setAttribute("userid", user.getUserId());
			 session.setAttribute("userhaoma",-1);
			if(userRole.equals("admin") && user.getUserRole() == 0) {
				//session.setAttribute("userid", user.getUserId());
					System.out.println("user.getUserId()=="+user.getUserId());
				response.sendRedirect("home.jsp");
			}else if (userRole.equals("company") && (user.getUserRole() == 10|| user.getUserRole() == 11||user.getUserRole() == 12)) {
				if(user.getUserRole() == 10){
					//session.setAttribute("userid1", user.getUserId());
					String address=user.getUserProv()+".";
					session.setAttribute("foundarea", address);
					session.setAttribute("roleuser", user.getUserRole());
				    session.setAttribute("userarea", user.getUserProv());
				    System.out.println(user.getUserProv());
				    List<User> users = userService.findUserByProv(user.getUserProv());
				    session.setAttribute("users",users );
				    session.setAttribute("userCompany", user.getUserSummary());
				    response.sendRedirect("company.jsp");
				    }
			if(user.getUserRole() == 11){
				//session.setAttribute("userid", user.getUserId());
					String address=user.getUserProv()+user.getUserCity();
					session.setAttribute("roleuser", user.getUserRole());
					session.setAttribute("userarea", user.getUserCity());
					session.setAttribute("foundarea", address);
					List<User> users = userService.findUserByCity(user.getUserCity());
				    session.setAttribute("users",users );
				    session.setAttribute("userCompany", user.getUserSummary());
					response.sendRedirect("company.jsp");}
			if(user.getUserRole() == 12){
				//session.setAttribute("userid", user.getUserId());
				session.setAttribute("roleuser", user.getUserRole());
					String address=user.getUserProv()+user.getUserCity()+user.getUserArea();
					session.setAttribute("userarea", user.getUserArea());
					session.setAttribute("foundarea", address);
					 session.setAttribute("userCompany", user.getUserSummary());
					List<User> users = userService.findUserByArea(user.getUserArea());
				    session.setAttribute("users",users );
					response.sendRedirect("company.jsp");	
			}}else if (userRole.equals("tree") && user.getUserRole() == -1) {//12.4
				session.setAttribute("userhaoma",-1);
				List<User> users = userService.findAllUsers();
				session.setAttribute("users", users);
				 session.setAttribute("userCompany", user.getUserSummary());
				response.sendRedirect("tree.jsp");
			}else if (userRole.equals("user") && user.getUserRole() != 0&& user.getUserRole() != 10&& user.getUserRole() != 11&& user.getUserRole() != 12&& user.getUserRole() != -1) {
				//session.setAttribute("userid", user.getUserId());
				session.setAttribute("userSummary", user.getUserSummary());
				session.setAttribute("userid", user.getUserId());
				session.setAttribute("Area", user.getUserProv());
				System.out.println("nihao"+user.getUserProv());
				 session.setAttribute("userCompany", user.getUserName());
				 session.setAttribute("userhaoma",234);
				response.sendRedirect("user.jsp");
			}//12.4
			else{
				session.setAttribute("rtnMsg", rtnMsg);
				response.sendRedirect("login.jsp");
			}
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
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	@Override
	public void init() throws ServletException {
		
	}

}
