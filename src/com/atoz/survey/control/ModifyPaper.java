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
import com.atoz.survey.service.PaperService;

public class ModifyPaper extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ModifyPaper() {
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
			//Question question=new Question();
		//First first =new First();
		PaperDaoImpl paperDao = new PaperDaoImpl();
		//FirstDaoImpl firstDao=new FirstDaoImpl();
		QuestionDaoImpl questionDao = new QuestionDaoImpl();
		HttpSession session = request.getSession();
		
//		User user = (User) session.getAttribute("users");
//
//		int userId = user.getUserId();
//		System.out.println(userId);
//		paper.setUserId(userId);
		//设置一级指标
		String paperTitle0 = request.getParameter("paperTitle");
		String paperTitle = new String(paperTitle0.getBytes("ISO-8859-1"),"utf-8");
		System.out.println(paperTitle);
		paper.setPaperTitle(paperTitle);
		//first.setPaperTitle(paperTitle);
		//设置所属行业
		String paperTypeString = request.getParameter("paperType");
	    int paperType = Integer.parseInt(paperTypeString);
		paper.setPaperType(paperType);
		System.out.println(paperType);
		//first.setPaperType(paperType);
		//设置二级指标
		String paperSummary0 = request.getParameter("paperSummary");
		String paperSummary = new String(paperSummary0.getBytes("ISO-8859-1"),"utf-8");
		paper.setPaperSummary(paperSummary);
		//设置权重paperJidu
		System.out.println(paperSummary);
		String paperJidu0 = request.getParameter("paperJidu");
		int paperJidu = Integer.parseInt(paperJidu0);
		//paper.setPaperJidu(paperJidu);
		//question.setQstJidu(paperJidu);
		String paperBg = request.getParameter("paperWeight");
	   System.out.println(paperJidu);
		//int weight=Integer.parseInt(paperBg);
		//first.setWeight(weight);
		//发布日期
		System.out.println(paperBg);
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String paperStartDate = simpleDateFormat.format(date);
		paper.setPaperStartDate(paperStartDate);
		
		//截止日期的设置
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE,+30);
		date = calendar.getTime();
		String dataString = simpleDateFormat.format(date);
		paper.setPaperEndDate(dataString);
		
		int paperStatus = 0;//未发布
		paper.setPaperStatus(paperStatus);
		int paperCount=0;
		//回答次数 
	
		paper.setPaperCount(paperCount);
		List<Question> questions = new ArrayList<Question>();
		List<String> QSTTLTLE = new ArrayList<String>();
		if(paperTitle.equals("请选择一级标题")||paperSummary.equals("请选择二级标题")){
		//	JOptionPane.showMessageDialog(null, "请选择一二级指标");
			response.sendRedirect("modifypaper.jsp?t="+paperType+"");
		}else{
//			if(paperJidu==1){
//			paper.setPaperBgsp(paperBg);
//			paperDao.addPapersSp(paper);}
//			if(paperJidu==2){
//				paper.setPaperBgsm(paperBg);
//				paperDao.addPapersSm(paper);}
//			if(paperJidu==3){
//				paper.setPaperBga(paperBg);
//				paperDao.addPapersAu(paper);}
//			if(paperJidu==4){
//				paper.setPaperBgw(paperBg);
//				//paperDao.addPapersWi(paper);
//				}
		//questionDao.updateQuestionsjidu(questionId, qstJidu);
		//firstDao.addfirsts(first);  List<Paper> findPaperIdBySummaryandTitle(String paperTitle,String paperSummary)
			List<Paper> papers = paperDao.findPaperIdBySummaryandTitleandfabu(paperTitle, paperSummary,paperCount);
		System.out.println(papers);
  System.out.println();
		System.out.println("papersize=="+papers.size());
		
		//int paperNum[]=new int[papers.size()];
	//	for(int i=0;i<papers.size();i++){
		
			for(Paper pap:papers)
			{
			
				  List<Question> questions1 = questionDao .findQuestionsByPaperIdandfabu(pap.getPaperId(),paperCount);
				 
				  questions.addAll(questions1);}  
		System.out.println(questions);
		if(questions.isEmpty()){
		//	JOptionPane.showMessageDialog(null, "当前标题下没有未发布的题目");
			response.sendRedirect("modifypaper.jsp?t="+paperType+"");
		}else{
		for(Question wenti: questions){
			QSTTLTLE.add(wenti.getQstTitle());
		}
		
		String content="";
		String QstTitle="";
		String QstAnswer="";
		int QstId=0;
		
			content=questions.get(0).getQstOption();
			QstTitle=questions.get(0).getQstTitle();
			QstAnswer=questions.get(0).getQstAnswer();
			QstId=questions.get(0).getQstId();
		
		System.out.println("QSTTLTLE=="+ QSTTLTLE.get(0));
		session.setAttribute("QSTTLTLE", QSTTLTLE.get(0));
		System.out.println("content=="+ content);
		session.setAttribute("content", content);
		session.setAttribute("QstTitle", QstTitle);
		session.setAttribute("QstAnswer", QstAnswer);
		session.setAttribute("QstId", QstId);
       // List<Question> questions = questionDao.findQuestionsByPaperId(paperId);
		///System.out.println(questions);
		//int papertype = paperDao.findPaperIdBypapertype(paperType);//11.30
	    session.setAttribute("papertype", paperType);
		session.setAttribute("paperJidu", paperJidu);
		session.setAttribute("papertype", new Integer(paperType));//11.30
		//session.setAttribute("paperId", new Integer(paperId));
		session.setAttribute("questions", questions);
		session.setAttribute("paperTitle", paperTitle);
		session.setAttribute("paperSummary", paperSummary);
		response.sendRedirect("modifytitle.jsp");
			}
	}
		}

	public void init() throws ServletException {
		// Put your code here
	}

}
