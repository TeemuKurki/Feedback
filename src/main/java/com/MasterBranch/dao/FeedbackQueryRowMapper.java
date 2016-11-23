package com.MasterBranch.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.MasterBranch.bean.Enquiry;
import com.MasterBranch.bean.Query;

public class FeedbackQueryRowMapper implements RowMapper<Query> {
	public Query mapRow(ResultSet rs, int rowNum) throws SQLException {
		Query query = new Query();
		query.setId(rs.getInt("id"));
		query.setDbId(rs.getInt("id"));
		query.setQuery(rs.getString("question"));
		query.setQueryType(rs.getInt("questionType"));
		return query;
	}
}