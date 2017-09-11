package com.atoz.survey.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atoz.survey.dao.PaperDao;
import com.atoz.survey.dao.mysqlimpl.PaperDaoImpl;
import com.atoz.survey.dao.mysqlimpl.QuestionDaoImpl;
import com.atoz.survey.po.Paper;
import com.atoz.survey.po.Question;
import com.atoz.survey.po.User;

public class PubPaper extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public PubPaper() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
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
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @param qstCount 
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		PaperDao paperDao = new PaperDaoImpl();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("users");
		
		QuestionDaoImpl questionDao = new QuestionDaoImpl();
		String paperId0=session.getAttribute("paperId").toString();
		int paperId=Integer.parseInt(paperId0);
		System.out.println("paperId=="+paperId);
		String biaodan=request.getParameter("fabu").trim();
		System.out.println("biaodan=="+biaodan);
		if(biaodan.equals("保存")){
			int paperCount=0;
		int result=questionDao.updatefabuBypaperId(paperId, paperCount);
		int result1=paperDao.updatefabuByPaperId(paperId, paperCount);
		System.out.println("result1=="+result1);
		System.out.println("result=="+result);}
		if(biaodan.equals("发布")){
			int paperCount=1;
			int result=questionDao.updatefabuBypaperId(paperId, paperCount);
			int result1=paperDao.updatefabuByPaperId(paperId, paperCount);
			System.out.println("result1=="+result1);
			System.out.println("result=="+result);}
	
		if(user != null)
		{
			int userId = user.getUserId();	
			List<Paper> papers = paperDao.findPaperByUserId(userId);			
			System.out.println(papers);
			session.setAttribute("papers", papers);
			response.sendRedirect("home.jsp");
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
