package com.atoz.survey.dao;

import java.util.List;

import com.atoz.survey.po.Paper;

public interface PaperDao {
	List<Paper> findPapersBytitleandtype(String title,int type);
	List<Paper> findAllPapers();
	List<Paper> findPaperByUserId(int userId);
	List<Paper> findPaperByPaperType(int paperType);
	//List<Paper> findTitleByPaperId(int paperId);
	Paper findPaperByPaperId(int paperId);
	int   findPaperIdByuserIdAndDate(int userId,String paperStartDate);
	List<Paper> findPapersBytitleandtypeandjidu(String title,int type,int paperJidu);
	int findPaperIdBypapertype(int paperType);//11.30
	int addPapersSm(Paper paper);
	int addPapersSp(Paper paper);
	int addPapersAu(Paper paper);
	int addPapersWi(Paper paper);
	int addPapers(Paper paper);
	int modifiedStatusBypaperId(int paperId);
	int deletePaperByPaperId(int paperId);
	int deletePaperByUserId(int userId);
	int deletePaperByPaperType(int papertype,int qstjidu);
	List<Paper> findPaperIdBySummaryandTitleandfabu(String paperTitle,String paperSummary,int paperCount);
	List<Paper> findPaperIdBySummaryandTitleandfabuandyiji(String paperTitle,int paperType,int paperCount);
	int updatefabuByPaperId(int paperId, int paperCount);
	int updatefabuBylg(int type, int paperCount);
}
