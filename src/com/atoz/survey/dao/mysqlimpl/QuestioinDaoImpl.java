package com.atoz.survey.dao.mysqlimpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.atoz.survey.dao.QuestionDao;
import com.atoz.survey.po.Question;

public class QuestioinDaoImpl extends BaseDao implements QuestionDao {
	@Override
	public List<Question> findQuestionsByPaperId(int paperId) {
		// TODO Auto-generated method stub
		List<Question> questions = new ArrayList<Question>();
		getConn();
		String sql = "select * from Questions where paperId = ?";
		doQuery(sql,paperId);
		try {
			while(rs.next()){
				Question question = new Question();
				question.setQstId(rs.getInt(1));
				question.setPaperId(rs.getInt(2));
				question.setQstType(rs.getInt(3));
				question.setQstTitle(rs.getString(4));
				question.setQstOption(rs.getString(5));
				question.setQstAnswer(rs.getString(6));
				questions.add(question);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		closeAll();
		return questions;
	}
	@Override
	public List<Question> showResultByPaperId(int paperId) {
		// TODO Auto-generated method stub
		
		List<Question> questions = new ArrayList<Question>();
		getConn();
		String sql = "select * from Questions where paperId = ?";
		doQuery(sql,paperId);
		try {
			while(rs.next()){
				Question question = new Question();
				question.setQstId(rs.getInt(1));
				question.setPaperId(rs.getInt(2));
				question.setQstType(rs.getInt(3));
				question.setQstTitle(rs.getString(4));
				question.setQstOption(rs.getString(5));
				question.setQstAnswer(rs.getString(6));
				questions.add(question);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		closeAll();
		return questions;
	}

	public int addQuestions(Question question) {
		// TODO Auto-generated method stub
		getConn();
		String sql = "insert into Questions values(?, ?, ?, ?, ?,?)";
		doOperate(sql, question.getQstId(),question.getPaperId(),question.getQstType(),
				question.getQstOption(),"");
		closeAll();
		return result;
	}
	@Override
	public int updateQuestions(int questionId,String qstAnswer) {
		// TODO Auto-generated method stub
		getConn();
		String sql = "update Questions set qstAnswer = ? where qstId = ?";
		doOperate(sql, qstAnswer,questionId);
		closeAll();
		return result;
	}
	@Override
	public int updateQuestionsjidu(int questionId,int qstJidu) {
		// TODO Auto-generated method stub
		getConn();
		String sql = "update Questions set qstJidu = ? where qstId = ?";
		doOperate(sql, qstJidu,questionId);
		closeAll();
		return result;
	}
	public int deleteQusetionByQuestionId(int questionId) {
		// TODO Auto-generated method stub
		getConn();
		String sql = "delete * from Questions where qstId = ?";
		doOperate(sql, questionId);
		closeAll();
		return result;
	}
	@Override
	public List<String> findQstAnswerByPaperId(int paperId) {
		// TODO Auto-generated method stub
		List<String> strings = new ArrayList<String>();
		getConn();
		String sql = "select qstAnswer from Questions where paperId = ?";
		doQuery(sql, paperId);
		try {
			while(rs.next()){
				String string = "";
				string += rs.getString(1);
				strings.add(string);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		closeAll();
		return strings;
	}
	@Override
	public int deleteQusetionByPaperId(int paperId) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List<Question> findQuestionsByqst(int qsttype) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Question> showResultByqstType(int qsttype) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int deleteQusetionByPaperType(int papertype,int qstjidu) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	
	public Question findOptionByQstTitle(int paperId, String QstTi) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int modifybyqstId(int qstId, String qstTitle, String content,String qstAnswer,int paperCount) {
		getConn();
		String sql = "update Questions set qstTile = ? ,qstOption= ?, qstAnswer= ? ,qstCount= ? where qstId = ?";
		doOperate(sql, qstTitle,content,qstAnswer,paperCount, qstId);
		closeAll();
		return result;
	}
	
	@Override
	public int updatefabuBypaperId(int paperId, int qstCount) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List<Question> findQuestionsByqstandjiduandfabu(int qsttype,
			int paperjidu, int qstCount) {
		// TODO Auto-generated method stub
		return null;
	}
	public int updatefabuBytype(int type, int qstCount) {
		// TODO Auto-generated method stub
		getConn();
		String sql = "update Questions set qstCount = ? where qstType = ?";
		doOperate(sql, qstCount, type);
		closeAll();
		return result;
	}
	@Override
	public List<Question> findQuestionsByqstandjidu(int qsttype,int paperjidu) {
		List<Question> questions = new ArrayList<Question>();
		getConn();
		String sql = "select * from Questions where qstType = ? and qstJidu= ?";
		doQuery(sql, qsttype,paperjidu);
		try {
			while (rs.next()) {
				Question question = new Question();
				question.setQstId(rs.getInt(1));
				question.setPaperId(rs.getInt(2));
				question.setQstType(rs.getInt(3));
				question.setQstTitle(rs.getString(4));
				question.setQstOption(rs.getString(5));
				question.setQstAnswer(rs.getString(6));
				question.setQstJidu(rs.getInt(7));
				question.setQstCount(rs.getInt(8));
				questions.add(question);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		closeAll();
		return questions;
	}
	public List<Question> findQuestionsByPaperIdandfabu(int paperId,int paperCount) {
		// TODO Auto-generated method stub
		List<Question> questions = new ArrayList<Question>();
		getConn();
		String sql = "select * from Questions where paperId = ? and qstCount= ?";
		doQuery(sql, paperId);
		try {
			while (rs.next()) {
				Question question = new Question();
				question.setQstId(rs.getInt(1));
				question.setPaperId(rs.getInt(2));
				question.setQstType(rs.getInt(3));
				question.setQstTitle(rs.getString(4));
				question.setQstOption(rs.getString(5));
				question.setQstAnswer(rs.getString(6));
				question.setQstJidu(rs.getInt(7));
				question.setQstCount(rs.getInt(8));
				questions.add(question);
			}
		} catch (SQLException e) {
			System.out.println("List<Question> findQuestionsByPaperIdandfabu(int paperId,int paperCount)");
		}
		closeAll();
		return questions;
	}


}
