package com.MasterBranch.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.MasterBranch.bean.Enquiry;
import com.MasterBranch.bean.Query;
import com.MasterBranch.dao.FeedbackDAO;
@Controller
public class FeedbackController {
	@Inject
	FeedbackDAO dao;
	
	@RequestMapping("/{id}")
	public @ResponseBody List<Query> getAllQueries(@PathVariable Integer id) {
		List<Query> queries = dao.getAllQueries(id);
		return queries;
	}
	
	@RequestMapping(value="/addEnquiry", method=RequestMethod.POST)
	public String addEnquiry(@ModelAttribute(value="enquiry") Enquiry enquiry) {
		dao.addEnquiry(enquiry);
		return "/enquiries";
	}
	
	@RequestMapping(value="/enquiries/{id}/edit", method=RequestMethod.GET)
	public String editQueries(@PathVariable Integer id, Model model) {
		List<Query> queries = dao.getAllQueries(id);
		model.addAttribute("queries", queries);
		return "/enquiries/" + Integer.toString(id) + "/edit";
	}
	
	@RequestMapping(value="/enquiries/{id}/edit", method=RequestMethod.POST)
	public String saveQueries(@PathVariable Integer id, @ModelAttribute(value="query") Query query) {
		dao.addQuery(id, query);
		return "/enquiries/" + Integer.toString(id) + "/edit";
	}
	
	@RequestMapping("/enquiries")
	public @ResponseBody List<Enquiry> getAllEnquiries() {
		List<Enquiry> enquiries = dao.getAllEnquiries();
		return enquiries;
	}
	
}
