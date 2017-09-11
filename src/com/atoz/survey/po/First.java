package com.atoz.survey.po;

public class First {

	private int firstid;//问卷ID号
	private String paperTitle;//一级指标
	private int score;//问卷分
	private int weight;//问卷权重
	public int getFirstid() {
		return firstid;
	}
	public First(int firstid, String paperTitle, int score, int weight,
			int paperType) {
		super();
		this.firstid = firstid;
		this.paperTitle = paperTitle;
		this.score = score;
		this.weight = weight;
		this.paperType = paperType;
	}
	public First() {
		super();
	}
	public void setFirstid(int firstid) {
		this.firstid = firstid;
	}
	public String getPaperTitle() {
		return paperTitle;
	}
	public void setPaperTitle(String paperTitle) {
		this.paperTitle = paperTitle;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getPaperType() {
		return paperType;
	}
	public void setPaperType(int paperType) {
		this.paperType = paperType;
	}
	private int paperType;//问卷类型
}
