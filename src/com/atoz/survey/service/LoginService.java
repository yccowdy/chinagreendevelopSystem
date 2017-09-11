package com.atoz.survey.service;

import com.atoz.survey.po.Login;

public interface LoginService {
	
	Login loginInfo(String userName, String userPassword);//11.29 role 登陆判断,int userRole
	
}
