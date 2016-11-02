package com.MasterBranch.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.MasterBranch.bean.Inquiry;
import com.MasterBranch.bean.Query;
import com.MasterBranch.dao.FeedbackJdbcImpl;

@Controller
public class FeedbackController {
	@Inject
	FeedbackJdbcImpl dao;
	
	@RequestMapping("/{id}/**")
	public @ResponseBody List<Query> getAllQueries(@PathVariable Integer id) {
		List<Query> queries = dao.getAllQueries(id);
		return queries;
	}
	
	@RequestMapping("/inquiries")
	public @ResponseBody List<Inquiry> getAllInquiries() {
		List<Inquiry> inquiries = dao.getAllInquiries();
		return inquiries;
	}
}
