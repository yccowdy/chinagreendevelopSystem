package com.atoz.survey.dao;

import com.atoz.survey.po.Login;

public interface LoginDao {

	Login loginInfo(String userName, String userPassword); //11.29 role 登陆判断int userRole
}