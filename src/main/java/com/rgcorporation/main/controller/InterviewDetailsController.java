package com.rgcorporation.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rgcorporation.main.model.InterviewDetails;
import com.rgcorporation.main.service.InterviewDetailsServiceInterface;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("interviewdetails")
public class InterviewDetailsController {

	@Autowired
	private InterviewDetailsServiceInterface interviewDetailsServiceInterface;

	@RequestMapping(value = "interviewdetail", method = RequestMethod.GET)
	public List<InterviewDetails> getInterviewDetails() {
		return interviewDetailsServiceInterface.getAllInterviewDetails();
	}

	@RequestMapping(value = "interviewdetail/{interviewid}", method = RequestMethod.GET)
	public InterviewDetails getDetails(@PathVariable int interviewid) {
		return interviewDetailsServiceInterface.getInterviewDetailsById(interviewid);
	}

	@RequestMapping(value = "interviewdetail", method = RequestMethod.POST)
	public boolean addNewInterviewDetails(@RequestBody InterviewDetails interviewDetails) {
		return interviewDetailsServiceInterface.addNewInterviewDetails(interviewDetails);
	}

	@RequestMapping(value = "inprocessinterviewdetail", method = RequestMethod.GET)
	public List<InterviewDetails> getAllInterviewDetailsAsPending() {
		return interviewDetailsServiceInterface.getAllInterviewDetailsAsPending();
	}

//	@RequestMapping(value = "updateinterviewdetailsbystatus", method = RequestMethod.PUT)
//	public boolean updateInterviewDetailsAsStatus(@RequestBody InterviewDetails interviewDetails) {
//		return interviewDetailsServiceInterface.updateInterviewDetailsAsStatus(interviewDetails);
//	}

	@RequestMapping(value = "interviewdetail", method = RequestMethod.PUT)
	public boolean updateInterviewDetails(@RequestBody InterviewDetails interviewDetails) {
		return interviewDetailsServiceInterface.updateInterviewDetails(interviewDetails);
	}
	
	
}
