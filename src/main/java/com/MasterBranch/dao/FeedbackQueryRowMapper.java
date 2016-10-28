package com.MasterBranch.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.MasterBranch.bean.Query;

public class FeedbackQueryRowMapper implements RowMapper<Query> {

	@Override
	public Query mapRow(ResultSet rs, int rowNum) throws SQLException {
		Query q = new Query();
		return null;
	}

}
