//所有用户信息
package com.a.model;

public class UserBean {
	private int userId;
	private String userName;
	private String userPassword;
	private String userIcon;
	private int ID;
	private String userMail;
	private String userReg;
	private String userSex;
	private int userRole;
	private int userGrade;
	private String userSummary;
	private String userArea;
	private String userProv;
	private String userCity;	
	private String userAdd;
	private String userShangshi;
	private String userType;
	private String userPerson;
	public String getUserPerson() {
		return userPerson;
	}
	public void setUserPerson(String userPerson) {
		this.userPerson = userPerson;
	}
	private int userSpring;
	private int userSummer;
	private int userAut;
	private int userWin;
	private int userSspr;
	private int userSsm;
	private int userSa;
	private int userSw;
	private int userSelf;
	public UserBean(int id2, int sum, String daan, String grade,
			String paperStartDate,String Nm,String Dz,String Gm,String Lx,String Hy) {
		this.setUserId(id2);
		this.setUserSw(sum);
		this.setUserIcon(daan);
		this.setUserOrder(grade);
		this.setUserTime(paperStartDate);
		this.setUserSummary(Nm);
		this.setUserAdd(Dz);
		this.setUserShangshi(Gm); 
		this.setUserType(Lx);
		this.setUserPerson(Hy);
	}
	public UserBean(String Nm,String Dz,String Gm,String Lx,String Hy,int userSw) {
		
		this.setUserSummary(Nm);
		this.setUserAdd(Dz);
		this.setUserShangshi(Gm); 
		this.setUserType(Lx);
		this.setUserPerson(Hy);
		this.setUserSw(userSw);
	}
	public UserBean(String userName, String userPassword, String userMail,String userReg, String userSex, int userRole,String userSummary,String userArea,String userProv,String userCity,String userAdd,int userWin,int userSw) {
	
	
	   this.setUserName(userName);
	   this.setUserPassword(userPassword);
	   this.setUserMail(userMail);
	   this.setUserReg(userReg);
	   this.setUserSex(userSex);
	   this.setUserRole(userRole);
	   this.setUserSummary(userSummary);
	   this.setUserArea(userArea);
	   this.setUserProv(userProv);
	   this.setUserCity(userCity);
	   this.setUserAdd(userAdd);
	   this.setUserWin(userWin);
	   this.setUserSw(userSw);
	}
	public String getUserAdd() {
		return userAdd;
	}

	public void setUserAdd(String userAdd) {
		this.userAdd = userAdd;
	}
public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
public UserBean(){
		
	}
public String getUserType() {
	return userType;
}
public void setUserType(String userType) {
	this.userType = userType;
}
public String getUserShangshi() {
	return userShangshi;
}
public void setUserShangshi(String userShangshi) {
	this.userShangshi = userShangshi;
}
	public String getUserIcon() {
		return userIcon;
	}
	public void setUserIcon(String userIcon) {
		this.userIcon = userIcon;
	}
	
	public int getUserSelf() {
		return userSelf;
	}
	public void setUserSelf(int userSelf) {
		this.userSelf = userSelf;
	}
	private String userTime;
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
	private String userOrder;
	public int getUserSpring() {
		return userSpring;
	}
	public void setUserSpring(int userSpring) {
		this.userSpring = userSpring;
	}
	public int getUserSummer() {
		return userSummer;
	}
	public void setUserSummer(int userSummer) {
		this.userSummer = userSummer;
	}
	public int getUserAut() {
		return userAut;
	}
	public void setUserAut(int userAut) {
		this.userAut = userAut;
	}
	public int getUserWin() {
		return userWin;
	}
	public void setUserWin(int userWin) {
		this.userWin = userWin;
	}
	public int getUserSspr() {
		return userSspr;
	}
	public void setUserSspr(int userSspr) {
		this.userSspr = userSspr;
	}
	public int getUserSsm() {
		return userSsm;
	}
	public void setUserSsm(int userSsm) {
		this.userSsm = userSsm;
	}
	public int getUserSa() {
		return userSa;
	}
	public void setUserSa(int userSa) {
		this.userSa = userSa;
	}
	public int getUserSw() {
		return userSw;
	}
	public void setUserSw(int userSw) {
		this.userSw = userSw;
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
	public int getUserGrade() {
		return userGrade;
	}
	public void setUserGrade(int userGrade) {
		this.userGrade = userGrade;
	}
	public String getUserSummary() {
		return userSummary;
	}
	public void setUserSummary(String userSummary) {
		this.userSummary = userSummary;
	}
	public String getUserArea() {
		return userArea;
	}
	public void setUserArea(String userArea) {
		this.userArea = userArea;
	}
	public String getUserProv() {
		return userProv;
	}
	public void setUserProv(String userProv) {
		this.userProv = userProv;
	}
	public String getUserCity() {
		return userCity;
	}
	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}



}

