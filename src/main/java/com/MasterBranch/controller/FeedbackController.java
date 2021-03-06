package com.MasterBranch.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.MasterBranch.model.Answer;
import com.MasterBranch.model.Enquiry;
import com.MasterBranch.model.Question;
import com.MasterBranch.repository.AnswerRepository;
import com.MasterBranch.repository.EnquiryRepository;
import com.MasterBranch.repository.OptionRepository;
import com.MasterBranch.repository.QuestionRepository;

@CrossOrigin
@Controller
public class FeedbackController {

	@Autowired
	private QuestionRepository questionRepository;
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
	
	@RequestMapping("/answers/{questionId}")
	public @ResponseBody List<Answer> allAnswers(@PathVariable int questionId) {
		List<Answer> answers = answerRepository.findByQuestionId(questionId);
		return answers;
	}
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/enquiries")
	public @ResponseBody List<Enquiry> allEnquiries() {
		List<Enquiry> enquiries = enquiryRepository.findAll();
		return enquiries;
	}

	
	@RequestMapping("/questions")
	public @ResponseBody List<Question> allQuestions() {
		List<Question> questions = questionRepository.findAll();
		return questions;
	}
	
	@RequestMapping("/question/delete")
	public @ResponseBody List<Question> deleteQuestion() {
		List<Question> questions = questionRepository.findAll();
		return questions;
	}

	@RequestMapping(value="/questions/{id}")
	public @ResponseBody Question singlequestion(@PathVariable int id) {
		Question question = questionRepository.findOne(id);
		return question;
	}
		
	@RequestMapping("/enquiries/{id}")
	public @ResponseBody Enquiry getEnquiry(@PathVariable int id) {
		Enquiry enq = enquiryRepository.findOne(id);
		return enq;
	}
	
	@RequestMapping(value="/questions/{id}/delete")
	public @ResponseBody List<Question> deleteQuestion(@PathVariable int id) {
		Question question = questionRepository.findOne(id);
		questionRepository.delete(question);
		return allQuestions();
	}
	
	@RequestMapping(value="/enquiries/{id}/delete")
	public @ResponseBody List<Enquiry> deleteEnquiry(@PathVariable int id) {
		Enquiry e = enquiryRepository.findOne(id);
		enquiryRepository.delete(e);
		return allEnquiries();
	}
	
	@RequestMapping(value="/addEnquiry", method=RequestMethod.POST)
 	public String addEnquiry(@RequestBody Enquiry enquiry) {
 		enquiryRepository.save(enquiry);
 		return "redirect:/enquiries";
	}
	
	@RequestMapping(value="/enquiries/{enquiryId}/addQuestion", method=RequestMethod.POST)
	public String saveQuestion(@PathVariable Integer enquiryId, @RequestBody Question question) {
 		Enquiry e = enquiryRepository.findOne(enquiryId);
 		question.setEnquiry(e);
 		questionRepository.save(question);
	 	return "redirect:/enquiries/" + Integer.toString(enquiryId);
	}
	
	@RequestMapping(value="/question/{questionId}/answer",method=RequestMethod.POST)
	   public String postAnswer(@PathVariable Integer questionId, @RequestBody Answer answer, HttpServletRequest request) {
			answer.setQuestionId(questionId);
			answerRepository.save(answer);
			return "redirect:/answers/" + questionId;
	   }
	
}
