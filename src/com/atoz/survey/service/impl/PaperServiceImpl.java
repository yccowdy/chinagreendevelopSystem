package com.atoz.survey.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import com.atoz.survey.dao.PaperDao;
import com.atoz.survey.dao.mysqlimpl.PaperDaoImpl;
import com.atoz.survey.po.Paper;
import com.atoz.survey.service.PaperService;

public class PaperServiceImpl implements PaperService {
	
	private PaperDaoImpl paperDao = new PaperDaoImpl();
	File file = new File("config.properties");
	Properties properties = new Properties();
	
	public List<Paper> findAllPapers() {
		// TODO Auto-generated method stub
		try {
			System.out.println("出错");
			properties.load(new FileInputStream(file));
			String paperDaoString = properties.getProperty("paperDao");
			paperDao = (PaperDaoImpl) Class.forName(paperDaoString).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return paperDao.findAllPapers();
	}
	

	public List<Paper> findPaperByUserId(int userId) {
		// TODO Auto-generated method stub
		try {
			properties.load(new FileInputStream(file));
			String paperDaoString = properties.getProperty("paperDao");
			paperDao = (PaperDaoImpl) Class.forName(paperDaoString).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return paperDao.findPaperByUserId(userId);
	}
	public List<Paper> findPapersBytitleandtypeandjidu(String title,int type,int paperJidu){
		// TODO Auto-generated method stub
		try {
			properties.load(new FileInputStream(file));
			String paperDaoString = properties.getProperty("paperDao");
			paperDao = (PaperDaoImpl) Class.forName(paperDaoString).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return paperDao.findPapersBytitleandtypeandjidu(title,type,paperJidu);
	}
	public List<Paper> findPaperByPaperType(int paperType) {
		
		return null;
	}
	public List<Paper> findPaperIdBySummaryandTitleandfabuandyiji(String paperTitle,int paperType,int paperCount){
		try {
			properties.load(new FileInputStream(file));
			String paperDaoString = properties.getProperty("paperDao");
			paperDao = (PaperDaoImpl) Class.forName(paperDaoString).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return paperDao.findPaperIdBySummaryandTitleandfabuandyiji(paperTitle,paperType,paperCount);
	}
	
	public Paper findPaperByPaperId(int paperId) {
		// TODO Auto-generated method stub
		try {
			properties.load(new FileInputStream(file));
			String paperDaoString = properties.getProperty("paperDao");
			paperDao = (PaperDaoImpl) Class.forName(paperDaoString).newInstance();
		} catch (Exception e) {
			
		}
		return paperDao.findPaperByPaperId(paperId);
	}

	public int findPaperIdByuserIdAndDate(int userId, String paperStartDate) {
		// TODO Auto-generated method stub
		try {
			properties.load(new FileInputStream(file));
			String paperDaoString = properties.getProperty("paperDao");
			paperDao = (PaperDaoImpl) Class.forName(paperDaoString).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return paperDao.findPaperIdByuserIdAndDate(userId, paperStartDate);
	}
	
	public int updatefabuBylg(int type, int paperCount) {
		// TODO Auto-generated method stub
		try {
			properties.load(new FileInputStream(file));
			String paperDaoString = properties.getProperty("paperDao");
			paperDao = (PaperDaoImpl) Class.forName(paperDaoString).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return paperDao.updatefabuBylg(type, paperCount);
	}
	public int addPapers(Paper paper) {
		// TODO Auto-generated method stub
		try {
			properties.load(new FileInputStream(file));
			String paperDaoString = properties.getProperty("paperDao");
			paperDao = (PaperDaoImpl) Class.forName(paperDaoString).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return paperDao.addPapers(paper);
	}
	public int addPapersSm(Paper paper) {
		// TODO Auto-generated method stub
		try {
			properties.load(new FileInputStream(file));
			String paperDaoString = properties.getProperty("paperDao");
			paperDao = (PaperDaoImpl) Class.forName(paperDaoString).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return paperDao.addPapersSm(paper);
	}

	public int updatefabuByPaperId(int paperId, int paperCount) {
		// TODO Auto-generated method stub
		try {
			properties.load(new FileInputStream(file));
			String paperDaoString = properties.getProperty("paperDao");
			paperDao = (PaperDaoImpl) Class.forName(paperDaoString).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return paperDao.updatefabuByPaperId(paperId,paperCount);
	}
	public int addPapersWi(Paper paper) {
		// TODO Auto-generated method stub
		try {
			properties.load(new FileInputStream(file));
			String paperDaoString = properties.getProperty("paperDao");
			paperDao = (PaperDaoImpl) Class.forName(paperDaoString).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return paperDao.addPapersWi(paper);
	}
	public int addPapersAu(Paper paper) {
		// TODO Auto-generated method stub
		try {
			properties.load(new FileInputStream(file));
			String paperDaoString = properties.getProperty("paperDao");
			paperDao = (PaperDaoImpl) Class.forName(paperDaoString).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return paperDao.addPapersAu(paper);
	}
	public List<Paper> findPaperIdBySummaryandTitleandfabu(String paperTitle,String paperSummary,int paperCount){
		try {
			properties.load(new FileInputStream(file));
			String paperDaoString = properties.getProperty("paperDao");
			paperDao = (PaperDaoImpl) Class.forName(paperDaoString).newInstance();
		} catch (Exception e) {
			System.out.println("List<Paper> findPaperIdBySummaryandTitle(String paperTitle,String paperSummary)");
		}
		return paperDao.findPaperIdBySummaryandTitleandfabu(paperTitle, paperSummary,paperCount);
	}
	
	public int addPapersSp(Paper paper) {
		// TODO Auto-generated method stub
		try {
			properties.load(new FileInputStream(file));
			String paperDaoString = properties.getProperty("paperDao");
			paperDao = (PaperDaoImpl) Class.forName(paperDaoString).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return paperDao.addPapersSp(paper);
	}
	public int deletePaperByPaperId(int paperId) {
		// TODO Auto-generated method stub
		try {
			properties.load(new FileInputStream(file));
			String paperDaoString = properties.getProperty("paperDao");
			paperDao = (PaperDaoImpl) Class.forName(paperDaoString).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return paperDao.deletePaperByPaperId(paperId);
	}

	public int deletePaperByUserId(int userId) {
		// TODO Auto-generated method stub
		try {
			properties.load(new FileInputStream(file));
			String paperDaoString = properties.getProperty("paperDao");
			paperDao = (PaperDaoImpl) Class.forName(paperDaoString).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return paperDao.deletePaperByUserId(userId);
	}




}
