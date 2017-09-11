package com.atoz.survey.po;
/**
 * JavaBean:User
 * 
 * @author SingleX
 *
 */
public class User {
	private int userId;//ID号
	private String userName;//用户名
	private String userPassword;//用户密码
	private String userIcon;//用户分数
	private String userMail;//邮箱
	private String userReg;//注册日期
	private String userSex;//政府公告
	private int userRole;//用户角色 
	private double userGrade;
	private String userSummary;//公司名称
	private String userArea;
	private String UserProv;
	private String userCity;
	private String userAdd;
	private String userZc;
	private String userType;
	private String userIntro;
	private String userShangshi;
	private String userPerson;
	private double userSpring;
	private double userSummer;
	private double userAut;
	private double userWin;
	private double userSspr;
	private double userSsm;
	private double userSa;
	private double userSw;
	private String userTime;
	private String userOrder;
	public String getUserZc() {
		return userZc;
	}
	public void setUserZc(String userZc) {
		this.userZc = userZc;
	}
	
	public String getUserTime() {
		return userTime;
	}
	public void setUserTime(String userTime) {
		this.userTime = userTime;
	}
	public String getUserOrder() {
		return userOrder;
	}
	public void setUserOrder(String userOrder) {
		this.userOrder = userOrder;
	}
	public double getUserSspr() {
		return userSspr;
	}
	public void setUserSspr(double userSspr) {
		this.userSspr = userSspr;
	}
	public double getUserSsm() {
		return userSsm;
	}
	public void setUserSsm(double userSsm) {
		this.userSsm = userSsm;
	}
	public double getUserSa() {
		return userSa;
	}
	public void setUserSa(double userSa) {
		this.userSa = userSa;
	}
	public double getUserSw() {
		return userSw;
	}
	public void setUserSw(double userSw) {
		this.userSw = userSw;
	}

	public double getUserSpring() {
		return userSpring;
	}
	public void setUserSpring(double userSpring) {
		this.userSpring = userSpring;
	}
	public double getUserSummer() {
		return userSummer;
	}
	public void setUserSummer(double userSummer) {
		this.userSummer = userSummer;
	}
	public double getUserAut() {
		return userAut;
	}
	public void setUserAut(double userAut) {
		this.userAut = userAut;
	}
	public double getUserWin() {
		return userWin;
	}
	public void setUserWin(double userWin) {
		this.userWin = userWin;
	}
	
	
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getUserIntro() {
		return userIntro;
	}
	public void setUserIntro(String userIntro) {
		this.userIntro = userIntro;
	}
	public String getUserShangshi() {
		return userShangshi;
	}
	public void setUserShangshi(String userShangshi) {
		this.userShangshi = userShangshi;
	}
	public String getUserPerson() {
		return userPerson;
	}
	public void setUserPerson(String userPerson) {
		this.userPerson = userPerson;
	}

	public String getUserAdd() {
		return userAdd;
	}
	public void setUserAdd(String userAdd) {
		this.userAdd = userAdd;
	}
	public String getUserProv() {
		return UserProv;
	}
	public void setUserProv(String userProv) {
		UserProv = userProv;
	}
	
	public String getUserCity() {
		return userCity;
	}
	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}
	
	public String getUserArea() {
		return userArea;
	}
	public void setUserArea(String userArea) {
		this.userArea = userArea;
	}
	public String getUserSummary() {
		return userSummary;
	}
	public void setUserSummary(String userSummary) {
		this.userSummary = userSummary;
	}
	public double getUserGrade() {
		return userGrade;
	}
	public void setUserGrade(double userGrade) {
		this.userGrade = userGrade;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserIcon() {
		return userIcon;
	}
	public void setUserIcon(String userIcon) {
		this.userIcon = userIcon;
	}
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public String getUserReg() {
		return userReg;
	}
	public void setUserReg(String userReg) {
		this.userReg = userReg;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public int getUserRole() {
		return userRole;
	}
	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}
	public User(int userId, String userName, String userPassword, String userIcon, String userMail, String userReg, String userSex, int userRole,double userGrade,String userSummary,String userArea,String UserProv,String userCity,String userAdd,String userZc,String userPerson,String userType,String userIntro,String userShangshi,double userSpring,double userSummer,double userAut,double userWin,double userSspr,double userSsm,double userSa,double userSw,String userTime,String userOrder) {
		super();
		this.userIntro=userIntro;
		this.userShangshi=userShangshi;
		this.userType=userType;
		this.userZc=userZc;
		this.userPerson=userPerson;
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userIcon = userIcon;
		this.userMail = userMail;
		this.userReg = userReg;
		this.userSex = userSex;
		this.userRole = userRole;
		this.userGrade=userGrade;
		this.userSummary=userSummary;
		this.userArea=userArea;
		this.userAdd=userAdd;
		this.userAut=userAut;
		this.userCity=userCity;
		this.userIntro=userIntro;
		this.userPerson=userPerson;
		this.UserProv=UserProv;
		this.userShangshi=userShangshi;
		this.userSpring=userSpring;
		this.userSummer=userSummer;
		this.userType=userType;
		this.userWin=userWin;
		this.userZc=userZc;
		this.userSsm=userSsm;
		this.userSspr=userSspr;
		this.userSa=userSa;
		this.userSw=userSw;
		this.userOrder=userOrder;
		this.userTime=userTime;
	}
	public User() {
		super();
		
	}
	
	
}
