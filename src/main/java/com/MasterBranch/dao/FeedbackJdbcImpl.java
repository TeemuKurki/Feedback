package com.MasterBranch.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
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
	
	public List<Query> getAllQueries(int id){

		String sql = "SELECT Query.id, question FROM Query INNER JOIN Queries ON Query.id = Queries.query_id WHERE enquiry_id = ?;";
		Object[] parameter = new Object[] { id };
		List<Query> queries = new ArrayList<Query>();
		try {
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, parameter);
				int rowId = 1;
				for (Map row : rows) {
					Query query = new Query();
					query.setId(rowId);
					query.setQuery((String)row.get("question"));
					queries.add(query);
					rowId++;
				}		
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


	public void addEnquiry(Enquiry e) {
		final String sql = "INSERT INTO Enquiries(description) VALUES(?)";
		final String name = e.getName();
		jdbcTemplate.update(new PreparedStatementCreator() {	
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, name);
				return ps;
			}
		});
	}

	public void addQuery(int enquiryId, Query q) {
		final String sql = "INSERT INTO Query(description) VALUES(?) INNER JOIN Queries ON "
				+ "Query.id = Queries.query_id WHERE enquery_id = "+enquiryId;
		final String query = q.getQuery();
		jdbcTemplate.update(new PreparedStatementCreator() {	
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, query);
				return ps;
			}
		});	
	}
	
}