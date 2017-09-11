package com.atoz.survey.po;
/**
 * JavaBean:Question
 * 
 * @author SingleX
 *
 */
public class Question {
	private int qstId;//题号ID
	private int paperId;//所属问卷ID
	private int qstType;//题目类型
	private String qstTitle;//题干
	private String qstOption;//选项
	private String qstAnswer;//统计结果
	private int qstJidu;//统计结果
	private int qstCount;
	public int getQstCount() {
		return qstCount;
	}
	public void setQstCount(int qstCount) {
		this.qstCount = qstCount;
	}
	public int getQstJidu() {
		return qstJidu;
	}
	public void setQstJidu(int qstJidu) {
		this.qstJidu = qstJidu;
	}
	public int getQstId() {
		return qstId;
	}
	public void setQstId(int qstId) {
		this.qstId = qstId;
	}
	public int getPaperId() {
		return paperId;
	}
	public void setPaperId(int paperId) {
		this.paperId = paperId;
	}
	public int getQstType() {
		return qstType;
	}
	public void setQstType(int qstType) {
		this.qstType = qstType;
	}
	public String getQstTitle() {
		return qstTitle;
	}
	public void setQstTitle(String qstTitle) {
		this.qstTitle = qstTitle;
	}
	public String getQstOption() {
		return qstOption;
	}
	public void setQstOption(String qstOption) {
		this.qstOption = qstOption;
	}
	public String getQstAnswer() {
		return qstAnswer;
	}
	public void setQstAnswer(String qstAnswer) {
		this.qstAnswer = qstAnswer;
	}
	public Question(int qstId, int paperId, int qstType, String qstTitle, String qstOption, String qstAnswer,int qstJidu,int qstCount) {
		super();
		this.qstId = qstId;
		this.paperId = paperId;
		this.qstType = qstType;
		this.qstTitle = qstTitle;
		this.qstOption = qstOption;
		this.qstAnswer = qstAnswer;
		this.qstJidu=qstJidu;
		this.qstCount=qstCount;
	}
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
}
