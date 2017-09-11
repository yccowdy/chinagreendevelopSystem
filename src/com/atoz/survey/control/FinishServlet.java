package com.atoz.survey.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.atoz.survey.dao.QuestionDao;
import com.atoz.survey.dao.mysqlimpl.QuestionDaoImpl;
import com.atoz.survey.po.Paper;
import com.atoz.survey.po.Question;
import com.atoz.survey.po.User;
import com.atoz.survey.service.impl.PaperServiceImpl;
import com.atoz.survey.service.impl.UserServiceImpl;

public class FinishServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public FinishServlet() {
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
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			double sum=0;
			int paperCount=1;
			QuestionDaoImpl questionDao = new QuestionDaoImpl();//IMPL
			UserServiceImpl userService = new UserServiceImpl();
			PaperServiceImpl paperimpl = new PaperServiceImpl();//12.2
			HttpSession session = request.getSession();
			String papertypeString =request.getParameter("papertype");
			System.out.println("papertypeString=="+papertypeString);
			//User user=(User)session.getAttribute("users");
			int papertype = Integer.parseInt(papertypeString);//题目ID
			
			//int userid=user.getUserId();
		//System.out.println("userid=="+userid);
			String id=request.getParameter("userid");//选择的ID
			int id2 = Integer.parseInt(id);
			System.out.println("id2=="+id2);
			
			String role=session.getAttribute("role").toString();
			int n= Integer.parseInt(role);//定义角色类型跳转到不同的JSP页面
			String totalNumString = request.getParameter("totalNum");
			int totalNum = Integer.parseInt(totalNumString);
			System.out.println(totalNum);//题目个数
			String paperjiduString = request.getParameter("paperjidu");
			int paperjidu = Integer.parseInt(paperjiduString);
			System.out.println("季度是"+paperjidu);
			int answers[] = new int[totalNum];
			try {
			for (int i = 0; i < answers.length; i++) {
				String ss =  "q" + (i + 1);
				// 在这里要处理到底是问答题还是选择题。
				String answerString = request.getParameter(ss);
				System.out.println("ss+"+ss);
				System.out.println("111111answerString"+answerString);
				int an=Integer.parseInt(answerString);
				answers[i] = an;  //得到答案的字符串
				System.out.println(answers[i]);
			} }catch (Exception e) {
				if(n==-1){
				//JOptionPane.showMessageDialog(null, "题目没有做完");
					
				
				response.sendRedirect("surveypage.jsp?papertype="+papertype+"&userid="+id2+"&paperJidu="+paperjidu+"");
				return;}
				if(n!=-1){
					//JOptionPane.showMessageDialog(null, "题目没有做完");	
					response.sendRedirect("surveypage.jsp?papertype="+papertype+"&userid="+id2+"&paperJidu="+paperjidu+"");
					return;}
			}
			System.out.println("dfsjagjkdskjhjkdfgsahkj你好");
			List<Question> questions = questionDao.findQuestionsByqstandjiduandfabu(papertype,paperjidu,paperCount);
if(paperjidu==4){
int j = 0; //记录题号
for (Question question : questions) {
		String string = question.getQstAnswer();
		int paperID=question.getPaperId();//
		Paper paper=new Paper();
		paper=paperimpl.findPaperByPaperId(paperID);
		System.out.println(paperID);
		String PaperBg=paper.getPaperBgw();
		double weight = Double.parseDouble(PaperBg);//weight
		double grade=Double.parseDouble(string);
		double f = 0;
		int k = answers[j];
		switch (k) {
		case 0:
			f=grade*1*weight;
			    //System.out.println("选的A");
			break;
		case 1:
			f=grade*0.75*weight;
			 break;
		case 2:
			f=grade*0.5*weight;
			 break;
		case 3:
			f=grade*0.25*weight;
			 break;
		case 4:	 //11.30 1
			f=grade*0*weight;
			 break;//11.30 1
		default:
			break;
		}
		//将修改后的答案写入数据库
		sum=sum+f;
		System.out.println(sum);
		//String newAnswer = String.valueOf(f);
		//questionDao.updateQuestions(question.getQstId(), newAnswer);		
	j++;
}
	
	System.out.println(role);
	System.out.println("jsadhf;lkkldfsklgdskj黑乎乎");
	String Sum = String.valueOf(sum);
	double s = Double.parseDouble(Sum);
	System.out.println(s);
	System.out.println(Sum);
	User user1=userService.findUserByUserId(id2);
	if(id2==6){
		
		user1.setUserWin(s);
		userService.modifywiUsers(user1);
	}else{
	user1.setUserSw(sum);
	userService.modifyswiUsers(user1);
	}

	if (n== 0) {
		response.sendRedirect("home.jsp");
	} else if(n==-1){
		response.sendRedirect("tree.jsp");
	}else if (n== 10||n==11||n==12) {
		response.sendRedirect("company.jsp");
	}else{
		response.sendRedirect("user.jsp");
	} 
}


			}
					
	

	
	@Override
	public void init() throws ServletException {
		// Put your code here
	}

}
