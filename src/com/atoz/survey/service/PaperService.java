package com.atoz.survey.service;

import java.util.List;

import com.atoz.survey.po.Paper;

public interface PaperService {
	
	List<Paper> findAllPapers();
	List<Paper> findPaperByUserId(int userId);
	List<Paper> findPaperByPaperType(int paperType);
	//List<Paper> findTitleByPaperId(int paperId);
	Paper findPaperByPaperId(int paperId);
	int   findPaperIdByuserIdAndDate(int userId,String paperStartDate);
//	Paper showResultByPaperId(int paperId);
	int addPapersAu(Paper paper);
	int addPapersSp(Paper paper);
	int addPapersSm(Paper paper);
	int addPapersWi(Paper paper);
	List<Paper> findPapersBytitleandtypeandjidu(String title,int type,int paperJidu);
	int addPapers(Paper paper);
	int deletePaperByPaperId(int paperId);
	int deletePaperByUserId(int userId);
	List<Paper> findPaperIdBySummaryandTitleandfabu(String paperTitle,String paperSummary,int paperCount);
	List<Paper> findPaperIdBySummaryandTitleandfabuandyiji(String paperTitle,int paperType,int paperCount);
	int updatefabuByPaperId(int paperId, int paperCount);
	int updatefabuBylg(int type, int paperCount);
}