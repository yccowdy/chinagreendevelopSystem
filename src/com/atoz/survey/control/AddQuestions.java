package com.atoz.survey.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.atoz.survey.dao.QuestionDao;
import com.atoz.survey.dao.mysqlimpl.QuestionDaoImpl;
import com.atoz.survey.po.Question;

public class AddQuestions extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddQuestions() {
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

		// &#%& 题与题的分割号 $#$问题间的分割号
		// 不用字符串相连，改用list存储，然后写入数据库
		Question question = new Question();
		QuestionDaoImpl questionDao = new QuestionDaoImpl();
		
		HttpSession session = request.getSession();
		Integer paperIdString = (Integer) session.getAttribute("paperId");
		if (paperIdString != null) {
			int paperId = paperIdString.intValue();
			question.setPaperId(paperId);
		} else {
			System.out.println("空");
		}

		
		String qstTitle0 = request.getParameter("qstTitle");
		String qstTitle = new String(qstTitle0.getBytes("ISO-8859-1"), "utf-8");
		question.setQstTitle(qstTitle);

		String qstTypeString = request.getParameter("qstType"); // 问题类型
		int qstType = Integer.parseInt(qstTypeString);
		question.setQstType(qstType);
		String paperJidu0 = request.getParameter("paperJidu"); // 问题季度
		int qstJidu = Integer.parseInt(paperJidu0);
		question.setQstJidu(qstJidu);

		
		String qstNum10 = request.getParameter("qstOption1");
		String qstNum1 = new String(qstNum10.getBytes("ISO-8859-1"), "utf-8");

		String qstNum20 = request.getParameter("qstOption2");
		String qstNum2 = new String(qstNum20.getBytes("ISO-8859-1"), "utf-8");

		String qstNum30 = request.getParameter("qstOption3");
		String qstNum3 = new String(qstNum30.getBytes("ISO-8859-1"), "utf-8");

		String qstNum40 = request.getParameter("qstOption4");
		String qstNum4 = new String(qstNum40.getBytes("ISO-8859-1"), "utf-8");

		String qstNum50 = request.getParameter("qstOption5");
		String qstNum5 = new String(qstNum50.getBytes("ISO-8859-1"), "utf-8");
		System.out.println("qstNum1=="+qstNum1);
		System.out.println("qstNum2=="+qstNum2);System.out.println("qstNum3=="+qstNum3);
		System.out.println("qstNum4=="+qstNum4);System.out.println("qstNum1=="+qstNum5);
		if(qstNum4.equals("0")){
			if(qstNum1.equals("")||qstNum1==null||qstNum2.equals("")||qstNum2==null||qstNum3.equals("")||qstNum3==null||qstTitle.equals("")||qstTitle==null){
				///JOptionPane.showMessageDialog(null, "选项不能为空");
				response.sendRedirect("addquestion1.jsp");
				return;
			}else{
			String content = qstNum1 + "#" + qstNum2 + "#" + qstNum3;
			question.setQstOption(content);}
		}else{
			if(qstNum1.equals("")||qstNum1==null||qstNum2.equals("")||qstNum2==null||qstNum3.equals("")||qstNum3==null||qstNum4.equals("")||qstNum4==null||qstNum5.equals("")||qstNum5==null||qstTitle.equals("")||qstTitle==null){
	System.out.println("sajkfsgdjj年好吗");
				//JOptionPane.showMessageDialog(null, "选项不能为空");
				response.sendRedirect("addquestion1.jsp");
				return;
			}else{
		String content = qstNum1 + "#" + qstNum2 + "#" + qstNum3 + "#"
				+ qstNum4 + "#" + qstNum5;
			question.setQstOption(content);}
		}
		question.setQstCount(0);
	
		String answer=request.getParameter("qstAnswer");//
		question.setQstAnswer(answer);
		// 初始化问题答案
		boolean isNum = answer.matches("[0-9]+"); 
		if(isNum){
		int a=Integer.parseInt(answer);	
		String j=request.getParameter("jc");//接收还能出几分
		int s=Integer.parseInt(j);
		if((100-s-a)<0){
		//	JOptionPane.showMessageDialog(null, "分数已达到上线,确定你的分数");
			response.sendRedirect("addquestion1.jsp");
		}else{
		questionDao.addQuestions(question);
		response.sendRedirect("success.jsp");
		}
	}
	else {
		//JOptionPane.showMessageDialog(null, "分数输入的不是数字，请重新输入");
		response.sendRedirect("addquestion1.jsp");
		
	}
	}

	@Override
	public void init() throws ServletException {
		// Put your code here
	}

}
