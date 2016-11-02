package com.MasterBranch.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.MasterBranch.bean.Enquiry;

public class FeedbackEnquiryRowMapper implements RowMapper<Enquiry> {
// Does not get queries
	@Override
	public Enquiry mapRow(ResultSet rs, int rowNum) throws SQLException {
		Enquiry iq = new Enquiry();
		iq.setDeployed(rs.getBoolean("isDeployed"));
		iq.setId(rs.getInt("id"));
		iq.setName(rs.getString("name"));
		return iq;
	}

}