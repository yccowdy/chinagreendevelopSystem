package com.atoz.survey.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atoz.survey.po.User;
import com.atoz.survey.service.impl.UserServiceImpl;

public class SortServlet extends HttpServlet {

	
	public SortServlet() {
		super();
	}

	
	public void destroy() {
		super.destroy(); 
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
       String jiaose=request.getParameter("jiaose");
        System.out.println(jiaose);
        
       
        String useradd=request.getParameter("useradd");
        System.out.println("useradd=="+useradd);
        String ThreeMark=request.getParameter("ThreeMark");
        
        System.out.println("ThreeMark=="+ThreeMark);

        String juese=request.getParameter("juese");
      
       
       request.setAttribute("ThreeMark",ThreeMark);
       request.setAttribute("jiaose", jiaose);
       request.setAttribute("juese", juese);
       request.setAttribute("userid", 6);
       request.setAttribute("useradd", useradd);
       request.getRequestDispatcher("sort.jsp").forward(request, response); 
    	
	}
        
    


	public void init() throws ServletException {
		
	}

}
