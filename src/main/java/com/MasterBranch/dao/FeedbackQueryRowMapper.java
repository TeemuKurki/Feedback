package com.MasterBranch.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.MasterBranch.bean.Query;

public class FeedbackQueryRowMapper implements RowMapper<Query> {

	public Query mapRow(ResultSet rs, int rowNum) throws SQLException {
		Query q = new Query();
		q.setId(rs.getInt("id"));
		q.setAnswer(rs.getString("answer"));
		q.setQuery(rs.getString("query"));
		return q;
	}

}
