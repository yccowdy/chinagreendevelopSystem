package com.atoz.survey.service;

import java.util.List;


import com.atoz.survey.po.User;

public interface UserService {
	
	List<User> findAllUsers();
	List<User> findotherUsers();
	User findUserByUserId(int userId);
	User findUserByUserName(String userName);
	int modifySexUsers(User user);
	User findUserByUserSummary(String userSummary);
	List<User> findSortUserProv(int chooseRole,String userProv);
	List<User> findSortUserCity(int chooseRole,String userCity);
	List<User> findSortUserArea(int chooseRole,String userArea);
	List<User> findSortUserthreeProv(int chooseRole,String userProv);
	List<User> findSortUserthreeCity(int chooseRole,String useCity);
	List<User> findSortUserthreeArea(int chooseRole,String userArea);
	//int addSelf(User user);
	int modifyComp(User user);
	int modifyspUsers(User user);
	int modifysmUsers(User user);
	int modifyauUsers(User user);
	int modifywiUsers(User user);
	int modifysspUsers(User user);
	int modifyssmUsers(User user);
	int modifysauUsers(User user);
	int modifyswiUsers(User user);
	int addUsers(User user);
	int modifyUsers(User user);
	int modigradefyUsers(User user);
	int modifygradeUsers(User user);
     int modifygover(User user);
     int deleteUsers(int userId);
	int modifyadminUsers(User user);
	List<User> findUserByChooseType(int chooseRole);
	List<User> findUserByArea(String userArea);
	List<User> findUserByAreaandRole(int chooseRole,String userArea);
	List<User> findUserByProv(String userArea);
	List<User> findUserSummary();
	List<User> findUserByProvandRole(int chooseRole,String userArea);
	List<User> findUserByCity(String userArea);
	List<User> findUserByCityandRole(int chooseRole,String userArea);
	int updatefabuBytype(int type, int qstCount);
}