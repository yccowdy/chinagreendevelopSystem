package com.atoz.survey.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import com.atoz.survey.dao.UserDao;
import com.atoz.survey.dao.mysqlimpl.UserDaoImpl;

import com.atoz.survey.po.User;
import com.atoz.survey.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDaoImpl userDao = new UserDaoImpl();
	File file = new File("config.properties");
	Properties properties = new Properties();

	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		try {
			properties.load(new FileInputStream(file));
			String userDaoString = properties.getProperty("userDao");
			userDao = (UserDaoImpl) Class.forName(userDaoString).newInstance();
		} catch (Exception e) {
			System.out.println("List<User> findAllUsers()");
		}
		return userDao.findAllUsers();
	}
	public List<User> findUserByChooseType(int chooseRole) {
		// TODO Auto-generated method stub
		try {
			properties.load(new FileInputStream(file));
			String userDaoString = properties.getProperty("userDao");
			System.out.println(userDaoString);
			userDao = (UserDaoImpl) Class.forName(userDaoString).newInstance();
			System.out.println(userDao);
		} catch (Exception e) {
		
			System.out.println("List<User> findUserByChooseType(int chooseRole)");
		}
		return userDao.findUserByChooseType(chooseRole);
	}
	public List<User> findUserSummary() {
		// TODO Auto-generated method stub
		try {
			properties.load(new FileInputStream(file));
			String userDaoString = properties.getProperty("userDao");
			System.out.println(userDaoString);
			userDao = (UserDaoImpl) Class.forName(userDaoString).newInstance();
			System.out.println(userDao);
		} catch (Exception e) {
			
			System.out.println("List<User> findUserSummary()");
		}
		return userDao.findUserSummary();
	}
	
		public List<User> findUserByAreaandRole(int chooseRole,String userArea) {
		// TODO Auto-generated method stub
		try {
			properties.load(new FileInputStream(file));
			String userDaoString = properties.getProperty("userDao");
			System.out.println(userDaoString);
			userDao = (UserDaoImpl) Class.forName(userDaoString).newInstance();
			System.out.println(userDao);
		} catch (Exception e) {
			
			System.out.println("List<User> findUserByAreaandRole(int chooseRole,String userArea)");
		}
		return userDao.findUserByAreaandRole(chooseRole,userArea);
	}
	public List<User> findUserByArea(String userArea) {
		
		try {
			properties.load(new FileInputStream(file));
			String userDaoString = properties.getProperty("userDao");
			System.out.println(userDaoString);
			userDao = (UserDaoImpl) Class.forName(userDaoString).newInstance();
			System.out.println(userDao);
		} catch (Exception e) {
		
			System.out.println("List<User> findUserByArea(String userArea)");
		}
		return userDao.findUserByArea(userArea);
	}
	public List<User> findUserByProvandRole(int chooseRole,String userArea) {
		// TODO Auto-generated method stub
		try {
			properties.load(new FileInputStream(file));
			String userDaoString = properties.getProperty("userDao");
			System.out.println("userDaoString==="+userDaoString);
			userDao = (UserDaoImpl) Class.forName(userDaoString).newInstance();
			System.out.println(userDao);
		} catch (Exception e) {
			
			System.out.println("package com.atoz.survey.service.implProvandRole12111");
		}
		return userDao.findUserByProvandRole(chooseRole,userArea);
	}
	public List<User> findUserByProv(String userArea) {
		
		try {
			properties.load(new FileInputStream(file));
			String userDaoString = properties.getProperty("userDao");
			System.out.println(userDaoString);
			userDao = (UserDaoImpl) Class.forName(userDaoString).newInstance();
			System.out.println(userDao);
		} catch (Exception e) {
			
			System.out.println("List<User> findUserByProv(String userArea)");
		}
		return userDao.findUserByProv(userArea);
	}
	public List<User> findUserByCityandRole(int chooseRole,String userArea) {
		// TODO Auto-generated method stub
		try {
			properties.load(new FileInputStream(file));
			String userDaoString = properties.getProperty("userDao");
			System.out.println(userDaoString);
			userDao = (UserDaoImpl) Class.forName(userDaoString).newInstance();
			System.out.println(userDao);
		} catch (Exception e) {
		
			System.out.println(" List<User> findUserByCityandRole(int chooseRole,String userArea)");
		}
		return userDao.findUserByCityandRole(chooseRole,userArea);
	}
	public List<User> findUserByCity(String userArea) {
		
		try {
			properties.load(new FileInputStream(file));
			String userDaoString = properties.getProperty("userDao");
			System.out.println(userDaoString);
			userDao = (UserDaoImpl) Class.forName(userDaoString).newInstance();
			System.out.println(userDao);
		} catch (Exception e) {
		
			System.out.println("List<User> findUserByCity(String userArea)");
		}
		return userDao.findUserByCity(userArea);
	}
	public List<User> findotherUsers() {
		// TODO Auto-generated method stub
		try {
			properties.load(new FileInputStream(file));
			String userDaoString = properties.getProperty("userDao");
			userDao = (UserDaoImpl) Class.forName(userDaoString).newInstance();
		} catch (Exception e) {
			
			System.out.println("List<User> findotherUsers()");// TODO Auto-generated catch block
		}
		return userDao.findotherUsers();
	}
	
	public List<User> findSortUserCity(int chooseRole,String userCity){
		try {
			properties.load(new FileInputStream(file));
			String userDaoString = properties.getProperty("userDao");
			userDao = (UserDaoImpl) Class.forName(userDaoString).newInstance();
		} catch (Exception e) {
		
			System.out.println("List<User> findSortUserCity(int chooseRole,String userCity)");// TODO Auto-generated catch block
		}
		return userDao.findSortUserCity(chooseRole,userCity);
	}
	public List<User> findSortUserthreeArea(int chooseRole,String userArea){
		try {
			properties.load(new FileInputStream(file));
			String userDaoString = properties.getProperty("userDao");
			userDao = (UserDaoImpl) Class.forName(userDaoString).newInstance();
		} catch (Exception e) {
			
			System.out.println("List<User> findSortUserthreeArea(int chooseRole,String userArea)");// TODO Auto-generated catch block
		}
		return userDao.findSortUserthreeArea(chooseRole,userArea);
	}
	public List<User> findSortUserthreeCity(int chooseRole,String userCity){
		try {
			properties.load(new FileInputStream(file));
			String userDaoString = properties.getProperty("userDao");
			userDao = (UserDaoImpl) Class.forName(userDaoString).newInstance();
		} catch (Exception e) {
			
			System.out.println("List<User> findSortUserthreeArea(int chooseRole,String userArea)");// TODO Auto-generated catch block
		}
		return userDao.findSortUserthreeCity(chooseRole,userCity);
	}
	public List<User> findSortUserthreeProv(int chooseRole,String userProv){
		try {
			properties.load(new FileInputStream(file));
			String userDaoString = properties.getProperty("userDao");
			userDao = (UserDaoImpl) Class.forName(userDaoString).newInstance();
		} catch (Exception e) {
		
			System.out.println("List<User> findSortUserthreeProv(int chooseRole,String userProv)");// TODO Auto-generated catch block
		}
		return userDao.findSortUserthreeProv(chooseRole,userProv);
	}
	public List<User> findSortUserArea(int chooseRole,String userArea){
		try {
			properties.load(new FileInputStream(file));
			String userDaoString = properties.getProperty("userDao");
			userDao = (UserDaoImpl) Class.forName(userDaoString).newInstance();
		} catch (Exception e) {
			
			System.out.println("List<User> findSortUserArea(int chooseRole,String userArea)");// TODO Auto-generated catch block
		}
		return userDao.findSortUserArea(chooseRole,userArea);
	}
	@Override
	public List<User> findSortUserProv(int chooseRole, String userProv) {
		try {
			properties.load(new FileInputStream(file));
			String userDaoString = properties.getProperty("userDao");
			userDao = (UserDaoImpl) Class.forName(userDaoString).newInstance();
		} catch (Exception e) {
			
			System.out.println("List<User> findSortUserProv(int chooseRole, String userProv)");// TODO Auto-generated catch block
		}
		return userDao.findSortUserProv(chooseRole,userProv);
	}
	public User findUserByUserId(int userId) {
		
		try {
			properties.load(new FileInputStream(file));
			String userDaoString = properties.getProperty("userDao");
			userDao = (UserDaoImpl) Class.forName(userDaoString).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("User findUserByUserId(int userId)");
		}
		return userDao.findUserByUserId(userId);
	}

	public User findUserByUserName(String userName) {
		// TODO Auto-generated method stub
		try {
			properties.load(new FileInputStream(file));
			String userDaoString = properties.getProperty("userDao");
			userDao = (UserDaoImpl) Class.forName(userDaoString).newInstance();
		} catch (Exception e) {
			System.out.println("User findUserByUserName(String userName)");
		}
		return userDao.findUserByUserName(userName);
	}
	
	public User findUserByUserSummary(String userSummary) {
		// TODO Auto-generated method stub
		try {
			properties.load(new FileInputStream(file));
			String userDaoString = properties.getProperty("userDao");
			userDao = (UserDaoImpl) Class.forName(userDaoString).newInstance();
		} catch (Exception e) {
			System.out.println(" User findUserByUserSummary(String userSummary)");
		}
		return userDao.findUserByUserSummary(userSummary);
	}

	public int addUsers(User user) {
		// TODO Auto-generated method stub
		try {
			properties.load(new FileInputStream(file));
			String userDaoString = properties.getProperty("userDao");
			userDao = (UserDaoImpl) Class.forName(userDaoString).newInstance();//异常
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userDao.addUsers(user);
	}
	
//	public int addSelf(User user) {
//		// TODO Auto-generated method stub
//		try {
//			properties.load(new FileInputStream(file));
//			String userDaoString = properties.getProperty("userDao");
//			userDao = (UserDaoImpl) Class.forName(userDaoString).newInstance();//异常
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//		}
//		return userDao.addSelf(user);
//	}
	public int modifyUsers(User user) {
		// TODO Auto-generated method stub
		try {
			properties.load(new FileInputStream(file));
			String userDaoString = properties.getProperty("userDao");
			userDao = (UserDaoImpl) Class.forName(userDaoString).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return userDao.modifyUsers(user);
	}
	public int updatefabuBytype(int type, int qstCount) {
		// TODO Auto-generated method stub
		try {
			properties.load(new FileInputStream(file));
			String userDaoString = properties.getProperty("userDao");
			userDao = (UserDaoImpl) Class.forName(userDaoString).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return userDao.updatefabuBytype(type,qstCount);
	}
	
	public int modifyComp(User user) {
		// TODO Auto-generated method stub
		try {
			properties.load(new FileInputStream(file));
			String userDaoString = properties.getProperty("userDao");
			userDao = (UserDaoImpl) Class.forName(userDaoString).newInstance();
		} catch (Exception e) {
 System.out.println("modifyComp出错");
		}
		return userDao.modifyComp(user);
	}

	public int modigradefyUsers(User user) {
		// TODO Auto-generated method stub
		try {
			properties.load(new FileInputStream(file));
			String userDaoString = properties.getProperty("userDao");
			userDao = (UserDaoImpl) Class.forName(userDaoString).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return userDao.modigradefyUsers(user);
	}
	public int modifygover(User user) {
		// TODO Auto-generated method stub
		try {
			System.out.println(4567890);
			properties.load(new FileInputStream(file));
			String userDaoString = properties.getProperty("userDao");
			
			userDao = (UserDaoImpl) Class.forName(userDaoString).newInstance();
		} catch (Exception e) {
			System.out.println("int modifygover(User user)");
		}
		return userDao.modifygover(user);
	}
	public int modifysspUsers(User user) {
		// TODO Auto-generated method stub
		try {
			properties.load(new FileInputStream(file));
			String userDaoString = properties.getProperty("userDao");
			userDao = (UserDaoImpl) Class.forName(userDaoString).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return userDao.modifysspUsers(user);
	}
	public int modifyspUsers(User user) {
		// TODO Auto-generated method stub
		try {
			properties.load(new FileInputStream(file));
			String userDaoString = properties.getProperty("userDao");
			userDao = (UserDaoImpl) Class.forName(userDaoString).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return userDao.modifyspUsers(user);
	}
	
	public int modifysmUsers(User user) {
		// TODO Auto-generated method stub
		try {
			properties.load(new FileInputStream(file));
			String userDaoString = properties.getProperty("userDao");
			userDao = (UserDaoImpl) Class.forName(userDaoString).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return userDao.modifysmUsers(user);
	}
	
	public int modifyssmUsers(User user) {
		// TODO Auto-generated method stub
		try {
			properties.load(new FileInputStream(file));
			String userDaoString = properties.getProperty("userDao");
			userDao = (UserDaoImpl) Class.forName(userDaoString).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return userDao.modifyssmUsers(user);
	}
	
	public int modifyauUsers(User user) {
		// TODO Auto-generated method stub
		try {
			properties.load(new FileInputStream(file));
			String userDaoString = properties.getProperty("userDao");
			userDao = (UserDaoImpl) Class.forName(userDaoString).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return userDao.modifyauUsers(user);
	}
	
	public int modifysauUsers(User user) {
		// TODO Auto-generated method stub
		try {
			properties.load(new FileInputStream(file));
			String userDaoString = properties.getProperty("userDao");
			userDao = (UserDaoImpl) Class.forName(userDaoString).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return userDao.modifysauUsers(user);
	}
	
	public int modifywiUsers(User user) {
		// TODO Auto-generated method stub
		try {
			properties.load(new FileInputStream(file));
			String userDaoString = properties.getProperty("userDao");
			userDao = (UserDaoImpl) Class.forName(userDaoString).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return userDao.modifywiUsers(user);
	}
	
	public int modifyswiUsers(User user) {
		// TODO Auto-generated method stub
		try {
			properties.load(new FileInputStream(file));
			String userDaoString = properties.getProperty("userDao");
			userDao = (UserDaoImpl) Class.forName(userDaoString).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return userDao.modifyswiUsers(user);
	}
	
	public int modifygradeUsers(User user) {
		// TODO Auto-generated method stub
		try {
			properties.load(new FileInputStream(file));
			String userDaoString = properties.getProperty("userDao");
			userDao = (UserDaoImpl) Class.forName(userDaoString).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return userDao.modifygradeUsers(user);
	}
	
	public int modifySexUsers(User user) {
		// TODO Auto-generated method stub
		try {
			properties.load(new FileInputStream(file));
			String userDaoString = properties.getProperty("userDao");
			userDao = (UserDaoImpl) Class.forName(userDaoString).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return userDao.modifySexUsers(user);
	}
	public int modifyadminUsers(User user) {
		// TODO Auto-generated method stub
		try {
			properties.load(new FileInputStream(file));
			String userDaoString = properties.getProperty("userDao");
			userDao = (UserDaoImpl) Class.forName(userDaoString).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userDao.modifyadminUsers(user);
	}
	public int deleteUsers(int userId) {
		// TODO Auto-generated method stub
		try {
			properties.load(new FileInputStream(file));
			String userDaoString = properties.getProperty("userDao");
			userDao = (UserDaoImpl) Class.forName(userDaoString).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return userDao.deleteUsers(userId);
	}
	
	
}
