package ModifyTitleServlet;

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
import com.atoz.survey.po.Paper;
import com.atoz.survey.po.Question;
import com.atoz.survey.po.User;

public class ModifyTitleServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ModifyTitleServlet() {
		super();
	}

	
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
		request.setCharacterEncoding("utf-8");
		PaperDao paperDao = new PaperDaoImpl();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("users");
		String ss=request.getParameter("ss");
		System.out.println(ss);
		
		if(user != null)
		{
			int userId = user.getUserId();
			List<Paper> papers = paperDao.findPaperByUserId(userId);
			session.setAttribute("papers", papers);
			response.sendRedirect("home.jsp");
		}
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
