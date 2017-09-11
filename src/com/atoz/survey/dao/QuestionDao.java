package com.atoz.survey.dao;

import java.util.List;

import com.atoz.survey.po.Question;


public interface QuestionDao {

	List<Question> findQuestionsByPaperId(int paperId);
	List<Question> showResultByPaperId(int paperId);
	List<String> findQstAnswerByPaperId(int paperId);
	List<Question> findQuestionsByqst(int qsttype);
	List<Question> showResultByqstType(int qsttype);//12.1
	int addQuestions(Question question);
	int updateQuestions(int qstId,String qstAnswer);
	int deleteQusetionByQuestionId(int questionId);
	int deleteQusetionByPaperId(int paperId);
	int deleteQusetionByPaperType(int papertype,int qstjidu);
	int updateQuestionsjidu(int questionId,int qstJidu);
	Question findOptionByQstTitle(int paperId,String QstTi);
	int modifybyqstId(int qstId, String qstTitle, String content,String qstAnswer,int paperCount);
    int updatefabuBypaperId(int paperId, int qstCount);
    List<Question> findQuestionsByqstandjiduandfabu(int qsttype,int paperjidu,int qstCount);
    List<Question> findQuestionsByqstandjidu(int qsttype,int paperjidu);
    List<Question> findQuestionsByPaperIdandfabu(int paperId,int paperCount);
    int updatefabuBytype(int type, int qstCount);
}
