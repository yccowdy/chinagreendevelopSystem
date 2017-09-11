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

public class ModifyTitle extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ModifyTitle() {
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
		//Question question = new Question();
		QuestionDaoImpl questionDao = new QuestionDaoImpl();
		
		//HttpSession session = request.getSession();
		//Integer paperIdString = (Integer) session.getAttribute("paperId");
//		if (paperIdString != null) {
//			int paperId = paperIdString.intValue();
//			question.setPaperId(paperId);
//		} else {
//			System.out.println("空");
//		}
		int paperCount=1;
		String qstTitle0 = request.getParameter("qstTitle");
		String qstTitle = new String(qstTitle0.getBytes("ISO-8859-1"), "utf-8");
		
		String paperSummary0 = request.getParameter("paperSummary");
		String paperSummary = new String(paperSummary0.getBytes("ISO-8859-1"), "utf-8");
		System.out.println("paperSummary=="+paperSummary);
		String qstAnswer = request.getParameter("qstAnswer");
		//int qstAnswer=Integer.parseInt(qstAnswer0);
		System.out.println(qstAnswer);
		String QstId0 = request.getParameter("QstId");
		//String paperSummary = new String(paperSummary0.getBytes("ISO-8859-1"), "utf-8");
		System.out.println("QstId=="+QstId0);
		int QstId=Integer.parseInt(QstId0);
	//	String paperSummary = new String(paperSummary0.getBytes("ISO-8859-1"), "utf-8");
		
		
//		String qstTypeString = request.getParameter("qstType"); // 问题类型
//		int qstType = Integer.parseInt(qstTypeString);
//		question.setQstType(qstType);
//		String paperJidu0 = request.getParameter("paperJidu"); // 问题类型
//		int qstJidu = Integer.parseInt(paperJidu0);
//		question.setQstJidu(qstJidu);


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
		boolean isNum = qstAnswer.matches("[0-9]+"); 
			if(paperSummary.equals("环境管理体系认证")){
				if(""==qstNum1||qstNum1==null||qstNum2==""||qstNum2==null||qstNum3==""||qstNum3==null||qstTitle==null||qstTitle==""){
					//JOptionPane.showMessageDialog(null, "选项不能为空");
					response.sendRedirect("addquestion1.jsp");
					return;
				}else{
			String content = qstNum1 + "#" + qstNum2 + "#" + qstNum3;
			if(!isNum){
				//JOptionPane.showMessageDialog(null, "分数输入的不是数字，请重新输入");
				response.sendRedirect("modifytitle.jsp");
				JOptionPane.showMessageDialog(null, "修改失败！");
			}
			else
			{
			int result=questionDao.modifybyqstId(QstId,qstTitle,content,qstAnswer,paperCount);
			System.out.println("result==="+result);
			if(result==1){
				//JOptionPane.showMessageDialog(null, "修改成功！");
			response.sendRedirect("modifytitle.jsp");
			}
			else {JOptionPane.showMessageDialog(null, "修改失败！");
			response.sendRedirect("modifytitle.jsp");}
			}}
			}
		else{
			if(""==qstNum1||qstNum1==null||qstNum2==""||qstNum2==null||qstNum3==""||qstNum3==null||qstNum4==""||qstNum4==null||qstNum5==""||qstNum5==null||qstTitle==null||qstTitle==""){
				//JOptionPane.showMessageDialog(null, "选项不能为空");
				response.sendRedirect("addquestion1.jsp");
				return;
			}else{
		String content = qstNum1 + "#" + qstNum2 + "#" + qstNum3 + "#" + qstNum4 + "#" + qstNum5;
		System.out.println(content);
		if(!isNum){
			//JOptionPane.showMessageDialog(null, "分数输入的不是数字，请重新输入");
			response.sendRedirect("modifytitle.jsp");
			JOptionPane.showMessageDialog(null, "修改失败！");
		}
		
		else{
		int result=questionDao.modifybyqstId(QstId,qstTitle,content,qstAnswer,paperCount);
		System.out.println("result==="+result);
		if(result==1){
			//JOptionPane.showMessageDialog(null, "修改成功！");
		response.sendRedirect("modifytitle.jsp");
		}
		else {//JOptionPane.showMessageDialog(null, "修改失败！");
		response.sendRedirect("modifytitle.jsp");}
	}
		}}
	}

	@Override
	public void init() throws ServletException {
		
	}

}
