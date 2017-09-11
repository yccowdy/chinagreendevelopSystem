package com.atoz.survey.dao.mysqlimpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.atoz.survey.dao.UserDao;
import com.atoz.survey.po.User;

public class UserDaoImpl extends BaseDao implements UserDao {

	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		List<User> users = new ArrayList<User>();
		getConn();
		String sql = "select * from Users ";
		doQuery(sql);
		try {
			while (rs.next()) {
				User user = new User();
				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setUserPassword(rs.getString(3));
				user.setUserIcon(rs.getString(4));
				user.setUserMail(rs.getString(5));
				user.setUserReg(rs.getString(6));
				user.setUserSex(rs.getString(7));
				user.setUserRole(rs.getInt(8));
				user.setUserGrade(rs.getInt(9));
				user.setUserSummary(rs.getString(10));
				user.setUserArea(rs.getString(11));				
				user.setUserProv(rs.getString(12));
				user.setUserCity(rs.getString(13));
				user.setUserAdd(rs.getString(14));
				user.setUserZc(rs.getString(15));
				user.setUserPerson(rs.getString(16));
				user.setUserType(rs.getString(17));
				user.setUserIntro(rs.getString(18));
				user.setUserShangshi(rs.getString(19));
				user.setUserSpring(rs.getInt(20));
				user.setUserSummer(rs.getInt(21));
				user.setUserAut(rs.getInt(22));
				user.setUserWin(rs.getInt(23));
				user.setUserSspr(rs.getInt(24));
				user.setUserSsm(rs.getInt(25));
				user.setUserSa(rs.getInt(26));
				user.setUserSw(rs.getInt(27));
				users.add(user);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		closeAll();
		return users;
	}
	public List<User> findUserByChooseType(int chooseRole) {
		// TODO Auto-generated method stub
		List<User> users = new ArrayList<User>();
		getConn();
		String sql = "select * from Users WHERE userRole = ?";
		doQuery(sql,chooseRole);
		try {
			while (rs.next()) {
				User user = new User();
				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setUserPassword(rs.getString(3));
				user.setUserIcon(rs.getString(4));
				user.setUserMail(rs.getString(5));
				user.setUserReg(rs.getString(6));
				user.setUserSex(rs.getString(7));
				user.setUserRole(rs.getInt(8));
				user.setUserGrade(rs.getInt(9));
				user.setUserSummary(rs.getString(10));
				user.setUserArea(rs.getString(11));				
				user.setUserProv(rs.getString(12));
				user.setUserCity(rs.getString(13));
				user.setUserAdd(rs.getString(14));
				user.setUserZc(rs.getString(15));
				user.setUserPerson(rs.getString(16));
				user.setUserType(rs.getString(17));
				user.setUserIntro(rs.getString(18));
				user.setUserShangshi(rs.getString(19));
				user.setUserSpring(rs.getInt(20));
				user.setUserSummer(rs.getInt(21));
				user.setUserAut(rs.getInt(22));
				user.setUserWin(rs.getInt(23));
				user.setUserSspr(rs.getInt(24));
				user.setUserSsm(rs.getInt(25));
				user.setUserSa(rs.getInt(26));
				user.setUserSw(rs.getInt(27));
				users.add(user);
			}
		} catch (Exception e) {
System.out.println("package com.atoz.survey.dao.mysqlimpl");
		}
		closeAll();
		return users;
	}
	public List<User> findUserByAreaandRole(int chooseRole,String userArea) {
		// TODO Auto-generated method stub
		List<User> users = new ArrayList<User>();
		getConn();
		String sql = "select * from Users WHERE userRole=? and userArea= ?";
		doQuery(sql,chooseRole,userArea);
		try {
			while (rs.next()) {
				User user = new User();
				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setUserPassword(rs.getString(3));
				user.setUserIcon(rs.getString(4));
				user.setUserMail(rs.getString(5));
				user.setUserReg(rs.getString(6));
				user.setUserSex(rs.getString(7));
				user.setUserRole(rs.getInt(8));
				user.setUserGrade(rs.getInt(9));
				user.setUserSummary(rs.getString(10));
				user.setUserArea(rs.getString(11));				
				user.setUserProv(rs.getString(12));
				user.setUserCity(rs.getString(13));
				user.setUserAdd(rs.getString(14));
				user.setUserZc(rs.getString(15));
				user.setUserPerson(rs.getString(16));
				user.setUserType(rs.getString(17));
				user.setUserIntro(rs.getString(18));
				user.setUserShangshi(rs.getString(19));
				user.setUserSpring(rs.getInt(20));
				user.setUserSummer(rs.getInt(21));
				user.setUserAut(rs.getInt(22));
				user.setUserWin(rs.getInt(23));
				user.setUserSspr(rs.getInt(24));
				user.setUserSsm(rs.getInt(25));
				user.setUserSa(rs.getInt(26));
				user.setUserSw(rs.getInt(27));
				users.add(user);
			}
		} catch (Exception e) {
System.out.println("package com.atoz.survey.dao.mysqlimpl");
		}
		closeAll();
		return users;
	}
	public List<User> findUserByArea(String userArea) {
		// TODO Auto-generated method stub
		List<User> users = new ArrayList<User>();
		getConn();
		String sql = "select * from Users WHERE userArea= ?";
		doQuery(sql,userArea);
		try {
			while (rs.next()) {
				User user = new User();
				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setUserPassword(rs.getString(3));
				user.setUserIcon(rs.getString(4));
				user.setUserMail(rs.getString(5));
				user.setUserReg(rs.getString(6));
				user.setUserSex(rs.getString(7));
				user.setUserRole(rs.getInt(8));
				user.setUserGrade(rs.getInt(9));
				user.setUserSummary(rs.getString(10));
				user.setUserArea(rs.getString(11));				
				user.setUserProv(rs.getString(12));
				user.setUserCity(rs.getString(13));
				user.setUserAdd(rs.getString(14));
				user.setUserZc(rs.getString(15));
				user.setUserPerson(rs.getString(16));
				user.setUserType(rs.getString(17));
				user.setUserIntro(rs.getString(18));
				user.setUserShangshi(rs.getString(19));
				user.setUserSpring(rs.getInt(20));
				user.setUserSummer(rs.getInt(21));
				user.setUserAut(rs.getInt(22));
				user.setUserWin(rs.getInt(23));
				user.setUserSspr(rs.getInt(24));
				user.setUserSsm(rs.getInt(25));
				user.setUserSa(rs.getInt(26));
				user.setUserSw(rs.getInt(27));
				users.add(user);
			}
		} catch (Exception e) {
System.out.println("package com.atoz.survey.dao.mysqlimplArea");
		}
		closeAll();
		return users;
	}
	public List<User> findUserByProv(String userArea) {
		// TODO Auto-generated method stub
		List<User> users = new ArrayList<User>();
		getConn();
		String sql = "select * from Users WHERE userProv= ?";
		doQuery(sql,userArea);
		try {
			while (rs.next()) {
				User user = new User();
				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setUserPassword(rs.getString(3));
				user.setUserIcon(rs.getString(4));
				user.setUserMail(rs.getString(5));
				user.setUserReg(rs.getString(6));
				user.setUserSex(rs.getString(7));
				user.setUserRole(rs.getInt(8));
				user.setUserGrade(rs.getInt(9));
				user.setUserSummary(rs.getString(10));
				user.setUserArea(rs.getString(11));				
				user.setUserProv(rs.getString(12));
				user.setUserCity(rs.getString(13));
				user.setUserAdd(rs.getString(14));
				user.setUserZc(rs.getString(15));
				user.setUserPerson(rs.getString(16));
				user.setUserType(rs.getString(17));
				user.setUserIntro(rs.getString(18));
				user.setUserShangshi(rs.getString(19));
				user.setUserSpring(rs.getInt(20));
				user.setUserSummer(rs.getInt(21));
				user.setUserAut(rs.getInt(22));
				user.setUserWin(rs.getInt(23));
				user.setUserSspr(rs.getInt(24));
				user.setUserSsm(rs.getInt(25));
				user.setUserSa(rs.getInt(26));
				user.setUserSw(rs.getInt(27));
				users.add(user);
			}
		} catch (Exception e) {
System.out.println("package com.atoz.survey.dao.mysqlimplPro");
		}
		closeAll();
		return users;
	}
	public List<User> findUserByProvandRole(int chooseRole, String userArea) {
		// TODO Auto-generated method stub
		List<User> users = new ArrayList<User>();
		getConn();
		String sql = "select * from Users WHERE userRole= ? and userProv= ?";
		doQuery(sql,chooseRole,userArea);
		try {
			while (rs.next()) {
				User user = new User();
				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setUserPassword(rs.getString(3));
				user.setUserIcon(rs.getString(4));
				user.setUserMail(rs.getString(5));
				user.setUserReg(rs.getString(6));
				user.setUserSex(rs.getString(7));
				user.setUserRole(rs.getInt(8));
				user.setUserGrade(rs.getInt(9));
				user.setUserSummary(rs.getString(10));
				user.setUserArea(rs.getString(11));				
				user.setUserProv(rs.getString(12));
				user.setUserCity(rs.getString(13));
				user.setUserAdd(rs.getString(14));
				user.setUserZc(rs.getString(15));
				user.setUserPerson(rs.getString(16));
				user.setUserType(rs.getString(17));
				user.setUserIntro(rs.getString(18));
				user.setUserShangshi(rs.getString(19));
				user.setUserSpring(rs.getInt(20));
				user.setUserSummer(rs.getInt(21));
				user.setUserAut(rs.getInt(22));
				user.setUserWin(rs.getInt(23));
				user.setUserSspr(rs.getInt(24));
				user.setUserSsm(rs.getInt(25));
				user.setUserSa(rs.getInt(26));
				user.setUserSw(rs.getInt(27));
				users.add(user);
			}
		} catch (Exception e) {
System.out.println("package com.atoz.survey.dao.mysqlimplProandRole");
		}
		closeAll();
		return users;
	}
	public List<User> findUserByCity(String userArea) {
		// TODO Auto-generated method stub
		List<User> users = new ArrayList<User>();
		getConn();
		String sql = "select * from Users WHERE userCity= ?";
		doQuery(sql,userArea);
		try {
			while (rs.next()) {
				User user = new User();
				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setUserPassword(rs.getString(3));
				user.setUserIcon(rs.getString(4));
				user.setUserMail(rs.getString(5));
				user.setUserReg(rs.getString(6));
				user.setUserSex(rs.getString(7));
				user.setUserRole(rs.getInt(8));
				user.setUserGrade(rs.getInt(9));
				user.setUserSummary(rs.getString(10));
				user.setUserArea(rs.getString(11));				
				user.setUserProv(rs.getString(12));
				user.setUserCity(rs.getString(13));
				user.setUserAdd(rs.getString(14));
				user.setUserZc(rs.getString(15));
				user.setUserPerson(rs.getString(16));
				user.setUserType(rs.getString(17));
				user.setUserIntro(rs.getString(18));
				user.setUserShangshi(rs.getString(19));
				user.setUserSpring(rs.getInt(20));
				user.setUserSummer(rs.getInt(21));
				user.setUserAut(rs.getInt(22));
				user.setUserWin(rs.getInt(23));
				user.setUserSspr(rs.getInt(24));
				user.setUserSsm(rs.getInt(25));
				user.setUserSa(rs.getInt(26));
				user.setUserSw(rs.getInt(27));
				users.add(user);
			}
		} catch (Exception e) {
System.out.println("package com.atoz.survey.dao.mysqlimplCity");
		}
		closeAll();
		return users;
	}
	public List<User> findUserByCityandRole(int chooseRole, String userArea) {
		// TODO Auto-generated method stub
		List<User> users = new ArrayList<User>();
		getConn();
		String sql = "select * from Users WHERE userRole=? and userCity= ?";
		doQuery(sql,chooseRole,userArea);
		try {
			while (rs.next()) {
				User user = new User();
				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setUserPassword(rs.getString(3));
				user.setUserIcon(rs.getString(4));
				user.setUserMail(rs.getString(5));
				user.setUserReg(rs.getString(6));
				user.setUserSex(rs.getString(7));
				user.setUserRole(rs.getInt(8));
				user.setUserGrade(rs.getInt(9));
				user.setUserSummary(rs.getString(10));
				user.setUserArea(rs.getString(11));				
				user.setUserProv(rs.getString(12));
				user.setUserCity(rs.getString(13));
				user.setUserAdd(rs.getString(14));
				user.setUserZc(rs.getString(15));
				user.setUserPerson(rs.getString(16));
				user.setUserType(rs.getString(17));
				user.setUserIntro(rs.getString(18));
				user.setUserShangshi(rs.getString(19));
				user.setUserSpring(rs.getInt(20));
				user.setUserSummer(rs.getInt(21));
				user.setUserAut(rs.getInt(22));
				user.setUserWin(rs.getInt(23));
				user.setUserSspr(rs.getInt(24));
				user.setUserSsm(rs.getInt(25));
				user.setUserSa(rs.getInt(26));
				user.setUserSw(rs.getInt(27));
				users.add(user);
			}
		} catch (Exception e) {
System.out.println("package com.atoz.survey.dao.mysqlimplCityandRole");
		}
		closeAll();
		return users;
	}
	
	
	
	
	
	public List<User> findotherUsers() {
		// TODO Auto-generated method stub
		List<User> users = new ArrayList<User>();
		getConn();
		String sql = "select * from Users";
		doQuery(sql);
		try {
			while (rs.next()) {
				User user = new User();
				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setUserPassword(rs.getString(3));
				user.setUserIcon(rs.getString(4));
				user.setUserMail(rs.getString(5));
				user.setUserReg(rs.getString(6));
				user.setUserSex(rs.getString(7));
				user.setUserRole(rs.getInt(8));
				user.setUserGrade(rs.getInt(9));
				user.setUserSummary(rs.getString(10));
				user.setUserArea(rs.getString(11));				
				user.setUserProv(rs.getString(12));
				user.setUserCity(rs.getString(13));
				user.setUserAdd(rs.getString(14));
				user.setUserZc(rs.getString(15));
				user.setUserPerson(rs.getString(16));
				user.setUserType(rs.getString(17));
				user.setUserIntro(rs.getString(18));
				user.setUserShangshi(rs.getString(19));
				user.setUserSpring(rs.getInt(20));
				user.setUserSummer(rs.getInt(21));
				user.setUserAut(rs.getInt(22));
				user.setUserWin(rs.getInt(23));
				user.setUserSspr(rs.getInt(24));
				user.setUserSsm(rs.getInt(25));
				user.setUserSa(rs.getInt(26));
				user.setUserSw(rs.getInt(27));
				users.add(user);
			}
		} catch (Exception e) {
			System.out.println("package com.atoz.survey.dao.mysqlimpl");
		}
		closeAll();
		return users;
	}
	public List<User> findSortUserthreeProv(int chooseRole,String userProv){
		List<User> users = new ArrayList<User>();
		getConn();
		String sql = "select * from Users WHERE userRole = ? and userProv= ? order by userWin desc";
		doQuery(sql,chooseRole,userProv);
		try {
			while (rs.next()) {
				User user = new User();
				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setUserPassword(rs.getString(3));
				user.setUserIcon(rs.getString(4));
				user.setUserMail(rs.getString(5));
				user.setUserReg(rs.getString(6));
				user.setUserSex(rs.getString(7));
				user.setUserRole(rs.getInt(8));
				user.setUserGrade(rs.getInt(9));
				user.setUserSummary(rs.getString(10));
				user.setUserArea(rs.getString(11));				
				user.setUserProv(rs.getString(12));
				user.setUserCity(rs.getString(13));
				user.setUserAdd(rs.getString(14));
				user.setUserZc(rs.getString(15));
				user.setUserPerson(rs.getString(16));
				user.setUserType(rs.getString(17));
				user.setUserIntro(rs.getString(18));
				user.setUserShangshi(rs.getString(19));
				user.setUserSpring(rs.getInt(20));
				user.setUserSummer(rs.getInt(21));
				user.setUserAut(rs.getInt(22));
				user.setUserWin(rs.getInt(23));
				user.setUserSspr(rs.getInt(24));
				user.setUserSsm(rs.getInt(25));
				user.setUserSa(rs.getInt(26));
				user.setUserSw(rs.getInt(27));
				users.add(user);
			}
		} catch (Exception e) {
System.out.println("package com.atoz.survey.dao.mysqlimpl");
		}
		closeAll();
		return users;
	}

	public List<User> findSortUserthreeCity(int chooseRole,String userCity){
		List<User> users = new ArrayList<User>();
		getConn();
		String sql = "select * from Users WHERE userRole = ? and userCity= ? order by userWin desc";
		doQuery(sql,chooseRole,userCity);
		try {
			while (rs.next()) {
				User user = new User();
				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setUserPassword(rs.getString(3));
				user.setUserIcon(rs.getString(4));
				user.setUserMail(rs.getString(5));
				user.setUserReg(rs.getString(6));
				user.setUserSex(rs.getString(7));
				user.setUserRole(rs.getInt(8));
				user.setUserGrade(rs.getInt(9));
				user.setUserSummary(rs.getString(10));
				user.setUserArea(rs.getString(11));				
				user.setUserProv(rs.getString(12));
				user.setUserCity(rs.getString(13));
				user.setUserAdd(rs.getString(14));
				user.setUserZc(rs.getString(15));
				user.setUserPerson(rs.getString(16));
				user.setUserType(rs.getString(17));
				user.setUserIntro(rs.getString(18));
				user.setUserShangshi(rs.getString(19));
				user.setUserSpring(rs.getInt(20));
				user.setUserSummer(rs.getInt(21));
				user.setUserAut(rs.getInt(22));
				user.setUserWin(rs.getInt(23));
				user.setUserSspr(rs.getInt(24));
				user.setUserSsm(rs.getInt(25));
				user.setUserSa(rs.getInt(26));
				user.setUserSw(rs.getInt(27));
				users.add(user);
			}
		} catch (Exception e) {
System.out.println("package com.atoz.survey.dao.mysqlimpl");
		}
		closeAll();
		return users;
	}
		
	
	public List<User> findSortUserthreeArea(int chooseRole,String userArea){
		List<User> users = new ArrayList<User>();
		getConn();
		String sql = "select * from Users WHERE userRole = ? and userArea= ? order by userWin desc";
		doQuery(sql,chooseRole,userArea);
		try {
			while (rs.next()) {
				User user = new User();
				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setUserPassword(rs.getString(3));
				user.setUserIcon(rs.getString(4));
				user.setUserMail(rs.getString(5));
				user.setUserReg(rs.getString(6));
				user.setUserSex(rs.getString(7));
				user.setUserRole(rs.getInt(8));
				user.setUserGrade(rs.getInt(9));
				user.setUserSummary(rs.getString(10));
				user.setUserArea(rs.getString(11));				
				user.setUserProv(rs.getString(12));
				user.setUserCity(rs.getString(13));
				user.setUserAdd(rs.getString(14));
				user.setUserZc(rs.getString(15));
				user.setUserPerson(rs.getString(16));
				user.setUserType(rs.getString(17));
				user.setUserIntro(rs.getString(18));
				user.setUserShangshi(rs.getString(19));
				user.setUserSpring(rs.getInt(20));
				user.setUserSummer(rs.getInt(21));
				user.setUserAut(rs.getInt(22));
				user.setUserWin(rs.getInt(23));
				user.setUserSspr(rs.getInt(24));
				user.setUserSsm(rs.getInt(25));
				user.setUserSa(rs.getInt(26));
				user.setUserSw(rs.getInt(27));
				users.add(user);
			}
		} catch (Exception e) {
System.out.println("package com.atoz.survey.dao.mysqlimpl");
		}
		closeAll();
		return users;
	}

	public List<User> findSortUserProv(int chooseRole,String userProv) {
		// TODO Auto-generated method stub
		List<User> users = new ArrayList<User>();
		getConn();
		String sql = "select * from Users WHERE userRole = ? and userProv=? order by userSw desc";
		doQuery(sql,chooseRole,userProv);
		try {
			while (rs.next()) {
				User user = new User();
				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setUserPassword(rs.getString(3));
				user.setUserIcon(rs.getString(4));
				user.setUserMail(rs.getString(5));
				user.setUserReg(rs.getString(6));
				user.setUserSex(rs.getString(7));
				user.setUserRole(rs.getInt(8));
				user.setUserGrade(rs.getInt(9));
				user.setUserSummary(rs.getString(10));
				user.setUserArea(rs.getString(11));				
				user.setUserProv(rs.getString(12));
				user.setUserCity(rs.getString(13));
				user.setUserAdd(rs.getString(14));
				user.setUserZc(rs.getString(15));
				user.setUserPerson(rs.getString(16));
				user.setUserType(rs.getString(17));
				user.setUserIntro(rs.getString(18));
				user.setUserShangshi(rs.getString(19));
				user.setUserSpring(rs.getInt(20));
				user.setUserSummer(rs.getInt(21));
				user.setUserAut(rs.getInt(22));
				user.setUserWin(rs.getInt(23));
				user.setUserSspr(rs.getInt(24));
				user.setUserSsm(rs.getInt(25));
				user.setUserSa(rs.getInt(26));
				user.setUserSw(rs.getInt(27));
				users.add(user);
			}
		} catch (Exception e) {
System.out.println("package com.atoz.survey.dao.mysqlimpl");
		}
		closeAll();
		return users;
	}
	public List<User> findSortUserArea(int chooseRole,String userArea) {
		// TODO Auto-generated method stub
		List<User> users = new ArrayList<User>();
		getConn();
		String sql = "select * from Users WHERE userRole = ? and userArea=? order by userSw desc";
		doQuery(sql,chooseRole,userArea);
		try {
			while (rs.next()) {
				User user = new User();
				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setUserPassword(rs.getString(3));
				user.setUserIcon(rs.getString(4));
				user.setUserMail(rs.getString(5));
				user.setUserReg(rs.getString(6));
				user.setUserSex(rs.getString(7));
				user.setUserRole(rs.getInt(8));
				user.setUserGrade(rs.getInt(9));
				user.setUserSummary(rs.getString(10));
				user.setUserArea(rs.getString(11));				
				user.setUserProv(rs.getString(12));
				user.setUserCity(rs.getString(13));
				user.setUserAdd(rs.getString(14));
				user.setUserZc(rs.getString(15));
				user.setUserPerson(rs.getString(16));
				user.setUserType(rs.getString(17));
				user.setUserIntro(rs.getString(18));
				user.setUserShangshi(rs.getString(19));
				user.setUserSpring(rs.getInt(20));
				user.setUserSummer(rs.getInt(21));
				user.setUserAut(rs.getInt(22));
				user.setUserWin(rs.getInt(23));
				user.setUserSspr(rs.getInt(24));
				user.setUserSsm(rs.getInt(25));
				user.setUserSa(rs.getInt(26));
				user.setUserSw(rs.getInt(27));
				users.add(user);
			}
		} catch (Exception e) {
System.out.println("package com.atoz.survey.dao.mysqlimpl");
		}
		closeAll();
		return users;
	}
	public List<User> findSortUserCity(int chooseRole,String userCity) {
		// TODO Auto-generated method stub
		List<User> users = new ArrayList<User>();
		getConn();
		String sql = "select * from Users WHERE userRole = ? and userCity=? order by userSw desc";
		doQuery(sql,chooseRole,userCity);
		try {
			while (rs.next()) {
				User user = new User();
				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setUserPassword(rs.getString(3));
				user.setUserIcon(rs.getString(4));
				user.setUserMail(rs.getString(5));
				user.setUserReg(rs.getString(6));
				user.setUserSex(rs.getString(7));
				user.setUserRole(rs.getInt(8));
				user.setUserGrade(rs.getInt(9));
				user.setUserSummary(rs.getString(10));
				user.setUserArea(rs.getString(11));				
				user.setUserProv(rs.getString(12));
				user.setUserCity(rs.getString(13));
				user.setUserAdd(rs.getString(14));
				user.setUserZc(rs.getString(15));
				user.setUserPerson(rs.getString(16));
				user.setUserType(rs.getString(17));
				user.setUserIntro(rs.getString(18));
				user.setUserShangshi(rs.getString(19));
				user.setUserSpring(rs.getInt(20));
				user.setUserSummer(rs.getInt(21));
				user.setUserAut(rs.getInt(22));
				user.setUserWin(rs.getInt(23));
				user.setUserSspr(rs.getInt(24));
				user.setUserSsm(rs.getInt(25));
				user.setUserSa(rs.getInt(26));
				user.setUserSw(rs.getInt(27));
				users.add(user);
			}
		} catch (Exception e) {
System.out.println("package com.atoz.survey.dao.mysqlimpl");
		}
		closeAll();
		return users;
	}
	public User findUserByUserSummary(String userSummary) {
		User user = null;
		getConn();
		String sql = "SELECT * FROM Users WHERE userSummary = ?";
		doQuery(sql,userSummary);
		try {
			if(rs.next()){
				user = new User();
				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setUserPassword(rs.getString(3));
				user.setUserIcon(rs.getString(4));
				user.setUserMail(rs.getString(5));
				user.setUserReg(rs.getString(6));
				user.setUserSex(rs.getString(7));
				user.setUserRole(rs.getInt(8));
				user.setUserGrade(rs.getInt(9));
				user.setUserSummary(rs.getString(10));
				user.setUserArea(rs.getString(11));				
				user.setUserProv(rs.getString(12));
				user.setUserCity(rs.getString(13));
				user.setUserAdd(rs.getString(14));
				user.setUserZc(rs.getString(15));
				user.setUserPerson(rs.getString(16));
				user.setUserType(rs.getString(17));
				user.setUserIntro(rs.getString(18));
				user.setUserShangshi(rs.getString(19));
				user.setUserSpring(rs.getInt(20));
				user.setUserSummer(rs.getInt(21));
				user.setUserAut(rs.getInt(22));
				user.setUserWin(rs.getInt(23));
				user.setUserSspr(rs.getInt(24));
				user.setUserSsm(rs.getInt(25));
				user.setUserSa(rs.getInt(26));
				user.setUserSw(rs.getInt(27));
			}
		} catch (Exception e) {
			System.out.println("package com.atoz.survey.dao.mysqlimpl");
		}
		closeAll();
		return user;
	}
	public User findUserByUserId(int userId) {
		
		User user = null;
		getConn();
		String sql = "SELECT * FROM Users WHERE userId = ?";
		doQuery(sql, userId);
		try {
			if(rs.next()){
				user = new User();
				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setUserPassword(rs.getString(3));
				user.setUserIcon(rs.getString(4));
				user.setUserMail(rs.getString(5));
				user.setUserReg(rs.getString(6));
				user.setUserSex(rs.getString(7));
				user.setUserRole(rs.getInt(8));
				user.setUserGrade(rs.getInt(9));
				user.setUserSummary(rs.getString(10));
				user.setUserArea(rs.getString(11));				
				user.setUserProv(rs.getString(12));
				user.setUserCity(rs.getString(13));
				user.setUserAdd(rs.getString(14));
				user.setUserZc(rs.getString(15));
				user.setUserPerson(rs.getString(16));
				user.setUserType(rs.getString(17));
				user.setUserIntro(rs.getString(18));
				user.setUserShangshi(rs.getString(19));
				user.setUserSpring(rs.getInt(20));
				user.setUserSummer(rs.getInt(21));
				user.setUserAut(rs.getInt(22));
				user.setUserWin(rs.getInt(23));
				user.setUserSspr(rs.getInt(24));
				user.setUserSsm(rs.getInt(25));
				user.setUserSa(rs.getInt(26));
				user.setUserSw(rs.getInt(27));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		closeAll();
		return user;
	}	
	public User findUserByUserName(String userName) {
		User user = null;
		getConn();
		String sql = "SELECT * FROM Users WHERE userName = ?";
		doQuery(sql,userName);
		System.out.println("2");
		try {
			if(rs.next()){
				user = new User();
				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setUserPassword(rs.getString(3));
				user.setUserIcon(rs.getString(4));
				user.setUserMail(rs.getString(5));
				user.setUserReg(rs.getString(6));
				user.setUserSex(rs.getString(7));
				user.setUserRole(rs.getInt(8));
				user.setUserGrade(rs.getInt(9));
				user.setUserSummary(rs.getString(10));
				user.setUserArea(rs.getString(11));				
				user.setUserProv(rs.getString(12));
				user.setUserCity(rs.getString(13));
				user.setUserAdd(rs.getString(14));
				user.setUserZc(rs.getString(15));
				user.setUserPerson(rs.getString(16));
				user.setUserType(rs.getString(17));
				user.setUserIntro(rs.getString(18));
				user.setUserShangshi(rs.getString(19));
				user.setUserSpring(rs.getInt(20));
				user.setUserSummer(rs.getInt(21));
				user.setUserAut(rs.getInt(22));
				user.setUserWin(rs.getInt(23));
				user.setUserSspr(rs.getInt(24));
				user.setUserSsm(rs.getInt(25));
				user.setUserSa(rs.getInt(26));
				user.setUserSw(rs.getInt(27));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("package com.atoz.survey.dao.mysqlimpl");
		}
		closeAll();
		return user;
	}
	

	public int addUsers(User user) {
		    getConn();
			String sql = "INSERT INTO Users (userId,userName,userPassword,userIcon,userMail,userReg,userSex,userRole,userGrade,userSummary,userArea,userProv,userCity,userAdd,userZc,userPerson,userType,userIntro,userShangshi,userWin,userSw) values (NULL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			doOperate(sql, user.getUserName(), user.getUserPassword(),user.getUserIcon(),user.getUserMail(),user.getUserReg(),user.getUserSex(), user.getUserRole(), user.getUserGrade(),user.getUserSummary(),user.getUserArea(),user.getUserProv(),user.getUserCity(),user.getUserAdd(),user.getUserZc(),user.getUserPerson(),user.getUserType(),user.getUserIntro(),user.getUserShangshi(),user.getUserWin(),user.getUserSw());
	        closeAll();
		    return 0;
		
			}

	public int modifyComp(User user){
		getConn();
		String sql = "UPDATE Users SET userZc= ?,userPerson=?,userType=?,userIntro=?,userShangshi=? WHERE userId = ?";
		doOperate(sql,user.getUserZc(),user.getUserPerson(),user.getUserType(),user.getUserIntro(),user.getUserShangshi(),user.getUserId());
		closeAll();
		return 0;
	}
	
	public int modifyspUsers(User user){
		getConn();
		String sql = "UPDATE Users SET userSpring = ? WHERE userId = ?";//"UPDATE Users SET userIcon = concat(userIcon,',',?) WHERE userId = ?";
		doOperate(sql,user.getUserSpring(), user.getUserId());
		closeAll();
		return 0;
	}
	public int modifysspUsers(User user){
		getConn();
		String sql = "UPDATE Users SET userSspr = ? WHERE userId = ?";//"UPDATE Users SET userIcon = concat(userIcon,',',?) WHERE userId = ?";
		doOperate(sql,user.getUserSspr(), user.getUserId());
		closeAll();
		return 0;
	}
	public int modifysmUsers(User user){
		getConn();
		String sql = "UPDATE Users SET userSummer = ? WHERE userId = ?";//"UPDATE Users SET userIcon = concat(userIcon,',',?) WHERE userId = ?";
		doOperate(sql,user.getUserSummer(), user.getUserId());
		closeAll();
		return 0;
	}
	public int updatefabuBytype(int type, int qstCount) {
		// TODO Auto-generated method stub
		getConn();
		String sql = "update Users set userGrade = ? where userRole = ?";
		doOperate(sql, qstCount, type);
		closeAll();
		return result;
	}
	public int modifyssmUsers(User user){
		getConn();
		String sql = "UPDATE Users SET userSsm = ? WHERE userId = ?";//"UPDATE Users SET userIcon = concat(userIcon,',',?) WHERE userId = ?";
		doOperate(sql,user.getUserSsm(), user.getUserId());
		closeAll();
		return 0;
	}
	public int modifyauUsers(User user){
		getConn();
		String sql = "UPDATE Users SET userAut = ? WHERE userId = ?";//"UPDATE Users SET userIcon = concat(userIcon,',',?) WHERE userId = ?";
		doOperate(sql,user.getUserAut(), user.getUserId());
		closeAll();
		return 0;
	}
	public int modifysauUsers(User user){
		getConn();
		String sql = "UPDATE Users SET userSa = ? WHERE userId = ?";//"UPDATE Users SET userIcon = concat(userIcon,',',?) WHERE userId = ?";
		doOperate(sql,user.getUserSa(), user.getUserId());
		closeAll();
		return 0;
	}
	public int modifywiUsers(User user){
		getConn();
		String sql = "UPDATE Users SET userWin = ? WHERE userId = ?";//"UPDATE Users SET userIcon = concat(userIcon,',',?) WHERE userId = ?";
		doOperate(sql,user.getUserWin(), user.getUserId());
		closeAll();
		return 0;
	}
	public int modifyswiUsers(User user){
		getConn();
		String sql = "UPDATE Users SET userSw = ? WHERE userId = ?";//"UPDATE Users SET userIcon = concat(userIcon,',',?) WHERE userId = ?";
		doOperate(sql,user.getUserSw(), user.getUserId());
		closeAll();
		return 0;
	}
public int modifyUsers(User user) {
// TODO Auto-generated method stub
getConn();
String sql = "UPDATE Users SET userPassword = ?, userMail = ?,userSex = ? WHERE userId = ?";
doOperate(sql, user.getUserPassword(), user.getUserMail(),user.getUserSex(),  user.getUserId());
closeAll();
		return 0;
	}


public int modifygover(User user) {
	// TODO Auto-generated method stub
	getConn();
	String sql = "UPDATE Users SET userPassword = ?, userMail = ? WHERE userId = ?";
	System.out.println(sql);
	doOperate(sql, user.getUserPassword(), user.getUserMail(), user.getUserId());
	closeAll();
			return 0;
		}
	public int modifySexUsers(User user) {
		// TODO Auto-generated method stub
		getConn();
		String sql = "UPDATE Users SET userSex = ? WHERE userId = ?";
		doOperate(sql, user.getUserSex(),user.getUserId());
		closeAll();
		return 0;
	}
	public int modigradefyUsers(User user) {
		
		getConn();
		String sql = "UPDATE Users SET userIcon = ? WHERE userId = ?";//"UPDATE Users SET userIcon = concat(userIcon,',',?) WHERE userId = ?";
		doOperate(sql,user.getUserIcon(), user.getUserId());
		closeAll();
		return 0;
	}

	public int modifygradeUsers(User user) {
		
		getConn();
		String sql = "UPDATE Users SET userGrade = ? WHERE userId = ?";//"UPDATE Users SET userGrade = concat(userGrade,?) WHERE userId = ?"
		doOperate(sql,user.getUserGrade(), user.getUserId());
		closeAll();
		return 0;
	}
	

	public int deleteUsers(int userId) {
		// TODO Auto-generated method stub
		getConn();
		String sql = "DELETE FROM Users WHERE userId = ?";
		doOperate(sql, userId);
		closeAll();
		return 0;
	}

	public int modifyadminUsers(User user) {
		
		getConn();
		String sql = "UPDATE Users SET userPassword = ?,userMail = ? WHERE userId = ?";
		doOperate(sql,user.getUserPassword(),user.getUserMail(), user.getUserId());
		closeAll();
		
		return 0;
	}
	@Override
	public List<User> findUserSummary() {
		List<User> users = new ArrayList<User>();
		getConn();
		String sql = "select * from Users";
		doQuery(sql);
		try {
			while (rs.next()) {
				User user = new User();
				
				user.setUserSummary(rs.getString(10));
				
				users.add(user);
			}
		} catch (Exception e) {
System.out.println("package com.atoz.survey.dao.mysqlimplSummary");
		}
		closeAll();
		return users;
	}
	
	}
	
	


	

	
	
	

