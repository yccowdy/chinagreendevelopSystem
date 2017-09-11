package com.atoz.survey.dao.mysqlimpl;

/**
 * Database BaseDao
 * 
 * @author SingleX
 */
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
	protected Connection conn;
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	protected int result;

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
			System.out.println("Loading Database Engine Failed !");
		}
	}

	/**
	 * Connect Database链接数据库
	 */
	public void getConn() {
	
		String url = "jdbc:mysql://localhost:3306/china?user=root&password=1234&useUnicode=true&characterEncoding=utf-8&autoReconnect=true&failOverReadOnly=false";
		try {
			conn = DriverManager.getConnection(url);
			System.out.println(conn);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(conn);
		}
	}
	public void closeAll() {
		try {
			if (pstmt != null && !pstmt.isClosed()) {
				pstmt.close();
			}
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Close Database Conn ERROR !");
		}
	}

	/**
	 * Database Query
	 */
	public void doQuery(String sql, Object... params) {
		try {
			pstmt = conn.prepareStatement(sql);
			if (pstmt != null) {
				for (int i = 0; i < params.length; i++) {
					pstmt.setObject(i + 1, params[i]);
				}
			}
			System.out.println("111");
			rs = pstmt.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Database Query ERROR !");
		}
	}

	/**
	 * Database Operate
	 */
	public void doOperate(String sql, Object... params) {
		try {
			pstmt = conn.prepareStatement(sql);
			if (pstmt != null) {
				for (int i = 0; i < params.length; i++) {
					pstmt.setObject(i + 1, params[i]);
				}
			}
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(sql);
			System.out.println("Database Operate ERROR !");
		}
	}

	/**
	 * Check If Exist Tables
	 */
	boolean existTable(String tableName) {
		DatabaseMetaData meta;
		try {
			meta = conn.getMetaData();
			ResultSet rs = meta.getTables(null, null, tableName, null);
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Check If Exits Tables Failed !");
		}
		return false;
	}	
}
