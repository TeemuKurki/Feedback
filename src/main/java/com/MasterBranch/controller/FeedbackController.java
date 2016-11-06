package com.MasterBranch.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.MasterBranch.bean.Enquiry;
import com.MasterBranch.bean.Query;
import com.MasterBranch.dao.FeedbackDAO;
@Controller
public class FeedbackController {
	@Inject
	FeedbackDAO dao;
	
	@RequestMapping("/{id}/**")
	public @ResponseBody List<Query> getAllQueries(@PathVariable Integer id) {
		List<Query> queries = dao.getAllQueries(id);
		return queries;
	}
	
	@RequestMapping("/enquiries")
	public @ResponseBody List<Enquiry> getAllEnquiries() {
		List<Enquiry> enquiries = dao.getAllEnquiries();
		return enquiries;
	}
	
}
