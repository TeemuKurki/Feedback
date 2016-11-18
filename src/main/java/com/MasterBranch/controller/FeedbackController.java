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
	
	@RequestMapping(value="/addEnquiry", method=RequestMethod.GET)
	public String getCreateForm(Model model) {
		Enquiry emptyEnquiry = new Enquiry();
		model.addAttribute("enquiry", emptyEnquiry);
		return "createForm";
	}
	
	@RequestMapping(value="/addEnquiry", method=RequestMethod.POST)
	public String addEnquiry(@ModelAttribute(value="enquiry") Enquiry enquiry) {
		dao.addEnquiry(enquiry);
		return "redirect:/enquiries";
	}
	
	@RequestMapping(value="/enquiries/{id}/edit", method=RequestMethod.GET)
	public String editQueries(@PathVariable Integer id, Model model) {
		Query query = new Query();
		model.addAttribute("query", query);
		List<Query> queries = dao.getAllQueries(id);
		Enquiry enquiry = dao.getEnquiry(id);
		model.addAttribute("queries", queries);
		model.addAttribute("enquiry", enquiry);
		return "/enquiries/edit";
	}
	
	@RequestMapping(value="/enquiries/{id}/edit", method=RequestMethod.POST)
	public String saveQueries(@PathVariable Integer id, @ModelAttribute(value="query") Query query) {
		System.out.println("delete testi 3");
		dao.addQuery(id, query);
		return "redirect:/enquiries/" + Integer.toString(id) + "/edit";
	}
	
	@RequestMapping(value="/enquiries/", method=RequestMethod.GET)
	public String showAll(Model model) {
		model.addAttribute("enquiries", dao.getAllEnquiries());
		return "/enquiries/showAll";
		
	}
	
	@RequestMapping("/enquiries.json")
	public @ResponseBody List<Enquiry> getAllEnquiries() {
		List<Enquiry> enquiries = dao.getAllEnquiries();
		return enquiries;
	}
	
}
