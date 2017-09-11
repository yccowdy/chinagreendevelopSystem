package com.atoz.survey.dao.mysqlimpl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.atoz.survey.dao.PaperDao;
import com.atoz.survey.po.Paper;

public class PaperDaoImpl extends BaseDao implements PaperDao {

	public List<Paper> findPapersBytitleandtype(String title,int type){
		List<Paper> papers = new ArrayList<Paper>();
		getConn();
		String sql = "select * from Papers where paperTitle= ? and paperType=?";
		
		doQuery(sql,title,type);
		try {
			while (rs.next()) {
				Paper paper = new Paper();
				paper.setPaperId(rs.getInt(1));
				paper.setUserId(rs.getInt(2));
				paper.setPaperTitle(rs.getString(3));
				paper.setPaperSummary(rs.getString(4));
				paper.setPaperStartDate(rs.getString(5));
				paper.setPaperEndDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(rs.getDate(6)));
				paper.setPaperBg(rs.getString(7));
				paper.setPaperType(rs.getInt(8));
				paper.setPaperStatus(rs.getInt(9));
				paper.setPaperCount(rs.getInt(10));
				paper.setPaperJidu(rs.getInt(11));
				paper.setPaperBgsp(rs.getString(12));
				paper.setPaperBgsm(rs.getString(13));
				paper.setPaperBga(rs.getString(14));
				paper.setPaperBgw(rs.getString(15));
				papers.add(paper); // 将paper添加进paperList中去。
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		closeAll();
		return papers;
	}
	public List<Paper> findPapersBytitleandtypeandjidu(String title,int type,int paperJidu){
		List<Paper> papers = new ArrayList<Paper>();
		getConn();
		String sql = "select * from Papers where paperTitle= ? and paperType=? and paperJidu= ?";		
		doQuery(sql,title,type,paperJidu);
		System.out.println("rs==="+rs);
		try {
			while (rs.next()) {
				Paper paper = new Paper();
				paper.setPaperId(rs.getInt(1));
				paper.setUserId(rs.getInt(2));
				paper.setPaperTitle(rs.getString(3));
				paper.setPaperSummary(rs.getString(4));
				paper.setPaperStartDate(rs.getString(5));
				paper.setPaperEndDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(rs.getDate(6)));
				paper.setPaperBg(rs.getString(7));
				paper.setPaperType(rs.getInt(8));
				paper.setPaperStatus(rs.getInt(9));
				paper.setPaperCount(rs.getInt(10));
				paper.setPaperJidu(rs.getInt(11));
				paper.setPaperBgsp(rs.getString(12));
				paper.setPaperBgsm(rs.getString(13));
				paper.setPaperBga(rs.getString(14));
				paper.setPaperBgw(rs.getString(15));
				papers.add(paper); // 将paper添加进paperList中去。
			}
		
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		closeAll();
		return papers;
	}
	
	public List<Paper> findAllPapers() {
		// TODO Auto-generated method stub
		List<Paper> papers = new ArrayList<Paper>();
		System.out.println("4");
		getConn();
		String sql = "select * from Papers";
		doQuery(sql);
		try {
			while (rs.next()) {
				Paper paper = new Paper();
				paper.setPaperId(rs.getInt(1));
				paper.setUserId(rs.getInt(2));
				paper.setPaperTitle(rs.getString(3));
				paper.setPaperSummary(rs.getString(4));
				paper.setPaperStartDate(rs.getString(5));
				paper.setPaperEndDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(rs.getDate(6)));
				paper.setPaperBg(rs.getString(7));
				paper.setPaperType(rs.getInt(8));
				paper.setPaperStatus(rs.getInt(9));
				paper.setPaperCount(rs.getInt(10));
				paper.setPaperJidu(rs.getInt(11));
				paper.setPaperBgsp(rs.getString(12));
				paper.setPaperBgsm(rs.getString(13));
				paper.setPaperBga(rs.getString(14));
				paper.setPaperBgw(rs.getString(15));
				papers.add(paper); // 将paper添加进paperList中去。
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		closeAll();
		return papers;
	}

	public List<Paper> findPaperByUserId(int userId) {
		// TODO Auto-generated method stub
		List<Paper> papers = new ArrayList<Paper>(); // 当存在paper对象是再建立paper对象。先置空。
		getConn();
		String sql = "select * from Papers where userId  = ?";
		doQuery(sql, userId);
		try {
			while (rs.next()) {
				Paper paper = new Paper();
				paper.setPaperId(rs.getInt(1));
				paper.setUserId(rs.getInt(2));
				paper.setPaperTitle(rs.getString(3));
				paper.setPaperSummary(rs.getString(4));
				paper.setPaperStartDate(rs.getString(5));
				paper.setPaperEndDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(rs.getDate(6)));
				paper.setPaperBg(rs.getString(7));
				paper.setPaperType(rs.getInt(8));
				paper.setPaperStatus(rs.getInt(9));
				paper.setPaperCount(rs.getInt(10));
				paper.setPaperJidu(rs.getInt(11));
				paper.setPaperBgsp(rs.getString(12));
				paper.setPaperBgsm(rs.getString(13));
				paper.setPaperBga(rs.getString(14));
				paper.setPaperBgw(rs.getString(15));
				papers.add(paper); // 将paper添加进paperList中去。
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		closeAll();
		return papers;
	}
	public List<Paper> findPaperIdBySummaryandTitleandfabu(String paperTitle,String paperSummary,int paperCount) {
		List<Paper> papers = new ArrayList<Paper>();
		// TODO Auto-generated method stub
		getConn();
		String sql = "select * from Papers where paperTitle = ? and paperSummary= ? and paperCount= ?";
		doQuery(sql,paperTitle,paperSummary,paperCount);
		try {
			while (rs.next()) {
				Paper paper = new Paper();
				paper.setPaperId(rs.getInt(1));
				paper.setUserId(rs.getInt(2));
				paper.setPaperTitle(rs.getString(3));
				paper.setPaperSummary(rs.getString(4));
				paper.setPaperStartDate(rs.getString(5));
				paper.setPaperEndDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(rs.getDate(6)));
				paper.setPaperBg(rs.getString(7));
				paper.setPaperType(rs.getInt(8));
				paper.setPaperStatus(rs.getInt(9));
				paper.setPaperCount(rs.getInt(10));
				paper.setPaperJidu(rs.getInt(11));
				paper.setPaperBgsp(rs.getString(12));
				paper.setPaperBgsm(rs.getString(13));
				paper.setPaperBga(rs.getString(14));
				paper.setPaperBgw(rs.getString(15));
				papers.add(paper); // 将paper添加进paperList中去。
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		closeAll();
		return papers;
	}
	public List<Paper> findPaperIdBySummaryandTitleandfabuandyiji(String paperTitle,int paperType,int paperCount) {
		List<Paper> papers = new ArrayList<Paper>();
		// TODO Auto-generated method stub
		getConn();
		String sql = "select * from Papers where paperTitle = ? and paperType= ? and paperCount= ?";
		doQuery(sql,paperTitle,paperType,paperCount);
		try {
			while (rs.next()) {
				Paper paper = new Paper();
				paper.setPaperId(rs.getInt(1));
				paper.setUserId(rs.getInt(2));
				paper.setPaperTitle(rs.getString(3));
				paper.setPaperSummary(rs.getString(4));
				paper.setPaperStartDate(rs.getString(5));
				paper.setPaperEndDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(rs.getDate(6)));
				paper.setPaperBg(rs.getString(7));
				paper.setPaperType(rs.getInt(8));
				paper.setPaperStatus(rs.getInt(9));
				paper.setPaperCount(rs.getInt(10));
				paper.setPaperJidu(rs.getInt(11));
				paper.setPaperBgsp(rs.getString(12));
				paper.setPaperBgsm(rs.getString(13));
				paper.setPaperBga(rs.getString(14));
				paper.setPaperBgw(rs.getString(15));
				papers.add(paper); // 将paper添加进paperList中去。
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		closeAll();
		return papers;
	}
	public List<Paper> findPaperByPaperType(int paperType) {
		// TODO Auto-generated method stub
		List<Paper> papers = new ArrayList<Paper>();
		getConn();
		String sql = "select * from Papers where PaperType = ?";
		doQuery(sql, paperType);
		System.out.println("----"+paperType);
		try {
			while (rs.next()) {
				Paper paper = new Paper();
				paper.setPaperId(rs.getInt(1));
				paper.setUserId(rs.getInt(2));
				paper.setPaperTitle(rs.getString(3));
				paper.setPaperSummary(rs.getString(4));
				paper.setPaperStartDate(rs.getString(5));
				paper.setPaperEndDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(rs.getDate(6)));
				paper.setPaperBg(rs.getString(7));
				paper.setPaperType(rs.getInt(8));
				paper.setPaperStatus(rs.getInt(9));
				paper.setPaperCount(rs.getInt(10));
				paper.setPaperJidu(rs.getInt(11));
				paper.setPaperBgsp(rs.getString(12));
				paper.setPaperBgsm(rs.getString(13));
				paper.setPaperBga(rs.getString(14));
				paper.setPaperBgw(rs.getString(15));
				papers.add(paper); // 将paper添加进paperList中去。
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		closeAll();

		return papers;
	}

	public Paper findPaperByPaperId(int paperId) {
		// TODO Auto-generated method stub
		Paper paper = null;
		getConn();
		String sql = "select * from Papers where PaperId = ?";
		doQuery(sql, paperId);
		try {
			while (rs.next()) {
				paper = new Paper();
				paper.setPaperId(rs.getInt(1));
				paper.setUserId(rs.getInt(2));
				paper.setPaperTitle(rs.getString(3));
				paper.setPaperSummary(rs.getString(4));
				paper.setPaperStartDate(rs.getString(5));
				paper.setPaperEndDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(rs.getDate(6)));
				paper.setPaperBg(rs.getString(7));
				paper.setPaperType(rs.getInt(8));
				paper.setPaperStatus(rs.getInt(9));
				paper.setPaperCount(rs.getInt(10));
				paper.setPaperJidu(rs.getInt(11));
				paper.setPaperBgsp(rs.getString(12));
				paper.setPaperBgsm(rs.getString(13));
				paper.setPaperBga(rs.getString(14));
				paper.setPaperBgw(rs.getString(15));
			}
		} catch (SQLException e) {
		e.printStackTrace();
		}
		closeAll();
		return paper;
	}

	public int addPapers(Paper paper) {
		// TODO Auto-generated method stub
		getConn();
		String sql = "insert into Papers values (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		doOperate(sql, paper.getUserId(), paper.getPaperTitle(), paper.getPaperSummary(), paper.getPaperStartDate(), paper.getPaperEndDate(), paper.getPaperBg(), paper.getPaperType(), paper.getPaperStatus(), paper.getPaperCount(),paper.getPaperJidu());
		closeAll();

		return result;
	}
	public int addPapersSp(Paper paper){
		getConn();
		String sql = "insert into Papers (paperId,userId,paperTitle,paperSummary,paperStartDate,paperEndDate,paperBg,paperType,paperStatus,paperCount,paperJidu,paperBgsp) values (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
		doOperate(sql, paper.getUserId(), paper.getPaperTitle(), paper.getPaperSummary(), paper.getPaperStartDate(), paper.getPaperEndDate(), paper.getPaperBg(), paper.getPaperType(), paper.getPaperStatus(), paper.getPaperCount(),paper.getPaperJidu(),paper.getPaperBgsp());
		closeAll();

		return result;
	}
	public int addPapersSm(Paper paper){
		getConn();
		String sql = "insert into Papers (paperId,userId,paperTitle,paperSummary,paperStartDate,paperEndDate,paperBg,paperType,paperStatus,paperCount,paperJidu,paperBgsm) values (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
		doOperate(sql, paper.getUserId(), paper.getPaperTitle(), paper.getPaperSummary(), paper.getPaperStartDate(), paper.getPaperEndDate(), paper.getPaperBg(), paper.getPaperType(), paper.getPaperStatus(), paper.getPaperCount(),paper.getPaperJidu(),paper.getPaperBgsm());
		closeAll();

		return result;
	}
	public int addPapersAu(Paper paper){
		getConn();
		String sql = "insert into Papers (paperId,userId,paperTitle,paperSummary,paperStartDate,paperEndDate,paperBg,paperType,paperStatus,paperCount,paperJidu,paperBga) values (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
		doOperate(sql, paper.getUserId(), paper.getPaperTitle(), paper.getPaperSummary(), paper.getPaperStartDate(), paper.getPaperEndDate(), paper.getPaperBg(), paper.getPaperType(), paper.getPaperStatus(), paper.getPaperCount(),paper.getPaperJidu(),paper.getPaperBga());
		closeAll();

		return result;
	}
	public int addPapersWi(Paper paper){
		getConn();
		String sql = "insert into Papers (paperId,userId,paperTitle,paperSummary,paperStartDate,paperEndDate,paperBg,paperType,paperStatus,paperCount,paperJidu,paperBgw) values (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
		doOperate(sql, paper.getUserId(), paper.getPaperTitle(), paper.getPaperSummary(), paper.getPaperStartDate(), paper.getPaperEndDate(), paper.getPaperBg(), paper.getPaperType(), paper.getPaperStatus(), paper.getPaperCount(),paper.getPaperJidu(),paper.getPaperBgw());
		closeAll();

		return result;
	}
	
	public int deletePaperByPaperId(int paperId) {
		// TODO Auto-generated method stub
		getConn();
		String sql = "delete from Papers where paperId = ?";
		doOperate(sql, paperId);
		closeAll();
		return result;
	}
	
	public int updatefabuByPaperId(int paperId, int paperCount) {
		// TODO Auto-generated method stub
		getConn();
		String sql = "update Papers set paperCount = ? where paperId = ?";
		doOperate(sql, paperCount, paperId);
		closeAll();
		return result;
	}
	public int updatefabuBylg(int type, int paperCount) {
		// TODO Auto-generated method stub
		getConn();
		String sql = "update Papers set paperCount = ? where paperType = ?";
		doOperate(sql, paperCount, type);
		closeAll();
		return result;
	}
	//12.1
	public int deletePaperByPaperType(int papertype,int qstjidu) {
		// TODO Auto-generated method stub
		
		getConn();
		String sql = "delete from Papers where paperType = ?  and paperJidu= ?";
		doOperate(sql, papertype,qstjidu);
		closeAll();
		return result;
	}

	public int deletePaperByUserId(int userId) {
		// TODO Auto-generated method stub
		getConn();
		String sql = "delete from Papers where userId = ?";
		doOperate(sql, userId);
		closeAll();
		return result;
	}

	public int findPaperIdByuserIdAndDate(int userId, String paperStartDate) {
		// TODO Auto-generated method stub
		int paperId = 0;
		getConn();
		String sql = "select PaperId from Papers where userId = ? and paperStartDate = ?";
		doQuery(sql, userId, paperStartDate);
		try {
			while (rs.next()) {
				paperId = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return paperId;
	}
	//11.30
	public int findPaperIdBypapertype(int paperType) {
		// TODO Auto-generated method stub
		getConn();
		String sql = "select paperType from Papers where paperType = ?";
		doQuery(sql,paperType);
		try {
			while (rs.next()) {
				paperType = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return paperType;
	}
	public int modifiedStatusBypaperId(int paperId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
