package com.atoz.survey.control;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.atoz.survey.dao.PaperDao;
import com.atoz.survey.dao.mysqlimpl.FirstDaoImpl;
import com.atoz.survey.dao.mysqlimpl.PaperDaoImpl;
import com.atoz.survey.dao.mysqlimpl.QuestionDaoImpl;
import com.atoz.survey.po.First;
import com.atoz.survey.po.Paper;
import com.atoz.survey.po.Question;
import com.atoz.survey.po.User;
//import com.sun.org.apache.bcel.internal.generic.NEW;

public class Bytypeandyiji extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Bytypeandyiji() {
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

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Paper paper = new Paper();
		
		PaperDaoImpl paperDao = new PaperDaoImpl();
	
		QuestionDaoImpl questionDao = new QuestionDaoImpl();
		HttpSession session = request.getSession();
		String paperTitle0 = request.getParameter("yiji");
		int paperTitle1=Integer.parseInt(paperTitle0);
		
		System.out.println(paperTitle1);
		String paperTypeString = request.getParameter("papertype");
	    int paperType = Integer.parseInt(paperTypeString);
		//paper.setPaperType(paperType);
		System.out.println(paperType);
		String paperNow0 = request.getParameter("paperNow");
		int paperNow=Integer.parseInt(paperNow0);
		System.out.println(paperNow);
		String paperJidu0 = request.getParameter("paperJidu");
		int paperJidu = Integer.parseInt(paperJidu0);
//String paperfabu0 = request.getParameter("paperfabu");
//	int paperfabu = Integer.parseInt(paperfabu0);
//System.out.println("paperfabu=="+paperfabu);
		if(paperTitle1==79){
		int paperfabu=paperTitle1;
			List<Question> questions = questionDao.findQuestionsByqstandjidu(paperType,paperJidu);
			System.out.println(questions);
			System.out.println("paperfabu=="+paperfabu);
			 request.setAttribute("papertype", paperType);
			    request.setAttribute("paperJidu",paperJidu);
				//session.setAttribute("papertype", new Integer(paperType));//11.30
		request.setAttribute("paperNow",paperNow);
			    session.setAttribute("questions", questions);
			    request.setAttribute("paperfabu", paperfabu);
			   // request.setAttribute("paperTitle", paperTitle);
			//session.setAttribute("paperSummary", paperSummary);
		//	    response.sendRedirect("glysurveypage.jsp");
		request.getRequestDispatcher("glysurveypage.jsp").forward(request, response); 
				
			
		}
		else if(paperTitle1==86){
			int paperfabu=paperTitle1;
			int paperCount=1;//发布
			List<Question> questions = questionDao.findQuestionsByqstandjiduandfabu(paperType,paperJidu,paperCount);
			System.out.println(questions);
			System.out.println("paperfabu=="+paperfabu);
			
			 request.setAttribute("papertype", paperType);
			    request.setAttribute("paperJidu",paperJidu);
				//session.setAttribute("papertype", new Integer(paperType));//11.30
		request.setAttribute("paperNow",paperNow);
			    session.setAttribute("questions", questions);
			    request.setAttribute("paperfabu", paperfabu);
			//    response.sendRedirect("glysurveypage.jsp");
		request.getRequestDispatcher("glysurveypage.jsp").forward(request, response); 
				
			
		}
else if(paperTitle1==87){
	int paperfabu=paperTitle1;	
			int paperCount=0;//未发布
			List<Question> questions = questionDao.findQuestionsByqstandjiduandfabu(paperType,paperJidu,paperCount);
			System.out.println(questions);
			if(questions.size()==0){
				//JOptionPane.showMessageDialog(null, "当前没有未发布的题目");
				response.sendRedirect("glysurveypage.jsp?papertype="+paperType+"&paperfabu="+79+"&paperJidu="+4+"&paperNow="+30+"");
				return;
			}
			System.out.println("paperfabu=="+	paperfabu);
			 request.setAttribute("papertype", paperType);
			    request.setAttribute("paperJidu",paperJidu);
				//session.setAttribute("papertype", new Integer(paperType));//11.30
		request.setAttribute("paperNow",paperNow);
			    session.setAttribute("questions", questions);
			    
			    request.setAttribute("paperfabu", paperfabu);
			
			    request.getRequestDispatcher("glysurveypage.jsp").forward(request, response);
		}
		else {
			int paperCount=1;
		List<Question> questions = new ArrayList<Question>();
		int paperfabu=paperTitle1;
	String paperTitle="";
	
	
	if(paperTitle1==80){
		paperTitle="绿色文化";
	}
	if(paperTitle1==81){
		paperTitle="组织体系";
	}
	if(paperTitle1==82){
		paperTitle="战略规划";
	}
	if(paperTitle1==83){
		paperTitle="管理制度";
	}
	if(paperTitle1==84){
		paperTitle="技术措施";
	}
	if(paperTitle1==85){
		paperTitle="环保绩效";
	}
			List<Paper> papers = paperDao.findPaperIdBySummaryandTitleandfabuandyiji(paperTitle, paperType,paperCount);
		System.out.println(papers);
		System.out.println("papers.size()=="+papers.size());
	
			for(Paper pap:papers)
			{
			
				  List<Question> questions1 = questionDao .findQuestionsByPaperId(pap.getPaperId());
				 
				  questions.addAll(questions1);}  
		System.out.println(questions);
		
	System.out.println("paperfabu=="+paperfabu);
		 request.setAttribute("papertype", paperType);
		    request.setAttribute("paperJidu",4);
		
	        request.setAttribute("paperNow",paperNow);
		    session.setAttribute("questions", questions);
		    request.setAttribute("paperTitle", paperTitle);
		    request.setAttribute("paperfabu", paperfabu);
		  //  response.sendRedirect("glysurveypage.jsp");
		  request.getRequestDispatcher("glysurveypage.jsp").forward(request, response); 
			}
		}


	public void init() throws ServletException {
		// Put your code here
	}

}
