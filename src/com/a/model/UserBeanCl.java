


package com.a.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;



public class UserBeanCl {
	private Statement sm = null;  //PreparedStatement
	private ResultSet rs = null;
	private Connection ct = null;
	private PreparedStatement ps=null;
	//�ر���Դ����
	public void close(){
		try{
			if(rs!=null){
		    rs.close();
		    rs=null;
			}
			if(sm!=null){
				sm.close();
				sm=null;
			}
			if(ct!=null){
				ct.close();
				ct=null;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}


	public ArrayList show(String area,int hid){
		ArrayList list=new ArrayList();
		try {
			//int id=Integer.parseInt(hid);
			ct=(new ConnDB()).getConn();
			sm=ct.createStatement();
			System.out.println(hid);
			String sql="select * from Users where userRole ='"+hid+"' and userProv='"+area+"'";
			
			rs=sm.executeQuery(sql);
			System.out.println("rs===denghyu=="+rs);
			//List<String> score=new ArrayList<String>();
			while(rs.next()){
				UserBean ub=new UserBean();
				ub.setUserId(rs.getInt(1));
				ub.setUserName(rs.getString(2));
				//ub.setUserIcon(rs.getString(4));
				ub.setUserRole(rs.getInt(8));
				ub.setUserGrade(rs.getInt(9));
				ub.setUserSummary(rs.getString(10));
				ub.setUserArea(rs.getString(11));
				ub.setUserProv(rs.getString(12));
				ub.setUserCity(rs.getString(13));
				ub.setUserSpring(rs.getInt(20));
				ub.setUserSummer(rs.getInt(21));
				ub.setUserAut(rs.getInt(22));
				ub.setUserWin(rs.getInt(23));
				ub.setUserSpring(rs.getInt(24));
				ub.setUserSsm(rs.getInt(25));
				ub.setUserSa(rs.getInt(26));
				ub.setUserSw(rs.getInt(27));
				//score.add(rs.getString(2));
				list.add(ub);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			this.close();
		}
		return list;
	}
	public HashSet<UserBean> showpro(){
		HashSet<UserBean> hs = new HashSet<UserBean>();
		try {
			//int id=Integer.parseInt(hid);
			ct=(new ConnDB()).getConn();
			sm=ct.createStatement();

			String sql="select * from Users";
			
			rs=sm.executeQuery(sql);
			
			//List<String> score=new ArrayList<String>();
			while(rs.next()){
				UserBean ub=new UserBean();
				
				ub.setUserRole(rs.getInt(8));
				
				ub.setUserProv(rs.getString(12));
				
				hs.add(ub);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			this.close();
		}
		return hs;
	}
	public HashSet<UserBean> showproxj(){
		HashSet<UserBean> hs = new HashSet<UserBean>();
		
		try {
			//int id=Integer.parseInt(hid);
			ct=(new ConnDB()).getConn();
			sm=ct.createStatement();

			String sql="select * from Users";
			
			rs=sm.executeQuery(sql);
			
			//List<String> score=new ArrayList<String>();
			while(rs.next()){
				UserBean ub=new UserBean();
				ub.setUserProv(rs.getString(12));
				
				//score.add(rs.getString(2));
				hs.add(ub);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			this.close();
		}
		return hs;
	}
	public ArrayList showpromark(String pro){
		 ArrayList al=new ArrayList();
		try {
			//int id=Integer.parseInt(hid);
			ct=(new ConnDB()).getConn();
			sm=ct.createStatement();

			String sql="select * from Users where userProv='"+pro+"'";
			
			
			rs=sm.executeQuery(sql);
			System.out.println("rs===denghyu=="+rs);
			//List<String> score=new ArrayList<String>();
			while(rs.next()){
				UserBean ub=new UserBean();
				ub.setUserId(rs.getInt(1));
				ub.setUserName(rs.getString(2));
				//ub.setUserIcon(rs.getString(4));
				ub.setUserRole(rs.getInt(8));
				ub.setUserGrade(rs.getInt(9));
				ub.setUserSummary(rs.getString(10));
				ub.setUserArea(rs.getString(11));
				ub.setUserProv(rs.getString(12));
				ub.setUserCity(rs.getString(13));
				ub.setUserSpring(rs.getInt(20));
				ub.setUserSummer(rs.getInt(21));
				ub.setUserAut(rs.getInt(22));
				ub.setUserWin(rs.getInt(23));
				ub.setUserSpring(rs.getInt(24));
				ub.setUserSsm(rs.getInt(25));
				ub.setUserSa(rs.getInt(26));
				ub.setUserSw(rs.getInt(27));
				//score.add(rs.getString(2));
				al.add(ub);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			this.close();
		}
		return al;
	}
	public int addSelf(UserBean subBean){
	
		try {
			
			ct=new ConnDB().getConn();
			sm=ct.createStatement();			
			String sql="insert into mark(UserId, UserSelf, UserAns, UserOrder, UserTime,UserNm,UserDz,UserGm,UserLx,UserHy)values(?,?,?,?,?,?,?,?,?,?)";			
			ps = ct.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, subBean.getUserId());
			ps.setInt(2, subBean.getUserSw());
			ps.setString(3, subBean.getUserIcon());
			ps.setString(4, subBean.getUserOrder());
			ps.setString(5, subBean.getUserTime());
			ps.setString(6, subBean.getUserSummary());
			ps.setString(7, subBean.getUserAdd());
			ps.setString(8, subBean.getUserShangshi());
			ps.setString(9, subBean.getUserType());
			ps.setString(10, subBean.getUserPerson());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}finally{
			this.close();
		}
		return 1;
	}
	public ArrayList<UserBean> ExcelgetAllUser(){
		ArrayList<UserBean> al=new ArrayList<UserBean>();
	
		UserBean sb=null;
	
		
		//System.out.println(year);//11.3
		
		try {
			ct=new ConnDB().getConn();
			String sql="select * from mark";
			ps=ct.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
//				String[] ans=rs.getString(4).split(",");
//				for(int i=0;i<ans.length;i++){
//					answer.add(ans[i]);
//				}
				sb=new UserBean(rs.getString(7),
						rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getString(11),rs.getInt(3) 
						);
			//	2017.5.24   ycc
//				if(d!=null) date.setTime(d);//11.3
//				String y=date.get(Calendar.YEAR)+"";//获取对应ID的出题年份
//				System.out.println(y);//看是否获取到对应ID的出题年份并把打印出来.
//				if(y.equals(year))
//				{//比较年份是否相等 赋值
//					
//				}
				al.add(sb);
			}
			return al;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}finally{
			closeSourse();
		}
	}
	public void closeSourse(){
		try {
			if(this.rs!=null){
				this.rs.close();
				this.rs=null;
			}
			if(this.ps!=null){
				this.ps.close();
				this.ps=null;
			}
			if(this.ct!=null){
				this.ct.close();
				this.ct=null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int addQiye(UserBean subBean){
		
		try {
			
			ct=new ConnDB().getConn();
			String sql="insert into Users(userName,userPassword,userMail,userReg,userSex,userRole,userSummary,userArea,userProv,userCity,userAdd,userWin,userSw) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";			
			ps = ct.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, subBean.getUserName());
			ps.setString(2, subBean.getUserPassword());
			ps.setString(3, subBean.getUserMail());
			ps.setString(4, subBean.getUserReg());
			ps.setString(5, subBean.getUserSex());
			ps.setInt(6, subBean.getUserRole());
			ps.setString(7, subBean.getUserSummary());
			ps.setString(8, subBean.getUserArea());
			ps.setString(9, subBean.getUserProv());
			ps.setString(10, subBean.getUserCity());
			ps.setString(11, subBean.getUserAdd());
			ps.setInt(12, subBean.getUserWin());
			ps.setInt(13, subBean.getUserSw());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}finally{
			this.close();
		}
		return 1;
	}
	public ArrayList showtype(int type){
		ArrayList list=new ArrayList();
		try {
			//int id=Integer.parseInt(hid);
			ct=new ConnDB().getConn();
			sm=ct.createStatement();
			System.out.println(type);
			String sql="select * from Users where userRole ='"+type+"'";
			rs=sm.executeQuery(sql);
			while(rs.next()){
				UserBean ub=new UserBean();
				ub.setUserId(rs.getInt(1));
				ub.setUserName(rs.getString(2));
				ub.setUserIcon(rs.getString(4));
				ub.setUserRole(rs.getInt(8));
				ub.setUserGrade(rs.getInt(9));
				ub.setUserSummary(rs.getString(10));
				ub.setUserArea(rs.getString(11));
				ub.setUserProv(rs.getString(12));
				ub.setUserCity(rs.getString(13));
				ub.setUserSpring(rs.getInt(20));
				ub.setUserSummer(rs.getInt(21));
				ub.setUserAut(rs.getInt(22));
				ub.setUserWin(rs.getInt(23));
				ub.setUserSpring(rs.getInt(24));
				ub.setUserSsm(rs.getInt(25));
				ub.setUserSa(rs.getInt(26));
				ub.setUserSw(rs.getInt(27));
				//score.add(rs.getString(2));
				list.add(ub);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			this.close();
		}
		return list;
	}

}
