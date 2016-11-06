package com.MasterBranch.dao;

import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.MasterBranch.bean.Enquiry;
import com.MasterBranch.bean.Query;
@Repository
public class FeedbackJdbcImpl implements FeedbackDAO {
	@Inject
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Query> getAllQueries(int enquiryId){
		//Pitäisi hakea kaikki kysymykset tietyltä kyselyltä
		String sql = "SELECT Queries FROM Enquiries WHERE id = ?";
		Object[] parameter = new Object[] { enquiryId };
		RowMapper<Query> queryMapper = new FeedbackQueryRowMapper();
		List<Query> queries = null;
		try {
			queries = jdbcTemplate.query(sql, parameter, queryMapper);
		}catch(IncorrectResultSizeDataAccessException e){
			//Placeholder. Adding better error handling later
			System.out.println("Cannot find data from database");
		}
		return queries;
	}
	public List<Enquiry> getAllEnquiries(){
		String sql = "SELECT * FROM Enquiries";
		RowMapper<Enquiry> enquiryMapper = new FeedbackEnquiryRowMapper();
		List<Enquiry> enquiries = jdbcTemplate.query(sql, enquiryMapper);
		return enquiries;
	}
}
