package com.MasterBranch.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.MasterBranch.bean.Query;
/**
 * 
 * 
 *
 */

public class FeedbackJdbcImpl {

	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Query> getAllQuerys(){
		String sql = "SELECT queries FROM inquires WHERE id = ?";
		RowMapper<Query> queryMapper = new FeedbackQueryRowMapper();
		List<Query> queries = jdbcTemplate.query(sql, queryMapper);
		return queries;
	}
}
