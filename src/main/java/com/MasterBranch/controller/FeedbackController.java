package com.MasterBranch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.repository.config.RepositoryConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.MasterBranch.model.Answer;
import com.MasterBranch.model.Enquiry;
import com.MasterBranch.model.Query;
import com.MasterBranch.repository.AnswerRepository;
import com.MasterBranch.repository.EnquiryRepository;
import com.MasterBranch.repository.OptionRepository;
import com.MasterBranch.repository.QueryRepository;
@Controller
public class FeedbackController {

	@Autowired
	private QueryRepository queryRepository;
	@Autowired
	private EnquiryRepository enquiryRepository;
	@Autowired
	private AnswerRepository answerRepository;
	@Autowired
	private OptionRepository optionRepository;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/answers")
	public @ResponseBody List<Answer> allAnswers() {
		List<Answer> answers = answerRepository.findAll();
		return answers;
	}
	
	@RequestMapping("/enquiries")
	public @ResponseBody List<Enquiry> allEnquiries() {
		List<Enquiry> enquiries = enquiryRepository.findAll();
		return enquiries;
	}
	
	@RequestMapping("/queries")
	public @ResponseBody List<Query> allQueries() {
		List<Query> queries = queryRepository.findAll();
		return queries;
}
	@RequestMapping("/queries/delete")
	public @ResponseBody List<Query> deleteQueries() {
		List<Query> queries = queryRepository.findAll();
		System.out.println(queries);
		return queries;
}

	@RequestMapping(value="/enquiries/{id}")
	public @ResponseBody Enquiry allEnquiries(@PathVariable int id) {
		Enquiry e = enquiryRepository.findOne(id);
		System.out.println(e);
		return e;
	}
    
	@RequestMapping(value="/queries/{id}")
	public @ResponseBody Query singleQuery(@PathVariable int id) {
		Query query = queryRepository.findOne(id);
		return query;
	}
	
	@RequestMapping(value="/queries/{id}/delete")
	public @ResponseBody List<Query> deleteQuery(@PathVariable int id) {
		Query query = queryRepository.findOne(id);
		queryRepository.delete(query);
		return allQueries();
	}
	
	@RequestMapping(value="/enquiries/{id}/delete")
	public @ResponseBody List<Enquiry> deleteEnquiry(@PathVariable int id) {
		Enquiry e = enquiryRepository.findOne(id);
		enquiryRepository.delete(e);
		return allEnquiries();
	}
	
	@RequestMapping(value="/addEnquiry", method=RequestMethod.GET)
	public String getCreateForm(Model model) {
		Enquiry emptyEnquiry = new Enquiry();
		model.addAttribute("enquiry", emptyEnquiry);
		return "addEnquiry";
	}
	
	@RequestMapping(value="/addEnquiry", method=RequestMethod.POST)
	public String addEnquiry(@ModelAttribute(value="enquiry") Enquiry enquiry) {
		enquiryRepository.save(enquiry);
		return "redirect:/enquiries";
	}
	/*
	@RequestMapping(value="/enquiries/{id}/edit", method=RequestMethod.GET)
	public String editQueries(@PathVariable Integer id, Model model) {
		Query query = new Query();
		model.addAttribute("query", query);;
		//model.addAttribute("queries", queryRepository.findById(id));
		model.addAttribute("enquiry", enquiryRepository.findOne(id));
		return "/enquiries/edit";
	}
	
	@RequestMapping(value="/enquiries/{id}/edit", method=RequestMethod.POST)
	public String saveQuery(@PathVariable Integer id, @ModelAttribute(value="query") Query query) {
		queryRepository.save(query);
		return "redirect:/enquiries/" + Integer.toString(id) + "/edit";
	}
	/*
	@RequestMapping(value="/enquiries/{id}/edit", method=RequestMethod.DELETE)
	public String deleteQuery(@PathVariable Integer id, @ModelAttribute(value="query") Query query) {
		queryRepository.save(query);
		return "redirect:/enquiries/" + Integer.toString(id) + "/edit";
	}
	
	@RequestMapping(value="/enquiries", method=RequestMethod.GET)
	public String showAll(Model model) {
		model.addAttribute("enquiries", enquiryRepository.findAll());
		return "/enquiries/showAll";
	}
	
	@RequestMapping("/enquiries.json")
	public @ResponseBody List<Enquiry> getAllEnquiries() {
		List<Enquiry> enquiries = enquiryRepository.findAll();
		return enquiries;
	}
	
	@RequestMapping(value="/enquiries/{enquiryId}/{queryId}", method=RequestMethod.GET)
	public String addEmptyAnswer(@PathVariable Integer enquiryId, @PathVariable Integer queryId, Model model) {
		model.addAttribute("answers", answerRepository.findById(queryId));
		Answer answer = new Answer();
		model.addAttribute("answer", answer);
		return "answerForm";
	}
	
	@RequestMapping(value="/enquiries/{enquiryId}/{queryDbId}", method=RequestMethod.POST)
	public String addAnswer(@PathVariable Integer enquiryId, @PathVariable Integer queryDbId, @ModelAttribute(value="answer") Answer answer) {
		answerRepository.save(answer);
		return "redirect:/enquiries/"+Integer.toString(enquiryId)+"/"+Integer.toString(queryDbId);
	}
	*/
}
