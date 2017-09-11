package com.atoz.survey.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.atoz.survey.dao.LoginDao;
import com.atoz.survey.dao.mysqlimpl.LoginDaoImpl;
import com.atoz.survey.po.Login;
import com.atoz.survey.service.LoginService;

public class LoginServiceImpl implements LoginService {

	private LoginDaoImpl loginDao = new LoginDaoImpl();
	File file = new File("config.properties");
	Properties properties = new Properties();

	public Login loginInfo(String userName, String userPassword) {//11.29 role 登陆判断,int userRole
		// TODO Auto-generated method stub
		try {
			properties.load(new FileInputStream(file));
			String loginDaoString = properties.getProperty("loginDao");
			loginDao = (LoginDaoImpl) Class.forName(loginDaoString).newInstance();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return loginDao.loginInfo(userName, userPassword);//,userRole
	}
}
