package com.atoz.survey.dao.mysqlimpl;

import com.atoz.survey.po.First;

public class FirstDaoImpl extends BaseDao {
	public int addfirsts(First first) {
		// TODO Auto-generated method stub
		getConn();
		String sql = "insert into first values (NULL, ?,0, ?, ?)";
		doOperate(sql, first.getPaperTitle(),first.getWeight(),first.getPaperType());
		closeAll();

		return result;
	}
}
