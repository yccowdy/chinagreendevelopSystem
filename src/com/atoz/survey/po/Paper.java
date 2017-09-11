package com.atoz.survey.po;
/**
 * JavaBean:Paper
 * 
 * @author SingleX
 *
 */
public class Paper {
	private int paperId;//问卷ID号
	private int userId;//用户ID
	private String paperTitle;//问卷一级指标
	private String paperSummary;//问卷二级指标
	private String paperStartDate;//问卷发布日期
	private String paperEndDate;//问卷结束日期
	private String paperBg;//问卷权重
	private int paperType;//问卷分类
	private int paperStatus;//问卷状态
	private int paperCount;//问卷回答次数
	private int paperJidu;//问卷回答次数
	private String paperBgsp;//问卷分类
	private String paperBgsm;//问卷状态
	private String paperBga;//问卷回答次数
	private String paperBgw;//问卷回答次数
	public String getPaperBgsp() {
		return paperBgsp;
	}
	public void setPaperBgsp(String paperBgsp) {
		this.paperBgsp = paperBgsp;
	}
	public String getPaperBgsm() {
		return paperBgsm;
	}
	public void setPaperBgsm(String paperBgsm) {
		this.paperBgsm = paperBgsm;
	}
	public String getPaperBga() {
		return paperBga;
	}
	public void setPaperBga(String paperBga) {
		this.paperBga = paperBga;
	}
	public String getPaperBgw() {
		return paperBgw;
	}
	public void setPaperBgw(String paperBgw) {
		this.paperBgw = paperBgw;
	}
	
	public int getPaperJidu() {
		return paperJidu;
	}
	public void setPaperJidu(int paperJidu) {
		this.paperJidu = paperJidu;
	}
	public int getPaperId() {
		return paperId;
	}
	public void setPaperId(int paperId) {
		this.paperId = paperId;
	}
	public String getPaperTitle() {
		return paperTitle;
	}
	public void setPaperTitle(String paperTitle) {
		this.paperTitle = paperTitle;
	}
	public String getPaperSummary() {
		return paperSummary;
	}
	public void setPaperSummary(String paperSummary) {
		this.paperSummary = paperSummary;
	}
	public String getPaperStartDate() {
		return paperStartDate;
	}
	public void setPaperStartDate(String paperStartDate) {
		this.paperStartDate = paperStartDate;
	}
	public String getPaperEndDate() {
		return paperEndDate;
	}
	public void setPaperEndDate(String paperEndDate) {
		this.paperEndDate = paperEndDate;
	}
	public String getPaperBg() {
		return paperBg;
	}
	public void setPaperBg(String paperBg) {
		this.paperBg = paperBg;
	}
	public int getPaperCount() {
		return paperCount;
	}
	public void setPaperCount(int paperCount) {
		this.paperCount = paperCount;
	}
	public int getPaperType() {
		return paperType;
	}
	public void setPaperType(int paperType) {
		this.paperType = paperType;
	}
	public int getPaperStatus() {
		return paperStatus;
	}
	public void setPaperStatus(int paperStatus) {
		this.paperStatus = paperStatus;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Paper(int paperId, int userId, String paperTitle, String paperSummary, String paperStartDate, String paperEndDate, String paperBg, int paperType, int paperStatus, int paperCount,int paperJidu,String paperBgsp,String paperBgsm,String paperBga,String paperBgw) {
		super();
		this.paperId = paperId;
		this.userId = userId;
		this.paperTitle = paperTitle;
		this.paperSummary = paperSummary;
		this.paperStartDate = paperStartDate;
		this.paperEndDate = paperEndDate;
		this.paperBg = paperBg;
		this.paperType = paperType;
		this.paperStatus = paperStatus;
		this.paperCount = paperCount;
		this.paperJidu=paperJidu;
		this.paperBgsp=paperBgsp;
		this.paperBgsm=paperBgsm;
		this.paperBga=paperBga;
		this.paperBgw=paperBgw;
	}
	public Paper() {
		super();
		// TODO Auto-generated constructor stub
	}
}
