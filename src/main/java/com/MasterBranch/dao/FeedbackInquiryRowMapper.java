package com.MasterBranch.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.MasterBranch.bean.Inquiry;

public class FeedbackInquiryRowMapper implements RowMapper<Inquiry> {
// Does not get queries
	@Override
	public Inquiry mapRow(ResultSet rs, int rowNum) throws SQLException {
		Inquiry iq = new Inquiry();
		iq.setDeployed(rs.getBoolean("isDeployed"));
		iq.setId(rs.getInt("id"));
		iq.setName(rs.getString("name"));
		return iq;
	}

}