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
import org.springframework.transaction.annotation.Transactional;

import com.MasterBranch.bean.Answer;
import com.MasterBranch.bean.Enquiry;
import com.MasterBranch.bean.Option;
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
	
	public Enquiry getEnquiry(int id) {
		String sql = "SELECT * FROM Enquiry WHERE id = " + Integer.toString(id) + ";";
		RowMapper<Enquiry> enquiryMapper = new FeedbackEnquiryRowMapper();
		Enquiry enquiry = jdbcTemplate.query(sql, enquiryMapper).get(0);
		return enquiry;
	}
	
	public Query getQuery(int id) {
		String sql = "SELECT * FROM Query WHERE id = " + Integer.toString(id) + ";";
		Object[] parameter = new Object[] { id };
		RowMapper<Query> queryMapper = new FeedbackQueryRowMapper();
		Query query = jdbcTemplate.query(sql, queryMapper).get(0);
		if(query.getQueryType() == 1) {
			String optionSQL = "SELECT Option.id, optionValue FROM Option INNER JOIN Options ON Option.id = Options.option_id INNER JOIN Query ON query_id=Query.id WHERE query_id = ?;";
			List<Option> options = new ArrayList<Option>();
			try {
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(optionSQL, parameter);
				int rowId = 1;
				for (Map row : rows) {
					Option option = new Option();
					option.setId((Integer)row.get("id"));
					option.setOptionValue((String)row.get("optionValue"));
					options.add(option);
					rowId++;
				}		
			} catch(IncorrectResultSizeDataAccessException e){
				//Placeholder. Adding better error handling later
				System.out.println("Cannot find data from database");
			}
			query.setOptions(options);
		}
		
		return query;
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
					query.setDbId((Integer)row.get("id"));
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
		String sql = "SELECT * FROM Enquiry";
		RowMapper<Enquiry> enquiryMapper = new FeedbackEnquiryRowMapper();
		List<Enquiry> enquiries = jdbcTemplate.query(sql, enquiryMapper);
		for(int i = 0; i < enquiries.size(); i++) {
			List<Query> queries = getAllQueries(enquiries.get(i).getId());
			enquiries.get(i).setQueries(queries);
		}
		return enquiries;
	}
	
	public void deleteQuery(int enquiryId, int queryId) {
		
	}
	
	public void deleteEnquiry(int id) {
		
	}

	public void addEnquiry(Enquiry e) {
		final String sql = "INSERT INTO Enquiry(description) VALUES(?)";
		final String name = e.getName();
		jdbcTemplate.update(new PreparedStatementCreator() {	
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, name);
				return ps;
			}
		});
	}

	@Transactional
	public void addQuery(int enquiryId, Query q) {
		final String sql = "INSERT INTO Query(question) VALUES(?);";
		final String query = q.getQuery();
		jdbcTemplate.update(new PreparedStatementCreator() {	
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, query);
				return ps;
			}
		});	
		final String sql2 = "INSERT INTO Queries(enquiry_id,query_id) VALUES ("+enquiryId+",LAST_INSERT_ID())";
		jdbcTemplate.update(new PreparedStatementCreator() {	
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql2);
				return ps;
			}
		});
	}
	
	public void addAnswer(int queryId, Answer a){
		final String sql = "INSERT INTO Answer(answer) VALUES(?)";
		final String answer = a.getAnswer();
		jdbcTemplate.update(new PreparedStatementCreator() {	
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, answer);
				return ps;
			}
		});
		final String sql2 = "INSERT INTO Answers(query_id,answer_id) VALUES ("+queryId+",LAST_INSERT_ID())";
		jdbcTemplate.update(new PreparedStatementCreator() {	
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql2);
				return ps;
			}
		});
	}
	
}