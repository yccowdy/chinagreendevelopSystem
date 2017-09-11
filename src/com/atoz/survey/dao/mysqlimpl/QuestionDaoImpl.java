package com.atoz.survey.dao.mysqlimpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.atoz.survey.dao.QuestionDao;
import com.atoz.survey.po.Question;
import com.atoz.survey.po.User;

public class QuestionDaoImpl extends BaseDao implements QuestionDao {

	

	public List<Question> findQuestionsByPaperId(int paperId) {
		// TODO Auto-generated method stub
		List<Question> questions = new ArrayList<Question>();
		getConn();
		String sql = "select * from Questions where paperId = ?";
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
			System.out.println("package com.atoz.survey.dao.mysqlimpl");
		}
		closeAll();
		return questions;
	}
	public List<Question> findQuestionsByPaperIdandfabu(int paperId,int paperCount) {
		// TODO Auto-generated method stub
		List<Question> questions = new ArrayList<Question>();
		getConn();
		String sql = "select * from Questions where paperId = ? and qstCount= ?";
		doQuery(sql, paperId,paperCount);
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
	
	public List<Question> showResultByPaperId(int paperId) {
		// TODO Auto-generated method stub

		List<Question> questions = new ArrayList<Question>();
		getConn();
		String sql = "select * from Questions where paperId = ?";
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
			
			e.printStackTrace();
		}
		closeAll();
		return questions;
	}
	//12.1
	public List<Question> showResultByqstType(int qsttype) {
		// TODO Auto-generated method stub

		List<Question> questions = new ArrayList<Question>();
		getConn();
		String sql = "select * from Questions where qstType = ?";
		doQuery(sql, qsttype);
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
			
			e.printStackTrace();
		}
		closeAll();
		return questions;
	}
	public Question findOptionByQstTitle(int paperId,String QstTi){
		Question question = null;
		getConn();
		String sql = "SELECT * FROM Questions WHERE paperId = ? and qstTile= ?";
		doQuery(sql,paperId,QstTi);
		try {
			if(rs.next()){
				question = new Question();
				question.setQstId(rs.getInt(1));
				question.setPaperId(rs.getInt(2));
				question.setQstType(rs.getInt(3));
				question.setQstTitle(rs.getString(4));
				question.setQstOption(rs.getString(5));
				question.setQstAnswer(rs.getString(6));
				question.setQstJidu(rs.getInt(7));
				question.setQstCount(rs.getInt(8));
			}
		} catch (Exception e) {
			System.out.println("package com.atoz.survey.dao.mysqlimpl");
		}
		closeAll();
		return question;
	}
	
	public int addQuestions(Question question) {
		// TODO Auto-generated method stub
		getConn();
		String sql = "insert into Questions values(NULL,?,?,?,?,?,?,?)";
		doOperate(sql, question.getPaperId(), question.getQstType(), question.getQstTitle(), question.getQstOption(), question.getQstAnswer(),question.getQstJidu(),question.getQstCount());
		closeAll();
		return result;
	}
	//12.1
/*	public int addQuestionsandUser(Question question,int role){
		getConn();
		String sql = "insert into user_question values(NULL,?, ?, ?, ?,?)";
		doOperate(sql, question.getPaperId(), question.getQstType(), question.getQstTitle(), question.getQstOption(), question.getQstAnswer());
		closeAll();
		return 0;
	}*/
	public int updateQuestions(int questionId, String qstAnswer) {
		// TODO Auto-generated method stub
		getConn();
		String sql = "update Questions set qstAnswer = ? where qstId = ?";
		doOperate(sql, qstAnswer, questionId);
		closeAll();
		return result;
	}
	public int updateQuestionsjidu(int questionId, int qstJidu) {
		// TODO Auto-generated method stub
		getConn();
		String sql = "update Questions set qstJidu = ? where qstId = ?";
		doOperate(sql, qstJidu, questionId);
		closeAll();
		return result;
	}
	public int updatefabuBypaperId(int paperId, int qstCount) {
		// TODO Auto-generated method stub
		getConn();
		String sql = "update Questions set qstCount = ? where paperId = ?";
		doOperate(sql, qstCount, paperId);
		closeAll();
		return result;
	}
	public int updatefabuBytype(int type, int qstCount) {
		// TODO Auto-generated method stub
		getConn();
		String sql = "update Questions set qstCount = ? where qstType = ?";
		doOperate(sql, qstCount, type);
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

	public List<String> findQstAnswerByPaperId(int paperId) {
		// TODO Auto-generated method stub
		List<String> strings = new ArrayList<String>();

		getConn();
		String sql = "select qstId qstAnswer from Questions where paperId = ?";
		doQuery(sql, paperId);
		try {
			while (rs.next()) {
				String string = "";
				string += rs.getString(1);
			
				string += "&" + rs.getString(2);
				strings.add(string);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		closeAll();
		return strings;
	}

	public int deleteQusetionByPaperId(int paperId) {
		// TODO Auto-generated method stub
		getConn();
		String sql = "delete from Questions where paperId = ?";
		doOperate(sql, paperId);
		closeAll();
		return result;
	}
	//12.1
	public int deleteQusetionByPaperType(int papertype,int qstjidu) {
		// TODO Auto-generated method stub
		getConn();
		String sql = "delete from Questions where qstType = ? and qstJidu= ?";
		doOperate(sql, papertype,qstjidu);
		closeAll();

		return result;
	}
	@Override
	public List<Question> findQuestionsByqstandjiduandfabu(int qsttype,int paperjidu,int qstCount) {
		List<Question> questions = new ArrayList<Question>();
		getConn();
		String sql = "select * from Questions where qstType = ? and qstJidu= ? and qstCount= ?";
		doQuery(sql, qsttype,paperjidu,qstCount);
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
	@Override
	public List<Question> findQuestionsByqst(int qsttype) {
		List<Question> questions = new ArrayList<Question>();
		getConn();
		String sql = "select * from Questions where qstType = ?";
		doQuery(sql, qsttype);
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
				questions.add(question);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		closeAll();
		return questions;
	}

	public int modifybyqstId(int qstId, String qstTitle, String content,String qstAnswer,int paperCount) {
		getConn();
		String sql = "update Questions set qstTile = ? ,qstOption= ?, qstAnswer= ? ,qstCount= ? where qstId = ?";
		doOperate(sql, qstTitle,content,qstAnswer,paperCount, qstId);
		closeAll();
		return result;
	}
	
	


	
	
	

}
