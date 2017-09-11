package com.atoz.survey.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atoz.survey.dao.PaperDao;
import com.atoz.survey.dao.QuestionDao;
import com.atoz.survey.dao.mysqlimpl.PaperDaoImpl;
import com.atoz.survey.dao.mysqlimpl.QuestionDaoImpl;
import com.atoz.survey.po.Paper;
import com.atoz.survey.po.User;

public class DeletePage extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DeletePage() {
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
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String paperTypeString=request.getParameter("papertype");
		//String paperIdString = request.getParameter("paperId");
		//session.setAttribute("papertype", new Integer(paperType));
		String qstjidu0=request.getParameter("qstjidu");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("users");
		if(paperTypeString != null && user != null&&qstjidu0 !=null){
			int paperType = Integer.parseInt(paperTypeString);
			//int paperId = Integer.parseInt(paperIdString);12.1
			int userId = user.getUserId();
			int qstjidu = Integer.parseInt(qstjidu0);
			System.out.println(qstjidu);
			PaperDaoImpl paperDao = new PaperDaoImpl();
			int paperNum = paperDao.deletePaperByPaperType(paperType,qstjidu);
			
			QuestionDaoImpl questionDao = new QuestionDaoImpl(); 
			int questionNum = questionDao.deleteQusetionByPaperType(paperType,qstjidu);
			PaperDaoImpl paperDaoImpl = new PaperDaoImpl();
			List<Paper> papers = paperDaoImpl.findAllPapers();//findPaperByUserId(userId)
			session.setAttribute("papers", papers);
			if(user.getUserRole()==0){
				response.sendRedirect("home.jsp");
			}else{
				response.sendRedirect("user.jsp");
			}
			
		}
		
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	@Override
	public void init() throws ServletException {
		// Put your code here
	}

}
