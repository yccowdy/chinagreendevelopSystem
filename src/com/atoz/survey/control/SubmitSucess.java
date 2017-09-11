package com.atoz.survey.control;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

//import org.junit.Test;  




import com.lowagie.text.DocumentException;  
import com.lowagie.text.pdf.AcroFields;  
import com.lowagie.text.pdf.PdfReader;  
import com.lowagie.text.pdf.PdfStamper;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletContext;

import java.io.*;  
import java.util.*;  

import com.a.model.UserBean;
import com.a.model.UserBeanCl;
import com.atoz.survey.dao.QuestionDao;
import com.atoz.survey.dao.mysqlimpl.QuestionDaoImpl;
import com.atoz.survey.po.Paper;
import com.atoz.survey.po.Question;
import com.atoz.survey.po.User;
import com.atoz.survey.service.impl.PaperServiceImpl;
import com.atoz.survey.service.impl.UserServiceImpl;


public class SubmitSucess extends HttpServlet {
	public static FTPClient ftp; 
	/**
	 * Constructor of the object.
	 */
	public SubmitSucess() {
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

	@SuppressWarnings("resource")
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
			double sum=0;
			int paperCount=1;
			String daan="";
			char ans='0';
			QuestionDaoImpl questionDao = new QuestionDaoImpl();//IMPL
			UserServiceImpl userService = new UserServiceImpl();
			PaperServiceImpl paperimpl = new PaperServiceImpl();//12.2
			HttpSession session = request.getSession();
			String papertypeString =request.getParameter("papertype");
			//System.out.println("papertypeString=="+papertypeString);
			
			int papertype = Integer.parseInt(papertypeString);//题目ID

			String id=request.getParameter("userid");//选择的ID
			int id2 = Integer.parseInt(id);
			//System.out.println("id2=="+id2);
			String treeid3=request.getParameter("treeid3");
			//System.out.println("treeid3=="+treeid3);//选择的ID
			int treeid = Integer.parseInt(treeid3);
			//System.out.println("treeid=="+treeid);
			String role=session.getAttribute("role").toString();
			int n= Integer.parseInt(role);//定义角色类型跳转到不同的JSP页面
			String totalNumString = request.getParameter("totalNum");
			int totalNum = Integer.parseInt(totalNumString);
			//System.out.println(totalNum);//题目个数
			String paperjiduString = request.getParameter("paperjidu");
			int paperjidu = Integer.parseInt(paperjiduString);
			//System.out.println("季度是"+paperjidu);
			int answers[] = new int[totalNum];
			try {
			for (int i = 0; i < answers.length; i++) {
				String ss =  "q" + (i + 1);
				String answerString = request.getParameter(ss);
				System.out.println("ss+"+ss);
				System.out.println("111111answerString"+answerString);
				int an=Integer.parseInt(answerString);
				answers[i] = an;  //得到答案的字符串
				System.out.println(answers[i]);
			} }catch (Exception e) {
					//JOptionPane.showMessageDialog(null, "题目没有做完");
					response.sendRedirect("surveypage.jsp?papertype="+papertype+"&userid="+id2+"&paperJidu="+paperjidu+"");
					return;
			}
		
			List<Question> questions = questionDao.findQuestionsByqstandjiduandfabu(papertype,paperjidu,paperCount);
		if(paperjidu==1){
			int j = 0; //记录题号
			for (Question question : questions) {
					String string = question.getQstAnswer();
					int paperID=question.getPaperId();//
					Paper paper=new Paper();
					paper=paperimpl.findPaperByPaperId(paperID);
					
					String PaperBg=paper.getPaperBgsp();
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
				String Sum = String.valueOf(sum);
				double s = Double.parseDouble(Sum);
				User user1=userService.findUserByUserId(id2);
				if(id2==6){
					
					user1.setUserSpring(s);
					userService.modifyspUsers(user1);
				}else{
				user1.setUserSspr(sum);
				userService.modifysspUsers(user1);
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
	if(paperjidu==2){
	int j = 0; //记录题号
	for (Question question : questions) {
			String string = question.getQstAnswer();
			int paperID=question.getPaperId();//
			Paper paper=new Paper();
			paper=paperimpl.findPaperByPaperId(paperID);
			int jidu=paper.getPaperJidu();
			System.out.println("jidu位"+jidu);
			String PaperBg=paper.getPaperBgsm();
			System.out.println("PaperBg="+PaperBg);
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
		String Sum = String.valueOf(sum);
		double s = Double.parseDouble(Sum);
		User user1=userService.findUserByUserId(id2);
		if(id2==6){
			
			user1.setUserSpring(s);
			userService.modifyspUsers(user1);
		}else{
		user1.setUserSspr(sum);
		userService.modifysspUsers(user1);
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
	


if(paperjidu==3){
int j = 0; //记录题号
for (Question question : questions) {
		String string = question.getQstAnswer();
		int paperID=question.getPaperId();//
		Paper paper=new Paper();
		paper=paperimpl.findPaperByPaperId(paperID);
		int jidu=paper.getPaperJidu();
		System.out.println("jidu"+jidu);
		String PaperBg=paper.getPaperBga();
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
		System.out.println("sum为："+sum);
		//String newAnswer = String.valueOf(f);
		//questionDao.updateQuestions(question.getQstId(), newAnswer);		
	j++;
}

	System.out.println(role);
	String Sum = String.valueOf(sum);
	double s = Double.parseDouble(Sum);
	User user1=userService.findUserByUserId(id2);
	if(id2==6){
		user1.setUserAut(s);
		userService.modifyauUsers(user1);
	}else{
	user1.setUserSa(sum);
	userService.modifysauUsers(user1);
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
		
		if(answers[j]==0){
			ans='A';
		}
		if(answers[j]==1){
			ans='B';
		}
		if(answers[j]==2){
			ans='C';
		}
		if(answers[j]==3){
			ans='D';
		}
		if(answers[j]==4){
			ans='E';
		}
		daan+=ans;
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
Date date = new Date();
SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//SimpleDateFormat simpleDateFormatjt = new SimpleDateFormat("yyyy-MM-dd");
String paperStartDate = simpleDateFormat.format(date);
///String jutishijian=simpleDateFormatjt.format(date);
//System.out.println("perhhhh"+jutishijian);
//System.out.println("daan=="+daan);
Calendar now = Calendar.getInstance();  

final String time=now.get(Calendar.YEAR)+","+(now.get(Calendar.MONTH) + 1) +","+ now.get(Calendar.DAY_OF_MONTH);
final String[] anwwer=daan.split(",");
//System.out.println("hjyfhjfhjfhj"+anwwer[3]);
//	System.out.println(role);
//	System.out.println("jsadhf;lkkldfsklgdskj黑乎乎");
	String Sum = String.valueOf(sum);
double s = Double.parseDouble(Sum);
final String s1=String.valueOf(s);
//	System.out.println(s);
//	System.out.println("n=="+n);
//	System.out.println(Sum);
//	System.out.println("id2=="+id2);
	String grade="";
	if(s<70){
		
	grade="企业对于环境的治理有待提升哦~";	
	}
	else if(s>=70&&s<80){
		grade="A级绿色企业";	
		}
	else if(s>=80&&s<90){
		grade="AA级绿色企业";	
		}
	else if(s>=90){
		grade="AAA级绿色企业";	
		}
	User user1=userService.findUserByUserId(id2);
String name=user1.getUserSummary();
	 String jianjie=user1.getUserIntro();
	 String Nm=user1.getUserSummary();
	 String Dz=user1.getUserAdd();
	 String Gm=user1.getUserShangshi();
	 String Tx=user1.getUserType();
	 String Hy=user1.getUserPerson();

	  String fileName = this.getClass().getClassLoader().getResource("/").getPath()+"/greentitle.pdf";
  	///File file=new File(fileName);
	  SubmitSucess t = new SubmitSucess(); 
		InputStream in=new FileInputStream(fileName);
		// File file = new File(sc.getRealPath("/") + savePath, "2155.pdf");
        PdfReader reader = new PdfReader(fileName);  
        Map<String, String> data = new HashMap<String, String>(); 
        data.put("company", name); 
        for(int i=1;i<=anwwer.length;i++)
        data.put("file"+i, anwwer[i-1]);  
        data.put("introduct",jianjie);
        data.put("time",time );
        data.put("grade",s1);
        data.put("level", grade);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();  
        PdfStamper ps=null;
        try {
        	ps = new PdfStamper(reader, bos);
		} catch (Exception e) {
			e.printStackTrace();
		}
        AcroFields fields = ps.getAcroFields();  
    
        for (String key : data.keySet()) {  
            String value = data.get(key);  
            try {
				fields.setField(key, value);
			} catch (DocumentException e) {
			
				e.printStackTrace();
			}  
        }  
        ps.setFormFlattening(true);  
        try {
			ps.close();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
     
    for (String key : data.keySet()) {  
              String value = data.get(key);  
              try {
				fields.setField(key, value);
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
          }  
  
   // File file = new File(user1.getUserSummary()+".pdf"); 
    String g=user1.getUserName();
    
    File file = new File(this.getClass().getClassLoader().getResource("/").getPath()+"/"+g+".pdf");
    OutputStream out=new FileOutputStream(file);
    //    FileOutputStream fos = new FileOutputStream(file);  
        out.write(bos.toByteArray()); 
        try {
				Boolean a=t.connect("/webapps/ROOT/", "58.64.140.245", 21, "NS71273246", "xiexie2017");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
      
        try {
			t.upload(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
    	System.out.println(transFile(in, out,4096));
	UserBean userub=new UserBean(id2,(int) sum,daan,grade,paperStartDate,Nm,Dz,Gm,Tx,Hy);
if(n==-1){
	user1.setUserWin(s);
     userService.modifywiUsers(user1);	
	}else{
	int www=new UserBeanCl().addSelf(userub);
		System.out.println("wwww=="+www);
		user1.setUserSw(s);
		int aa=userService.modifyswiUsers(user1);
		System.out.println("aa=="+aa);
		
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
	public static int transFile(InputStream in, OutputStream out, int fileSize) {
		int receiveLen = 0;
		final int bufSize = 1000;
		try {
		byte[] buf = new byte[bufSize];
		int len = 0;
		while(fileSize - receiveLen > bufSize)
		{
		len = in.read(buf);
		out.write(buf, 0, len);
		out.flush();
		receiveLen += len;
		//System.out.println(len);
		}
		while(receiveLen < fileSize)
		{
		len = in.read(buf, 0, fileSize - receiveLen);
		//System.out.println(len);
		out.write(buf, 0, len);
		receiveLen += len;
		out.flush();
		}
		} catch (IOException e) {
		e.printStackTrace();
		}
		return receiveLen;
		}
	 public void upload(File file) throws Exception{      
	        if(file.isDirectory()){           
	            ftp.makeDirectory(file.getName());                
	            ftp.changeWorkingDirectory(file.getName());      
	            String[] files = file.list();             
	            for (int i = 0; i < files.length; i++) {      
	                File file1 = new File(file.getPath()+"/"+files[i] );      
	                if(file1.isDirectory()){      
	                    upload(file1);      
	                    ftp.changeToParentDirectory();      
	                }else{                    
	                    File file2 = new File(file.getPath()+"/"+files[i]);      
	                    FileInputStream input = new FileInputStream(file2);      
	                    ftp.storeFile(file2.getName(), input);      
	                    input.close();                            
	                }                 
	            }      
	        }else{      
	            File file2 = new File(file.getPath());      
	            FileInputStream input = new FileInputStream(file2);      
	            ftp.storeFile(file2.getName(), input);      
	            input.close();        
	        }      
	    }  
	    public boolean connect(String path,String addr,int port,String username,String password) throws Exception {      
	        boolean result = false;      
	    ftp = new FTPClient();      
	        int reply;      
	        ftp.connect(addr,port);      
	        ftp.login(username,password);      
	        ftp.setFileType(FTPClient.BINARY_FILE_TYPE);      
	        reply = ftp.getReplyCode();      
	        if (!FTPReply.isPositiveCompletion(reply)) {      
	            ftp.disconnect();      
	            return result;      
	        }      
	        ftp.changeWorkingDirectory(path);      
	        result = true;      
	        return result;      
	    }      






	
	
					
	

	
	@Override
	public void init(ServletConfig config) throws ServletException {
		 
	}

}
